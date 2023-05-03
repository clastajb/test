package com.antsrl.formazione.simpledemo.config;

import com.antsrl.formazione.simpledemo.model.Car;
import com.antsrl.formazione.simpledemo.model.Engine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class CarConfig {

    @Scope("prototype")
    @Bean
    public Car car(@Qualifier("electricEngine") Engine engine){

        Car car = new Car();
        car.setEngine(engine);
        return car;
    }
}
