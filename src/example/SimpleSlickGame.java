package example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import org.lwjgl.input.Mouse;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame {
	static Board board;
	
	/*private Image blackPlayerPiece;
	private Image bluePlayerPiece;
	private Image greenPlayerPiece;
	private Image orangePlayerPiece;
	private Image pinkPlayerPiece;
	private Image redPlayerPiece;
	private Image whitePlayerPiece;
	private Image yellowPlayerPiece;*/
	
	private Image summaryBackImage = null;
	private Image summaryFrontImage = null;
	private Image missionCardBack = null;
	
	private Image trainCardBack = null;
	private Image blackTrainCard = null;
	private Image blueTrainCard = null;
	private Image greenTrainCard = null;
	private Image orangeTrainCard = null;
	private Image pinkTrainCard = null;
	private Image redTrainCard = null;
	private Image whiteTrainCard = null;
	private Image yellowTrainCard = null;
	private Image rainbowTrainCard = null;
	
	private Image[] missions= null;
	
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
		board.setBoardPic(map);
		
		//Setting the images for the summaryCard
		summaryBackImage = new Image("/summaryBack.jpg");
		summaryFrontImage = new Image("/summaryFront.jpg");
		board.summaryCard.setBackImage(summaryBackImage);
		board.summaryCard.setFrontImage(summaryFrontImage);
		
		//Setting cardback and cardfront for the trainCards
		//Cardback is the same for all the trainCards
		trainCardBack = new Image("/trainCardBack.png");
		for (int i=0; i<board.trainCards.length; i++)
		{
			board.trainCards[i].setBackImage(trainCardBack);
		}
		
	/*	//Loading all the playerPieceImages
		blackPlayerPiece = new Image("/blackPlayerPiece.png");
		bluePlayerPiece = new Image("/bluePlayerPiece.png");
		greenPlayerPiece = new Image("/greenPlayerPiece.png");
		orangePlayerPiece = new Image("/orangePlayerPiece.png");
		pinkPlayerPiece = new Image("/pinkPlayerPiece.png");
		redPlayerPiece = new Image("/redPlayerPiece.png");
		whitePlayerPiece = new Image("/whitePlayerPiece.png");
		yellowPlayerPiece = new Image("/yellowPlayerPiece.png");*/
		
		//Loading all the trainCardImages
		blackTrainCard = new Image("/blackTrainCard.png");
		blueTrainCard = new Image("/blueTrainCard.png");
		greenTrainCard = new Image("/greenTrainCard.png");
		orangeTrainCard = new Image("/orangeTrainCard.png");
		pinkTrainCard = new Image("/pinkTrainCard.png");
		redTrainCard = new Image("/redTrainCard.png");
		whiteTrainCard = new Image("/whiteTrainCard.png");
		yellowTrainCard = new Image("/yellowTrainCard.png");
		rainbowTrainCard = new Image("/rainbowTrainCard.png");
		
		//Applying the trainCardImages to the correct spot within the array.
		for (int i = 0; i < 12; i++) {
			board.trainCards[i].setFrontImage(blueTrainCard);
		}
		for (int i = 12; i < 24; i++) {
			board.trainCards[i].setFrontImage(redTrainCard);
		}
		for (int i = 24; i < 36; i++) {
			board.trainCards[i].setFrontImage(orangeTrainCard);
		}
		for (int i = 36; i < 48; i++) {
			board.trainCards[i].setFrontImage(whiteTrainCard);
		}
		for (int i = 48; i < 60; i++) {
			board.trainCards[i].setFrontImage(yellowTrainCard);
		}
		for (int i = 60; i < 72; i++) {
			board.trainCards[i].setFrontImage(blackTrainCard);
		}
		for (int i = 72; i < 84; i++) {
			board.trainCards[i].setFrontImage(greenTrainCard);
		}
		for (int i = 84; i < 96; i++) {
			board.trainCards[i].setFrontImage(pinkTrainCard);
		}
		for (int i = 96; i < 110; i++) {
			board.trainCards[i].setFrontImage(rainbowTrainCard);
		}
		
		missions = new Image[30];
		
		//Loading and applying the missionCards.
		for (int i=0; i<board.missionCards.length; i++)
		{
		missions[i] = new Image("/mission("+i+").png");
		board.missionCards[i].setFrontImage(missions[i]);
		}		
		
		//Setting the cardback for the missioncards
		missionCardBack = new Image("/missionCardBack.png");
		for (int i=0; i<board.missionCards.length; i++)
		{
			board.missionCards[i].setBackImage(missionCardBack);
		}
		
		//Shuffle mission cards
		board.missionCardStack.shuffle(board.missionCards);
		
		//Shuffle train cards
		board.trainCardStack.shuffle(board.trainCards);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		Input input = gc.getInput();
		 xpos = Mouse.getX();
		 ypos = Mouse.getY();
		 

		//Calling flipcard function if activated
			if (input.isMousePressed(0)) {
				if (xpos <board.summaryCard.xPos+board.summaryCard.width && xpos>board.summaryCard.xPos && ypos>768-board.summaryCard.height)
					//board.summaryCard.flipCard();
					//board.missionCardStack.card[1].flipCard();
					board.trainCardStack.card[1].flipCard();
		}

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
	 // Loads the placement Map image used	to detect cities
		
		board.getBoardPic().draw();; // Place it in (0,0)
		board.summaryCard.setVisible();
		board.missionCardStack.card[1].setVisible();
		board.trainCardStack.card[1].setVisible();
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