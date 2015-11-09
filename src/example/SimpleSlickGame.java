package example;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		for(int i = 0; i < 10; i++){
		g.drawString("Stop, siger Kirsten!", 2.5f*i*10, 2*i*10);
		}
	
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/**
	 * This function will check if two towns are connected
	 * @param _townA 
	 * The "start" town, you're checking if townB is connected to townA or vice versa
	 * @param _townB
	 * The "other" town.
	 * @return
	 * Returns true if any of the connections of townB starts or ends in townA.
	 */
	
	public boolean checkConnected(Town _townA, Town _townB){
		//Loop through all the connections of _townB
		for(int i = 0; i < _townB.getConnections().length; i++){
		//If any of the connections of _townB starts or ends in _townA, return true.
		if(_townB.getConnections()[i].getTownA() == _townA 
				|| _townB.getConnections()[i].getTownB() == _townA)
		return true;
		}
		//else return false
		return false;
	}
}