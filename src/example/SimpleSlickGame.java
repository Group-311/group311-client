package example;

import java.util.logging.Level;
import org.lwjgl.input.Mouse;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
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
	// private Image rainbowTrainCard = null; without jokers

	private Image[] missions = null;
	
	private Color red,green,blue,yellow;

	private Image map = null;

	int xpos;
	int ypos;
	Input input;

	private Town townA = null;
	private Town townB = null;

	public Connection selectedConnection = null;

	public SimpleSlickGame(String gamename) {
		super("TicketToRide");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// I don't know where this has to be loaded, but for now we can load all
		// images here

		map = new Image("/pics/Map.jpg");
		board.setBoardPic(map);
		
		//Setting som colors for the playerpieces
		red = new Color(255,0,0);
		green = new Color(0,255,0);
		blue = new Color(0,0,255);
		yellow = new Color(255,255,0);
		
		
		board.players[0].setColor(new Color(red));
		board.players[1].setColor(new Color(green));
		board.players[2].setColor(new Color(blue));
		board.players[3].setColor(new Color(yellow));
		
		// Setting the images for the summaryCard
		summaryBackImage = new Image("/pics/summaryBack.jpg");
		summaryFrontImage = new Image("/pics/summaryFront.jpg");
		board.summaryCard.setBackImage(summaryBackImage);
		board.summaryCard.setFrontImage(summaryFrontImage);

		// Setting cardback and cardfront for the trainCards
		// Cardback is the same for all the trainCards
		trainCardBack = new Image("/pics/trainCardBack.png");

		for (int i = 0; i < board.trainCards.length; i++) {
			board.trainCards[i].setBackImage(trainCardBack);
			board.trainCards[i].xPos = 1024 - board.trainCardStack.width;
			board.trainCards[i].yPos += board.trainCardStack.height;
		}

		// Setting the image for the stationaryCard
		board.stationaryCard.setBackImage(trainCardBack);
		board.stationaryCard.xPos = 1024 - board.stationaryCard.width;
		board.stationaryCard.yPos += board.stationaryCard.height;

		// Loading all the trainCardImages
		blackTrainCard = new Image("/pics/blackTrainCard.png");
		blueTrainCard = new Image("/pics/blueTrainCard.png");
		greenTrainCard = new Image("/pics/greenTrainCard.png");
		orangeTrainCard = new Image("/pics/orangeTrainCard.png");
		pinkTrainCard = new Image("/pics/pinkTrainCard.png");
		redTrainCard = new Image("/pics/redTrainCard.png");
		whiteTrainCard = new Image("/pics/whiteTrainCard.png");
		yellowTrainCard = new Image("/pics/yellowTrainCard.png");
		// rainbowTrainCard = new Image("/rainbowTrainCard.png"); without jokers

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
		// for (int i = 96; i < 110; i++) {
		// board.trainCards[i].setFrontImage(rainbowTrainCard); // with jokers
		// }

		// Shuffle train cards in the traincard stack
		board.trainCardStack.shuffle(board.trainCards);
		// Set the mouse input conditions for the borders of the traincard stack
		board.trainCardStack.xPos = 1024 - board.trainCardStack.width;
		board.trainCardStack.yPos += board.trainCardStack.height;

		missions = new Image[30];

		// Loading and applying the missionCards.
		for (int i = 0; i < board.missionCards.length; i++) {
			missions[i] = new Image("/pics/misssion(" + i + ").jpg");
			board.missionCards[i].setFrontImage(missions[i]);
		}

		// Setting the cardback for the missioncards
		missionCardBack = new Image("/pics/missionCardBack.png");
		for (int i = 0; i < board.missionCards.length; i++) {
			board.missionCards[i].setBackImage(missionCardBack);
		}

		// Shuffle mission cards in the missioncard stack
		board.missionCardStack.shuffle(board.missionCards);
		// Set the mouse input conditions for the borders of the missioncard
		// stack
		board.missionCardStack.xPos = 1024 - board.missionCardStack.width;
		board.missionCardStack.yPos += board.missionCardStack.height;
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {

		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();

		int currentCard = 0;

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
			if (townA != null && townB != null) {
				if (findConnectionToBuild(townA, townB) == null) {
					townA = null;
					townB = null;
				} else {
					selectedConnection = findConnectionToBuild(townA, townB);
					System.out.println("The selected connection require " + selectedConnection.getLength()
							+ " trains with the color " + selectedConnection.getColor().getColorName());
				}

			}

			// System.out.println(townB.getName() + " " + townA.getName());
		}
		// --------------------------------------------------------------------------------------------------------------------------------------------

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
				board.missionCardStack.card[0].flipCard();
			}

			// mouse input conditions for train card stack
			if (xpos < board.trainCardStack.xPos + board.trainCardStack.width && xpos > board.trainCardStack.xPos
					&& ypos < 768 - board.trainCardStack.height && ypos > 768 - 2 * board.trainCardStack.height) {
				// System.out.println(" ");
				// for(int j = 0; j < 5; j++) {
				// board.displayedCardStack.card[j] =
				// board.trainCards[currentCard++];
				// System.out.println(board.displayedCardStack.card[j]);
				// System.out.println("Card " + currentCard + ", which is " +
				// board.trainCards[currentCard] + " from the train card stack,
				// is now equal to card " + board.displayedCardStack.card[j] + "
				// in the displayed stack");
				// }

				for (int j = 0; j < 5; j++) {
					board.trainCardStack.card[currentCard++].yPos = 595 - board.trainCardStack.height * (j + 1);
					board.trainCardStack.card[j].flipCard();
				}

				// Exact values for the moouseY input conditions as reminders
				// board.trainCardStack.card[0].yPos = 510;
				// board.trainCardStack.card[1].yPos = 425;
				// board.trainCardStack.card[2].yPos = 340;
				// board.trainCardStack.card[3].yPos = 255;
				// board.trainCardStack.card[4].yPos = 170;
			}

			// Mouse input conditions for the displayed cards
			// if (xpos < board.trainCardStack.xPos + board.trainCardStack.width
			// && xpos > board.trainCardStack.xPos
			// && ypos < 768 - 2 * board.trainCardStack.height && ypos > 768 - 3
			// * board.trainCardStack.height) {
			// }

			// if (xpos < board.trainCardStack.xPos + board.trainCardStack.width
			// && xpos > board.trainCardStack.xPos
			// && ypos < 768 - 3 * board.trainCardStack.height && ypos > 768 - 4
			// * board.trainCardStack.height) {
			// }
			//
			// if (xpos < board.trainCardStack.xPos + board.trainCardStack.width
			// && xpos > board.trainCardStack.xPos
			// && ypos < 768 - 4 * board.trainCardStack.height && ypos > 768 - 5
			// * board.trainCardStack.height) {
			// }
			//
			// if (xpos < board.trainCardStack.xPos + board.trainCardStack.width
			// && xpos > board.trainCardStack.xPos
			// && ypos < 768 - 5 * board.trainCardStack.height && ypos > 768 - 6
			// * board.trainCardStack.height) {
			// }
			//
			// if (xpos < board.trainCardStack.xPos + board.trainCardStack.width
			// && xpos > board.trainCardStack.xPos
			// && ypos < 768 - 6 * board.trainCardStack.height && ypos > 768 - 7
			// * board.trainCardStack.height) {
			// }

		}
	}

	private Connection findConnectionToBuild(Town town1, Town town2) {

		for (int i = 0; i < board.connections.size(); i++) {
			if (board.connections.get(i).getTownA().getName() == town1.getName()
					|| board.connections.get(i).getTownA().getName() == town2.getName()) {
				// Keeps looking for the right connection
				if (board.connections.get(i).getTownB().getName() == town1.getName()
						|| board.connections.get(i).getTownB().getName() == town2.getName()) {
					System.out.println("These are neighbours");
					if (!board.connections.get(i).getIsTaken())
						return board.connections.get(i);
				}
			}
			/*
			 * else { System.out.println(
			 * "You probably didnt click two neighbouring cities, or no connections are available between these two cities"
			 * ); }
			 */
		}
		return null;
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// Loads the placement Map image used to detect cities

		board.getBoardPic().draw(); // Place it in (0,0)

		board.summaryCard.setVisible();
		
		board.stationaryCard.setVisible();

		board.missionCardStack.card[0].setVisible();

		for (int j = 0; j < 5; j++) {
			board.trainCardStack.card[j].setVisible();
		}
		
		//Setting the visibility of the playerpieces
		for (int i=0; i<board.players.length;i++)
		{
			board.players[i].setVisible(g);
		}
		
		board.button.setVisible(g,0);
		
		
	}

	public static void main(String[] args) throws SlickException {
		board = new Board(4);


		// GsonJson test with stacks of
		// traincards.-----------------------------------------------------------
		/*
		 * System.out.println(board.trainCardStack.card[1].getColor().
		 * getColorNum());
		 * System.out.println(board.trainCardStack.card[50].getColor().
		 * getColorNum()); Gson serializer = new Gson(); String Jsontrain =
		 * serializer.toJson(board);
		 * 
		 * Board temp = new Gson().fromJson(Jsontrain, Board.class);
		 * 
		 * System.out.println(temp.trainCardStack.card[1].getColor().getColorNum
		 * ());
		 */
		// JSON TEST END
		// ------------------------------------------------------------------------------------


		// GsonJson test with stacks of
		// traincards.-----------------------------------------------------------
		/*
		 * System.out.println(board.trainCardStack.card[1].getColor().
		 * getColorNum());
		 * System.out.println(board.trainCardStack.card[50].getColor().
		 * getColorNum()); Gson serializer = new Gson(); String Jsontrain =
		 * serializer.toJson(board);
		 * 
		 * Board temp = new Gson().fromJson(Jsontrain, Board.class);
		 * 
		 * System.out.println(temp.trainCardStack.
		 * card[1].getColor().getColorNum());
		 */
		// JSON TEST END
		// ------------------------------------------------------------------------------------


		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(1024, 768, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}