package com.company.game;

import com.company.actors.Customer;
import com.company.vechicles.*;

public class Generators {
    Customer newCustomer;
    Car newCar;
    Truck newTruck;
    // todo listy wartości

    // TODO Metody generatorów
    // Generator samochodów
    // Generator klientów


    public Generators() {

    }

    public Customer generateCustomer () {
        return newCustomer;
    }

    public Car generateCar() {
        return newCar;
    }

    public Truck generateTruck() {
        return newTruck;
    }

    public Boolean needRepairs () {
        return false;
    }

    public Integer brokenParts () {
        return 0;
    }
}
