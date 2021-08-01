package com.company.vechicles;

import com.company.actors.Mechanic;
import com.company.game.EnumData;

public abstract class Repairs {
    public EnumData.VechicleHistory operation;
    public Integer turn;
    public Vechicle vechicle;
    public EnumData.Parts part;
    public Mechanic mechanic;
    public String effect;

    public Repairs(EnumData.VechicleHistory operation, Integer turn, Vechicle vechicle, EnumData.Parts part, Mechanic mechanic, String effect) {
        this.operation = operation;
        this.turn = turn;
        this.vechicle = vechicle;
        this.part = part;
        this.mechanic = mechanic;
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "Dzień: " + turn +
                ", \tPojazd: " + vechicle +
                ", \tCzęść" + part +
                ", \tWarsztat: U" + mechanic + "a" +
                ", \tWynik: " + effect;
    }
}
