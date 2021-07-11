package com.company;

import java.util.Scanner;

public class Menus {

    Scanner scanner = new Scanner(System.in);
    Boolean onceForATurn = false;
    String userInput;

    public void difficultyMenu () {
        // todo rookie / mid / pro - ten ostatni losowa kasa z przedziału
        // rozważyć time limit
    }

    public void mainInGameMenu () {
        System.out.println("\t *** Menu Główne ***\n");
        System.out.println("Wybierz opcje podajac cyfrę z klawiatury:");
        System.out.println("[1] Przeglądaj bazę pojazdów do kupienia.");
        System.out.println("[2] Przeglądaj bazę posiadanych pojazdów (przegląd placu).");
        System.out.println("[3] Przeglądaj bazę potencjalnych klientów.");
        System.out.println("[4] Informacje o koncie.");
        System.out.println("[5] Przeglądaj historie transakcji.");
        System.out.println("[6] Sprawdź historie napraw każdego pojazdu.");
        System.out.println("[7] Sprawdź historie kosztów każdego pojazdu.");
        System.out.println("[9] Zakończ turę.");
        System.out.println("[0] Opuść program.");
        System.out.print("Twój wybór: ");
        userInput = scanner.next();
    }

    public void inMarketMenu () {
        System.out.println("Lista dostępnych aut \n");
        // lista
        System.out.print("Który pojazd wybierasz? ");
        // todo opcja powrotu
        System.out.print("Twój wybór: ");
        userInput = scanner.next();
    }

    public void repairMenu () {
        System.out.print("Który pojazd chcesz naprawić? ");
        // lista tylko z uszkodzeniami
        // todo opcja powrotu
        System.out.print("Twój wybór: ");
        userInput = scanner.next();
    }

    public void mechanicMenu () {
        System.out.println("Wybierz z czyich usług chcesz skorzystać:");
        System.out.println("[1] Janusz - najdroższy, 100% szans na naprawę usterki"); // dodać cenę
        System.out.println("[2] Marian - tańszy, ale tylko 90% szans na naprawę usterki"); // dodać cenę
        System.out.println("[3] Adrian - najtańszy, tylko 80% szans na naprawę usterki i 2% szans na zepsucię czegoś innego"); // dodać cenę
        System.out.print("Twój wybór: ");
        userInput = scanner.next();
    }

    public void advertisementMenu () {
        System.out.println("Gdzie chcesz dać ogłoszenie?");
        System.out.println("[1] Gazeta: 4500 - kilku nowych klientów(2-4).");
        System.out.println("[2] Internet: 1500 - tylko jeden nowy klient.");
        // todo opcja powrotu
    }
}
