import edu.jsu.mcis.*;

public class TictactoeKeywords
{
    private Tictactoe tictactoe = new Tictactoe();
    
    public void startNewGame()
	{
        return tictactoe.play();
    }
    
    public Boolean markLocation()
	{
        return tictactoe.setMarker();
    }
	
	public Tictactoe.Marker locationShouldBe()
	{
        return tictactoe.getMarker();
    }
	
	public Tictactoe.Outcome winnerShouldBe()
	{
        return tictactoe.getOutcome();
    }
	
	public Tictactoe.Marker o()
	{
        return tictactoe.Marker.OMARK();
    }
	
	public Tictactoe.Marker x()
	{
        return tictactoe.Marker.XMARK();
    }
	
	public Tictactoe.Marker tie()
	{
        return tictactoe.Marker.DRAW();
    }
    
}