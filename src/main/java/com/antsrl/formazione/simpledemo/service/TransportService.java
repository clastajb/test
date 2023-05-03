package com.antsrl.formazione.simpledemo.service;

import com.antsrl.formazione.simpledemo.model.Car;
import com.antsrl.formazione.simpledemo.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransportService {

    @Autowired
    @Qualifier("optionalBusinessService")
    private Optional<Object> optionalObject;

    @Autowired
    private Car car;

    @Autowired
    @Qualifier("endothermicTruck")
    private Truck mailDeliveryTruck;

    @Autowired
    @Qualifier("electricTruck")
    private Truck watermellonDeliveryTruck;

    public TransportService() {
        System.out.println("preparing for transportation");
    }

    public void movingStuffAroundTheWorld(){
        System.out.println("hey, I'm moving stuff around!!");

        car.engineStart();
        car.go();

        mailDeliveryTruck.loadCargo();
        mailDeliveryTruck.engineStart();
        mailDeliveryTruck.go();

        watermellonDeliveryTruck.engineStart();
        watermellonDeliveryTruck.go();

    }
}
