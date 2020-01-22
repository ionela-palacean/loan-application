package org.fasttrackit.loan.application.service;

import org.fasttrackit.loan.application.domain.Loan;
import org.fasttrackit.loan.application.exception.ResourceNotFoundException;
import org.fasttrackit.loan.application.persistance.LoanRepository;
import org.fasttrackit.loan.application.transfer.GetLoansRequest;
import org.fasttrackit.loan.application.transfer.SaveLoanRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class LoanService {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(LoanService.class);

// IoC -  Inversion of control

    private final LoanRepository loanRepository;

    // Dependency Injection
@Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan createLoan(SaveLoanRequest request){
    LOGGER.info("Creating loan {} ", request);
    Loan loan=new Loan();
    loan.setLoanType(request.getLoanType());
    loan.setLoanSum(request.getLoanSum());
    loan.setLoanPeriod(request.getLoanPeriod());
    loan.setImageUrl(request.getImageUrl());
    loan.setInterest(7.5);
    return loanRepository.save(loan);

    }

    public Loan getLoan(long id){
     LOGGER.info("Retrieving loan {}", id);

    //using Optional
    return loanRepository.findById(id)

            // lambda expression
            .orElseThrow( ()->new ResourceNotFoundException("Loan"+id+"does not exists"));

    }


    public Page<Loan> getLoans(GetLoansRequest request, Pageable pageable) {

    if (request != null && request.getPartialLoanType() != null) {
        return loanRepository.findByLoanTypeIs(request.getPartialLoanType(), pageable);
    }
   return loanRepository.findAll(pageable);
    }


    public Loan updateLoan(long id,SaveLoanRequest request){
    LOGGER.info("Updating product {}: {}",id, request);

    Loan loan=getLoan(id);
        BeanUtils.copyProperties(request, loan);
        return loanRepository.save(loan);

    }

    public void deleteLoan(long id){

    LOGGER.info("Deleting product {}",id);

    loanRepository.deleteById(id);
    LOGGER.info("Deleted product {}", id);

    }



    public Double calculateLoanRate(long loanId, double loanPeriod, double loanSum, double interest){

        Loan loan = getLoan(loanId);

        double interestResult1=(loanSum*interest)/100;
        double interestResult2=interestResult1/12;
        double result=loanSum/loanPeriod;
        double finalResult=result+interestResult2;

        return finalResult;
    }
}
