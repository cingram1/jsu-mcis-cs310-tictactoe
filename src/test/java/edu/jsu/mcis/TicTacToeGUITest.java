package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeGUITest
{
    
	@Test
	public void testPlayerXGoesFirst()
	{
		TicTacToeGUI board = new TicTacToeGUI();

        String turn = ("Player X");
        assertEquals(turn, board.playerTurn.getText());
	}

    @Test
    public void testCheckWinnerIfThereIsNoWinner() 
    {
        TicTacToeGUI board = new TicTacToeGUI();
        boolean winner = false;
        boolean result = board.checkWinner();
        assertEquals(winner, result);
    }
    
    @Test
    public void testCheckWinnerIfXwinsHorizontallyTopRow() 
    {
        TicTacToeGUI board = new TicTacToeGUI();
        boolean winner = true;
        board.space[0].setText("X");
        board.space[1].setText("X");
        board.space[2].setText("X");
        boolean result = board.checkWinner();
        assertEquals(winner, result);
    }
    
    @Test
    public void testCheckWinnerIfOwinsHorizontallyBottomRow() 
    {
        TicTacToeGUI board = new TicTacToeGUI();
        boolean winner = true;
        board.space[6].setText("O");
        board.space[7].setText("O");
        board.space[8].setText("O");
        boolean result = board.checkWinner();
        assertEquals(winner, result);
    }
    
    @Test
    public void testCheckWinnerIfXwinsDiagonal() 
    {
        TicTacToeGUI board = new TicTacToeGUI();
        boolean winner = true;
        board.space[0].setText("X");
        board.space[4].setText("X");
        board.space[8].setText("X");
        boolean result = board.checkWinner();
        assertEquals(winner, result);
    }
    
    @Test
    public void testCheckWinnerIfOwinsDownMiddle() 
    {
        TicTacToeGUI board = new TicTacToeGUI();
        boolean winner = true;
        board.space[1].setText("O");
        board.space[4].setText("O");
        board.space[7].setText("O");
        boolean result = board.checkWinner();
        assertEquals(winner, result);
    }

    
}

   