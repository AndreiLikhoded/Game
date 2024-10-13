package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int MINIMAL_NUMBER_OF_PLAYERS = 1;
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 20;
    private static final char HEADS = 'о';
    private static final char TAILS = 'р';

    public static void startGame(){
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;
        while(numberOfPlayers < MINIMAL_NUMBER_OF_PLAYERS || numberOfPlayers > MAXIMUM_NUMBER_OF_PLAYERS){
            try{
                System.out.println("ИГРА ОРЁЛ И РЕШКА");
                System.out.println("------------------");
                System.out.println("Введите количество игроков (" + MINIMAL_NUMBER_OF_PLAYERS + "-" + MAXIMUM_NUMBER_OF_PLAYERS + ")");
                numberOfPlayers = Integer.parseInt(scanner.nextLine());
                if(numberOfPlayers < MINIMAL_NUMBER_OF_PLAYERS || numberOfPlayers > MAXIMUM_NUMBER_OF_PLAYERS){
                    System.out.println("Ошибка, введите количество игроков от " + MINIMAL_NUMBER_OF_PLAYERS + "-" + MAXIMUM_NUMBER_OF_PLAYERS);
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
            char[] playersMove = new char[players.size()];
            boolean[] isLostPlayer = new boolean[players.size()];

            for(int i = 0; i < players.size(); i++){
                char move = ' ';
                while(move != TAILS && move != HEADS){
                    try{
                        System.out.println("[Игрок" + players.get(i) + "] ваша ставка (" + HEADS + " - орёл," + TAILS + " - решка):");
                        move = scanner.nextLine().charAt(0);
                        if(move != TAILS && move != HEADS){
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
    public static void printResult(int coinRandom, char[] playersMove){
        System.out.println("Подкинули монетку, выпала сторона: " + (coinRandom == HEADS ? TAILS : HEADS));
        System.out.println();

        System.out.println("Результаты игры");
        for(int i = 0; i < playersMove.length; i++){
            System.out.printf("%-6s  %-6s  %-6s\n", "Игрок" + (i + 1),
                    playersMove[i] == HEADS ? "[ставка орел]  :" : "[ставка решка] :",
                    (playersMove[i] == coinRandom) ? "выиграл/продолжает игру" : "проиграл/выбыл из игры");
        }
    }
}
