package org.fasttrackit.loan.application.transfer;

public class GetLoansRequest {

    private String partialLoanType;
    private Integer minLoanSum;

    public String getPartialLoanType() {
        return partialLoanType;
    }

    public void setPartialLoanType(String partialLoanType) {
        this.partialLoanType = partialLoanType;
    }

    @Override
    public String toString() {
        return "GetLoansRequest{" +
                "partialLoanType='" + partialLoanType + '\'' +
                ", minLoanSum=" + minLoanSum +
                '}';
    }
}
