package example;
import java.util.logging.Level;
import org.lwjgl.input.Mouse;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.LoadableImageData;

import com.sun.javafx.collections.MappingChange.Map;

import sun.net.www.content.image.gif;

public class SimpleSlickGame extends BasicGame
{
	public SimpleSlickGame(String gamename)
	{
		super("TicketToRide");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		if(input.isMousePressed(0))
		{
			System.out.println("x: " + xpos + "        y: " +ypos);
		
		}
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
	Image map = new Image("/Map.jpg");		//Loads the placement Map image used to detect cities
	g.drawImage(map, 0, 0);					//Place it in (0,0)
	}
	

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(1024, 768, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}