package com.leasig_firm.leasing.controller;
import com.leasig_firm.leasing.domain.Agreement;
import com.leasig_firm.leasing.service.AgreementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
@RestController
@RequestMapping(value = "/ag", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgreementController {
    private final AgreementService agreementService;
    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }
    @GetMapping
    public ResponseEntity<ArrayList<Agreement>> getAllAgreement(){
        return new ResponseEntity<>(agreementService.getAllAgreement(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Agreement> getAgreementById(@PathVariable int id) {
        Agreement agreement = agreementService.getAgreementById(id);
        return new ResponseEntity<>(agreement, agreement.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }
//    @GetMapping("/{debt}")
//    public ResponseEntity<Agreement> showDebt (@PathVariable double debt) {
//        Agreement agreement = agreementService.showDebt(debt);
//        return new ResponseEntity<>(agreement, agreement.getDebt() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
//    }
}
