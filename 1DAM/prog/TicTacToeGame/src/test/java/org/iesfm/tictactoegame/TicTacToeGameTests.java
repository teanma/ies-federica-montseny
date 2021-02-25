package org.iesfm.tictactoegame;

import org.iesfm.tictactoegame.exceptions.InvalidPositionException;
import org.iesfm.tictactoegame.exceptions.NotYourTurnException;
import org.iesfm.tictactoegame.exceptions.PositionInUseException;
import org.junit.Assert;
import org.junit.Test;

public class TicTacToeGameTests {

    private TicTacToeGame game = new TicTacToeGame();

    @Test
    public void noMoreMovesTest(){
        Character[][] board = {
                {TicTacToeGame.X, TicTacToeGame.X, TicTacToeGame.O},
                {TicTacToeGame.O, TicTacToeGame.O, TicTacToeGame.O},
                {TicTacToeGame.X, TicTacToeGame.O, TicTacToeGame.X}
        };
        game.setBoard(board);

        //Test execution
        boolean finished = game.isFinished();


        //Assertions
        Assert.assertTrue(finished);
    }

    @Test
    public void noMoreMovesDrawTest(){
        Character[][] board = {
                {TicTacToeGame.X, TicTacToeGame.X, TicTacToeGame.O},
                {TicTacToeGame.O, TicTacToeGame.O, TicTacToeGame.X},
                {TicTacToeGame.X, TicTacToeGame.O, TicTacToeGame.X}
        };
        game.setBoard(board);

        //Test execution

        Character winner = game.getWinner();

        //Assertions
        Assert.assertNull(winner);
    }

    @Test (expected = InvalidPositionException.class)
    public void invalidPositionTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };

        game.setBoard(board);

        game.putX(3, 4);
    }

    @Test
    public void putXTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null}, 
                {null, null, null}, 
                {null, null, null}  
        };

        game.setBoard(board);

        game.putX(1, 1);

        Character[][] expectedBoard = {
                {null, null, null},
                {null, TicTacToeGame.X, null},
                {null, null, null}
        };

        Assert.assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test (expected =  PositionInUseException.class)
    public void occupiedPositionTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null}, 
                {null, TicTacToeGame.O, TicTacToeGame.X},
                {null, null, null}  
        };

        game.setBoard(board);
        game.putX(1, 2);
    }

    @Test (expected = NotYourTurnException.class)
    public void notYourTurnTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null}, 
                {null, null, TicTacToeGame.X},
                {null, null, null} 
        };

        game.setBoard(board);
        game.putX(1, 2);
    }
}
