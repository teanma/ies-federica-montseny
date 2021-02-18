package org.iesfm.tictactoe;

import org.iesfm.tictactoe.exceptions.InvalidPositionException;
import org.iesfm.tictactoe.exceptions.NotYourTurnException;
import org.iesfm.tictactoe.exceptions.PositionInUseException;
import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTests {

    private TicTacToe game = new TicTacToe();

    @Test
    public void noMoreMovesFinishedTest() {
        // setup scenario
        Character[][] board = {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', 'O', 'X'},
        };
        game.setBoard(board);

        // Test execution
        boolean finished = game.isFinished();

        // Assertions
        Assert.assertTrue(finished);
    }

    @Test
    public void noMoreMovesDrawTest() {
        // setup scenario
        Character[][] board = {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', 'O', 'X'},
        };
        game.setBoard(board);

        // Test execution
        String winner = game.getWinner();

        // Assertions
        Assert.assertEquals("Draw", winner);
    }

    @Test(expected = InvalidPositionException.class)
    public void invalidPositionTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(3, 4);

    }

    @Test
    public void validPositionTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(1, 1);

        Character[][] expectedBoard = {
                {null, null, null},
                {null, 'X', null},
                {null, null, null},
        };

        Assert.assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test(expected = PositionInUseException.class)
    public void occupiedException() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, null, 'X'},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(1, 2);
    }

    @Test(expected = NotYourTurnException.class)
    public void notYourTurnTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, null, 'X'},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(1, 1);
    }
}
