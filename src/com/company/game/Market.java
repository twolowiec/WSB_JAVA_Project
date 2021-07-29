package com.company.game;

import com.company.vechicles.Vechicle;

import java.util.ArrayList;


public class Market {
    public ArrayList<Vechicle> marketVechicles;

    public Market() {
        this.marketVechicles = new ArrayList<>();
    }

    public ArrayList<Vechicle> getMarketVechicles() {
        return this.marketVechicles;
    }

    public void setMarketVechicles(Vechicle vechicle) {
        marketVechicles.add(vechicle);
    }

    public void addVechicleToMarket(Vechicle vechicle) {
        marketVechicles.add(vechicle);
    }

    public void removeVechicleFromMarket (Vechicle vechicle) {
        marketVechicles.remove(vechicle);
    }


}
