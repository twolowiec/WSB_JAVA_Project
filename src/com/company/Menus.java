package com.company;

import java.util.Scanner;

public class Menus {

    Scanner scanner = new Scanner(System.in);
    Boolean onceForATurn = false;
    String userInput;

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

    }
}
