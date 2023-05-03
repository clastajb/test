package com.antsrl.formazione.simpledemo.model;

public class Car {

    private Engine engine;

    public  void engineStart(){
        System.out.println("sto avviando il motore");
    }

    public void go(){
        engine.makeSomeNoise();
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
