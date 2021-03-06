package com.company.vechicles;

import com.company.game.EnumData;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Truck extends Vechicle {
    Integer loadCapacity;


    public Truck(String producer, Double value, String color, Double millage, Boolean needRepairs, ArrayList<EnumData.Parts> brokenParts, Integer loadCapacity) {
        super(producer, value, color, millage, needRepairs, brokenParts);
        this.loadCapacity = loadCapacity;
    }

//    public String getBrokenPartsPLNames() {
//        StringBuilder partString = null;
//        for (EnumData.Parts part : this.parts) {
//            partString.append("\t\t").append(part.namePL).append("\n");
//        }
//        return partString.toString();
//    }

    @Override
    public String toString() {
        String bParts = "";
        for (EnumData.Parts part : this.brokenParts) {
            bParts += "\t\t" + part.namePL + "\n";
        }

        return "\nSamochód dostawczy: " + "[" + id + "]\n" +
                "\tMarka: " + producer + "\n" +
                "\tCena: " + NumberFormat.getCurrencyInstance().format(value) + "\n" +
                "\tKolor: " + color + "\n" +
                "\tPrzebieg: " + millage + " km\n" +
                "\tPrzestrzeń ładunkowa: " + loadCapacity + "\n" +
                "\tCzy wymaga naprawy: " + ((needRepairs) ? "Tak" : "Nie") + "\n" +
                ((needRepairs) ? "\tCzęści do naprawy: \n" : "") +
                bParts +
                "-------------------------------\n";
        //Arrays.toString(this.parts)
    }

}
