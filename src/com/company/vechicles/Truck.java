package com.company.vechicles;

import com.company.game.EnumData;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Truck extends Vechicle {
    Integer loadCapacity;


    public Truck(String producer, Double value, String color, Double millage, Boolean needRepairs, EnumData.Parts[] parts, Integer loadCapacity) {
        super(producer, value, color, millage, needRepairs, parts);
        this.loadCapacity = loadCapacity;
    }

    public String getBrokenPartsPLNames() {
        StringBuilder partString = null;
        for (EnumData.Parts part : this.parts) {
            partString.append("\t\t").append(part.namePL).append("\n");
        }
        return partString.toString();
    }

    @Override
    public String toString() {
        return "Samochód dostawczy:" + "\n" +
                "\tMarka: " + producer + "\n" +
                "\tCena: " + NumberFormat.getCurrencyInstance().format(value) + "\n" +
                "\tKolor: " + color + "\n" +
                "\tPrzebieg: " + millage + "\n" +
                "\tPrzestrzeń ładunkowa: " + loadCapacity + "\n" +
                "\tCzy wymaga naprawy: " + ((needRepairs) ? "Tak" : "Nie") + "\n" +
                "\tCzęści do naprawy: " + ((needRepairs) ? Arrays.toString(this.parts) : "[]");
    }

}
