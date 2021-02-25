package org.iesfm.tictactoegame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConsoleTicTacToeGame game = new ConsoleTicTacToeGame(new Scanner(System.in), new TicTacToeGame());
        game.run();
    }
}
