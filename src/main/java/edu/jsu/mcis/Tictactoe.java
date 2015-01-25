package edu.jsu.mcis;

import java.util.Scanner;

public class Tictactoe 
{
    public enum Marker {XMARK, OMARK, EMPTY};
	public enum Outcome {XWIN, OWIN, DRAW, KEEP_GOING};
	private Marker[][] grid;

    public Tictactoe() 
	{
		grid = new Marker[3][3];
		clear();
    }

	public boolean winsAcross(Marker m)
	{
		int topCount = 0;
		int midCount = 0;
		int bottomCount = 0;
		for(int i = 0; i < grid.length; i++)
		{
			if(grid[0][i] == m)
			{
				topCount++;
			}
			else if(grid[1][i] == m)
			{
				midCount++;
			}
			else if(grid[2][i] == m)
			{
				bottomCount++;
			}	
		}
		
		if(topCount == 3 || midCount == 3 || bottomCount == 3)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public boolean winsDown(Marker m)
	{
		int leftCount = 0;
		int midCount = 0;
		int rightCount = 0;
		for(int i = 0; i < grid.length; i++)
		{
			if(grid[i][0] == m)
			{
				leftCount++;
			}
			else if(grid[i][1] == m)
			{
				midCount++;
			}
			else if(grid[i][2] == m)
			{
				rightCount++;
			}	
		}
		
		if(leftCount == 3 || midCount == 3 || rightCount == 3)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public boolean winsDiagonal(Marker m)
	{
		if((grid[0][0] == m && grid[1][1] == m && grid[2][2] == m) || (grid[0][2] == m && grid[1][1] == m && grid[2][0] == m))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isDraw()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++) 
			{
				if(grid[i][j] == Marker.EMPTY)
                {   
					return false;
				}
			}
		}
		return true;
                
	}
	
	public Outcome getOutcome()
	{
		if(winsDown(Marker.XMARK) || winsAcross(Marker.XMARK) || winsDiagonal(Marker.XMARK))
		{
			return Outcome.XWIN;
		}
		else if(winsDown(Marker.OMARK) || winsAcross(Marker.OMARK) || winsDiagonal(Marker.OMARK))
		{
			return Outcome.OWIN;
		}
		else if(isDraw())
		{
			return Outcome.DRAW;
		}
		else
		{
			return Outcome.KEEP_GOING;
		}
		
    }

	public boolean setMarker(int r, int c, Marker m)
	{
        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == Marker.EMPTY)
		{
			grid[r][c] = m;
			return true;
        }
        
		else 
		{
			return false;
		}
    }
    
    public Marker getMarker(int r, int c)
	{
        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
        {
			return grid[r][c];
		}
        else 
		{
			throw new RuntimeException("invalid location");
		}
    }
    
	public void display()
	{
        for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++) 
			{
                String s = " * ";
                
				if(grid[i][j] == Marker.XMARK)
                {   
					s = " X ";
				}
				else if(grid[i][j] == Marker.OMARK)
				{
                    s = " O ";
				}
                
				System.out.print(s);
            }
            System.out.println();
        }
    }
    
    public void clear() {
        for(int i = 0; i < grid.length; i++) 
		{
            for(int j = 0; j < grid[0].length; j++) 
			{
                grid[i][j] = Marker.EMPTY;
            }
        }
    }
	
	public void play() 
	{
        clear();
        boolean xTurn = true;
        while(getOutcome() == Outcome.KEEP_GOING) 
		{
            display();
            boolean invalidLocation = true;
            Marker m = (xTurn)? Marker.XMARK : Marker.OMARK;
            while(invalidLocation) 
			{
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter a row/col: ");
                int r = keyboard.nextInt();
                int c = keyboard.nextInt();
                if(getMarker(r, c) == Marker.EMPTY) 
				{
                    setMarker(r, c, m);
                }
                invalidLocation = setMarker(r, c, m);
            }
            xTurn = !xTurn;
        }
		
		if(getOutcome() == Outcome.XWIN)
		{
			System.out.println("PLAYER X WINS!!!");
		}
		else if(getOutcome() == Outcome.OWIN)
		{
			System.out.println("PLAYER O WINS!!!");
		}
		else
		{
			System.out.println("----DRAW----");
		}
    }
    
	public static void main(String[] args)
	{
		Tictactoe newGame = new Tictactoe();
		newGame.play();
    }
}
