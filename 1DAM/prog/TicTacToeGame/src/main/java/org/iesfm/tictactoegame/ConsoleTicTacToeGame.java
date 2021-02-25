package org.iesfm.tictactoegame;

import org.iesfm.tictactoegame.exceptions.InvalidPositionException;
import org.iesfm.tictactoegame.exceptions.NotYourTurnException;
import org.iesfm.tictactoegame.exceptions.PositionInUseException;

import java.util.Scanner;

public class ConsoleTicTacToeGame {
    private Scanner scan;
    private ITicTacToeGame game;

    public ConsoleTicTacToeGame(Scanner scan, ITicTacToeGame game) {
        this.scan = scan;
        this.game = game;
    }

    public void run(){
        System.out.println("Bienvenido al TicTacToe");

        printBoard(game.getBoard());

        while (!game.isFinished()){
            System.out.println("Es turno de " + game.getTurn());

            System.out.println("Introduce coordenadas");
            int x = scan.nextInt();
            int y = scan.nextInt();
            scan.nextLine();

            try {
                if(game.getTurn() == TicTacToeGame.X ){
                    game.putX(x, y);
                } else {
                    game.putO(x, y);
                }
            } catch (InvalidPositionException e){
                System.out.println("La posicion no es valida");
            } catch (NotYourTurnException e){
                System.out.println("no es tu turno");
            } catch (PositionInUseException e){
                System.out.println("La posicion esta ocupada");
            }
            printBoard(game.getBoard());
        }
        Character winner = game.getWinner();
        if (winner == null){
            System.out.println("Empate");
        } else {
            System.out.println("El ganador es " + winner);
        }
    }

    private void printBoard(Character[][] board){
        for (int i = 0; i < board.length; i++) {
            if(i == 0) {
                System.out.println("|̄ ̄ ̄ |̄ ̄ ̄ |̄ ̄ ̄ |");
            } else{
                System.out.println("|   |   |   |");
            }
            Character[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == null) {
                    System.out.print("|   ");
                } else if (row[j] == 'X') {
                    System.out.print("| X ");
                } else {
                    System.out.print("| O ");
                }
            }
            System.out.println("|");
            System.out.println("|___|___|___|");
        }
    }
}
