package org.iesfm.tictactoegame;

import org.iesfm.tictactoegame.exceptions.InvalidPositionException;
import org.iesfm.tictactoegame.exceptions.NotYourTurnException;
import org.iesfm.tictactoegame.exceptions.PositionInUseException;

public class TicTacToeGame implements ITicTacToeGame {

    public final static char X = 'X';
    public final static char O = 'O';

    private Character[][] board;

    public void TicTacToe() {
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
                    this.board[x][y] = X;
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
        return false;
    }

    @Override
    public String getWinner() {
        return null;
    }

    @Override
    public String getTurn() {
        return null;
    }
}
