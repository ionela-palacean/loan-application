package org.fasttrackit.loan.application.persistance;

import org.fasttrackit.loan.application.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
