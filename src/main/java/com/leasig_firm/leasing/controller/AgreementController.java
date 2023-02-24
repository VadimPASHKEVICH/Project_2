package com.leasig_firm.leasing.controller;
import com.leasig_firm.leasing.entity.Agreement;
import com.leasig_firm.leasing.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AgreementController {
    private final AgreementService agreementService;
    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }
    @GetMapping("/getAllAg")
    public ResponseEntity<ArrayList<Agreement>> getAllAgreement(){
        return new ResponseEntity<>(agreementService.getAllAgreement(),HttpStatus.OK);

    }
}
