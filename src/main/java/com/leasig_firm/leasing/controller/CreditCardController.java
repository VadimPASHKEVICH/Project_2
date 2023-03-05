package com.leasig_firm.leasing.controller;
import com.leasig_firm.leasing.domain.CreditCard;
import com.leasig_firm.leasing.domain.User;
import com.leasig_firm.leasing.service.CreditCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.BadLocationException;

@RestController
@RequestMapping(value = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreditCardController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }
    @PostMapping
    public ResponseEntity<HttpStatus> createCreditCard(@RequestBody CreditCard creditCard, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        creditCardService.createCreditCard(creditCard);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<HttpStatus> updateCreditCard(@RequestBody CreditCard creditCard, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            for (ObjectError o : bindingResult.getAllErrors()){
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        creditCardService.updateCreditCard(creditCard);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus>deleteCreditCard(CreditCard creditCard){
        creditCardService.deleteCreditCard(creditCard);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    }
