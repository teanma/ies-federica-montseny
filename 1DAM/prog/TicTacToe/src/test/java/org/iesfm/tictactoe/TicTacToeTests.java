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
                {TicTacToe.X, TicTacToe.O, TicTacToe.X},
                {TicTacToe.O, TicTacToe.O, TicTacToe.X},
                {TicTacToe.X, TicTacToe.O, TicTacToe.X},
        };
        game.setBoard(board);

        // Test execution
        boolean finished = game.isFinished();

        // Assertions
        Assert.assertTrue(finished);
    }

    @Test
    public void notFinishedTest() {
        // setup scenario
        Character[][] board = {
                {TicTacToe.X, null, TicTacToe.X},
                {TicTacToe.O, TicTacToe.O, TicTacToe.X},
                {TicTacToe.X, TicTacToe.O, TicTacToe.X},
        };
        game.setBoard(board);

        // Test execution
        boolean finished = game.isFinished();

        // Assertions
        Assert.assertFalse(finished);
    }

    @Test
    public void FinishedXWinnerTest() {
        // setup scenario
        Character[][] board = {
                {TicTacToe.X, null, TicTacToe.O},
                {TicTacToe.X, TicTacToe.O, TicTacToe.O},
                {TicTacToe.X, TicTacToe.O, TicTacToe.X},
        };
        game.setBoard(board);

        // Test execution
        boolean finished = game.isFinished();

        // Assertions
        Assert.assertTrue(finished);
    }

    @Test
    public void FinishedOWinnerTest() {
        // setup scenario
        Character[][] board = {
                {TicTacToe.X, null, TicTacToe.X},
                {TicTacToe.O, TicTacToe.O, TicTacToe.O},
                {TicTacToe.X, TicTacToe.X, TicTacToe.O},
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
                {TicTacToe.X, TicTacToe.X, TicTacToe.O},
                {TicTacToe.O, TicTacToe.O, TicTacToe.X},
                {TicTacToe.X, TicTacToe.O, TicTacToe.X},
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
        game.putX(3, 3);

    }

    @Test
    public void putXTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
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
                {null, TicTacToe.X, null},
                {null, null, null},
        };

        Assert.assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    public void putOTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, TicTacToe.X, null},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(0, 1);

        Character[][] expectedBoard = {
                {null, TicTacToe.O, null},
                {null, TicTacToe.X, null},
                {null, null, null},
        };

        Assert.assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test(expected = PositionInUseException.class)
    public void occupiedException() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, null, TicTacToe.X},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(1, 2);
    }

    @Test(expected = NotYourTurnException.class)
    public void notXTurnTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, null, TicTacToe.X},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(1, 1);
    }

    @Test(expected = NotYourTurnException.class)
    public void notOTurnTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        // setup scenario
        Character[][] board = {
                {null, null, null},
                {null, TicTacToe.O, TicTacToe.X},
                {null, null, null},
        };
        game.setBoard(board);

        // Test execution
        game.putX(0, 1);
    }
}
