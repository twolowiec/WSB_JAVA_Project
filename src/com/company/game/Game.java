package com.company.game;

import com.company.Effects;
import com.company.actors.Customer;
import com.company.actors.Mechanic;
import com.company.actors.Player;
import com.company.vechicles.Car;
import com.company.vechicles.Vechicle;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.game.Generators.generateCustomer;
import static com.company.game.Generators.generateVechicle;

public class Game extends Menus {
    Integer noOfPlayers;
    Double startingCash;
    Integer cashMultiplier;
    Integer turnLimit;

    public static Integer turn = 1;
    Boolean onceATurn = false;
    Boolean winingCondition = false;

    public Game(Integer noPlayers, Double startingCash, Integer cashMultiplier, Integer turnLimit) {
        this.noOfPlayers = noPlayers;
        this.startingCash = startingCash;
        this.cashMultiplier = cashMultiplier;
        this.turnLimit = turnLimit;

        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            customers.add(generateCustomer());
        }

        Market market = new Market();

        for (int i = 0; i < 15; i++) {
            market.setMarketVechicles(generateVechicle());
        }

        Mechanic janusz = new Mechanic(EnumData.Mechanics.JANUSZ);
        Mechanic marian = new Mechanic(EnumData.Mechanics.MARIAN);
        Mechanic adrian = new Mechanic(EnumData.Mechanics.ADRIAN);

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
                        System.out.println("Nie mo??esz ju?? w tej turze wykona?? zakupu samochodu.");
                        Effects.pressAnyKey();
                    } else {
                        System.out.println("Podaj 0 aby powr??ci?? do menu.");
                        System.out.println("Lub wybierz ID samochodu kt??ry chcesz zakupi??.");

                        System.out.print("Tw??j wyb??r: ");
                        int chooseMarketCar = sc.nextInt();
                        if (chooseMarketCar == 0) {
                            break;
                        } else {
                            player.buyMarketVechicle(market.marketVechicles.get(chooseMarketCar - 1));
                            market.marketVechicles.remove(chooseMarketCar - 1);
                            onceATurn = true;
                        }
                    }
                    break;
                }
                case 2: {
                    Effects.clearConsole();
                    System.out.println("Lista posiadanych pojazd??w:");
                    for (int i = 0; i < player.getDealerCars().size(); i++) {
                        Vechicle.id = i + 1;
                        System.out.println(player.getDealerCars().get(i).toString());
                    }
                    System.out.print("\nPodaj nr pojazdu dla kt??rego chcesz wykona?? akcje lub [0] aby powr??ci??: ");
                    int chooseVechicle = sc.nextInt();
                    if (chooseVechicle == 0) {
                        break;
                    }
                    Effects.clearConsole();
                    Vechicle vechicle = player.getDealerCars().get(chooseVechicle - 1);
                    vechicle.toString();
                    vechicleMenu(onceATurn);
                    int vechicleMenuChoice = sc.nextInt();
                    switch (vechicleMenuChoice) {
                        case 1: {
                            if (!vechicle.needRepairs) {
                                System.out.println("Ten pojazd nie wymaga napraw.");
                                Effects.pressAnyKey();
                                break;
                            } else if (onceATurn) {
                                System.out.println("W tej turze juz nie mo??esz naprawi?? ??adnego elementu.");
                                Effects.pressAnyKey();
                                break;
                            } else {
                                System.out.println("Kt??r?? cz?????? chcesz naprawi???");
                                for (int i = 0; i < vechicle.brokenParts.size(); i++) {
                                    System.out.println("\t[" + (i + 1) + "] " + vechicle.getBrokenParts(i).namePL);
                                }
                                System.out.println("\t[8] Powr??t do g??ownego menu.");
                                System.out.print("Tw??j wyb??r: ");
                                int partChoice = sc.nextInt();
                                if (partChoice == 8) break;
                                else {
                                    Double segmentMultiplier;
                                    Double partPrice = vechicle.getBrokenParts(partChoice - 1).partsPrice;
                                    Double brandMultiplier = EnumData.VechicleBrands.valueOf(vechicle.producer).partsBrandMultiplier;
                                    if (vechicle instanceof Car)
                                        segmentMultiplier = ((Car) vechicle).segment.segmentPartsMultiplier;
//                                                EnumData.CarSegment.values().equals(EnumData.VechicleBrands.valueOf(((Car) vechicle).segment.displayName)).segmentPartsMultiplier;
                                    else
                                        segmentMultiplier = 0.9;
                                    System.out.println("U kogo chcesz dokonac naprawy " + vechicle.getBrokenParts(partChoice - 1).namePL + "?");
                                    // mo??na by to zebrac w kolekcje uprosci??
                                    System.out.println("[1] U " + janusz.name + "a za kwot??: " + NumberFormat.getCurrencyInstance().format(janusz.getRepairPrice(partPrice, segmentMultiplier, brandMultiplier)));
                                    System.out.println("[2] U " + marian.name + "a za kwot??: " + NumberFormat.getCurrencyInstance().format(marian.getRepairPrice(partPrice, segmentMultiplier, brandMultiplier)));
                                    System.out.println("[3] U " + adrian.name + "a za kwot??: " + NumberFormat.getCurrencyInstance().format(adrian.getRepairPrice(partPrice, segmentMultiplier, brandMultiplier)));
                                    System.out.print("Tw??j wyb??r: ");
                                    int mechanicChoice = sc.nextInt();
                                    double repairCost = 0.0;
                                    switch (mechanicChoice) {
                                        case 1:
                                            vechicle.repairPart(vechicle.getBrokenParts(partChoice - 1), janusz);
                                            repairCost = janusz.getRepairPrice(partPrice, segmentMultiplier, brandMultiplier);
                                            break;
                                        case 2:
                                            vechicle.repairPart(vechicle.getBrokenParts(partChoice - 1), marian);
                                            repairCost = marian.getRepairPrice(partPrice, segmentMultiplier, brandMultiplier);
                                            break;
                                        case 3:
                                            vechicle.repairPart(vechicle.getBrokenParts(partChoice - 1), adrian);
                                            repairCost = adrian.getRepairPrice(partPrice, segmentMultiplier, brandMultiplier);
                                            break;

                                    }
                                    player.cash -= repairCost;
                                    player.addTransaction(EnumData.Costs.REPAIR, vechicle, (repairCost * -1));
                                    onceATurn = true;
                                }
                            }
                            break;
                        }
                        case 2: {
                            vechicle.getRepairHistory();
                            break;

                        }
                        case 3: {
                            player.getTransactions(vechicle);
                            break;
                        }
                        case 4: {
                            vechicle.setMarkup();
                            break;
                        }
                        case 5: {
                            Double cost = vechicle.washVechicle();
                            player.addTransaction(EnumData.Costs.DETAILING, vechicle, cost * -1);
                            break;
                        }
                        case 8: {
                            Effects.clearConsole();
                            break;
                        }
                        default:
                            System.out.println("Nieprawid??owy wyb??r!");
                    }
                    break;
                }
                case 3: {
                    Effects.clearConsole();
                    for (int i = 0; i < customers.size(); i++) {
                        Customer.id = i + 1;
                        System.out.printf(customers.get(i).toString());
                    }
                    System.out.println("Wybierz [0] aby powr??ci?? lub");
                    System.out.print("\nWybierz ID klienta z kt??rym chcesz przeprowadzi?? transakcje: ");
                    int clientId = sc.nextInt();
                    if (clientId == 0){
                        break;
                    }
                    Effects.clearConsole();
                    Customer customer = customers.get(clientId-1);
                    customer.toString();
                    System.out.println("Lista posiadanych pojazd??w:");
                    for (int i = 0; i < player.getDealerCars().size(); i++) {
                        Vechicle.id = i + 1;
                        System.out.println(player.getDealerCars().get(i).toString());
                    }
                    System.out.print("\nPodaj nr pojazdu dla kt??ry chcesz sprzeda??: ");
                    int chooseVechicle = sc.nextInt();
                    Vechicle vechicle = player.getDealerCars().get(chooseVechicle - 1);

                    try {
                        if (player.sellVechicle(vechicle, customer) == true) {
                            System.out.println("Sprzeda?? zako??czona sukcesem!");
                            customers.remove(customer);
                            System.out.println("Transakcja generuje 2 nowych klient??w.");
                            customers.add(generateCustomer());
                            customers.add(generateCustomer());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Effects.pressAnyKey();
                    break;
                }
                case 4: {
                    Effects.clearConsole();
                    System.out.printf("Tw??j obecny stan konta to: %.2f\n", player.cash);
                    break;
                }
                case 5: {
                    Effects.clearConsole();
                    if (onceATurn) {
                        System.out.println("Ju?? kupi??e?? reklam?? w tej turze!");
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
                    System.out.println(player.getTransactions().toString());
                    break;
                }
                case 9: {
                    this.turn++;
                    this.onceATurn = false;
                    int i = 0;
                    for (; i < (ThreadLocalRandom.current().nextInt(1, 3)); i++) {
                        market.marketVechicles.add(generateVechicle());
                    }
                    System.out.println("Na rynku pojawi??y si?? " + i + " nowe pojazdy.");
                    // mo??e to w jaki?? komunikat zapi????/zebra??
                    try {
                        Effects.loading("nowej tury");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    System.out.println("Prosze o wyb??r opcji z menu!");
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
            try {
                Effects.winner(playerName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (!isLoseGameConditionMeet()) {
            //todo w przypadku gry na wi??cej ni?? 1 gracza dodatkowy warunek
            try {
                Effects.loser();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            Effects.clearConsole();
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("Ju?? nas opuszczasz " + playerName + "? Mam nadziej?? ze Ci si?? podoba??o.");
        }
        System.out.printf("Tw??j wynik to: %.2f\n\n\n", player.cash);
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
