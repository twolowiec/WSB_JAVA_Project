package com.company.vechicles;

import com.company.actors.Mechanic;
import com.company.game.EnumData;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Vechicle {
    public static int id;
    public String producer;
    Double value;
    String color;
    public Double millage;
    public Boolean needRepairs;
    //    EnumData.Parts[] parts;
    public ArrayList<EnumData.Parts> brokenParts;
    public ArrayList<Repairs> repairHistory;


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

    public Integer conditionValue() {
        int condition = 0;
        if (brokenParts.size() == 0)
            condition = EnumData.CustomerVechicleCondition.OPERATIONAL.buyingVillingness;
        else if (brokenParts.contains(EnumData.Parts.SUSPENSION) && brokenParts.size() == 1)
            condition = EnumData.CustomerVechicleCondition.FAULTYSUSPENSION.buyingVillingness;
        else
            condition = EnumData.CustomerVechicleCondition.BROKEN.buyingVillingness;
        return condition;
    }

//    public Boolean doNeedRepair() {
//        return needRepairs;
//    }

    public EnumData.Parts getBrokenParts(int i) {
        EnumData.Parts[] parts = new EnumData.Parts[brokenParts.size()];
        brokenParts.toArray(parts);
        return parts[i];
    }

    public void setMarkup() {
        System.out.println("Ustaw marże na wartości pojazdu.");
        System.out.println("[1] 0%");
        System.out.println("[2] 5%");
        System.out.println("[3] 10%");
        System.out.print("Twój wybór: ");
        Scanner margin = new Scanner(System.in);

        switch (margin.nextInt()) {
            case 1:
                this.value *= 1.00;
                System.out.println("Wybrałeś 0% marży.");
                break;
            case 2:
                this.value *= 1.05;
                System.out.println("Wybrałeś 5% marży.");
                break;
            case 3:
                this.value *= 1.1;
                System.out.println("Wybrałeś 10% marży.");
                break;
            default:
                System.out.println("Niedozwolony wybór!");
        }
        System.out.println("Nowa cena to: " + NumberFormat.getCurrencyInstance().format(this.value));
    }

    public void repairPart (EnumData.Parts part, Mechanic mechanic) {
        this.brokenParts.remove(part);
        this.value *= part.repairedValueMultiplier;
        // TODO dodać logikę na powodzenie naprawy
        // TODO add to reapirhistory

        if (brokenParts.size() < 1) needRepairs = false;
    }

    public ArrayList<Repairs> getRepairHistory() {
        return repairHistory;
    }

    public Double washVechicle() {
        Double detailingPrice = 0.0;
        if (this instanceof Truck) {
            detailingPrice = ThreadLocalRandom.current().nextDouble(300,1000) * 1.5;
        } else {
            detailingPrice = ThreadLocalRandom.current().nextDouble(300,1000);
        }
        // TODO add to repair history
        return detailingPrice;
    }

    public void addVechicleHistory (EnumData.Parts part, Mechanic mechanic, String effect) {

        if (part == null) {
            EnumData.VechicleHistory operation = EnumData.VechicleHistory.DETAILING;
            String effectMsg = "Mycie i woskowanie";
        } else {
            EnumData.VechicleHistory operation = EnumData.VechicleHistory.REPAIR;
        }
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


