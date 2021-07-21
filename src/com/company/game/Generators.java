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
        EnumData.VechicleType type = EnumData.VechicleType.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleType.values().length)];
        // Pożadanym stanem pojazdu sterujemy za pomoca pola buyingVillingness w zbiorze ENUM CustomerVechicleCondition

        int condition = ThreadLocalRandom.current().nextInt(0, 100);
        int desiredCapacity = ThreadLocalRandom.current().nextInt(5, 15) * 100;

        for (int o = 0; o <= 1; o++) {
            brands[o] = EnumData.VechicleBrands.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleBrands.values().length)];
        }

        Customer newCustomer = new Customer(firstName, lastName, brands, cash, type, condition, desiredCapacity);
        return newCustomer;
    }

    public static void generateVechicle() {
//    public Vechicle generateVechicle() {
        EnumData.VechicleBrands brands = null;
        EnumData.VechicleType type = EnumData.VechicleType.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleType.values().length)];
        EnumData.VechicleBrands brand = EnumData.VechicleBrands.values()[ThreadLocalRandom.current().nextInt(0, EnumData.VechicleBrands.values().length)];
        if (brand.isCargo && type == EnumData.VechicleType.TRUCK) {
            generateTruck(brand);
            System.out.println(generateTruck(brand).toString());
        } else {
            generateCar(brand);
            System.out.println(generateCar(brand).toString());
        }
    }


    public static Car generateCar(EnumData.VechicleBrands brand) {
        String producer = String.valueOf(brand);
        boolean broken = ThreadLocalRandom.current().nextBoolean();
        ArrayList<EnumData.Parts> parts = new ArrayList<EnumData.Parts>();
        if (broken) {
            if (parts == null) {
                for (EnumData.Parts part : parts) {
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        parts.add(part);
                    }
                }
            }
        }

        String color = EnumData.Color.values()[ThreadLocalRandom.current().nextInt(0, EnumData.Color.values().length)].colorNamePL;
        String segment = brand.segment.displayName;
        double millage = Math.round(ThreadLocalRandom.current().nextDouble(500.0, 4000.0) * 1000.0) / 10.0;

        double price = brand.mediumPricePersonal; // zrobić warunek jeżeli do naprawy to cena do -3/4 jeżeli nie to do + 3/4

        Car newCar = new Car(producer, price, color, millage, broken, parts, segment);
        return newCar;
    }

    public static Truck generateTruck(EnumData.VechicleBrands brand) {
        String producer = String.valueOf(brand);
        boolean broken = ThreadLocalRandom.current().nextBoolean();
        ArrayList<EnumData.Parts> parts = new ArrayList<EnumData.Parts>();
        if (broken) {
            if (parts == null) {
                for (EnumData.Parts part : parts) {
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        parts.add(part);
                    }
                }
            }
        }
        String color = EnumData.Color.values()[ThreadLocalRandom.current().nextInt(0, EnumData.Color.values().length)].colorNamePL;
        double millage = Math.round(ThreadLocalRandom.current().nextDouble(500.0, 4000.0) * 1000.0) / 10.0;
        int capacity = brand.cargoCapacity;
        double price = brand.mediumPricePersonal; // zrobić warunek jeżeli do naprawy to cena do -3/4 jeżeli nie to do + 3/4
        Truck newTruck = new Truck(producer, price, color, millage, broken, parts, capacity);
        return newTruck;
    }

    public Boolean needRepairs() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public EnumData.Parts brokenParts() {
        return EnumData.Parts.values()[ThreadLocalRandom.current().nextInt(0, EnumData.Parts.values().length)];
    }
}
