package com.company.vechicles;

import com.company.game.EnumData;

import java.util.ArrayList;
import java.util.Arrays;

public class Vechicle {
    public static int id;
    public String producer;
    Double value;
    String color;
    Double millage;
    Boolean needRepairs;
    //    EnumData.Parts[] parts;
    ArrayList<EnumData.Parts> brokenParts;



    public Vechicle(String producer, Double value, String color, Double millage, Boolean needRepairs, ArrayList<EnumData.Parts> brokenParts) {
        this.producer = producer;
        this.value = value;
        this.color = color;
        this.millage = millage;
        this.needRepairs = needRepairs;
        this.brokenParts = brokenParts;
    }

    public Double getValue() {
        return this.value;
    }

    public Integer conditionValue () {
        int condition = 0;
        if (brokenParts.size() == 0)
            condition = EnumData.CustomerVechicleCondition.OPERATIONAL.buyingVillingness;
        else if (brokenParts.contains(EnumData.Parts.SUSPENSION) && brokenParts.size() == 1)
            condition = EnumData.CustomerVechicleCondition.FAULTYSUSPENSION.buyingVillingness;
        else
            condition = EnumData.CustomerVechicleCondition.BROKEN.buyingVillingness;
        return condition;
    }

//    public static void setBrokenParts(EnumData.Parts part) {
//        brokenParts.add(part);
//    }

//    public String getBrokenPartsPLNames() {
//        StringBuilder partString = null;
//        for (EnumData.Parts part : this.parts) {
//            partString.append("\t\t").append(part.namePL).append("\n");
//        }
//        return partString.toString();
//    }

    @Override
    public String toString() {
        return "Marka: " + producer + ", " +
                "Wartość: " + value + ", " +
                "Kolor: " + color + ", " +
                "Przebieg: " + millage + ", " +
                ", needRepairs=" + needRepairs +
                ", parts=" + brokenParts.toArray().toString();
    }
}


