package com.company.game;

import com.company.Effects;
import com.company.Main;
import com.company.actors.Customer;
import com.company.actors.Player;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends Menus {
    final Integer noOfPlayers;
    Boolean winingCondition = false;
    final Double startingCash;
    final Integer cashMultiplier;
    final Integer turnLimit;
//    Integer mainMenu = mainInGameMenu();
//    Integer marketMenu = inMarketMenu();
    Integer turn = 1;


    public Game(Integer noPlayers, Double startingCash, Integer cashMultiplier, Integer turnLimit) throws InterruptedException {
        this.noOfPlayers = noPlayers;
        this.startingCash = startingCash;
        this.cashMultiplier = cashMultiplier;
        this.turnLimit = turnLimit;

        ArrayList<Customer> customers = new ArrayList<>();


        Scanner sc = new Scanner(System.in);
        System.out.print("Graczu podaj swoje imie: ");
        String playerName = sc.next();
        Player player = new Player(playerName, startingCash);

        Effects.clearConsole();
        System.out.printf("Gracz: %s\t \t\tKasa: %.2f\t\t\t\tTura: %d\n\n\n", playerName, player.cash, turn);
        mainInGameMenu();
        int mainMenu = sc.nextInt();
        do {
            isWiningConditionMeet(player);


//            System.out.println("Gracz: " + playerName + "\t\t\tKasa: " + player.cash + "\t\t\t\tTura: " + turn+"\n\n");


            switch (mainMenu) {
                case 1: {
                    System.out.println("Wybrałeś 1");
//                    Integer marketMenu = inMarketMenu();
//                    switch (marketMenu) {
//                        case 0:
//                    }
                    break;
                }
                case 2: {
                    System.out.println("Wybrałeś 2");
//                    player.getDealerCars().toString();
                    break;
                }
                case 3: {
                    System.out.println("Wybrałeś 3");
//                    customers.toString();
                    break;
                }
                case 4: {
                    System.out.printf("Twój obecny stan konta to: %.2f\n", player.cash);
                    break;
                }
                case 5: {
                    System.out.println("Historia transakcji: \n");
                    player.getTransactions().toString();
                    break;
                }
                case 6: {
                    System.out.println("Wybrałeś 6");
                    break;
                }
                case 7: {
                    System.out.println("Wybrałeś 7");
                    player.cash += 100001.00;
                    break;
                }
                case 8: {
                    System.out.println("Wybrałeś 8");
                    break;
                }
                case 9: {
                    isWiningConditionMeet(player);
                    this.turn++;
                    System.out.println("Wybrałeś 9");
                    break;
                }
                default:
                    System.out.println("Prosze o wybór opcji z menu!");
            }
            isWiningConditionMeet(player);
            Effects.clearConsole();
            System.out.printf("Gracz: %s\t \t\tKasa: %.2f\t\t\t\tTura: %d\n\n", playerName, player.cash, turn);
            mainInGameMenu();
            mainMenu = sc.nextInt();

        } while (!winingCondition && mainMenu != 0 && isEndgameConditionMeet());
        if (isWiningConditionMeet(player)) {
            //todo przenieść całość do efektów
            Effects.clearConsole();
            System.out.println("\n\n\n\n\n\n\n\n\n");
            Effects.winner(playerName);
            System.out.printf("Twój wynik to: %.2f\n\n\n", player.cash);
            Effects.pressAnyKey();
        } else if (isEndgameConditionMeet()){
            //todo przenieść całość do efektów
            // w przypadku gry na więcej niż 1 gracza dodatkowy warunek
            Effects.clearConsole();
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("Mam nadzieję ze Ci się podobało " + playerName + " i zagrasz jeszcze nie raz.");
            System.out.printf("Twój wynik to: %.2f\n\n\n", player.cash);
            Effects.pressAnyKey();
        } else {
            //todo przenieść całość do efektów
            Effects.clearConsole();
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("Mam nadzieję ze Ci się podobało " + playerName + " i zagrasz jeszcze nie raz.");
            System.out.printf("Twój wynik to: %.2f\n\n\n", player.cash);
            Effects.pressAnyKey();
        }


    }

    Boolean isWiningConditionMeet(Player player) {
        // todo uproscić
        if (this.startingCash * this.cashMultiplier < player.cash) {
            return this.winingCondition = true;
        } else return this.winingCondition = false;
    }

    Boolean isEndgameConditionMeet() {
        if (this.turnLimit == null)
            return false;
        else return this.turn < this.turnLimit;
    }
}
