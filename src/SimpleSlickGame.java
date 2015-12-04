import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
import com.google.gson.Gson;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.security.ntlm.Client;

import sun.print.resources.serviceui;

public class SimpleSlickGame extends BasicGame implements Runnable {

	// ------
	PrintStream pStream;
	BufferedReader bufInput;
	String answer = null;
	String textString;
	static Socket s;

	static boolean runThisOnce=false;
	
	static Socket Sock;

	public static PrintStream ps;

	// -------

	public static Train t;
	public static Stack t2;

	public static Stack t6;

	public static Stack t8;
	public static Connection t9;
	public static PlayerPiece t10;

	public static Card m1;

	// public static Town townA, townB; //commented these out, as the already
	// existed in SimpleSlick

	public static Card missionCard;

	public static ArrayList<Integer> arrayTest;

	public static Town tempCityB, tempCityA;
	public static Card tempCard;

	public static boolean displayTheCards = false, displayTheCards2 = false;

	// +++++

	// Color counters
	static int blueColorCounter, redColorCounter, orangeColorCounter, whiteColorCounter, yellowColorCounter,
			blackColorCounter, greenColorCounter, pinkColorCounter;

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

	private Color red, green, blue, yellow;

	private Image map = null;

	private boolean completedActions = false;
	private boolean isYourTurn;
	private boolean youPickedTrainCards = false;
	private boolean youPickedMissionCards = false;
	private boolean youPlayedAConnection = false;

	int xpos;
	int ypos;
	Input input;

	private Town townA = null;
	private Town townB = null;

	String activater = null;

	public ArrayList<Connection> connectionsToDraw = new ArrayList<Connection>();

	Players player1 = new Players(1, board.colors[0]);
	Players player2 = new Players(2, board.colors[1]);
	Players player3 = new Players(3, board.colors[2]);
	Players player4 = new Players(4, board.colors[3]);

	ArrayList<Card> myHand;

	public Connection selectedConnection = null;

	public SimpleSlickGame(String gamename) {
		super("TicketToRide");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// I don't know where this has to be loaded, but for now we can load all
		// images here

		// for (int flf = 0; flf < board.connections.size(); flf++)
		// connectionsToDraw.add(board.connections.get(5));
		isYourTurn = false;
		map = new Image("/pics/Map.jpg");
		board.setBoardPic(map);

		// Setting som colors for the playerpieces
		red = new Color(255, 0, 0);
		green = new Color(0, 255, 0);
		blue = new Color(0, 0, 255);
		yellow = new Color(255, 255, 0);

		board.playerPieces[0].setColor(new Color(red));
		board.playerPieces[1].setColor(new Color(green));
		board.playerPieces[2].setColor(new Color(blue));
		board.playerPieces[3].setColor(new Color(yellow));

		// Setting the images for the summaryCard
		summaryBackImage = new Image("/pics/summaryBack.jpg");
		summaryFrontImage = new Image("/pics/summaryFront.jpg");
		board.summaryCard.setBackImage(summaryBackImage);
		board.summaryCard.setFrontImage(summaryFrontImage);

		/*
		 * Setting cardback and cardfront for the trainCards Cardback is the
		 * same for all the trainCards
		 */
		trainCardBack = new Image("/pics/trainCardBack.png");

		for (int i = 0; i < board.trainCards.length; i++) {
			board.trainCards[i].setBackImage(trainCardBack);
		}

		// Applying the cardback for the stationary image for train cards
		board.stationaryCardT.setBackImage(trainCardBack);

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
		// board.trainCards[i].setFrontImage(rainbowTrainCard); // no jokers atm
		// }

		missions = new Image[30];
		missionCardBack = new Image("/pics/missionCardBack.png");

		// Loading and applying the missionCards and setting the cardback for
		// the missioncards
		for (int i = 0; i < board.missionCards.length; i++) {
			missions[i] = new Image("/pics/misssion(" + i + ").jpg");
			board.missionCards[i].setFrontImage(missions[i]);
			board.missionCards[i].setBackImage(missionCardBack);
		}

		// Applying the cardback for the stationary image for mission cards
		board.stationaryCardM.setBackImage(missionCardBack);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {

		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();

		// --------------------------------------------------------------------------------------------------------------------------------------------
		// Will implement what happens when you click a city in here.

		if (board.isYourTurnBoard) {
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
						//connectionsToDraw.add(selectedConnection);
						
						
						
						
						// Claim a blue route, get points, use cards and train
						// tokens
						if (blueColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[0]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of blue cards decreases by amount of cost
							blueColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a red route, get points, use cards and train
						// tokens
						else if (redColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[1]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of red cards decreases by amount of cost
							redColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a orange route, get points, use cards and train
						// tokens
						else if (orangeColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[2]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of orange cards decreases by amount of
							// cost
							orangeColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a white route, get points, use cards and train
						// tokens
						else if (whiteColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[3]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of white cards decreases by amount of cost
							whiteColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a yellow route, get points, use cards and train
						// tokens
						else if (yellowColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[4]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of yellow cards decreases by amount of
							// cost
							yellowColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a black route, get points, use cards and train
						// tokens
						else if (blackColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[5]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of black cards decreases by amount of cost
							blackColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a grey route, get points, use cards and train
						// tokens
						else if (selectedConnection.getColor() == board.colors[6]) {
							// Play all cards - no conditions
							connectionsToDraw.add(selectedConnection);

							if (blueColorCounter == selectedConnection.getLength()) {
								blueColorCounter -= selectedConnection.getLength();
							} else if (redColorCounter == selectedConnection.getLength()) {
								redColorCounter -= selectedConnection.getLength();
							} else if (orangeColorCounter == selectedConnection.getLength()) {
								orangeColorCounter -= selectedConnection.getLength();
							} else if (whiteColorCounter == selectedConnection.getLength()) {
								whiteColorCounter -= selectedConnection.getLength();
							} else if (yellowColorCounter == selectedConnection.getLength()) {
								yellowColorCounter -= selectedConnection.getLength();
							} else if (blackColorCounter == selectedConnection.getLength()) {
								blackColorCounter -= selectedConnection.getLength();
							} else if (greenColorCounter == selectedConnection.getLength()) {
								greenColorCounter -= selectedConnection.getLength();
							} else if (pinkColorCounter == selectedConnection.getLength()) {
								pinkColorCounter -= selectedConnection.getLength();
							}

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a green route, get points, use cards and train
						// tokens
						else if (greenColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[7]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of green cards decreases by amount of cost
							greenColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}

						// Claim a pink route, get points, use cards and train
						// tokens
						else if (pinkColorCounter >= selectedConnection.getLength()
								&& selectedConnection.getColor() == board.colors[8]) {
							connectionsToDraw.add(selectedConnection);

							// Put the cards played back into the train card
							// stack array list
							for (int j = 0; j < selectedConnection.getLength(); j++) {
								board.arrayOfTrainCards.add(board.player1TrainHandStack.get(0));
								board.player1TrainHandStack.remove(0);
							}

							// amount of pink cards decreases by amount of cost
							pinkColorCounter -= selectedConnection.getLength();
							// amount of train pieces decreases by amount of
							// cost
							player1.numOfTrains -= selectedConnection.getLength();

							board.playerPieces[player1.playerNum].hasbeenmoved = false;
							board.playerPieces[player1.playerNum].totalPoints += selectedConnection.getLength();
						}
						
						
						
						

						completedActions = true;
						youPlayedAConnection = true;

						System.out.println("The selected connection require " + selectedConnection.getLength()
								+ " trains with the color " + selectedConnection.getColor().getColorName());
						
						// set the values of the towns to null so a new
						// connection can be made
						townA = null;
						townB = null;
					}
				}

				// System.out.println(townB.getName() + " " + townA.getName());

				/*
				 * SUMMARY CARD FLIP CARD
				 */
				if (xpos < board.summaryCard.xPos + board.summaryCard.width && xpos > board.summaryCard.xPos
						&& ypos > 768 - board.summaryCard.height) {
					board.summaryCard.flipCard();
				}

				/*
				 * MISSIONCARDSTACK FUNCTIONALITY MISSIONCARDSTACK TO HANDSTACK
				 * Mouse input conditions to do the following add the top card
				 * of the drawable mission card stack to the mission card hand
				 * stack for player 1 remove that card from the drawable mission
				 * card stack this will make the mission cards in the array list
				 * move 1 room to the left (decrease by 1)
				 */
				if (xpos < board.missionCardStack.xPos + Card.width && xpos > board.missionCardStack.xPos
						&& ypos > 768 - Card.height) {

					System.out.println("mission stack clicked");

					board.player1MissionHandStack.add(board.arrayOfMissionCards.get(0));
					board.arrayOfMissionCards.remove(0);
					board.player1MissionHandStack.add(board.arrayOfMissionCards.get(0));
					board.arrayOfMissionCards.remove(0);

					System.out.println(board.player1MissionHandStack.size());
					youPickedMissionCards = true;
					completedActions = true;
				}

				/*
				 * TRAINCARDSTACK FUNCTIONALITY TRAINCARDSTACK TO HANDSTACK
				 * Mouse input conditions to do the following add the top card
				 * of the drawable train card stack to the train card hand stack
				 * for player 1 remove that card from the drawable train card
				 * stack this will make the train cards in the array list move 1
				 * room to the left (decrease by 1)
				 */
				if (xpos < board.trainCardStack.xPos + Card.width && xpos > board.trainCardStack.xPos
						&& ypos < 768 - Card.height && ypos > 768 - 2 * Card.height) {

					System.out.println("face-down train card stack has been clicked");

					if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[0].getColorName()) {
						blueColorCounter++;
					} else if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[1]
							.getColorName()) {
						redColorCounter++;
					} else if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[2]
							.getColorName()) {
						orangeColorCounter++;
					} else if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[3]
							.getColorName()) {
						whiteColorCounter++;
					} else if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[4]
							.getColorName()) {
						yellowColorCounter++;
					} else if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[5]
							.getColorName()) {
						blackColorCounter++;
					} else if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[7]
							.getColorName()) {
						greenColorCounter++;
					} else if (board.arrayOfTrainCards.get(0).getColor().getColorName() == board.colors[8]
							.getColorName()) {
						pinkColorCounter++;
					}

					board.player1TrainHandStack.add(board.arrayOfTrainCards.get(0));
					board.arrayOfTrainCards.remove(0);

					for (int j = 0; j < board.player1TrainHandStack.size(); j++) {
						System.out.println(board.player1TrainHandStack.get(j).getColor().getColorName());
					}
					System.out.println(board.player1TrainHandStack.size());
					System.out.println("b:" + blueColorCounter + " r:" + redColorCounter + " o:" + orangeColorCounter
							+ " w:" + whiteColorCounter + " y:" + yellowColorCounter + " b:" + blackColorCounter + " g:"
							+ greenColorCounter + " p:" + pinkColorCounter);
					
					
					youPickedTrainCards= true;
					completedActions = true;
				}

				/*
				 * DISPLAYED STACK OF TRAINCARDS FUNCTIONALITY. The following is
				 * the structure for all the 5 rooms in the displayed hand stack
				 * array list Mouse input conditions to do the following check
				 * what color the card is and increment the proper color counter
				 * add the top card of the drawable train card stack to the
				 * train card hand stack for player 1 remove that card from the
				 * drawable train card stack reassign y positions for the cards
				 * in the drawable/displayed train stack this will make the
				 * train cards in the array list move 1 room to the left
				 * (decrease by 1)
				 */

				/*
				 * 1ST ROOM: FUNCTIONALITY IN DISPLAYED CARD TO HANDSTACK
				 */
				if (xpos < board.trainCardStack.xPos + Card.width && xpos > board.trainCardStack.xPos
						&& ypos < 768 - 2 * Card.height && ypos > 768 - 3 * Card.height) {

					System.out.println("Displayed train card #0 has been clicked");

					if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[0].getColorName()) {
						blueColorCounter++;
					} else if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[1]
							.getColorName()) {
						redColorCounter++;
					} else if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[2]
							.getColorName()) {
						orangeColorCounter++;
					} else if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[3]
							.getColorName()) {
						whiteColorCounter++;
					} else if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[4]
							.getColorName()) {
						yellowColorCounter++;
					} else if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[5]
							.getColorName()) {
						blackColorCounter++;
					} else if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[7]
							.getColorName()) {
						greenColorCounter++;
					} else if (board.displayedTrainStack.get(0).getColor().getColorName() == board.colors[8]
							.getColorName()) {
						pinkColorCounter++;
					}

					board.player1TrainHandStack.add(board.displayedTrainStack.get(0));
					board.displayedTrainStack.remove(0);
					board.displayedTrainStack.add(0, board.arrayOfTrainCards.get(0));
					board.arrayOfTrainCards.remove(0);

					board.displayedTrainStack.get(0).yPos = 170;
					board.displayedTrainStack.get(1).yPos = 255;
					board.displayedTrainStack.get(2).yPos = 340;
					board.displayedTrainStack.get(3).yPos = 425;
					board.displayedTrainStack.get(4).yPos = 510;

					for (int j = 0; j < board.player1TrainHandStack.size(); j++) {
						System.out.println(board.player1TrainHandStack.get(j).getColor().getColorName());
					}

					System.out.println(board.player1TrainHandStack.size());
					System.out.println("b:" + blueColorCounter + " r:" + redColorCounter + " o:" + orangeColorCounter
							+ " w:" + whiteColorCounter + " y:" + yellowColorCounter + " b:" + blackColorCounter + " g:"
							+ greenColorCounter + " p:" + pinkColorCounter);
				}

				/*
				 * 2ND ROOM: FUNCTIONALITY IN 2ND DISPLAYED CARD TO HANDSTACK
				 */
				if (xpos < board.trainCardStack.xPos + Card.width && xpos > board.trainCardStack.xPos
						&& ypos < 768 - 3 * Card.height && ypos > 768 - 4 * Card.height) {

					System.out.println("Displayed train card #1 has been clicked");

					if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[0].getColorName()) {
						blueColorCounter++;
					} else if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[1]
							.getColorName()) {
						redColorCounter++;
					} else if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[2]
							.getColorName()) {
						orangeColorCounter++;
					} else if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[3]
							.getColorName()) {
						whiteColorCounter++;
					} else if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[4]
							.getColorName()) {
						yellowColorCounter++;
					} else if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[5]
							.getColorName()) {
						blackColorCounter++;
					} else if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[7]
							.getColorName()) {
						greenColorCounter++;
					} else if (board.displayedTrainStack.get(1).getColor().getColorName() == board.colors[8]
							.getColorName()) {
						pinkColorCounter++;
					}

					board.player1TrainHandStack.add(board.displayedTrainStack.get(1));
					board.displayedTrainStack.remove(1);
					board.displayedTrainStack.add(1, board.arrayOfTrainCards.get(0));
					board.arrayOfTrainCards.remove(0);

					board.displayedTrainStack.get(0).yPos = 170;
					board.displayedTrainStack.get(1).yPos = 255;
					board.displayedTrainStack.get(2).yPos = 340;
					board.displayedTrainStack.get(3).yPos = 425;
					board.displayedTrainStack.get(4).yPos = 510;

					for (int j = 0; j < board.player1TrainHandStack.size(); j++) {
						System.out.println(board.player1TrainHandStack.get(j).getColor().getColorName());
					}

					System.out.println(board.player1TrainHandStack.size());
				}

				/*
				 * 3RD ROOM: FUNCTIONALITY IN 3RD DISPLAYED CARD TO HANDSTACK
				 */
				if (xpos < board.trainCardStack.xPos + Card.width && xpos > board.trainCardStack.xPos
						&& ypos < 768 - 4 * Card.height && ypos > 768 - 5 * Card.height) {

					System.out.println("Displayed train card #2 has been clicked");
					if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[0].getColorName()) {
						blueColorCounter++;
					} else if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[1]
							.getColorName()) {
						redColorCounter++;
					} else if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[2]
							.getColorName()) {
						orangeColorCounter++;
					} else if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[3]
							.getColorName()) {
						whiteColorCounter++;
					} else if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[4]
							.getColorName()) {
						yellowColorCounter++;
					} else if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[5]
							.getColorName()) {
						blackColorCounter++;
					} else if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[7]
							.getColorName()) {
						greenColorCounter++;
					} else if (board.displayedTrainStack.get(2).getColor().getColorName() == board.colors[8]
							.getColorName()) {
						pinkColorCounter++;
					}

					board.player1TrainHandStack.add(board.displayedTrainStack.get(2));
					board.displayedTrainStack.remove(2);
					board.displayedTrainStack.add(2, board.arrayOfTrainCards.get(0));
					board.arrayOfTrainCards.remove(0);

					board.displayedTrainStack.get(0).yPos = 170;
					board.displayedTrainStack.get(1).yPos = 255;
					board.displayedTrainStack.get(2).yPos = 340;
					board.displayedTrainStack.get(3).yPos = 425;
					board.displayedTrainStack.get(4).yPos = 510;

					for (int j = 0; j < board.player1TrainHandStack.size(); j++) {
						System.out.println(board.player1TrainHandStack.get(j).getColor().getColorName());
					}

					System.out.println(board.player1TrainHandStack.size());
				}

				/*
				 * 4TH ROOM: FUNCTIONALITY IN DISPLAYED CARD TO HANDSTACK
				 */
				if (xpos < board.trainCardStack.xPos + Card.width && xpos > board.trainCardStack.xPos
						&& ypos < 768 - 5 * Card.height && ypos > 768 - 6 * Card.height) {

					System.out.println("Displayed train card #3 has been clicked");

					if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[0].getColorName()) {
						blueColorCounter++;
					} else if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[1]
							.getColorName()) {
						redColorCounter++;
					} else if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[2]
							.getColorName()) {
						orangeColorCounter++;
					} else if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[3]
							.getColorName()) {
						whiteColorCounter++;
					} else if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[4]
							.getColorName()) {
						yellowColorCounter++;
					} else if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[5]
							.getColorName()) {
						blackColorCounter++;
					} else if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[7]
							.getColorName()) {
						greenColorCounter++;
					} else if (board.displayedTrainStack.get(3).getColor().getColorName() == board.colors[8]
							.getColorName()) {
						pinkColorCounter++;
					}

					board.player1TrainHandStack.add(board.displayedTrainStack.get(3));
					board.displayedTrainStack.remove(3);
					board.displayedTrainStack.add(3, board.arrayOfTrainCards.get(0));
					board.arrayOfTrainCards.remove(0);

					board.displayedTrainStack.get(0).yPos = 170;
					board.displayedTrainStack.get(1).yPos = 255;
					board.displayedTrainStack.get(2).yPos = 340;
					board.displayedTrainStack.get(3).yPos = 425;
					board.displayedTrainStack.get(4).yPos = 510;

					for (int j = 0; j < board.player1TrainHandStack.size(); j++) {
						System.out.println(board.player1TrainHandStack.get(j).getColor().getColorName());
					}

					System.out.println(board.player1TrainHandStack.size());
				}

				/*
				 * 5RD ROOM: FUNCTIONALITY IN 5TH DISPLAYED CARD TO HANDSTACK
				 */
				if (xpos < board.trainCardStack.xPos + Card.width && xpos > board.trainCardStack.xPos
						&& ypos < 768 - 6 * Card.height && ypos > 768 - 7 * Card.height) {

					System.out.println("Displayed train card #4 has been clicked");

					if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[0].getColorName()) {
						blueColorCounter++;
					} else if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[1]
							.getColorName()) {
						redColorCounter++;
					} else if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[2]
							.getColorName()) {
						orangeColorCounter++;
					} else if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[3]
							.getColorName()) {
						whiteColorCounter++;
					} else if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[4]
							.getColorName()) {
						yellowColorCounter++;
					} else if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[5]
							.getColorName()) {
						blackColorCounter++;
					} else if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[7]
							.getColorName()) {
						greenColorCounter++;
					} else if (board.displayedTrainStack.get(4).getColor().getColorName() == board.colors[8]
							.getColorName()) {
						pinkColorCounter++;
					}

					board.player1TrainHandStack.add(board.displayedTrainStack.get(4));
					board.displayedTrainStack.remove(4);
					board.displayedTrainStack.add(4, board.arrayOfTrainCards.get(0));
					board.arrayOfTrainCards.remove(0);

					board.displayedTrainStack.get(0).yPos = 170;
					board.displayedTrainStack.get(1).yPos = 255;
					board.displayedTrainStack.get(2).yPos = 340;
					board.displayedTrainStack.get(3).yPos = 425;
					board.displayedTrainStack.get(4).yPos = 510;

					for (int j = 0; j < board.player1TrainHandStack.size(); j++) {
						System.out.println(board.player1TrainHandStack.get(j).getColor().getColorName());
					}

					System.out.println(board.player1TrainHandStack.size());
				}

				// ---------------------------------------------------------------------------------------------------CLICKED
				// THE END BUTTON
				if (xpos < board.button.getxPos() + board.button.getWidth() && xpos > board.button.getxPos()
						&& ypos < 768 - board.button.getyPos()
						&& ypos > 768 - board.button.getyPos() - board.button.getHeight() && completedActions == true) {
					if (youPickedMissionCards) {
						System.out.println("YouPickedMissionCards");

						// Space for what should be send to the client
						activater = "state1";

						run();
						isYourTurn = false;

					}
					if (youPickedTrainCards) {
						System.out.println("YouPickedTrainCards");

						// Space for what should be send to the client
						activater = "state2";
						run();
						isYourTurn = false;
					}

					if (youPlayedAConnection) {
						System.out.println("youPlayedAConnection");
						
						//This is where we check if someone completed their mission, and they get the points
						for(int missions = 0; missions < player1.getHandOfMissions().size(); missions++){
							if(!player1.getHandOfMissions().get(missions).getPointsHaveBeenGiven() && player1.getHandOfMissions().get(missions).areConnected(player1)){
								board.playerPieces[0].move(player1.getHandOfMissions().get(missions).getPoints());
								player1.getHandOfMissions().get(missions).setPointsHaveBeenGiven(true);
							}
						}

						// Space for what should be send to the client
						activater = "state3";
						System.out.println(activater);
						run();
						isYourTurn = false;
					}

				}

			}
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
		board.stationaryCardT.setVisible();
		board.stationaryCardM.setVisible();

		// board.connections.get(2).setTakenByPlayer(player1, g);

		// images in the displayed train card stack
		// for (int i = 0; i < 5; i++) {
		// board.displayedTrainStack.get(i).setVisible1();
		// }

		// text in the displayed train card stack
		for (int j = 0; j < board.displayedTrainStack.size(); j++) {
			board.displayedTrainStack.get(j).setVisible1(g);
		}

		// Setting the visibility of the playerpieces
		for (int i = 0; i < board.playerPieces.length; i++) {
			board.playerPieces[i].setVisible(g);
		}

		// Drawing the string counters for the cards determined by color
		board.button.setVisible(g, 0);
		g.drawString("" + pinkColorCounter, 250, 750);
		g.drawString("" + whiteColorCounter, 322, 750);
		g.drawString("" + blueColorCounter, 394, 750);
		g.drawString("" + yellowColorCounter, 466, 750);
		g.drawString("" + orangeColorCounter, 538, 750);
		g.drawString("" + blackColorCounter, 610, 750);
		g.drawString("" + redColorCounter, 682, 750);
		g.drawString("" + greenColorCounter, 744, 750);

		// We have to loop through all the players and display their cards in
		// these areas.!
		if (board.player2TrainHandStack.size() != 0) {
			g.drawString("Player? tcards: " + board.player2TrainHandStack.size(), 20, 15);
		} else {
			g.drawString("Player? tcards: 0", 20, 15);
		}

		if (board.player2MissionHandStack.size() != 0) {
			g.drawString("Player? mcards: " + board.player2MissionHandStack.size(), 20, 30);
		} else {
			g.drawString("Player? mcards: 0", 20, 30);
		}

		if (/* Something with the trains */ 50 < 20) {
			// g.drawString("Player? trains: " + board.player2trains.size(), 20,
			// 45);
		} else {
			g.drawString("Player? tcards: 0", 20, 45);
		}
		
		g.setColor(new Color(0, 0, 0));
		g.drawString("Trains: " + player1.numOfTrains, 900, 720);

		board.button.setVisible(g, 0);

		if (completedActions)
			board.button.setVisible(g, 1);

		for (int j = 0; j < connectionsToDraw.size(); j++) {
			connectionsToDraw.get(j).drawConnection(player2, g);
			board.playerPieces[player1.playerNum].move(connectionsToDraw.get(j).getPoint());
		}

	}

	// +++++++++++++++++++++++++

	public static void main(String[] args) throws SlickException, UnknownHostException, IOException {

		board = new Board(4);

		// s = new Socket("172.20.10.2", 2222);
		s = new Socket("192.168.43.131", 2222);

		SimpleSlickGame client = new SimpleSlickGame("Ticket to Ride");

		Thread t1 = new Thread(client);
		t1.start();

		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(1024, 768, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);

		}

	}

	public void run() {

		try {
			PrintStream ps = new PrintStream(s.getOutputStream(), true);
			InputStreamReader ir = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(ir);
			Gson serializer = new Gson();

			if (activater != null) {
				if (activater != null) {
					if (activater.contains("state1")){
					ps.println(activater);

					System.out.println(board.arrayOfMissionCards.size());

					for (int j = 0; j < board.arrayOfMissionCards.size(); j++) {
						String temp = serializer.toJson(new MissionCard(
								new Town(board.arrayOfMissionCards.get(j).getTownA().getName(),
										board.arrayOfMissionCards.get(j).getTownA().getAmountOfConnections(),
										board.arrayOfMissionCards.get(j).getTownA().getxPos(),
										board.arrayOfMissionCards.get(j).getTownA().getyPos()),
								new Town(board.arrayOfMissionCards.get(j).getTownB().getName(),
										board.arrayOfMissionCards.get(j).getTownB().getAmountOfConnections(),
										board.arrayOfMissionCards.get(j).getTownB().getxPos(),
										board.arrayOfMissionCards.get(j).getTownB().getyPos()),
								board.arrayOfMissionCards.get(j).getPoints()));
						System.out.println(temp);
						ps.println(temp);

					}
					System.out.println(board.arrayOfMissionCards.size());
					
					
					for (int j =0; j<board.player1MissionHandStack.size(); j++)
					{
						String temp =serializer.toJson(board.player1MissionHandStack.get(j));
						ps.println(temp);
					}
					activater = null;
				}
					
					
					// IF STATE IS 2.
					else if (activater.contains("state2")){
						System.out.println(activater);
						System.out.println(board.arrayOfTrainCards.size());
						ps.println(activater);
						
						for (int j=0; j<board.arrayOfTrainCards.size(); j++)
						{
							String temp = serializer.toJson(board.arrayOfTrainCards.get(j));
							ps.println(temp);					
						}
						
						
						System.out.println(board.player1TrainHandStack.size());
						for (int j=0; j<board.player1TrainHandStack.size();j++)
						{
							String temp = serializer.toJson(board.player1TrainHandStack.get(j));
							ps.println(temp);
						}
						
						for (int j=0; j<5;j++)
						{
							String temp = serializer.toJson(board.displayedTrainStack.get(j));
							ps.println(temp);
						}
						activater = null;
					}
					else if (activater.contains("state3"))
					{
						ps.println(activater);
						// We need the trains
						
						// We need the trainCards
						for (int j=0; j<board.arrayOfTrainCards.size(); j++)
						{
							String temp = serializer.toJson(board.arrayOfTrainCards.get(j));
							ps.println(temp);					
						}
						ps.println("stop");
						// We need the traincardsstack
						for (int j=0; j<board.player1TrainHandStack.size();j++)
						{
							String temp = serializer.toJson(board.player1TrainHandStack.get(j));
							ps.println(temp);
						}
						ps.println("stop");
						// We need connections.isTaken(Player.)
						for (int j=0; j<board.connections.size();j++)
						{
							String temp = serializer.toJson(board.connections.get(j).getTakenByPlayer());
							ps.println(temp); 
						}
						
						
						
						activater = null;
						
					}
				}
			}
					// This is where we start sending the JSONS

			
			String whoAmI = br.readLine();
			while (true) {

				// This is what all clients should receive on gamestart
if (runThisOnce == true)
{
	
				if (whoAmI.contains("1")) {
					for (int i = 0; i < 4; i++) {
						String temp = br.readLine();
						Card c = new Gson().fromJson(temp, Card.class);
						board.player1TrainHandStack.add(c);
					}
					for (int i = 0; i < 2; i++) {
						String temp = br.readLine();
						MissionCard c = new Gson().fromJson(temp, MissionCard.class);
						board.player1MissionHandStack.add(c);
						System.out.println(board.player1MissionHandStack.get(i).getTownA().getName());
					}
						String temp1 = br.readLine();
						Players p1 = new Gson().fromJson(temp1, Players.class);
						
					
				} else if (whoAmI.contains("2")) {
					for (int i = 0; i < 4; i++) {
						String temp = br.readLine();
						Card c = new Gson().fromJson(temp, Card.class);
						board.player1TrainHandStack.add(c);
					}
					for (int i = 0; i < 2; i++) {
						String temp = br.readLine();
						MissionCard c = new Gson().fromJson(temp, MissionCard.class);
						board.player1MissionHandStack.add(c);
						System.out.println(board.player1MissionHandStack.get(i).getTownA().getName());
					}
					String temp2 = br.readLine();
					Players p2 = new Gson().fromJson(temp2, Players.class);
				} else if (whoAmI.contains("3")) {
					for (int i = 0; i < 4; i++) {
						String temp = br.readLine();
						Card c = new Gson().fromJson(temp, Card.class);
						board.player1TrainHandStack.add(c);

					}
					for (int i = 0; i < 2; i++) {
						String temp = br.readLine();
						MissionCard c = new Gson().fromJson(temp, MissionCard.class);
						board.player1MissionHandStack.add(c);
						System.out.println(board.player1MissionHandStack.get(i).getTownA().getName());
					}
					String temp3 = br.readLine();
					Players p3 = new Gson().fromJson(temp3, Players.class);
				} else if (whoAmI.contains("4")) {
					for (int i = 0; i < 4; i++) {
						String temp = br.readLine();
						Card c = new Gson().fromJson(temp, Card.class);
						board.player1TrainHandStack.add(c);
					}
					for (int i = 0; i < 2; i++) {
						String temp = br.readLine();
						MissionCard c = new Gson().fromJson(temp, MissionCard.class);
						board.player1MissionHandStack.add(c);
						System.out.println(board.player1MissionHandStack.get(i).getTownA().getName());
					}
					String temp4 = br.readLine();
					Players p4 = new Gson().fromJson(temp4, Players.class);
				}
				for (int i = 0; i < board.displayedTrainStack.size(); i++) {
					String temp = br.readLine();
					Card c = new Gson().fromJson(temp, Card.class);
					board.displayedTrainStack.remove(i);
					board.displayedTrainStack.add(i, c);

					System.out.println(board.displayedTrainStack.get(i).getColor().getColorName());
				}
				board.arrayOfTrainCards.clear();
				for (int i = 0; i < 75; i++) {
					String temp = br.readLine();
					Card c = new Gson().fromJson(temp, Card.class);
					board.arrayOfTrainCards.add(c);
				}
				System.out.println(board.arrayOfTrainCards.size());

				for (int i = 0; i < 8; i++) {
					board.arrayOfMissionCards.remove(0);
				}
				for (int i = 0; i < 22; i++) {
					String temp = br.readLine();
					MissionCard c = new Gson().fromJson(temp, MissionCard.class);
					board.arrayOfMissionCards.remove(i);
					board.arrayOfMissionCards.add(i, c);
				}
//runThisOnce=false;
}
				String Message = br.readLine();

				if (Message.contains("CanAct")) {
					isYourTurn = true;
					board.isYourTurnBoard = true;
				}

			}

		} catch (IOException | SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
