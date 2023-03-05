package com.leasig_firm.leasing.exception;

public class AgreementNotFoundException extends Exception{
    private int agreement;

    public AgreementNotFoundException(int agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        return "AgreementNotFoundException{" +
                "agreement=" + agreement +
                '}';
    }
}
