package com.company.vechicles;

public class Car extends Vechicle {
    String segment;

    public Car(String producer, String model, Double value, String color, Double millage, String segment) {
        super(producer, model, value, color, millage);
        this.segment = segment;
    }

    @Override
    public String toString() {
        return "Samochód osobowy{" +
                "segment='" + segment + '\'' +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", value=" + value +
                ", color='" + color + '\'' +
                ", millage=" + millage +
                '}';
    }
}
