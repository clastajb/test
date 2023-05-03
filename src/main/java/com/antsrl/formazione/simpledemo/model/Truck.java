package com.antsrl.formazione.simpledemo.model;

public class Truck {

    private Engine engine;

    public void engineStart(){
        System.out.println("I'm the king of the road!! get out of the way!");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void go() {
        this.engine.makeSomeNoise();
    }

    public void loadCargo(){
        System.out.println("loading stuff !!!");
    }
}
