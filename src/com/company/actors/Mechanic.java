package com.company.actors;

public class Mechanic {
    String name; // Janusz / Marian / Adrian
    Integer repairEfficiency; // Janusz 100% / Marian 90% / Adrian 80%
    Integer repairFaliureChance; // Janusz 0% / Marian 0% / Adrian 2%
    Double priceMultiplier; // Janusz 3x / Marian 1.1x / Adrian 0.6x

    public Mechanic(String name, Integer repairEfficiency, Integer repairFaliureChance, Double priceMultiplier) {
        this.name = name;
        this.repairEfficiency = repairEfficiency;
        this.repairFaliureChance = repairFaliureChance;
        this.priceMultiplier = priceMultiplier;
    }

    public Double getRepairPrice(Double partPrice, Double segmentMultiplier, Double vechicleMultiplier ) {
        return partPrice * segmentMultiplier * this.priceMultiplier * vechicleMultiplier;
    }
}
