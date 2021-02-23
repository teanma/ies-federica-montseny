package org.iesfm.tictactoegame;

import org.iesfm.tictactoegame.exceptions.InvalidPositionException;
import org.iesfm.tictactoegame.exceptions.NotYourTurnException;
import org.iesfm.tictactoegame.exceptions.PositionInUseException;

public interface ITicTacToeGame {

    void putX (int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException;
    void putO(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException;

    Character [][] getBoard();

    void setBoard(Character[][] board);

    void reset();

    boolean isFinished();

    String getWinner();

    String getTurn();
}