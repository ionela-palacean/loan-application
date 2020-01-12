package org.fasttrackit.loan.application;

import org.fasttrackit.loan.application.domain.Loan;
import org.fasttrackit.loan.application.exception.ResourceNotFoundException;
import org.fasttrackit.loan.application.service.LoanService;
import org.fasttrackit.loan.application.transfer.SaveLoanRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import java.nio.charset.MalformedInputException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanServiceIntegrationTests {

	@Autowired
	private LoanService loanService;

	@Test
 public	void testCreateLoan_whenValidRequest_thenLoanIsSaved() {

		createLoan();

	}



	@Test(expected=TransactionSystemException.class)

  public void testCreateLoan_whenInvalidRequest_thenThrowException(){

	     SaveLoanRequest request=new SaveLoanRequest();

	     // leaving request properties with default null values
        //  to validae the negative flow

	     loanService.createLoan(request);


}

@Test
public void testGetLoan_whenExistingLoan_thenReturnLoan(){
  Loan createdLoan=createLoan();
  Loan loan= loanService.getLoan(createdLoan.getId());

	assertThat(loan,notNullValue());
	assertThat(loan.getId(), is(createdLoan.getId()));
	assertThat(loan.getId(), greaterThan(0L));
	assertThat(loan.getLoanType(), is(createdLoan.getLoanType()));
	assertThat(loan.getLoanSum(), notNullValue());
	}

	@Test(expected= ResourceNotFoundException.class)

	public void testGetLoan_whenNonExistingLoan_thenThrowResourceNotFounException(){
      loanService.getLoan(99999);

	}

	@Test
	public void testUpdateLoan_whenValidRequest_thenReturnUpdatedLoan(){

		Loan createdLoan = createLoan();
		SaveLoanRequest request=new SaveLoanRequest();

		request.setLoanType(createdLoan.getLoanType()+"updated");
		request.setLoanSum(createdLoan.getLoanSum()+20);
		request.setLoanPeriod(createdLoan.getLoanPeriod()+10);

		Loan updatedLoan = loanService.updateLoan(createdLoan.getId(), request);
		assertThat(updatedLoan, notNullValue());
		assertThat(updatedLoan.getId(), is(createdLoan.getId()));
		assertThat(updatedLoan.getLoanType(), is(request.getLoanType()));
		assertThat(updatedLoan.getLoanSum(), is(request.getLoanSum()));
		assertThat(updatedLoan.getLoanPeriod(), is(request.getLoanPeriod()));

	}
 @Test(expected = ResourceNotFoundException.class)
	public void test_DeleteLoan_whenExistingLoan_thenLoanIsDeleted(){

		Loan loan=createLoan();
		loanService.deleteLoan(loan.getId());
		loanService.getLoan(loan.getId());



	}
	private Loan createLoan() {
		SaveLoanRequest request=new SaveLoanRequest();
		request.setLoanType("Credit Ipotecar pentru investitii imobiliare");
		request.setLoanPeriod(10);
		request.setLoanSum(4500000.00);
		Loan createdLoan = loanService.createLoan(request);

		assertThat(createdLoan,notNullValue());
		assertThat(createdLoan.getId(), notNullValue());
		assertThat(createdLoan.getId(), greaterThan(0L));
		assertThat(createdLoan.getLoanType(), is(request.getLoanType()));
		assertThat(createdLoan.getLoanSum(), notNullValue());

		return createdLoan;
	}
}
