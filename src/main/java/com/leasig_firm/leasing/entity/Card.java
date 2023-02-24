package com.leasig_firm.leasing.entity;

import lombok.Data;

@Data
public class Card {
    private int id;
    private String cardNumber;
    private String cardType;
    private String expirationDate;
    private int CVC;
}
