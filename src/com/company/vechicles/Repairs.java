package com.company.vechicles;

import com.company.actors.Mechanic;
import com.company.game.EnumData;

public abstract class Repairs {
    public Integer turn;
    public Vechicle vechicle;
    public EnumData.Parts part;
    public Mechanic mechanic;
    public String effect;

    public Repairs(Integer turn, Vechicle vechicle, EnumData.Parts part, Mechanic mechanic, String effect) {
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
