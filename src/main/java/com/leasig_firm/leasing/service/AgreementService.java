package com.leasig_firm.leasing.service;
import com.leasig_firm.leasing.domain.Agreement;
import com.leasig_firm.leasing.repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AgreementService {

    AgreementRepository agreementRepository;
    @Autowired
    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    public ArrayList<Agreement> getAllAgreement(){
        return (ArrayList<Agreement>) agreementRepository.findAll();
    }

    public Agreement getAgreementById(int id){
        return agreementRepository.getById(id);
    }

//    public Agreement showDebt(double debt){
//        return agreementRepository.findAll(debt);
//    }

}
