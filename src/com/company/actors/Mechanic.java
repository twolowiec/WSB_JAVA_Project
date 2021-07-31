package com.company.actors;

import com.company.game.EnumData;

public class Mechanic {
    public String name; // Janusz / Marian / Adrian
    Integer repairEfficiency; // Janusz 100% / Marian 90% / Adrian 80%
    Integer repairFaliureChance; // Janusz 0% / Marian 0% / Adrian 2%
    Double priceMultiplier; // Janusz 3x / Marian 1.1x / Adrian 0.6x

    public Mechanic(EnumData.Mechanics mechanic) {
        this.name = mechanic.displayName;
        this.repairEfficiency = mechanic.efficiency;
        this.repairFaliureChance = mechanic.failureChance;
        this.priceMultiplier = mechanic.priceMultiplier;
    }

    public Double getRepairPrice(Double partPrice, Double segmentMultiplier, Double vechicleMultiplier ) {
        return partPrice * segmentMultiplier * this.priceMultiplier * vechicleMultiplier;
    }
}
