package com.antsrl.formazione.simpledemo;

import com.antsrl.formazione.simpledemo.model.Car;
import com.antsrl.formazione.simpledemo.service.GeolocationService;
import com.antsrl.formazione.simpledemo.service.TransportService;
import com.antsrl.formazione.simpledemo.service.UselessService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(
                "com.antsrl.formazione.simpledemo");
        context.refresh();

        TransportService transportService = context.getBean(TransportService.class);
        transportService.movingStuffAroundTheWorld();

        TransportService transportServiceBello = context.getBean(TransportService.class);
        transportServiceBello.movingStuffAroundTheWorld();

        GeolocationService geolocationService = context.getBean(GeolocationService.class);
        geolocationService.trackingStuffAroundTheWorld();

        UselessService uselessService = context.getBean(UselessService.class);
        uselessService.doingUselessStuff();

        Car redCar = context.getBean(Car.class);
        Car blueCar = context.getBean(Car.class);

        trueOrThrow("le car sono lo stesso oggetto", () -> !Objects.equals(redCar, blueCar));
        trueOrThrow("i due transportservice non sono identici", () -> Objects.equals(transportService, transportServiceBello));
    }

    private static void trueOrThrow(String message, Callable<Boolean> callable){

        try {

            if(!callable.call()){
                throw new RuntimeException(message);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
