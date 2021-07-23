package com.company.vechicles;

import com.company.game.EnumData;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Car extends Vechicle {
    String segment;
//    private EnumData.Parts[] parts;

    public Car(String producer, Double value, String color, Double millage, Boolean needRepairs, EnumData.Parts[] parts, String segment) {
        super(producer, value, color, millage, needRepairs, parts);
        this.segment = segment;
    }

    public String getBrokenPartsPLNames() {
        String partString = null;
        for (int i = 0; i < this.parts.length; i++) {
            partString += "\t\t" + parts[i].namePL + "\n";
        }
        return partString;
    }

    @Override
    public String toString() {

        return "Samochód osobowy:\n" +
                "\tProducent: " + producer + '\n' +
                "\tCena: " + NumberFormat.getCurrencyInstance().format(value) + '\n' +
                "\tSegment: " + segment + '\n' +
                "\tKolor: " + color + '\n' +
                "\tPrzebieg: " + millage + '\n' +
                "\tCzy wymaga naprawy: " + ((needRepairs) ? "Tak" : "Nie") + "\n" +
                "\tCzęści do naprawy: " + ((needRepairs) ? Arrays.toString(this.parts) : "[]");
    }
}
