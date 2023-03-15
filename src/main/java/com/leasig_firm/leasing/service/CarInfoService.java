package com.leasig_firm.leasing.service;

import com.leasig_firm.leasing.domain.CarInfo;
import com.leasig_firm.leasing.repository.CarInfoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarInfoService {

    public CarInfoRepository carInfoRepository;

    public CarInfoService(CarInfoRepository carInfoRepository) {
        this.carInfoRepository = carInfoRepository;
    }

    public ArrayList<CarInfo>getInfoCar(){
        return carInfoRepository.getInfoCar();
    }
}
