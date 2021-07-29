package com.company.game;

import com.company.actors.Customer;
import com.company.vechicles.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Generators {
    //    private static ArrayList<EnumData.Parts> parts;
    Customer newCustomer;
    Car newCar;
    Truck newTruck;
    Vechicle newVechicle;
    // todo listy wartości

    // TODO Metody generatorów
    // Generator samochodów
    // Generator klientów


    public static Customer generateCustomer() {
        String firstName = String.valueOf(EnumData.FirstNames.values()[ThreadLocalRandom.current().nextInt(0, EnumData.FirstNames.values().length)]);
        String lastName = String.valueOf(EnumData.LastNames.values()[ThreadLocalRandom.current().nextInt(0, EnumData.LastNames.values().length)]);
        Double cash = Math.round(ThreadLocalRandom.current().nextDouble(10000.0, 200000.0) * 100.0) / 100.0;
        EnumData.VechicleBrands[] brands = new EnumData.VechicleBrands[2];

        for (int o = 0; o <= 1; o++) {
            brands[o] = EnumData.VechicleBrands.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleBrands.values().length)];
        }

        EnumData.VechicleType type;
        if (brands[0].isCargo == true || brands[1].isCargo == true) {
            type = EnumData.VechicleType.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleType.values().length)];
        } else {
            type = EnumData.VechicleType.CAR;
        }
        // Pożadanym stanem pojazdu sterujemy za pomoca pola buyingVillingness w zbiorze ENUM CustomerVechicleCondition

        int condition = ThreadLocalRandom.current().nextInt(0, 100);
        Integer desiredCapacity = null;
        if (type == EnumData.VechicleType.TRUCK) {
            desiredCapacity = ThreadLocalRandom.current().nextInt(5, 15) * 100;
        }

        Customer newCustomer = new Customer(firstName, lastName, brands, cash, type, condition, desiredCapacity);
        return newCustomer;
    }

    public static Vechicle generateVechicle() {
        EnumData.VechicleBrands brands = null;
        EnumData.VechicleType type = EnumData.VechicleType.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleType.values().length)];
        EnumData.VechicleBrands brand = EnumData.VechicleBrands.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleBrands.values().length)];
        if (brand.isCargo && type == EnumData.VechicleType.TRUCK) {
            return generateTruck(brand);
        } else {
            return generateCar(brand);
        }
    }


    public static Car generateCar(EnumData.VechicleBrands brand) {
        String producer = String.valueOf(brand);
        boolean broken = ThreadLocalRandom.current().nextBoolean();
//        EnumData.Parts[] parts = new EnumData.Parts[5];
        ArrayList<EnumData.Parts> brokenParts = new ArrayList<EnumData.Parts>();

        if (broken == true) {
            int i = 0;
            for (EnumData.Parts part : EnumData.Parts.values()) {
                if (ThreadLocalRandom.current().nextBoolean()) {
                    brokenParts.add(part);
                    i++;
                }
                if (i == 5) break;
            }
        }

        String color = EnumData.Color.values()[ThreadLocalRandom.current().nextInt(0, EnumData.Color.values().length)].colorNamePL;
        String segment = brand.segment.displayName;
        double millage = Math.round(ThreadLocalRandom.current().nextDouble(500.0, 4000.0) * 1000.0) / 10.0;
        double price = brand.mediumPricePersonal;
        double value;
        if (broken == true) {
            value = price - (price * (millage / 100000) / 8) - (price * (3 * brokenParts.size()/20)); // zrobić warunek jeżeli do naprawy to cena do -3/4 jeżeli nie to do + 3/4
        } else {
            value = price - price * (millage / 100000) / 6 + ThreadLocalRandom.current().nextDouble(0, brand.mediumPricePersonal / 4);
        }
        if (color == EnumData.Color.RED.colorNamePL) value *= 1.1; // bo czerwony szybszy xD
        Car newCar = new Car(producer, value, color, millage, broken, brokenParts, segment);
        return newCar;
    }

    public static Truck generateTruck(EnumData.VechicleBrands brand) {
        String producer = String.valueOf(brand);
        boolean broken = ThreadLocalRandom.current().nextBoolean();

        ArrayList<EnumData.Parts> brokenParts = new ArrayList<EnumData.Parts>();

        if (broken == true) {
            int i = 0;
            for (EnumData.Parts part : EnumData.Parts.values()) {
                if (ThreadLocalRandom.current().nextBoolean()) {
                    brokenParts.add(part);
                    i++;
                }
                if (i == 5) break;
            }
        }
        String color = EnumData.Color.values()[ThreadLocalRandom.current().nextInt(0, EnumData.Color.values().length)].colorNamePL;
        double millage = Math.round(ThreadLocalRandom.current().nextDouble(500.0, 4000.0) * 1000.0) / 10.0;
        Integer capacity = brand.cargoCapacity;
        double price = brand.mediumPricePersonal;
        double value;
        if (broken == true) {
            value = price - (price * (millage / 100000) / 8) - (price * (3 * brokenParts.size()/20));
        } else {
            value = price - price * (millage / 100000) / 6 + ThreadLocalRandom.current().nextDouble(0, brand.mediumPricePersonal / 4);
        }
        Truck newTruck = new Truck(producer, value, color, millage, broken, brokenParts, capacity);
        return newTruck;
    }

}
