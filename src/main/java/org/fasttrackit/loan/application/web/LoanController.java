package org.fasttrackit.loan.application.web;

import org.fasttrackit.loan.application.domain.Loan;
import org.fasttrackit.loan.application.service.LoanService;
import org.fasttrackit.loan.application.transfer.GetLoansRequest;
import org.fasttrackit.loan.application.transfer.SaveLoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/loans")
public class LoanController {

private final LoanService loanService;

@Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody @Valid SaveLoanRequest request){
        Loan loan = loanService.createLoan(request);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);

    }

@GetMapping("/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable("id") Long id){
    Loan loan = loanService.getLoan(id);
    return new ResponseEntity<>(loan, HttpStatus.OK);


}

@GetMapping
public ResponseEntity<Page<Loan>>  getLoans(GetLoansRequest request, Pageable pageable){

   Page<Loan> loans = loanService.getLoans(request, pageable);
   return new ResponseEntity<>(loans, HttpStatus.OK);
}

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable("id") Long id, @RequestBody @Valid SaveLoanRequest request){
        Loan loan = loanService.updateLoan(id, request);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Loan> deleteLoan(@PathVariable("id") Long id){
        loanService.deleteLoan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

}
