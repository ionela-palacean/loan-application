package org.fasttrackit.loan.application.service;

import org.fasttrackit.loan.application.domain.Loan;
import org.fasttrackit.loan.application.persistance.LoanRepository;
import org.fasttrackit.loan.application.transfer.SaveLoanRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    return loanRepository.save(loan);

    }
}
