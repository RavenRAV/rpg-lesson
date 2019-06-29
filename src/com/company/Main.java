package com.company;


import java.util.Random;

public class Main {
    public static int[] health = {700, 250, 250, 250};
    public static int[] hits = {50, 20, 20, 20};
    public static String[] hitTypes = {"Physical ", "Physical ", "Magical ", "Mental "};


    public static void main(String[] args) {
        while (!isFinished()) {
            changeBossDefence();
            round();
            printStatistics();
        }
    }

    public static void changeBossDefence() {
        Random r = new Random();
        int randomNumber = r.nextInt(3) + 1;
        hitTypes[0] = hitTypes[randomNumber];
    }

    public static void round() {
        for (int i = 1; i <= 3; i++) {
            if (health[0] > 0) {
                int damagedHealth = playerHit(i);
                if (damagedHealth < 0) {
                    health[0] = 0;
                } else {
                    health[0] = damagedHealth;
                }
            }
        }
        if (health[0] > 0) {
            for (int i = 1; i <= 3; i++) {
                health[i] = bossHit(i);
            }
        }
    }

    public static boolean isFinished() {
        if (health[0] <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        if (health[1] <= 0 && health[2] <= 0 && health[3] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static int playerHit(int playerIndex) {
        Random r = new Random();
        int randomNamber = r.nextInt(7) + 2;
        if (hitTypes[0].equals(hitTypes[playerIndex])) {
            System.out.println(hitTypes[playerIndex] + " hits: " + hits[playerIndex] * randomNamber);
            return health[0] - hits[playerIndex] * randomNamber;
        } else {
            return health[0] - hits[playerIndex];
        }
    }

    public static int bossHit(int playerIndex) {
        return health[playerIndex] - hits[0];
    }

    public static void printStatistics() {
        System.out.println("_______________");
        System.out.println("Boss health: " + health[0]);
        System.out.println("Warrior health: " + health[1]);
        System.out.println("Magic health: " + health[2]);
        System.out.println("Kinetic health: " + health[3]);
        System.out.println("_______________");
    }

}

