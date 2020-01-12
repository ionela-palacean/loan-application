package org.fasttrackit.loan.application.transfer;

import javax.validation.constraints.NotNull;

public class SaveLoanRequest {

    @NotNull
    private String loanType;
    @NotNull
    private Double loanSum;
    @NotNull
    private Integer loanPeriod;
    private String imageUrl;

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Double getLoanSum() {
        return loanSum;
    }

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
        return "SaveLoanRequest{" +
                "loanType='" + loanType + '\'' +
                ", loanSum=" + loanSum +
                ", loanPeriod=" + loanPeriod +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
