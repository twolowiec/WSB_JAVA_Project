package com.company.vechicles;

import com.company.game.EnumData;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Car extends Vechicle {
    public EnumData.CarSegment segment;
//    private EnumData.Parts[] parts;

    public Car(String producer, Double value, String color, Double millage, Boolean needRepairs, ArrayList<EnumData.Parts> brokenParts, EnumData.CarSegment segment) {
        super(producer, value, color, millage, needRepairs, brokenParts);
        this.segment = segment;
    }

//    public String getBrokenPartsPLNames() {
//        String partString = null;
//        for (int i = 0; i < this.parts.length; i++) {
//            partString += "\t\t" + parts[i].namePL + "\n";
//        }
//        return partString;
//    }


    public EnumData.CarSegment getSegment() {
        return segment;
    }

    @Override
    public String toString() {
        String bParts = "";
        for (EnumData.Parts part : this.brokenParts) {
            bParts += "\t\t" + part.namePL + "\n";
        }

        return "\nSamochód osobowy: " + "[" + id + "]\n" +
                "\tProducent: " + producer + '\n' +
                "\tCena: " + NumberFormat.getCurrencyInstance().format(value) + '\n' +
                "\tSegment: " + segment.displayName + '\n' +
                "\tKolor: " + color + '\n' +
                "\tPrzebieg: " + millage + " km\n" +
                "\tCzy wymaga naprawy: " + ((needRepairs) ? "Tak" : "Nie") + "\n" +
                ((needRepairs) ? "\tCzęści do naprawy: \n" : "") +
                bParts +
                "-------------------------------\n";

//                ((needRepairs) ? brokenParts.toString() : "[]");
    }
}
