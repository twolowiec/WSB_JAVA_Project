package com.company.game;

import com.company.Effects;

import java.util.Scanner;

public class Menus {

    Scanner scanner = new Scanner(System.in);
    static Scanner scannerStartMenu = new Scanner(System.in);
    static Scanner scannerDifficultyMenu = new Scanner(System.in);
//    Boolean onceForATurn = false;

    public void mainInGameMenu(boolean onceForATurn) {
        System.out.println("\t *** Menu Główne ***\n");
        if (onceForATurn) {
            System.out.println("Wybierz opcje podajac cyfrę z klawiatury:");
            System.out.println("[1] Przeglądaj bazę pojazdów do kupienia.");
            System.out.println("[2] Przeglądaj bazę posiadanych pojazdów (+ historia pojazdów i naprawy).");
            System.out.println("[3] Przeglądaj bazę potencjalnych klientów.");
            System.out.println("[4] Informacje o koncie.");
            System.out.println("[6] Przeglądaj historie transakcji.");
            System.out.println("[7] Sprawdź historie napraw każdego pojazdu.");
            System.out.println("[8] Sprawdź historie kosztów każdego pojazdu.");
            System.out.println("[9] Zakończ turę.");
            System.out.println("[0] Opuść program.");
            System.out.print("Twój wybór: ");
//            return scanner.nextInt();
        } else {
            System.out.println("Wybierz opcje podajac cyfrę z klawiatury:");
            System.out.println("[1] Przeglądaj bazę pojazdów do kupienia.");
            System.out.println("[2] Przeglądaj bazę posiadanych pojazdów (przegląd placu).");
            System.out.println("[3] Przeglądaj bazę potencjalnych klientów.");
            System.out.println("[4] Informacje o koncie.");
            System.out.println("[5] Kup reklamę.");
            System.out.println("[6] Przeglądaj historie transakcji.");
            System.out.println("[7] Sprawdź historie napraw każdego pojazdu."); // do wywalenia z głównego menu
            System.out.println("[8] Sprawdź historie kosztów każdego pojazdu."); // do wywalenia z głównego menu
            System.out.println("[9] Zakończ turę.");
            System.out.println("[0] Opuść grę.");
            System.out.print("Twój wybór: ");
        }
    }


    public void vechicleMenu (boolean onceForATurn) {
        if (onceForATurn) {
            System.out.println("Wybierz co chcesz zrobić z pojazdem: ");
            System.out.println("\t[2] Sprawdzić historię napraw pojazdu.");
            System.out.println("\t[3] Sprawdzić koszty związane z pojazdem.");
            System.out.println("\t[4] Ustawić marże na cenie.");
            System.out.println("\t[8] Powrót do poprzedniego menu.");
            System.out.print("Twój wybór: ");
        } else {
            System.out.println("Wybierz co chcesz zrobić z pojazdem: ");
            System.out.println("\t[1] Naprawić pojazd.");
            System.out.println("\t[2] Sprawdzić historię napraw pojazdu.");
            System.out.println("\t[3] Sprawdzić koszty związane z pojazdem.");
            System.out.println("\t[4] Ustawić marże na cenie.");
            System.out.println("\t[8] Powrót do poprzedniego menu.");
            System.out.print("Twój wybór: ");
        }
    }

    public void mechanicMenu (boolean onceForATurn) {
        if (onceForATurn) {
            System.out.println("Nie możesz naprawić żadnego auta w tej turze.");
            Effects.pressAnyKey();
        }
        System.out.println("Wybierz z czyich usług chcesz skorzystać:");
        System.out.println("[1] Janusz - najdroższy, 100% szans na naprawę usterki"); // dodać cenę
        System.out.println("[2] Marian - tańszy, ale tylko 90% szans na naprawę usterki"); // dodać cenę
        System.out.println("[3] Adrian - najtańszy, tylko 80% szans na naprawę usterki i 2% szans na zepsucię czegoś innego"); // dodać cenę
        System.out.println("[8] Powrót do głownego menu.");
        System.out.print("Twój wybór: ");
    }

    public void advertisementMenu () {
        System.out.println("Gdzie chcesz dać ogłoszenie?");
        System.out.println("[1] Gazeta: 4500 - kilku nowych klientów(2-4).");
        System.out.println("[2] Internet: 1500 - tylko jeden nowy klient.");
        System.out.println("[8] Powrót do głownego menu.");
        System.out.print("Twój wybór: ");
    }

    public static int startMenu() {
        System.out.println("Wybierz proszę co chcesz zrobić: \n");
        System.out.println("\t[1] Nowa gra.");
        System.out.println("\t[2] Instrukcja.");
        System.out.println("\t[3] O autorze.");
        System.out.println("\t[0] Zakończ program.");
        System.out.print("\nTwój wybór: ");
        return scannerStartMenu.nextInt();
    }

    public static int difficultyMenu() {
        System.out.println("\n\nChoose Your destiny: \n");
        System.out.println("\t[1] Rookie");
        System.out.println("\t[2] Mid");
        System.out.println("\t[3] Pro");
        System.out.print("\nTwój wybór: ");
        return scannerDifficultyMenu.nextInt();

        // rozważyć time limit
    }
}
