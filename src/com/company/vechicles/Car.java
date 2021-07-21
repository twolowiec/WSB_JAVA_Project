package com.company.vechicles;

import com.company.game.EnumData;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Car extends Vechicle {
    String segment;

    public Car(String producer, Double value, String color, Double millage, Boolean needRepairs, ArrayList<EnumData.Parts> brokenParts, String segment) {
        super(producer, value, color, millage, needRepairs, brokenParts);
        this.segment = segment;
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
        String partsString = getBrokenPartsPLNames();
        return "Samochód osobowy:\n" +
                "\tProducent: " + producer + '\n' +
                "\tCena: " + NumberFormat.getCurrencyInstance().format(value) + '\n' +
                "\tSegment: " + segment + '\n' +
                "\tKolor: " + color + '\n' +
                "\tPrzebieg: " + millage + '\n' +
                "\tCzy wymaga naprawy: " + ((needRepairs) ? "Tak" : "Nie") + "\n" +
                "\tCzęści do naprawy: \n" + ((partsString != null) ? partsString : "Brak");

    }
}
