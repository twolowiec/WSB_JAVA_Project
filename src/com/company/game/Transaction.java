package com.company.game;

import com.company.actors.Customer;
import com.company.vechicles.Vechicle;

public class Transaction {
    public Vechicle vechicle;
    public Customer customer;
    public Integer turn;
    public Double price;

    public Transaction(Vechicle vechicle, Customer customer, Integer turn, Double price) {
        this.vechicle = vechicle;
        this.customer = customer;
        this.turn = turn;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Operacja dotyczyła: " + "\n" +
                "\tPojazd: " + vechicle + "\n" +
                "\tKlient: " + customer + "\n" +
                "\tTura: " + turn +"\n" +
                "\tKwota: " + price +"\n";
    }
}
