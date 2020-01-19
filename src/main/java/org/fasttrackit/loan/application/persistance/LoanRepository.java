package org.fasttrackit.loan.application.persistance;

import org.fasttrackit.loan.application.domain.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Page<Loan> findByLoanTypeIs(String partialLoanType, Pageable pageable);

}
