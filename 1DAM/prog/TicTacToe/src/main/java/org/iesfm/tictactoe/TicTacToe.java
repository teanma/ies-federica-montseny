package org.iesfm.tictactoe;

import org.iesfm.tictactoe.exceptions.InvalidPositionException;
import org.iesfm.tictactoe.exceptions.NotYourTurnException;
import org.iesfm.tictactoe.exceptions.PositionInUseException;

public class TicTacToe implements ITicTacToe {
    private Character[][] board;

    public TicTacToe(Character[][] board) {
        this.board = board;
    }

    public TicTacToe() {
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };
        this.board = board;
    }


    public final static char X = TicTacToe.X;
    public final static char O = TicTacToe.O;

    private Character[][] board;

    public TicTacToe(Character[][] board) {
        this.board = board;
    }

    public TicTacToe() {
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };
        this.board = board;
    }

    @Override
    public void putX(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException {
        if(checkXTurn()) {
            if (checkValidPosition(x, y)) {
                if (checkOccupiedPosition(x, y)) {
                    this.board[x][y] = TicTacToe.X;
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
        // Recorrer las coordenadas(i)(j) del tablero y verifica el número de fichas que hay.
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] != null) {
                    counter++;
                }
            }
        }
        return counter%2 == 0;
    }

    private boolean checkValidPosition(int x, int y) throws InvalidPositionException {
        if(x < 0 || x > 2) {
            throw new InvalidPositionException();
        } else if (y < 0 || y > 2) {
            throw new InvalidPositionException();
        } else {
            return true;
        }
    }

    private boolean checkOccupiedPosition(int x, int y) throws PositionInUseException {
        if(board[x][y] != null) {
            throw new PositionInUseException();
        } else {
            return true;
        }
    }

    private boolean checkXTurn(int x, int y) {
        // Recorrer las coordenadas(i)(j) del tablero y verifica el número de fichas que hay.
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] != null) {
                    counter++;
                }
            }
        }
        if(counter%2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void putO(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException {
        if (checkXTurn()) {
            if (checkValidPosition(x, y)) {
                if (checkOccupiedPosition(x, y)) {
                    this.board[x][y] = TicTacToe.O;
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
