package com.company;

import java.util.concurrent.TimeUnit;

public class Effects {


    public static void loading(String name) throws InterruptedException {
        String text = "[Generowanie " + name + " zakończone!]";
        System.out.print("[");
        for (int i = 1; i <= text.length() - 2; i++) {
            Thread.sleep(150);
            System.out.print("#");
//            Thread.sleep(150);
//            System.out.print("\b#");
        }
        System.out.println("]");
        System.out.println(text);
        System.out.println("");
    }

    public static void winner(String playerName) throws InterruptedException {

        String len = " ";
        for (int j = 0; j <= playerName.length(); j++) {
            len = len + "\b";
        }

        for (int i = 1; i <= 50; i++) {
            Thread.sleep(100);
            System.out.print(len + " " + playerName);
        }
        System.out.println(" WINS!");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t Game Over!!!");
        System.out.println("");
    }

    public static void loser (String playerName) throws InterruptedException {
        String len = " ";
        for (int j = 0; j <= playerName.length(); j++) {
            len = len + "\b";
        }

        for (int i = 1; i <= 10; i++) {
//            Thread.sleep(100);
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t YOU LOSE!!!");
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println("\b\b\b\b\b\b\b\b\b\b\b");
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t YOU LOSE!!!");
        Thread.sleep(500);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t Game Over!!!");
        Thread.sleep(500);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t Better luck next time.");
        System.out.println("");
    }
}