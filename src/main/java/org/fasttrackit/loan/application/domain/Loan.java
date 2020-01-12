package org.fasttrackit.loan.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

public class Loan {

    @Id
    @GeneratedValue

    private Long id;
    @NotNull
    private String loanType;
    @NotNull
    private Double loanSum;
    @NotNull
    private Integer loanPeriod;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Double getLoanSum() { return loanSum; }

    public void setLoanSum(Double loanSum) {
        this.loanSum = loanSum;
    }

    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanType='" + loanType + '\'' +
                ", loanSum=" + loanSum +
                ", loanPeriod=" + loanPeriod +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
