package com.company;

import com.company.Effects;
import com.company.actors.Player;
import com.company.game.EnumData;
import com.company.game.Game;
import com.company.game.Generators;
import com.company.game.Menus;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (EnumData.Parts part : EnumData.Parts.values()) {
            System.out.println(part.namePL);
        }

        Generators.generateVechicle();


        Effects.clearConsole();
        System.out.println("\tWitam Cię w symulatorze Autohandlu.\n");
        System.out.println("Twoim zadaniem będzie zarabiać na handlu autami.");
        System.out.println("W zalezności od wybranej rozgrywki będziesz ścigał się z czasem albo innymi graczami *\n\n");
        int playerChoiceStart;

        do {
            playerChoiceStart = Menus.startMenu();
            switch (playerChoiceStart) {
                case 1:
                    int playerChoiceDiffculty = Menus.difficultyMenu();
                    switch (playerChoiceDiffculty) {
                        case 1: {
                            Game SinglePlayer = new Game(1, 200000.00, 2, null);
                            break;
                        }
                        case 2: {
                            Game SinglePlayer = new Game(1, 100000.00, 3, null);
                            break;
                        }
                        case 3:{
                            Game SinglePlayer = new Game(1, 50000.00, 4, 20);
                            break;
                        }
                        default:
                            System.out.println("Brak takiej opcji.");
                            break;
                    }
                    break;
                case 2: {
                    System.out.println("Kiedyś tu będzie instrukcja");
                    Effects.pressAnyKey();
                    break;
                }
                case 3: {
                    System.out.println("Autor: Tomasz Wołowiec, Student WSB WZ_ININ_PR1, Index: 50507");
                    Effects.pressAnyKey();
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Nie ma takiej opcji na liście.");
            }

            Effects.clearConsole();
        } while (playerChoiceStart != 0);







//        Integer playerNo = 1;

//        Game SinglePlayer = new Game(playerNo,true);
    }

}
