package com.antsrl.formazione.simpledemo.service;

import org.springframework.stereotype.Component;

@Component
public class GeolocationService {

    public GeolocationService() {
        System.out.println("hello, preparing to track stuff");
    }

    public void trackingStuffAroundTheWorld(){
        System.out.println("tracking moving objects and spying on you!!");
    }
}
