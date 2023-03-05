package com.leasig_firm.leasing.service;

import com.leasig_firm.leasing.domain.CreditCard;
import com.leasig_firm.leasing.domain.User;
import com.leasig_firm.leasing.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    public CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
    public void createCreditCard(CreditCard creditCard){
        creditCardRepository.createCreditCard(creditCard);
    }

    public void updateCreditCard(CreditCard creditCard){creditCardRepository.updateCreditCard(creditCard);}

    public void deleteCreditCard(CreditCard creditCard){ creditCardRepository.deleteCreditCard(creditCard);}
}
