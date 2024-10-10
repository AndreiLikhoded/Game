package game;

import java.util.Scanner;

public class Game {

    public static void Game() {
        int firstPlayerScore = -1;
        int secondPlayerScore = -1;
        int coinRandom;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        coinRandom = (int) (Math.random() * 2);
        System.out.println("ИГРА ОРЁЛ И РЕШКА");
        System.out.println("------------------");
        while (true) {
            int firstPlayerMove = 0;
            int secondPlayerMove = 0;
            while (firstPlayerMove < 0 || firstPlayerMove > 1) {
                try {
                    System.out.println("[Игрок 1] ваша ставка (1 - орёл, 0 - решка):");
                    firstPlayerMove = Integer.parseInt(scanner1.nextLine());
                    if (firstPlayerMove < 0 || firstPlayerMove > 1) {
                        System.out.println("Ошибка ввода");
                    }
                } catch (NumberFormatException e) {

                }
            }

            if (firstPlayerMove == coinRandom) {
                firstPlayerScore++;
            }

            while (secondPlayerMove < 0 || secondPlayerMove > 1) {
                try {
                    System.out.println("[Игрок 2] ваша ставка (1 - орёл, 0 - решка):");
                    secondPlayerMove = Integer.parseInt(scanner2.nextLine());
                    if (secondPlayerMove < 0 || secondPlayerMove > 1) {
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
        System.out.println("Подкинули монетку, выпала сторона: " + (coinRandom == 1 ? "орел" : "решка"));

        System.out.println("Результаты игры:");

        System.out.printf("%-15s  %-10s  %-10s\n", "Игрок 1", firstPlayerMove == 1 ? "[ставка орел] : " : "[ставка решка] : ",
                (firstPlayerMove == coinRandom) ? "Выиграл" : "Проиграл");

        System.out.printf("%-15s  %-10s  %-10s\n", "Игрок 2", secondPlayerMove == 1 ? "[ставка орел] : " : "[ставка решка] : ",
                (secondPlayerMove == coinRandom) ? "Выиграл" : "Проиграл");

    }

    public static void startGame() {
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("ИГРА ОРЁЛ И РЕШКА");
        System.out.println("------------------");

        while (true) {
            int coinRandom = (int) (Math.random() * 2);

            int firstPlayerMove = -1;
            while (firstPlayerMove < 0 || firstPlayerMove > 1) {
                try {
                    System.out.println("[Игрок 1] ваша ставка (1 - орёл, 0 - решка):");
                    firstPlayerMove = Integer.parseInt(scanner1.nextLine());
                    if (firstPlayerMove < 0 || firstPlayerMove > 1) {
                        System.out.println("Ошибка ввода");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода");
                }
            }

            if (firstPlayerMove == coinRandom) {
                firstPlayerScore++;
            }

            int secondPlayerMove = -1;
            while (secondPlayerMove < 0 || secondPlayerMove > 1) {
                try {
                    System.out.println("[Игрок 2] ваша ставка (1 - орёл, 0 - решка):");
                    secondPlayerMove = Integer.parseInt(scanner2.nextLine());
                    if (secondPlayerMove < 0 || secondPlayerMove > 1) {
                        System.out.println("Ошибка ввода");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода");
                }
            }

            if (secondPlayerMove == coinRandom) {
                secondPlayerScore++;
            }
            printResult(coinRandom, firstPlayerMove, secondPlayerMove);
            break;
        }
    }

    public static void printResult(int coinRandom, int firstPlayerMove, int secondPlayerMove) {
        System.out.println("Подкинули монетку, выпала сторона: " + (coinRandom == 1 ? "орёл" : "решка"));
        System.out.println();

        System.out.println("Результаты игры");

        System.out.printf("%-6s  %-6s  %-6s\n", "Игрок 1", firstPlayerMove == 1 ? "[ставка орел]  :" : "[ставка решка] :",
                (firstPlayerMove == coinRandom) ? "выиграл" : "проиграл");

        System.out.printf("%-6s  %-6s  %-6s\n", "Игрок 2", secondPlayerMove == 1 ? "[ставка орел]  :" : "[ставка решка] :",
                (secondPlayerMove == coinRandom) ? "выиграл" : "проиграл");
    }
}
