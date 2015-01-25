package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TictactoeTest
{
    
	@Test
	public void testInitialBoardIsCompletelyEmpty()
	{
		Tictactoe board = new Tictactoe();
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				assertEquals(Tictactoe.Marker.EMPTY, board.getMarker(row, col));
			}
		}
	}

	@Test
	public void testMarkXInUpperRightCorner()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(0, 2, Tictactoe.Marker.XMARK);
		
		assertEquals(Tictactoe.Marker.XMARK, board.getMarker(0, 2));	
	}
	
	@Test
	public void testMarkXInUpperRightCornerThenOInBottomCenter()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(0, 2, Tictactoe.Marker.XMARK);
		board.setMarker(2, 1, Tictactoe.Marker.OMARK);
		
		assertEquals(Tictactoe.Marker.OMARK, board.getMarker(2, 1));
	}
	
	@Test
	public void testGameWonByMarkXByFillingTopRow()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(0, 0, Tictactoe.Marker.XMARK);
		board.setMarker(0, 1, Tictactoe.Marker.XMARK);
		board.setMarker(0, 2, Tictactoe.Marker.XMARK);
		
		assertEquals(Tictactoe.Outcome.XWIN, board.getOutcome());
	}
	
	@Test
	public void testGameWonByMark0ByFillingLeftColumn()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(0, 0, Tictactoe.Marker.OMARK);
		board.setMarker(1, 0, Tictactoe.Marker.OMARK);
		board.setMarker(2, 0, Tictactoe.Marker.OMARK);
		
		assertEquals(Tictactoe.Outcome.OWIN, board.getOutcome());
	}
	
	@Test
	public void testGameWonByMarkXByDiagonal()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(0, 0, Tictactoe.Marker.XMARK);
		board.setMarker(1, 1, Tictactoe.Marker.XMARK);
		board.setMarker(2, 2, Tictactoe.Marker.XMARK);
		
		assertEquals(Tictactoe.Outcome.XWIN, board.getOutcome());
	}
	
	@Test
	public void testGameEndsInADraw()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(1, 1, Tictactoe.Marker.XMARK);
		board.setMarker(0, 0, Tictactoe.Marker.OMARK);
		board.setMarker(2, 0, Tictactoe.Marker.XMARK);
		board.setMarker(0, 2, Tictactoe.Marker.OMARK);
		board.setMarker(0, 1, Tictactoe.Marker.XMARK);
		board.setMarker(2, 1, Tictactoe.Marker.OMARK);
		board.setMarker(1, 2, Tictactoe.Marker.XMARK);
		board.setMarker(1, 0, Tictactoe.Marker.OMARK);
		board.setMarker(2, 2, Tictactoe.Marker.XMARK);
		
		assertEquals(Tictactoe.Outcome.DRAW, board.getOutcome());
	}
	
	@Test
	public void testIfClearEmptysTheBoard()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(0, 2, Tictactoe.Marker.XMARK);
		board.setMarker(2, 1, Tictactoe.Marker.OMARK);
		board.setMarker(1, 2, Tictactoe.Marker.XMARK);
		board.setMarker(1, 0, Tictactoe.Marker.OMARK);
		
		board.clear();
		
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				assertEquals(Tictactoe.Marker.EMPTY, board.getMarker(row, col));
			}
		}
	
	}
	
	@Test
	public void testDisplayPrintsXifSpaceIsXmark()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(0, 2, Tictactoe.Marker.XMARK);
		
		board.display();

		assertEquals(Tictactoe.Marker.XMARK, board.getMarker(0, 2));	
	}
	
	@Test
	public void testOutcomeIsKeepGoingIfThereIsNoWinnerOrDraw()
	{
		Tictactoe board = new Tictactoe();
		
		board.setMarker(1, 1, Tictactoe.Marker.XMARK);
		board.setMarker(0, 0, Tictactoe.Marker.OMARK);
		board.setMarker(2, 0, Tictactoe.Marker.XMARK);
		board.setMarker(0, 2, Tictactoe.Marker.OMARK);
		board.setMarker(0, 1, Tictactoe.Marker.XMARK);
		

		assertEquals(Tictactoe.Outcome.KEEP_GOING, board.getOutcome());
	}

}







