package game;

import java.util.Scanner;

public class Game {


    public static void startGame() {
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        int thirdPlayerScore = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("ИГРА ОРЁЛ И РЕШКА");
        System.out.println("------------------");

        while (true) {
            int coinRandom = (int) (Math.random() * 2);

            int firstPlayerMove = -1;
            while (firstPlayerMove < 0 || firstPlayerMove > 1) {
                try {
                    System.out.println("[Игрок 1] ваша ставка (1 - орёл, 0 - решка):");
                    firstPlayerMove = Integer.parseInt(scanner.nextLine());
                    if (firstPlayerMove < 0 || firstPlayerMove > 1) {
                        System.out.println("Ошибка ввода");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода");
                }
            }


            int secondPlayerMove = -1;
            while (secondPlayerMove < 0 || secondPlayerMove > 1) {
                try {
                    System.out.println("[Игрок 2] ваша ставка (1 - орёл, 0 - решка):");
                    secondPlayerMove = Integer.parseInt(scanner.nextLine());
                    if (secondPlayerMove < 0 || secondPlayerMove > 1) {
                        System.out.println("Ошибка ввода");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода");
                }
            }



            int thirdPlayerMove = -1;
            while(thirdPlayerMove < 0 || thirdPlayerMove > 1){
                try {
                    System.out.println("[Игрок 3] ваша ставка (1 - орёл, 0 - решка):");
                    thirdPlayerMove = Integer.parseInt(scanner.nextLine());
                    if(thirdPlayerMove < 0 || thirdPlayerMove > 1){
                        System.out.println("Ошибка ввода");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Ошибка ввода");
                }
            }

            printResult(coinRandom, firstPlayerMove, secondPlayerMove, thirdPlayerMove);
            break;
        }
    }

    public static void printResult(int coinRandom, int firstPlayerMove, int secondPlayerMove, int thirdPlayerMove) {
        System.out.println("Подкинули монетку, выпала сторона: " + (coinRandom == 1 ? "орёл" : "решка"));
        System.out.println();

        System.out.println("Результаты игры");

        System.out.printf("%-6s  %-6s  %-6s\n", "Игрок 1", firstPlayerMove == 1 ? "[ставка орёл]  :" : "[ставка решка] :",
                (firstPlayerMove == coinRandom) ? "выиграл" : "проиграл");

        System.out.printf("%-6s  %-6s  %-6s\n", "Игрок 2", secondPlayerMove == 1 ? "[ставка орёл]  :" : "[ставка решка] :",
                (secondPlayerMove == coinRandom) ? "выиграл" : "проиграл");

        System.out.printf("%-6s  %-6s  %-6s\n", "Игрок 3", thirdPlayerMove == 1 ? "[ставка орёл]  :" : "[ставка решка] :",
                (thirdPlayerMove == coinRandom) ? "выиграл" : "проиграл");
    }
}
