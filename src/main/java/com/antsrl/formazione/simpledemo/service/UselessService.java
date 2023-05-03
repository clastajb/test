package com.antsrl.formazione.simpledemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Lazy
@Component
public class UselessService {

    @Autowired
    @Qualifier("optionalBusinessService")
    private Object optionalObject;

    public UselessService() {
        System.out.println("preparing to do nothing...");
    }

    public void doingUselessStuff(){
        System.out.println("dicking around... =)");
    }
}
