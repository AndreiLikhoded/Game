package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void startGame(){
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;
        while(numberOfPlayers < 1 || numberOfPlayers > 20){
            try{
                System.out.println("ИГРА ОРЁЛ И РЕШКА");
                System.out.println("------------------");
                System.out.println("Введите количество игроков (1-20)");
                numberOfPlayers = Integer.parseInt(scanner.nextLine());
                if(numberOfPlayers < 1 || numberOfPlayers > 20){
                    System.out.println("Ошибка, введите количество игроков от 1-20");
                }
            }catch (NumberFormatException e){
                System.out.println("Ошибка");
            }
        }

        List<Integer> players = new ArrayList<>();
        for(int i = 1; i <= numberOfPlayers; i++){
            players.add(i);
        }

        while(players.size() > 0){
            int coinRandom = (int)(Math.random()*2);
            int[] playersMove = new int[players.size()];
            boolean[] isLostPlayer = new boolean[players.size()];
            for(int i = 0; i < players.size(); i++){
                int move = -1;
                while(move < 0 || move > 1){
                    try{
                        System.out.println("[Игрок" + players.get(i) + "] ваша ставка (1 - орёл, 0 - решка):");
                        move = Integer.parseInt(scanner.nextLine());
                        if(move < 0 || move > 1){
                            System.out.println("Ошибка");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Ошибка");
                    }
                }
                playersMove[i] = move;

                if(move != coinRandom){
                    isLostPlayer[i] = true;
                }
            }

            List<Integer> remainPlayers = new ArrayList<>();
            for(int i = 0; i < players.size(); i++){
                if(!isLostPlayer[i]){
                    remainPlayers.add(players.get(i));
                }
            }
            players = remainPlayers;
            printResult(coinRandom, playersMove);

        }
    }
    public static void printResult(int coinRandom, int[] playersMove){
        System.out.println("Подкинули монетку, выпала сторона: " + (coinRandom == 1 ? "орел" : "решка"));
        System.out.println();

        System.out.println("Результаты игры");

        for (int i = 0; i < playersMove.length; i++){
            System.out.printf("%-6s  %-6s  %-6s\n", "Игрок" + (i + 1),
                    playersMove[i] == 1 ? "[ставка орел]  :" : "[ставка решка] :",
                    (playersMove[i] == coinRandom) ? "выиграл/продолжает игру" : "проиграл/выбыл из игры");
        }
    }
}
