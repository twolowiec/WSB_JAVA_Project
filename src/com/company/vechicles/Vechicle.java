package com.company.vechicles;

import com.company.game.EnumData;

import java.util.ArrayList;
import java.util.Arrays;

public class Vechicle {
    String producer;
    Double value;
    String color;
    Double millage;
    Boolean needRepairs;
    EnumData.Parts[] parts;
    ArrayList<EnumData.Parts> brokenParts = new ArrayList<EnumData.Parts>();


    public Vechicle(String producer, Double value, String color, Double millage, Boolean needRepairs, ArrayList<EnumData.Parts> brokenParts) {
        this.producer = producer;
        this.value = value;
        this.color = color;
        this.millage = millage;
        this.needRepairs = needRepairs;
        this.brokenParts = brokenParts;
    }

    public void setBrokenParts(EnumData.Parts part) {
        this.brokenParts.add(part);
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
        return "Vechicle{" +
                "producer='" + producer + '\'' +
                ", value=" + value +
                ", color='" + color + '\'' +
                ", millage=" + millage +
                ", needRepairs=" + needRepairs +
                ", parts=" + Arrays.toString(parts) +
                ", brokenParts=" + brokenParts +
                '}';
    }
}


