package com.company.actors;

import com.company.game.EnumData;
import com.company.game.Game;
import com.company.game.Transaction;
import com.company.vechicles.Vechicle;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
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

    public String getTransactions(Vechicle vechicle) {
        String transact = "";
        for (Transaction transaction : transactions) {
            if (vechicle == transaction.vechicle) {
                 transact += transaction.toString();
            }

        }
        return transact;
    }

    public void buyMarketVechicle(Vechicle vechicle) {
        if (cash < vechicle.getValue()) {
            System.out.println("Nie stać Cię na zakup tego pojazdu.");
        } else {
            this.dealerCars.add(vechicle);

            this.cash -= vechicle.getValue();

            addTransaction(EnumData.Costs.BUY, vechicle, (vechicle.getValue() * -1));
            System.out.println("Zakupiłeś nastepujący pojazd: \n" + vechicle.toString());
            payTax(vechicle);
        }
    }



    public Boolean sellVechicle(Vechicle vechicle, Customer customer) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (customer.money < vechicle.getValue()) {
            throw new Exception ("Klienta nie stac na zakup tego pojazdu."); // Wiem powinno być inglisz
        }
        if (!(String.valueOf(customer.brandPreference[0]) == vechicle.producer || String.valueOf(customer.brandPreference[1]) == vechicle.producer)) {
            throw new Exception("Klienta nie interesuje ta marka.");// poprawić warunek logiczny i dobrze przetestować
        }
        if (customer.vechicleCondition > vechicle.conditionValue()) {
            throw new Exception("Klient nie chce tak uszkodzonego pojazdu.");
        }
        System.out.println("Czy wytargowałeś dodtkową marże przy sprzedaży?");
        System.out.println("\t [1] Tak");
        System.out.println("\t [2] Nie");
        int markup = sc.nextInt();
        if (markup == 1) {
            if (vechicle.millage < 150000.0){
                System.out.println("Panie niemiec tylko w niedziele do kościółka jeździł.");
            } else if (vechicle.brokenParts.size() < 1) {
                System.out.println("Panie niemiec pod kocem trzymał");
            } else {
                System.out.println("Panie niemiec płakał jak sprzedawał.");
            }
            vechicle.setMarkup();
        }

        this.dealerCars.remove(vechicle);
        this.cash += vechicle.getValue();
        payTax(vechicle);

        addTransaction(EnumData.Costs.SELL, vechicle, vechicle.getValue());
        return true;

    }

    public void payTax (Vechicle vechicle) {
        double tax = vechicle.getValue() * 0.02;
        this.cash -= tax;
        System.out.println("Zapłaciłeś 2% podatku od wartości pojazdu: " + NumberFormat.getCurrencyInstance().format(tax));
        addTransaction(EnumData.Costs.TAX, vechicle, (tax * -1));
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
        addTransaction(EnumData.Costs.ADVIERTISEMENT, null, ((double)adCost * -1));

        System.out.println("Kupiłeś reklamę w: " + advertisement.namePL);
        System.out.println("Za kwotę: " + NumberFormat.getCurrencyInstance().format(adCost));
        System.out.println("Przyciągneła ona nastepującą liczbę klientów: " + newCustomers);

        return newCustomers;
    }

    public void addTransaction (EnumData.Costs title, Vechicle vechicle, Double value) {
        EnumData.AccountOperations operation = null;
        if (value > 0) {
            operation = EnumData.AccountOperations.INCOME;
        } else {
            operation = EnumData.AccountOperations.OUTCOME;
        }
        Transaction transaction = new Transaction(vechicle, operation, title, Game.turn, value, cash);

        transactions.add(transaction);
    }

    public Double getCash () {
        return cash;
    }

    @Override
    public String toString() {
        return "Gracz: " + name + "\tGotówka: " + cash;
    }
}
