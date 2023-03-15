package com.leasig_firm.leasing.controller;

import com.leasig_firm.leasing.domain.CarInfo;
import com.leasig_firm.leasing.service.CarInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
@RequestMapping(value = "/infoCar", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarInfoController {
    private final CarInfoService carInfoService;

    public CarInfoController(CarInfoService carInfoService) {
        this.carInfoService = carInfoService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<CarInfo>> getInfoCar(){
        return new ResponseEntity<>(carInfoService.getInfoCar(), HttpStatus.OK);
    }
}
