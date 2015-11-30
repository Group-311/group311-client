package example;

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
import org.omg.CORBA.BAD_INV_ORDER;

import com.google.gson.Gson;

public class SimpleSlickGame extends BasicGame {
	static Board board;

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

	private Image[] missions = null;

	private Image map = null;

	int xpos;
	int ypos;
	Input input;
	
	private Town townA= null;
	private Town townB = null;
	
	public Connection selectedConnection = null;

	public SimpleSlickGame(String gamename) {
		super("TicketToRide");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// I don't know where this has to be loaded, but for now we can load all
		// images here

		map = new Image("/Map.jpg");
		board.setBoardPic(map);

		// Setting the images for the summaryCard
		summaryBackImage = new Image("/summaryBack.jpg");
		summaryFrontImage = new Image("/summaryFront.jpg");
		board.summaryCard.setBackImage(summaryBackImage);
		board.summaryCard.setFrontImage(summaryFrontImage);

		// Setting cardback and cardfront for the trainCards
		// Cardback is the same for all the trainCards
		trainCardBack = new Image("/trainCardBack.png");
		for (int i = 0; i < board.trainCards.length; i++) {
			board.trainCards[i].setBackImage(trainCardBack);
			board.trainCards[i].xPos = 1024 - board.trainCardStack.width;
			board.trainCards[i].yPos += board.trainCardStack.height;

		}

		// Loading all the trainCardImages
		blackTrainCard = new Image("/blackTrainCard.png");
		blueTrainCard = new Image("/blueTrainCard.png");
		greenTrainCard = new Image("/greenTrainCard.png");
		orangeTrainCard = new Image("/orangeTrainCard.png");
		pinkTrainCard = new Image("/pinkTrainCard.png");
		redTrainCard = new Image("/redTrainCard.png");
		whiteTrainCard = new Image("/whiteTrainCard.png");
		yellowTrainCard = new Image("/yellowTrainCard.png");
		rainbowTrainCard = new Image("/rainbowTrainCard.png");

		// Applying the trainCardImages to the correct spot within the array.
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

		// Shuffle train cards in the traincard stack
		board.trainCardStack.shuffle(board.trainCards);
		// Set the mouse input conditions for the borders of the traincard stack
		board.trainCardStack.xPos = 1024 - board.trainCardStack.width;
		board.trainCardStack.yPos += board.trainCardStack.height;

		missions = new Image[30];

		// Loading and applying the missionCards.
		for (int i = 0; i < board.missionCards.length; i++) {
			missions[i] = new Image("/mission(" + i + ").png");
			board.missionCards[i].setFrontImage(missions[i]);
		}

		// Setting the cardback for the missioncards
		missionCardBack = new Image("/missionCardBack.png");
		for (int i = 0; i < board.missionCards.length; i++) {
			board.missionCards[i].setBackImage(missionCardBack);
		}

		// Shuffle mission cards in the missioncard stack
		board.missionCardStack.shuffle(board.missionCards);
		// Set the mouse input conditions for the borders of the missioncard stack
		board.missionCardStack.xPos = 1024 - board.missionCardStack.width;
		board.missionCardStack.yPos += board.missionCardStack.height;
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {

		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();

		// Calling flipcard function if activated

		// --------------------------------------------------------------------------------------------------------------------------------------------
		// Will implement what happens when you click a city in here.

				if (input.isMousePressed(0)) {
					for (int j = 0; j < board.towns.length; j++) {
						if (xpos < board.towns[j].getxPos() + 10 && xpos >= board.towns[j].getxPos() - 10
								&& ypos < board.towns[j].getyPos() + 10 && ypos > board.towns[j].getyPos() - 10) {
							System.out.println("You have selected " + board.towns[j].getName());
							if (townA == null) {
								townA = board.towns[j];
								System.out.println(townA.getName() + " has been clicked as town A");
							} else if (townB == null) {
								townB = board.towns[j];
								System.out.println(townB.getName() + " has been clicked as town B");
							}
							
						}

					}
					if (townA!=null && townB!=null){
						if(findConnectionToBuild(townA, townB) == null){
							townA = null;
							townB = null;
						}else{
							selectedConnection = findConnectionToBuild(townA, townB);
							System.out.println("The selected connection require "+selectedConnection.getLength()+" trains with the color "+selectedConnection.getColor().getColorName());
						}
						
					}
					
					// System.out.println(townB.getName() + " " + townA.getName());
				}
				//  --------------------------------------------------------------------------------------------------------------------------------------------
		
		// Right click
		if (input.isMousePressed(1)) {
			// mouse input conditions for summary card
			if (xpos < board.summaryCard.xPos + board.summaryCard.width && xpos > board.summaryCard.xPos
					&& ypos > 768 - board.summaryCard.height) {
				board.summaryCard.flipCard();
			}

			// mouse input conditions for mission card stack
			if (xpos < board.missionCardStack.xPos + board.missionCardStack.width && xpos > board.missionCardStack.xPos
					&& ypos > 768 - board.missionCardStack.height) {
				board.missionCardStack.card[1].flipCard();
			}

			// mouse input conditions for train card stack
			if (xpos < board.trainCardStack.xPos + board.trainCardStack.width && xpos > board.trainCardStack.xPos
					&& ypos < 768 - board.trainCardStack.height && ypos > 768 - 2 * board.trainCardStack.height) {
				board.trainCardStack.card[1].flipCard();
			}
		}
	}
	private Connection findConnectionToBuild(Town town1, Town town2) {
		
		for(int i = 0; i < board.connections.length; i++){
			if(board.connections[i].getTownA().getName() == town1.getName() || board.connections[i].getTownA().getName() == town2.getName()){
				//Keeps looking for the right connection
				if(board.connections[i].getTownB().getName() == town1.getName() || board.connections[i].getTownB().getName() == town2.getName()){
					System.out.println("These are neighbours");
					if(!board.connections[i].isTaken())
						return board.connections[i];
				}
			}
			/*else {
				System.out.println("You probably didnt click two neighbouring cities, or no connections are available between these two cities");
			}*/
		}
		return null;
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// Loads the placement Map image used to detect cities

		board.getBoardPic().draw(); // Place it in (0,0)
		
		board.summaryCard.setVisible();
		board.missionCardStack.card[1].setVisible();
		board.trainCardStack.card[1].setVisible();
	}

	public static void main(String[] args) throws SlickException {
		board = new Board(3);
		System.out.println(board.connections[28].getTownA().getName());
		System.out.println(board.towns[20].getName());
		System.out.println(board.towns[20].getConnection(1).getTownA().getName());


		System.out.println(board.towns[0].getConnections().length);
		System.out.println(board.towns[3].getConnections().length);


		// GsonJson test with stacks of
		// traincards.-----------------------------------------------------------
		System.out.println(board.trainCardStack.card[1].getColor().getColorNum());
		System.out.println(board.trainCardStack.card[50].getColor().getColorNum());
		Gson serializer = new Gson();
		String Jsontrain = serializer.toJson(board);

		Board temp = new Gson().fromJson(Jsontrain, Board.class);

		System.out.println(temp.trainCardStack.card[1].getColor().getColorNum());
		// JSON TEST END
		// ------------------------------------------------------------------------------------

		// System.out.println(board.checkConnected(board.towns[0],
		// board.towns[3]));
		// board.checkConnected(board.towns[0], board.towns[2]);

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

		
		//GsonJson test with stacks of traincards.-----------------------------------------------------------
				/*System.out.println(board.trainCardStack.card[1].getColor().getColorNum());
				System.out.println(board.trainCardStack.card[50].getColor().getColorNum());
				Gson serializer = new Gson();
				String Jsontrain = serializer.toJson(board);
				
				Board temp  = new Gson().fromJson(Jsontrain, Board.class);
				
				System.out.println(temp.trainCardStack. card[1].getColor().getColorNum());*/
		// JSON TEST END ------------------------------------------------------------------------------------
				
				

		board.connections[8].setTaken(true);
		board.connections[17].setTaken(true);
		//board.connections[4].setTaken();
				
		//System.out.println(board.checkConnected(board.towns[0], board.towns[3]));
		//board.REMOVEDcheckConnected(board.towns[0], board.towns[1]);
		System.out.println(board.areConnected(board.towns[0], board.towns[10]));
		
/*	try{
			
			String sentence;
			String modifiedSentence;
			BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
			Socket clientSocket = new Socket("172.20.10.5", 1233);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
			clientSocket.close();
			
			}catch(Exception e){
				System.out.println(e.getStackTrace());
			}*/
		

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

	/*
	 * public boolean checkConnected(Town _townA, Town _townB) { // Loop through
	 * all the connections of _townB for (int i = 0; i <
	 * _townB.getConnections().length; i++) { // If any of the connections of
	 * _townB starts or ends in _townA, // return true. if
	 * (_townB.getConnections()[i].getTownA() == _townA ||
	 * _townB.getConnections()[i].getTownB() == _townA) return true; } // else
	 * return false return false; }
	 */
}