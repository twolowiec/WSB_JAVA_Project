package com.company.vechicles;

import com.company.game.EnumData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Vechicle {
    String producer;
    Double value;
    String color;
    Double millage;
    Boolean needRepairs;
    EnumData.Parts[] parts;
//    static ArrayList<EnumData.Parts> brokenParts;


    public Vechicle(String producer, Double value, String color, Double millage, Boolean needRepairs, EnumData.Parts[] parts) {
        this.producer = producer;
        this.value = value;
        this.color = color;
        this.millage = millage;
        this.needRepairs = needRepairs;
        this.parts = parts;
    }

//    public static void setBrokenParts(EnumData.Parts part) {
//        brokenParts.add(part);
//    }

    public String getBrokenPartsPLNames() {
        StringBuilder partString = null;
        for (EnumData.Parts part : this.parts) {
            partString.append("\t\t").append(part.namePL).append("\n");
        }
        return partString.toString();
    }

    @Override
    public String toString() {
        return "Vechicle{" +
                "producer='" + producer + '\'' +
                ", value=" + value +
                ", color='" + color + '\'' +
                ", millage=" + millage +
                ", needRepairs=" + needRepairs +
                ", parts=" + Arrays.toString(parts) +
                '}';
    }
}


