package com.company.game;

import com.company.Effects;
import com.company.actors.Customer;
import com.company.actors.Player;
import com.company.vechicles.Vechicle;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.game.Generators.generateCustomer;
import static com.company.game.Generators.generateVechicle;

public class Game extends Menus {
    Integer noOfPlayers;
    Boolean winingCondition = false;
    final Double startingCash;
    final Integer cashMultiplier;
    final Integer turnLimit;
    //    Integer mainMenu = mainInGameMenu();
//    Integer marketMenu = inMarketMenu();
    Integer turn = 1;
    Boolean onceATurn = false;


    public Game(Integer noPlayers, Double startingCash, Integer cashMultiplier, Integer turnLimit) throws InterruptedException {
        this.noOfPlayers = noPlayers;
        this.startingCash = startingCash;
        this.cashMultiplier = cashMultiplier;
        this.turnLimit = turnLimit;

        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            customers.add(generateCustomer());
        }
        // TODO przenieśc do marketu
        Market market = new Market();

        for (int i = 0; i < 15; i++) {
            market.setMarketVechicles(generateVechicle());
        }


        Scanner sc = new Scanner(System.in);
        System.out.print("Graczu podaj swoje imie: ");
        String playerName = sc.nextLine();
        Player player = new Player(playerName, startingCash);

        Effects.clearConsole();
        // Head bar
        System.out.printf("Gracz: %s\t \t\tKasa: %.2f\t\t\t\tTura: %d\n\n", playerName, player.cash, turn);
        // repeat Main Menu in loop
        mainInGameMenu(onceATurn);
        // read user input in loop
        int mainMenu = sc.nextInt();
        do {

            switch (mainMenu) {
                case 1: {
                    Effects.clearConsole();
                    for (int i = 0; i < market.marketVechicles.size(); i++) {
                        Vechicle.id = i + 1;
                        System.out.printf(market.marketVechicles.get(i).toString());
                    }

                    if (onceATurn == true) {
                        System.out.println("Nie możesz już w tej turze wykonać zakupu samochodu.");
                        Effects.pressAnyKey();
                    } else {
                        System.out.println("Podaj 0 aby powrócić do menu.");
                        System.out.println("Lub wybierz ID samochodu który chcesz zakupić.");

                        System.out.print("Twój wybór: ");
                        int chooseMarketCar = sc.nextInt();
                        if (chooseMarketCar == 0) {
                            break;
                        } else {
                            player.buyMarketVechicle(market.marketVechicles.get(chooseMarketCar - 1));
                            market.marketVechicles.remove(chooseMarketCar - 1);
                            onceATurn = true;
                        }
//                        if () {
//
//                        } else if (chooseMarketCar == 0) {
//
//                        } else System.out.println("Ten wybór jest niedozwolony");
                    }


                    break;
                }
                case 2: {
                    Effects.clearConsole();
                    for (int i = 0; i < player.getDealerCars().size(); i++) {
                        Vechicle.id = i + 1;
                        System.out.println(player.getDealerCars().get(i).toString());
                    }
                    break;
                }
                case 3: {
                    Effects.clearConsole();
                    for (int i = 0; i < customers.size(); i++) {
                        Customer.id = i + 1;
                        System.out.printf(customers.get(i).toString());
                    }
                    // TODO dodać tutaj sprzedaż z warunkiem i marżą

                    Effects.pressAnyKey();
                    break;
                }
                case 4: {
                    System.out.printf("Twój obecny stan konta to: %.2f\n", player.cash);
                    break;
                }
                case 5: {
                    Effects.clearConsole();
                    if (onceATurn) {
                        System.out.println("Już kupiłeś reklamę w tej turze!");
                        Effects.pressAnyKey();
                        break;
                    }
                    advertisementMenu();
                    int adChoice = sc.nextInt();
                    if (adChoice == 8)
                        break;
                    else {
                        int newCustomers = player.buyAd(EnumData.Advertisement.values()[adChoice - 1]);
                        for (int i = 0; i < newCustomers; i++) customers.add(generateCustomer());
                        Effects.pressAnyKey();
                        onceATurn = true;
                    }
                    break;
                }
                case 6: {
                    System.out.println("Wybrałeś 6");
                    player.getTransactions().toString();
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
                    this.turn++;
                    this.onceATurn = false;
                    int i = 0;
                    for (; i < (ThreadLocalRandom.current().nextInt(1, 3)); i++) {
                        market.marketVechicles.add(generateVechicle());
                    }
                    System.out.println("Na rynku pojawiły się " + i + " nowe pojazdy.");
                    // może to w jakiś komunikat zapiąć/zebrać
                    Effects.loading("nowej tury");
                    break;
                }
                default:
                    System.out.println("Prosze o wybór opcji z menu!");
            }

            Effects.clearConsole();
            // Head bar
            System.out.printf("Gracz: %s\t \t\tKasa: %.2f\t\t\t\tTura: %d\n\n", playerName, player.cash, turn);
            // repeat Main Menu in loop
            mainInGameMenu(onceATurn);
            // read user input in loop
            mainMenu = sc.nextInt();


        } while (isWiningConditionMeet(player) && mainMenu != 0 && isLoseGameConditionMeet());

        if (!isWiningConditionMeet(player)) {
            Effects.winner(playerName);
        } else if (!isLoseGameConditionMeet()) {
            //todo w przypadku gry na więcej niż 1 gracza dodatkowy warunek
            Effects.loser();
        } else {
            Effects.clearConsole();
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("Już nas opuszczasz " + playerName + "? Mam nadzieję ze Ci się podobało.");
        }
        System.out.printf("Twój wynik to: %.2f\n\n\n", player.cash);
        Effects.pressAnyKey();
    }

    Boolean isWiningConditionMeet(Player player) {
        // When returns false - breaks the loop
        return this.startingCash * this.cashMultiplier > player.cash;
    }

    Boolean isLoseGameConditionMeet() {
        // When returns false - breaks the loop
        if (this.turnLimit == null)
            return true;
        else return this.turn < this.turnLimit;
    }
}
