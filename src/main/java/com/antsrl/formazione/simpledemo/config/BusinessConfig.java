package com.antsrl.formazione.simpledemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class BusinessConfig {

    @Bean
    public Object optionalBusinessService(@Value("${business.load-bean:false}") Boolean loadBean){

        if(loadBean){
            System.out.println("loading an optional business service!!");
            return new Object();

        } else {

            System.out.println("NOT loading any optional business service!!");
            return null;
        }
    }
}
