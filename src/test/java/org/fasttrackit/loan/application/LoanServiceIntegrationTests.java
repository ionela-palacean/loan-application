package org.fasttrackit.loan.application;

import org.fasttrackit.loan.application.domain.Loan;
import org.fasttrackit.loan.application.service.LoanService;
import org.fasttrackit.loan.application.transfer.SaveLoanRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.MalformedInputException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@SpringBootTest
class LoanServiceIntegrationTests {

	@Autowired
	private LoanService loanService;

	@Test
	void testCreateLoan_whenValidRequest_thenLoanIsSaved() {

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


	}



}
