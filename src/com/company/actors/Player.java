package com.company.actors;

import com.company.game.Transaction;
import com.company.vechicles.Car;
import com.company.vechicles.Vechicle;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public Double cash;

    ArrayList<Car> dealerCars = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Player(String name, Double cash) {
        this.name = name;
        this.cash = cash;
    }

    public ArrayList<Car> getDealerCars() {
        return dealerCars;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }

    // TODO wkleić wcześniejsze próby
}
