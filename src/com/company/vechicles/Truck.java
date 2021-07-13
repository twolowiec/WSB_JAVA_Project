package com.company.vechicles;

public class Truck extends Vechicle {
    Double loadCapacity;


    public Truck(String producer, String model, Double value, String color, Double millage, Boolean needRepairs, Double loadCapacity) {
        super(producer, model, value, color, millage, needRepairs);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Samochód dostawczy:" + "\n" +
                "\tMarka: " + producer + "\n" +
                "\tModel: '" + model + "\n" +
                "\tCena: " + value + "\n" +
                "\tKolor: " + color + "\n" +
                "\tPrzebieg: " + millage + "\n" +
                "\tPrzestrzeń ładunkowa: " + loadCapacity + "\n" +
                "\tCzy wymaga naprawy: " + needRepairs + "\n";
    }
}
