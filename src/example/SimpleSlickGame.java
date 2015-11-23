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
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory.Zephyr;

import sun.net.www.content.image.gif;

import java.io.*;
import java.net.*;

public class SimpleSlickGame extends BasicGame {
	static Board board;
	private Image summaryBackImage = null;
	private Image summaryFrontImage = null;
	private Image map = null;

	int xpos;
	int ypos;
	Input input;
	
	public SimpleSlickGame(String gamename) {
		super("TicketToRide");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// I don't know where this has to be loaded, but for now we can load all
		// images here
		map = new Image("/Map.jpg");
		summaryBackImage = new Image("/summaryBack.jpg");
		summaryFrontImage = new Image("/summaryFront.jpg");
		board.summaryCard.setBackImage(summaryBackImage);
		board.summaryCard.setFrontImage(summaryFrontImage);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
	
		Input input = gc.getInput();
		 xpos = Mouse.getX();
		 ypos = Mouse.getY();

		//Calling flipcard function if activated
			if (input.isMousePressed(0)) {
				if (xpos <board.summaryCard.xPos+board.summaryCard.width && xpos>board.summaryCard.xPos && ypos<board.summaryCard.yPos+board.summaryCard.height && ypos>board.summaryCard.yPos)
					board.summaryCard.flipCard();
			
			
		}

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		
	 // Loads the placement Map image used	to detect cities
		map.draw(); // Place it in (0,0)
		board.summaryCard.setVisible();
	

	}

	public static void main(String[] args) throws SlickException {
		board = new Board(3);
		System.out.println(board.connections[28].getTownA().getName());
		System.out.println(board.towns[20].getName());
		System.out.println(board.towns[20].getConnection(1).getTownA().getName());

		/*
		 * try{
		 * 
		 * String sentence; String modifiedSentence; BufferedReader inFromUser =
		 * new BufferedReader( new InputStreamReader(System.in)); Socket
		 * clientSocket = new Socket("172.20.10.5", 1233); DataOutputStream
		 * outToServer = new DataOutputStream(clientSocket.getOutputStream());
		 * BufferedReader inFromServer = new BufferedReader(new
		 * InputStreamReader(clientSocket.getInputStream())); sentence =
		 * inFromUser.readLine(); outToServer.writeBytes(sentence + '\n');
		 * modifiedSentence = inFromServer.readLine(); System.out.println(
		 * "FROM SERVER: " + modifiedSentence); clientSocket.close();
		 * 
		 * }catch(Exception e){ System.out.println(e.getStackTrace()); }
		 */

		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(1024, 768, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * ONLY CHECKS ONE CONNECTION BETWEEN TWO TOWNS This function will check if
	 * two towns are connected
	 * 
	 * @param _townA
	 *            The "start" town, you're checking if townB is connected to
	 *            townA or vice versa
	 * @param _townB
	 *            The "other" town.
	 * @return Returns true if any of the connections of townB starts or ends in
	 *         townA.
	 */

	public boolean checkConnected(Town _townA, Town _townB) {
		// Loop through all the connections of _townB
		for (int i = 0; i < _townB.getConnections().length; i++) {
			// If any of the connections of _townB starts or ends in _townA,
			// return true.
			if (_townB.getConnections()[i].getTownA() == _townA || _townB.getConnections()[i].getTownB() == _townA)
				return true;
		}
		// else return false
		return false;
	}
}