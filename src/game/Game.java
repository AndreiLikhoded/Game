package game;

import java.util.Scanner;

public class Game {
    private static int firstPlayerScore = 0;
    private static int secondPlayerScore = 0;
    public static void startGame() {
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        int coinRandom;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        coinRandom = (int) (Math.random() * 2) + 1;
        System.out.println("ИГРА ОРЁЛ И РЕШКА");
        System.out.println("------------------");
        while (true) {
            int firstPlayerMove = 0;
            int secondPlayerMove = 0;
            while (firstPlayerMove < 1 || firstPlayerMove > 2) {
                try {
                    System.out.println("[Игрок 1] ваша ставка (2 - орёл, 1 - решка):");
                    firstPlayerMove = Integer.parseInt(scanner1.nextLine());
                    if (firstPlayerMove < 1 || firstPlayerMove > 2) {
                        System.out.println("Ошибка ввода");
                    }
                } catch (NumberFormatException e) {

                }
            }

            if (firstPlayerMove == coinRandom) {
                firstPlayerScore++;
            }

            while (secondPlayerMove < 1 || secondPlayerMove > 2) {
                try {
                    System.out.println("[Игрок 2] ваша ставка (1 - орёл, 2 - решка):");
                    secondPlayerMove = Integer.parseInt(scanner2.nextLine());
                    if (secondPlayerMove < 1 || secondPlayerMove > 2) {
                        System.out.println("Ошибка ввода");
                    }
                } catch (NumberFormatException e) {

                }
            }
                if (secondPlayerMove == coinRandom) {
                    secondPlayerScore++;
                }

            printResult(coinRandom, firstPlayerMove, secondPlayerMove, firstPlayerScore, secondPlayerScore);
                break;
        }
    }

    public static void printResult(int coinRandom, int firstPlayerMove, int secondPlayerMove, int firstPlayerScore, int secondPlayerScore) {
        System.out.println("Подкинули монетку, выпала сторона: " + (coinRandom == 1 ? "Решка" : "Орел"));

        System.out.println("Результаты игры:");

        System.out.printf("%-15s  %-15s  %-15s\n", "Игрок 1", firstPlayerMove == 1 ? "[ставка решка]" : "[ставка орел]",
                (firstPlayerMove == coinRandom) ? "Выиграл" : "Проиграл");

        System.out.printf("%-15s  %-15s  %-15s\n", "Игрок 2", secondPlayerMove == 1 ? "[ставка решка]" : "[ставка орел]",
                (secondPlayerMove == coinRandom) ? "Выиграл" : "Проиграл");

    }

}
