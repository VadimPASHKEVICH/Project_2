package com.leasig_firm.leasing.service;

import com.leasig_firm.leasing.domain.ClientAgreement;
import com.leasig_firm.leasing.repository.ClientAgreementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientAgreementService {

    public ClientAgreementRepository clientAgreementRepository;

    public ClientAgreementService(ClientAgreementRepository clientAgreementRepository) {
        this.clientAgreementRepository = clientAgreementRepository;
    }

    public ArrayList<ClientAgreement> getAllAgreement(){
        return clientAgreementRepository.getAllAgreement();
    }

    public ClientAgreement getAgreementById(int id){
        return clientAgreementRepository.getAgreementById(id);
    }

    public ClientAgreement showDebt(double debt){
        return clientAgreementRepository.showDebt(debt);
    }

}
