package com.company.game;

import com.company.vechicles.Vechicle;

import java.text.NumberFormat;

public class Transaction {
    public EnumData.AccountOperations operation;
    public EnumData.Costs title;
    public Vechicle vechicle;
    public Integer turn;
    public Double value;
    public Double balance;

    public Transaction(Vechicle vechicle, EnumData.AccountOperations operation, EnumData.Costs title, Integer turn, Double value, Double balance) {
        this.operation = operation;
        this.title = title;
        this.vechicle = vechicle;
        this.turn = turn;
        this.value = value;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nOperacja: " + operation.operationNamePL +
                "\tTytułem: " + title.namePL +
                "\tPojazd: " + vechicle.producer +
                "\tTura: " + turn +
                "\tKwota: " + NumberFormat.getCurrencyInstance().format(value) +
                "\tStan konta: " + NumberFormat.getCurrencyInstance().format(balance);
    }
}
