package com.leasig_firm.leasing.controller;

import com.leasig_firm.leasing.domain.ClientAgreement;
import com.leasig_firm.leasing.domain.User;
import com.leasig_firm.leasing.service.ClientAgreementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.Http2;
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
public class ClientAgreementController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ClientAgreementService clientAgreementService;

    public ClientAgreementController(ClientAgreementService clientAgreementService) {
        this.clientAgreementService = clientAgreementService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<ClientAgreement>> getAllAgreement(){
        return new ResponseEntity<>(clientAgreementService.getAllAgreement(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientAgreement> getAgreementById(@PathVariable int id) {
        ClientAgreement clientAgreement = clientAgreementService.getAgreementById(id);
        return new ResponseEntity<>(clientAgreement, clientAgreement.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }
    @GetMapping("/{debt}")
    public ResponseEntity<ClientAgreement> showDebt (@PathVariable double debt) {
        ClientAgreement clientAgreement = clientAgreementService.showDebt(debt);
        return new ResponseEntity<>(clientAgreement, clientAgreement.getDebt() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }
}
