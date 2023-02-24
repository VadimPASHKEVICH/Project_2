package com.leasig_firm.leasing.entity;

import lombok.Data;

@Data
public class Agreement {
    private int id;
    private int agreement;
    private String term;
    private double payment;
    private double debt;
    private String dateOfPayment;
    private double credit;
    private int idUsers;
}
