package org.iesfm.tictactoegame;

import org.iesfm.tictactoegame.exceptions.InvalidPositionException;
import org.iesfm.tictactoegame.exceptions.NotYourTurnException;
import org.iesfm.tictactoegame.exceptions.PositionInUseException;

public class TicTacToeGame implements ITicTacToeGame {

    public final static char X = 'X';
    public final static char O = 'O';

    private Character[][] board;

    public TicTacToeGame (Character[][] board) {
        this.board = board;
    }

    public TicTacToeGame() {
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };
        this.board = board;
    }

    @Override
    public void putX(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException {
        if (checkXTurn()) {
            if (checkValidPosition(x, y)) {
                if (!checkOccupiedPosition(x, y)){
                    this.board[x][y] = 'X';
                } else {
                    throw new PositionInUseException();
                }
            } else {
                throw  new InvalidPositionException();
            }
        } else {
            throw new NotYourTurnException();
        }
    }

    @Override
    public void putO(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException {
        if (!checkXTurn()) {
            if (checkValidPosition(x, y)) {
                if (!checkOccupiedPosition(x, y)) {
                    board[x][y] = 'O';
                } else {
                    throw new PositionInUseException();
                }
            } else {
                throw new InvalidPositionException();
            }
        } else {
            throw new NotYourTurnException();
        }
    }

    private boolean checkValidPosition(int x, int y) {
        return x >= 0 && x <= 2 && y >= 0 && y <= 2;
    }

    private boolean checkOccupiedPosition(int x, int y) {
        return board[x][y] != null;
    }

    private boolean checkXTurn() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != null) {
                    counter++;
                }
            }
        }
        return counter % 2 == 0;
    }


    @Override
    public Character[][] getBoard() {
        return board;
    }

    @Override
    public void setBoard(Character[][] board) {
        this.board = board;
    }

    @Override
    public void reset() {

    }

    @Override
    public boolean isFinished() {
        boolean finished = true;
        if (getWinner() == null){
            for (int i = 0; i < board.length; i++){
                Character[] column = board[i];
                for (int j = 0; j < column.length; j++) {
                    Character casilla = column[i];
                    if (casilla == null){
                        finished = false;
                    }
                }
            }
        }
        return finished;
    }

    @Override
    public Character getWinner() {
        Character winner = null;

        for (int i = 0; i < board.length; i++) {
            Character square1 = board[i][0];
            Character square2 = board[i][1];
            Character square3 = board[i][2];
            if (square1 == square2 && square2 == square3){
                winner = square1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            Character square1 = board[0][i];
            Character square2 = board[1][i];
            Character square3 = board[2][i];
            if (square1 == square2 && square2 == square3){
                winner = square1;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            winner = board [1][1];
        } else  if (board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            winner = board [1][1];
        }
        return winner;
    }

    @Override
    public Character getTurn() {
        if (checkXTurn()){
            return X;
        } else {
            return O;
        }
    }
}
