package game;

import java.util.Scanner;

public class Game {
    public static void startGame() {
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        int coinRandom;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        coinRandom = (int) (Math.random() * 2) + 1;
        System.out.println("Начало игры орёл и решка\n один - орёл, два - решка");

        while (true) {
            int firstPlayerMove = 0;
            int secondPlayerMove = 0;
            while (firstPlayerMove < 1 || firstPlayerMove > 2) {
                try {
                    System.out.println("Первый игрок введите 1 или 2");
                    firstPlayerMove = Integer.parseInt(scanner1.nextLine());
                    if (firstPlayerMove < 1 || firstPlayerMove > 2) {
                        System.out.println("Ошибка: введите 1 или 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите корректное число.");
                }
            }

            if (firstPlayerMove == coinRandom) {
                firstPlayerScore++;
            }

            while (secondPlayerMove < 1 || secondPlayerMove > 2) {
                try {
                    System.out.println("Второй игрок введите 1 или 2");
                    secondPlayerMove = Integer.parseInt(scanner2.nextLine());
                    if (secondPlayerMove < 1 || secondPlayerMove > 2) {
                        System.out.println("Ошибка: введите 1 или 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите корректное число.");
                }
            }
                if (secondPlayerMove == coinRandom) {
                    secondPlayerScore++;
                }
                if (firstPlayerScore > secondPlayerScore) {
                    System.out.println("Первый игрок победил");
                } else {
                    System.out.println("Второй игрок победил");
                }
                if (coinRandom == 1) {
                    System.out.println("Выпал орёл");
                } else {
                    System.out.println("Выпала решка");
                }
                break;
        }
            System.out.println("Счёт первого игрока " + firstPlayerScore + " Счёт второго игрока " + secondPlayerScore);
    }

}
