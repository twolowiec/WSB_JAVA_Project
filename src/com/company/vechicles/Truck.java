package com.company.vechicles;

public class Truck extends Vechicle {
    Double loadCapacity;


    public Truck(String producer, String model, Double value, String color, Double millage, Double loadCapacity) {
        super(producer, model, value, color, millage);
        this.loadCapacity = loadCapacity;
    }
}
