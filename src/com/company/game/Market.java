package com.company.game;

import com.company.vechicles.*;

import java.util.ArrayList;


public class Market {
    public ArrayList<Vechicle> marketVechicles = new ArrayList<>();

    public ArrayList<Vechicle> getMarketVechicles() {
        return this.marketVechicles;
    }

    public void setMarketVechicles(ArrayList<Vechicle> marketVechicles) {
        this.marketVechicles = marketVechicles;
    }

    public void addVechicleToMarket(Vechicle vechicle) {
        marketVechicles.add(vechicle);
    }

    public void removeVechicleFromMarket (Vechicle vechicle) {
        marketVechicles.remove(vechicle);
    }


}
