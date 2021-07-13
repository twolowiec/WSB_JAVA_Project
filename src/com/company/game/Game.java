package com.company.game;

import com.company.Main;
import com.company.actors.Customer;
import com.company.actors.Player;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends Menus {
    public final Integer noOfPlayers;
    public final Boolean winingCondition;
    Integer mainMenu = mainInGameMenu();
    Integer marketMenu = inMarketMenu();
    public Integer turn = 0;


    public Game(Integer noPlayers, Boolean winingCondition) {
        this.noOfPlayers = noPlayers;
        this.winingCondition = winingCondition;
        ArrayList<Customer> customers = new ArrayList<>();

        turn++;

        Scanner sc = new Scanner(System.in);
        System.out.print("Graczu podaj swoje imie: ");
        String playerName = sc.next();

        Player player = new Player(playerName, 50000.0);

//        System.out.println("Gracz: " + playerName + "\t\tKasa: "+ player.cash+"\t\tTura: "+turn);
        while (!winingCondition || mainMenu == 0) {
            System.out.println("Gracz: " + playerName + "\t\tKasa: " + player.cash + "\t\tTura: " + turn);

            switch (mainMenu) {
                case 1: {
                    switch (marketMenu) {
                        case 0:
                    }
                    break;
                }
                case 2: {
                    player.getDealerCars().toString();
                    break;
                }
                case 3: {
                    customers.toString();
                    break;
                }
                case 4: {
                    System.out.println("Twój obecny stan konta to: " + player.cash);
                    break;
                }
                case 5: {
                    System.out.println("Historia transakcji: /n");
                    player.getTransactions().toString();
                    break;
                }
                case 6: {

                    break;
                }
                default:
                    System.out.println("Prosze o wybór opcji z menu!");
            }

        }
    }

    public Boolean isWiningConditionMeet() {
        return true;
    }
}
