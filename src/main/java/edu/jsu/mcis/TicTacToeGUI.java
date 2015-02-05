package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
    public Container content;
	public JLabel playerTurn;
	public JButton[] space;
	public JButton exitButton;
	public JButton resetButton;
	public spaceButtonHandler[] spaceHandlers;
	public ExitButtonHandler exitHandler;
	public resetButtonHandler resetHandler;
	
	public boolean playerX;
	public boolean gameOver;
	
	public TicTacToeGUI()
	{
		setTitle("Tic Tac Toe GUI");
		setSize(800, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		content = getContentPane();

		content.setLayout(new GridLayout(4,3));

		space = new JButton[9];
		spaceHandlers = new spaceButtonHandler[9];
		
        for(int i = 0; i < 9; i++)
		{
			char ch = (char)('0' + i + 1);
			space[i] = new JButton(" " + ch);
			spaceHandlers[i] = new spaceButtonHandler();
			space[i].addActionListener(spaceHandlers[i]);
		}
		
		exitButton = new JButton("EXIT");
		exitHandler = new ExitButtonHandler();
		exitButton.addActionListener(exitHandler);
		resetButton = new JButton("RESET");
		resetHandler = new resetButtonHandler();
		resetButton.addActionListener(resetHandler);
		
        
		playerTurn = new JLabel("Player X", SwingConstants.CENTER);

						
		for(int i = 0; i < 9; i++)
		{
			content.add(space[i]);
		}
		content.add(resetButton);
		content.add(playerTurn);
		content.add(exitButton);
		
		display();
	}
    
    public void display()
	{
        
		playerX = true;
		gameOver = false;
		
		for(int i = 0; i < 9; i++)
		{
			char ch = (char)('0' + i + 1);
			space[i].setText(" "+ ch);
		}
		
		playerTurn.setText("Player X");
		
		setVisible(true);
	}
    
    public boolean checkWinner()
	{
		if(space[0].getText() == space[1].getText() && space[1].getText() == space[2].getText())
		{
            return true;
		}
		else if(space[3].getText() == space[4].getText() && space[4].getText() == space[5].getText())
		{
			return true;
		}
		else if(space[6].getText() == space[7].getText() && space[7].getText() == space[8].getText())
		{
			return true;
		}
		else if(space[0].getText() == space[3].getText() && space[3].getText() == space[6].getText())
		{
			return true;
		}
		else if(space[1].getText() == space[4].getText() && space[4].getText() == space[7].getText())
		{
			return true;
		}
		else if(space[2].getText() == space[5].getText() && space[5].getText() == space[8].getText())
		{
			return true;
		}
		else if(space[0].getText() == space[4].getText() && space[4].getText() == space[8].getText())
		{
			return true;
		}
		else if(space[2].getText() == space[4].getText() && space[4].getText() == space[6].getText())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{

		TicTacToeGUI newGame = new TicTacToeGUI();
	
	}
	
	
    
    
    
    
    private class spaceButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(gameOver)
			{
				return;
			}
			
			JButton pressed = (JButton)(e.getSource());
			String text = pressed.getText();
			

			if(text.equals("O") || text.equals("X"))
			{
				return;
			}
			
			if(playerX)
			{
				pressed.setText("X");
			}
			else
			{
				pressed.setText("O");
			}
			
			if(checkWinner())
			{
				gameOver = true;
				
				if(playerX)
				{
					playerTurn.setText("Player X wins!");
				}
				else
				{
					playerTurn.setText("Player O wins!");
				}
			}
            
            else
			{
				playerX = !playerX;

				if(playerX)
				{
					playerTurn.setText("Player X");
				}
				else
				{
					playerTurn.setText("Player O");
				}
			}
		}
	}
	
	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	private class resetButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display();
		}
	}
}