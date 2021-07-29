package com.company.actors;

import com.company.game.EnumData;
import com.company.game.Transaction;
import com.company.vechicles.Vechicle;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    public String name;
    public Double cash;

    ArrayList<Vechicle> dealerCars;
    ArrayList<Transaction> transactions;

    public Player(String name, Double cash) {
        this.name = name;
        this.cash = cash;
        this.dealerCars = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public ArrayList<Vechicle> getDealerCars() {
        return dealerCars;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void buyMarketVechicle(Vechicle vechicle) {
        if (cash < vechicle.getValue()) {
            System.out.println("Nie stać Cię na zakup tego pojazdu.");
        } else {
            this.dealerCars.add(vechicle);
            // TODO zdjąć pojazd z marketu i dodac nowy (przenieść market do klasy)
            this.cash -= vechicle.getValue();

            // TODO add to transactions
            System.out.println("Zakupiłeś nastepujący pojazd: \n" + vechicle.toString());
            payTax(vechicle);
        }
    }



    public void sellVechicle(Vechicle vechicle, Customer customer) throws Exception {
        if (customer.money < vechicle.getValue()) {
            throw new Exception ("Klienta nie stac na zakup tego pojazdu."); // Wiem powinno być inglisz
        }
        if (!(String.valueOf(customer.brandPreference[0]) == vechicle.producer || String.valueOf(customer.brandPreference[1]) == vechicle.producer)) {
            throw new Exception("Klienta nie interesuje ta marka.");// poprawić warunek logiczny i dobrze przetestować
        }
        if (customer.vechicleCondition > vechicle.conditionValue()) {
            throw new Exception("Klient nie chce tak uszkodzonego pojazdu.");
        }


    }

    public void payTax (Vechicle vechicle) {
        double tax = vechicle.getValue() * 0.02;
        this.cash -= tax;
        System.out.println("Zapłaciłeś 2% podatku od wartości pojazdu: " + NumberFormat.getCurrencyInstance().format(tax));
        // TODO add to transactions
    }

    public Integer buyAd (EnumData.Advertisement advertisement) {
        int adCost = 0;
        int newCustomers = 0;
        if (advertisement == EnumData.Advertisement.NEWSPAPER) {
            adCost = EnumData.Advertisement.NEWSPAPER.cost;
            newCustomers = ThreadLocalRandom.current().nextInt(2,4);
        } else if (advertisement == EnumData.Advertisement.INTERNET) {
            adCost = EnumData.Advertisement.INTERNET.cost;
            newCustomers = 1;
        }
        this.cash -= (double) adCost;
        // TODO add to transactions

        System.out.println("Kupiłeś reklamę w: " + advertisement.namePL);
        System.out.println("Za kwotę: " + NumberFormat.getCurrencyInstance().format(adCost));
        System.out.println("Przyciągneła ona nastepującą liczbę klientów: " + newCustomers);

        return newCustomers;
    }



    public Double getCash () {
        return cash;
    }

    @Override
    public String toString() {
        return "Gracz: " + name + "\tGotówka: " + cash;
    }
}
