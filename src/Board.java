


import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Board {

	private Image boardPic;
	Town[] towns;
	EndButton button;
	
	PlayerPiece[] playerPieces;

	
	ArrayList<Connection> connections = new ArrayList<Connection>();
	
	CustomColor[] colors;
	Card summaryCard;
	Card[] missionCards;
	Card[] trainCards;
	Card stationaryCardT, stationaryCardM;

	// Create a stack for all the missions
	Stack missionCardStack;
	Stack trainCardStack;		// Create a stack for all the traincards

	ArrayList<Card> player1MissionHandStack, player2MissionHandStack, player3MissionHandStack, player4MissionHandStack;
	ArrayList<Card> player1TrainHandStack, player2TrainHandStack, player3TrainHandStack, player4TrainHandStack;					// Instantiate player hand stack array lists
	ArrayList<Card> arrayOfMissionCards, arrayOfTrainCards, displayedTrainStack;							// Instantiate train card stack, displayed train card stack and displayed mission card stack arraylists

	int blueColorCounter, redColorCounter, orangeColorCounter, whiteColorCounter, yellowColorCounter, blackColorCounter, greenColorCounter, pinkColorCounter;
	int handTrainCardIncrementer;
	
	Board(int numOfPlayers) throws SlickException {
		
		player1TrainHandStack = new ArrayList<Card>();			// Player hand stack
		player2TrainHandStack = new ArrayList<Card>();			// Player hand stack
		player3TrainHandStack = new ArrayList<Card>();			// Player hand stack
		player4TrainHandStack = new ArrayList<Card>();			// Player hand stack
		
		player1MissionHandStack = new ArrayList<Card>();			// Player hand stack
		player2MissionHandStack = new ArrayList<Card>();			// Player hand stack
		player3MissionHandStack = new ArrayList<Card>();			// Player hand stack
		player4MissionHandStack = new ArrayList<Card>();			// Player hand stack
		
		displayedTrainStack = new ArrayList<Card>();		// Displayed stack on the board
				
		// set the amount of towns, connections, colors and players
		towns = new Town[36];
		colors = new CustomColor[9];
		playerPieces = new PlayerPiece[numOfPlayers];

		// create the different types of cards
		summaryCard = new SummaryCard();
		
		// create stationary card for a stationary backImage on the mission and train stacks
		stationaryCardT = new StationaryCard();
		stationaryCardT.xPos = 1024 - stationaryCardT.width;
		stationaryCardT.yPos += stationaryCardT.height;
		
		stationaryCardM = new StationaryCard();
		stationaryCardM.xPos = 1024 - stationaryCardM.width;
		stationaryCardM.yPos = 1;
		
		missionCards = new MissionCard[30];
		//trainCards = new TrainCard[110];		with joker
		trainCards = new TrainCard[96];		// without jokers

		// create all the different colors for the trains/players
		colors[0] = new CustomColor("blue", 0, new Color(0,0,255));
		colors[1] = new CustomColor("red", 1, new Color(255,0,0));
		colors[2] = new CustomColor("orange", 2, new Color(255,127,0));
		colors[3] = new CustomColor("white", 3, new Color(255,255,255));
		colors[4] = new CustomColor("yellow", 4, new Color(255,255,0));
		colors[5] = new CustomColor("black", 5, new Color(0,0,0));
		colors[6] = new CustomColor("grey", 6, new Color(127,127,127));
		colors[7] = new CustomColor("green", 7, new Color(0,255,0));
		colors[8] = new CustomColor("pink", 8, new Color(255,127,127));
		//colors[9] = new Color("rainbow", 9);	no joker
		
		button = new EndButton();
		
	
		towns[0] = new Town("Vancouver", 3, 94, 591);
		
		towns[1] = new Town("Seattle", 6, 92, 542);
		towns[2] = new Town("Portland", 5, 74, 499);
		towns[3] = new Town("San Francisco", 6, 61, 325);
		towns[4] = new Town("Los Angeles", 5, 128, 233);
		towns[5] = new Town("Calgary", 4, 210, 605);
		towns[6] = new Town("Helena", 7, 297, 489);
		towns[7] = new Town("Salt Lake City", 7, 233, 382);
		towns[8] = new Town("Las Vegas", 2, 186, 286);
		towns[9] = new Town("Phoenix", 4, 235, 228);
		towns[10] = new Town("Winnipeg", 4, 407, 596);
		towns[11] = new Town("Denver", 9, 349, 354);
		towns[12] = new Town("Santa Fe", 4, 342, 274);
		towns[13] = new Town("El Paso", 6, 338, 196);
		towns[14] = new Town("Duluth", 7, 504, 495);
		towns[15] = new Town("Omaha", 7, 478, 415);
		towns[16] = new Town("Kansas City", 8, 497, 370);
		towns[17] = new Town("Oklahoma City", 8, 479, 293);
		towns[18] = new Town("Dallas", 6, 497, 217);
		towns[19] = new Town("Houston", 4, 532, 184);
		towns[20] = new Town("Sault St Marie", 4, 616, 553);
		towns[21] = new Town("Chicago", 7, 612, 441);
		towns[22] = new Town("Saint Louis", 7, 573, 370);
		towns[23] = new Town("Little Rock", 5, 557, 290);
		towns[24] = new Town("New Orleans", 5, 613, 192);
		towns[25] = new Town("Montreal", 5, 784, 611);
		towns[26] = new Town("Toronto", 5, 712, 534);
		towns[27] = new Town("Pittsburgh", 9, 726, 453);
		towns[28] = new Town("Nashville", 5, 654, 335);
		towns[29] = new Town("Atlanta", 7, 695, 304);
		towns[30] = new Town("Boston", 4, 845, 559);
		towns[31] = new Town("New York", 7, 800, 493);
		towns[32] = new Town("Washington", 5, 807, 414);
		towns[33] = new Town("Raleigh", 7, 756, 355);
		towns[34] = new Town("Charleston", 3, 781, 298);
		towns[35] = new Town("Miami", 3, 809, 159);

		// creating all the connections
		//connections[0] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections.add(new Connection(colors[6], towns[0], towns[1], 1, 1));
		
		//connections[1] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections.add(new Connection(colors[6], towns[0], towns[1], 1, 1));
		
		//connections[2] = new Connection(colors[6], towns[1], towns[2], 1, 1);
		connections.add(new Connection(colors[6], towns[1], towns[2], 1, 1));
		
		//connections[3] = new Connection(colors[6], towns[1], towns[2], 1, 1);
		connections.add(new Connection(colors[6], towns[1], towns[2], 1, 1));
		
		//connections[4] = new Connection(colors[7], towns[2], towns[3], 5, 10);
		connections.add(new Connection(colors[7], towns[2], towns[3], 5, 10));
		
		//connections[5] = new Connection(colors[8], towns[2], towns[3], 5, 10);
		connections.add(new Connection(colors[8], towns[2], towns[3], 5, 10));
		
		//connections[6] = new Connection(colors[4], towns[3], towns[4], 3, 4);
		connections.add(new Connection(colors[4], towns[3], towns[4], 3, 4));
		
		//connections[7] = new Connection(colors[8], towns[3], towns[4], 3, 4);
		connections.add(new Connection(colors[8], towns[3], towns[4], 3, 4));
		
		//connections[8] = new Connection(colors[6], towns[0], towns[5], 3, 4);
		connections.add(new Connection(colors[6], towns[0], towns[5], 3, 4));
		
		//connections[9] = new Connection(colors[6], towns[1], towns[5], 4, 7);
		connections.add(new Connection(colors[6], towns[1], towns[5], 4, 7));
		
		//connections[10] = new Connection(colors[4], towns[1], towns[6], 6, 13);
		connections.add(new Connection(colors[4], towns[1], towns[6], 6, 15));
		
		//connections[11] = new Connection(colors[0], towns[2], towns[7], 6, 13);
		connections.add(new Connection(colors[0], towns[2], towns[7], 6, 15));
		
		//connections[12] = new Connection(colors[2], towns[3], towns[7], 5, 10);
		connections.add(new Connection(colors[2], towns[3], towns[7], 5, 10));
		
		//connections[13] = new Connection(colors[3], towns[3], towns[7], 5, 10);
		connections.add(new Connection(colors[3], towns[3], towns[7], 5, 10));
		
		//connections[14] = new Connection(colors[6], towns[4], towns[8], 2, 2);
		connections.add(new Connection(colors[6], towns[4], towns[8], 2, 2));
		
		//connections[15] = new Connection(colors[6], towns[4], towns[9], 3, 4);
		connections.add(new Connection(colors[6], towns[4], towns[9], 3, 4));
		
		//connections[16] = new Connection(colors[5], towns[4], towns[13], 6, 13);
		connections.add(new Connection(colors[5], towns[4], towns[13], 6, 15));
		
		//connections[17] = new Connection(colors[3], towns[5], towns[10], 6, 13);
		connections.add(new Connection(colors[3], towns[5], towns[10], 6, 15));
		
		//connections[18] = new Connection(colors[6], towns[5], towns[6], 4, 7);
		connections.add(new Connection(colors[6], towns[5], towns[6], 4, 7));
		
		//connections[19] = new Connection(colors[8], towns[6], towns[7], 3, 4);
		connections.add(new Connection(colors[8], towns[6], towns[7], 3, 4));
		
		//connections[20] = new Connection(colors[1], towns[7], towns[11], 3, 4);
		connections.add(new Connection(colors[1], towns[7], towns[11], 3, 4));
		
		//connections[21] = new Connection(colors[4], towns[7], towns[11], 3, 4);
		connections.add(new Connection(colors[4], towns[7], towns[11], 3, 4));
		
		//connections[22] = new Connection(colors[3], towns[9], towns[11], 5, 10);
		connections.add(new Connection(colors[3], towns[9], towns[11], 5, 10));
		
		//connections[23] = new Connection(colors[6], towns[9], towns[12], 3, 4);
		connections.add(new Connection(colors[6], towns[9], towns[12], 3, 4));
		
		//connections[24] = new Connection(colors[6], towns[9], towns[13], 3, 4);
		connections.add(new Connection(colors[6], towns[9], towns[13], 3, 4));
		
		//connections[25] = new Connection(colors[0], towns[6], towns[10], 4, 7);
		connections.add(new Connection(colors[0], towns[6], towns[10], 4, 7));
		
		//connections[26] = new Connection(colors[2], towns[6], towns[14], 6, 13);
		connections.add(new Connection(colors[2], towns[6], towns[14], 6, 15));
		
		//connections[27] = new Connection(colors[1], towns[6], towns[15], 5, 10);
		connections.add(new Connection(colors[1], towns[6], towns[15], 5, 10));
		
		//connections[28] = new Connection(colors[7], towns[6], towns[11], 4, 7);
		connections.add(new Connection(colors[7], towns[6], towns[11], 4, 7));
		
		//connections[29] = new Connection(colors[8], towns[11], towns[15], 4, 7);
		connections.add(new Connection(colors[8], towns[11], towns[15], 4, 7));
		
		//connections[30] = new Connection(colors[5], towns[11], towns[16], 4, 7);
		connections.add(new Connection(colors[5], towns[11], towns[16], 4, 7));
		
		//connections[31] = new Connection(colors[2], towns[11], towns[16], 4, 7);
		connections.add(new Connection(colors[2], towns[11], towns[16], 4, 7));
		
		//connections[32] = new Connection(colors[1], towns[11], towns[7], 4, 7);
		connections.add(new Connection(colors[1], towns[11], towns[17], 4, 7));
		
		//connections[33] = new Connection(colors[6], towns[11], towns[12], 2, 2);
		connections.add(new Connection(colors[6], towns[11], towns[12], 2, 2));
		
		//connections[34] = new Connection(colors[0], towns[12], towns[17], 3, 4);
		connections.add(new Connection(colors[0], towns[12], towns[17], 3, 4));
		
		//connections[35] = new Connection(colors[6], towns[12], towns[13], 2, 2);
		connections.add(new Connection(colors[6], towns[12], towns[13], 2, 2));
		
		//connections[36] = new Connection(colors[4], towns[13], towns[17], 5, 10);
		connections.add(new Connection(colors[4], towns[13], towns[17], 5, 10));
		
		//connections[37] = new Connection(colors[1], towns[13], towns[18], 4, 7);
		connections.add(new Connection(colors[1], towns[13], towns[18], 4, 7));
		
		//connections[38] = new Connection(colors[7], towns[13], towns[19], 6, 13);
		connections.add(new Connection(colors[7], towns[13], towns[19], 6, 15));
		
		//connections[39] = new Connection(colors[6], towns[10], towns[20], 6, 13);
		connections.add(new Connection(colors[6], towns[10], towns[20], 6, 15));
		
		//connections[40] = new Connection(colors[5], towns[10], towns[14], 4, 7);
		connections.add(new Connection(colors[5], towns[10], towns[14], 4, 7));
		
		//connections[41] = new Connection(colors[6], towns[14], towns[20], 3, 4);
		connections.add(new Connection(colors[6], towns[14], towns[20], 3, 4));
		
		//connections[42] = new Connection(colors[8], towns[14], towns[26], 6, 13);
		connections.add(new Connection(colors[8], towns[14], towns[26], 6, 15));
		
		//connections[43] = new Connection(colors[1], towns[14], towns[21], 3, 4);
		connections.add(new Connection(colors[1], towns[14], towns[21], 3, 4));
		
		//connections[44] = new Connection(colors[6], towns[14], towns[15], 2, 2);
		connections.add(new Connection(colors[6], towns[14], towns[15], 2, 2));
		
		//connections[45] = new Connection(colors[6], towns[14], towns[15], 2, 2);
		connections.add(new Connection(colors[6], towns[14], towns[15], 2, 2));
		
		//connections[46] = new Connection(colors[0], towns[15], towns[21], 4, 7);
		connections.add(new Connection(colors[0], towns[15], towns[21], 4, 7));
		
		//connections[47] = new Connection(colors[6], towns[15], towns[16], 1, 1);
		connections.add(new Connection(colors[6], towns[15], towns[16], 1, 1));
		
		//connections[48] = new Connection(colors[6], towns[15], towns[16], 1, 1);
		connections.add(new Connection(colors[6], towns[15], towns[16], 1, 1));
		
		//connections[49] = new Connection(colors[0], towns[16], towns[22], 2, 2);
		connections.add(new Connection(colors[0], towns[16], towns[22], 2, 2));
		
		//connections[50] = new Connection(colors[8], towns[16], towns[22], 2, 2);
		connections.add(new Connection(colors[8], towns[16], towns[22], 2, 2));
		
		//connections[51] = new Connection(colors[6], towns[16], towns[17], 2, 2);
		connections.add(new Connection(colors[6], towns[16], towns[17], 2, 2));

		//connections[52] = new Connection(colors[6], towns[16], towns[17], 2, 2);
		connections.add(new Connection(colors[6], towns[16], towns[17], 2, 2));
		
		//connections[53] = new Connection(colors[6], towns[17], towns[23], 2, 2);
		connections.add(new Connection(colors[6], towns[17], towns[23], 2, 2));
		
		//connections[54] = new Connection(colors[6], towns[17], towns[18], 2, 2);
		connections.add(new Connection(colors[6], towns[17], towns[18], 2, 2));
		
		//connections[55] = new Connection(colors[6], towns[17], towns[18], 2, 2);
		connections.add(new Connection(colors[6], towns[17], towns[18], 2, 2));
		
		//connections[56] = new Connection(colors[0], towns[15], towns[21], 4, 7);
		connections.add(new Connection(colors[6], towns[18], towns[23], 2, 2));
		
		//connections[57] = new Connection(colors[6], towns[18], towns[19], 1, 1);
		connections.add(new Connection(colors[6], towns[18], towns[19], 1, 1));
		
		//connections[58] = new Connection(colors[6], towns[18], towns[19], 1, 1);
		connections.add(new Connection(colors[6], towns[18], towns[19], 1, 1));
		
		//connections[59] = new Connection(colors[6], towns[18], towns[24], 2, 2);
		connections.add(new Connection(colors[6], towns[19], towns[24], 2, 2));

		//connections[60] = new Connection(colors[5], towns[20], towns[25], 5, 10);
		connections.add(new Connection(colors[5], towns[20], towns[25], 5, 10));
		
		//connections[61] = new Connection(colors[6], towns[20], towns[26], 2, 2);
		connections.add(new Connection(colors[6], towns[20], towns[26], 2, 2));
		
		//connections[62] = new Connection(colors[6], towns[26], towns[25], 3, 4);
		connections.add(new Connection(colors[6], towns[26], towns[25], 3, 4));
		
		//connections[63] = new Connection(colors[3], towns[21], towns[26], 4, 7);
		connections.add(new Connection(colors[3], towns[21], towns[26], 4, 7));
		
		//connections[64] = new Connection(colors[2], towns[21], towns[27], 3, 4);
		connections.add(new Connection(colors[2], towns[21], towns[27], 3, 4));
		
		//connections[65] = new Connection(colors[5], towns[21], towns[27], 3, 4);
		connections.add(new Connection(colors[5], towns[21], towns[27], 3, 4));
		
		//connections[66] = new Connection(colors[7], towns[21], towns[22], 2, 2);
		connections.add(new Connection(colors[7], towns[21], towns[22], 2, 2));
		
		//connections[67] = new Connection(colors[3], towns[21], towns[22], 2, 2);
		connections.add(new Connection(colors[3], towns[21], towns[22], 2, 2));
		
		//connections[68] = new Connection(colors[7], towns[22], towns[27], 5, 10);
		connections.add(new Connection(colors[7], towns[22], towns[27], 5, 10));
		
		//connections[69] = new Connection(colors[6], towns[22], towns[28], 2, 2);
		connections.add(new Connection(colors[6], towns[22], towns[28], 2, 2));
		
		//connections[70] = new Connection(colors[6], towns[22], towns[23], 2, 2);
		connections.add(new Connection(colors[6], towns[22], towns[23], 2, 2));
		
		//connections[71] = new Connection(colors[3], towns[23], towns[28], 3, 4);
		connections.add(new Connection(colors[3], towns[23], towns[28], 3, 4));
		
		//connections[72] = new Connection(colors[7], towns[23], towns[24], 3, 4);
		connections.add(new Connection(colors[7], towns[23], towns[24], 3, 4));
		
		//connections[73] = new Connection(colors[4], towns[24], towns[29], 4, 7);
		connections.add(new Connection(colors[4], towns[24], towns[29], 4, 7));
		
		//connections[74] = new Connection(colors[2], towns[24], towns[29], 4, 7);
		connections.add(new Connection(colors[2], towns[24], towns[29], 4, 7));
		
		//connections[75] = new Connection(colors[1], towns[24], towns[35], 6, 13);
		connections.add(new Connection(colors[1], towns[24], towns[35], 6, 15));
		
		//connections[76] = new Connection(colors[6], towns[26], towns[27], 2, 2);
		connections.add(new Connection(colors[6], towns[26], towns[27], 2, 2));
		
		//connections[77] = new Connection(colors[3], towns[27], towns[31], 2, 2);
		connections.add(new Connection(colors[3], towns[27], towns[31], 2, 2));
		
		//connections[78] = new Connection(colors[7], towns[27], towns[31], 2, 2);
		connections.add(new Connection(colors[7], towns[27], towns[31], 2, 2));
		
		//connections[79] = new Connection(colors[6], towns[27], towns[32], 2, 2);
		connections.add(new Connection(colors[6], towns[27], towns[32], 2, 2));

		//connections[80] = new Connection(colors[6], towns[27], towns[33], 2, 2);
		connections.add(new Connection(colors[6], towns[27], towns[33], 2, 2));
		
		//connections[81] = new Connection(colors[4], towns[27], towns[28], 4, 7);
		connections.add(new Connection(colors[4], towns[27], towns[28], 4, 7));
		
		//connections[82] = new Connection(colors[5], towns[28], towns[33], 3, 4);
		connections.add(new Connection(colors[5], towns[28], towns[33], 3, 4));
		
		//connections[83] = new Connection(colors[6], towns[28], towns[29], 1, 1);
		connections.add(new Connection(colors[6], towns[28], towns[29], 1, 1));
		
		//connections[84] = new Connection(colors[6], towns[29], towns[33], 2, 2);
		connections.add(new Connection(colors[6], towns[29], towns[33], 2, 2));
		
		//connections[85] = new Connection(colors[6], towns[29], towns[33], 2, 2);
		connections.add(new Connection(colors[6], towns[29], towns[33], 2, 2));
		
		//connections[86] = new Connection(colors[6], towns[29], towns[34], 2, 2);
		connections.add(new Connection(colors[6], towns[29], towns[34], 2, 2));
		
		//connections[87] = new Connection(colors[0], towns[29], towns[35], 5, 10);
		connections.add(new Connection(colors[0], towns[29], towns[35], 5, 10));
		
		//connections[88] = new Connection(colors[6], towns[25], towns[30], 2, 2);
		connections.add(new Connection(colors[6], towns[25], towns[30], 2, 2));
		
		//connections[89] = new Connection(colors[6], towns[25], towns[30], 2, 2);
		connections.add(new Connection(colors[6], towns[25], towns[30], 2, 2));
		
		//connections[90] = new Connection(colors[1], towns[25], towns[31], 3, 4);
		connections.add(new Connection(colors[1], towns[25], towns[31], 3, 4));
		
		//connections[91] = new Connection(colors[4], towns[30], towns[31], 2, 2);
		connections.add(new Connection(colors[4], towns[30], towns[31], 2, 2));
		
		//connections[92] = new Connection(colors[1], towns[30], towns[31], 2, 2);
		connections.add(new Connection(colors[1], towns[30], towns[31], 2, 2));

		//connections[93] = new Connection(colors[2], towns[31], towns[32], 2, 2);
		connections.add(new Connection(colors[2], towns[31], towns[32], 2, 2));
		
		//connections[94] = new Connection(colors[5], towns[31], towns[32], 2, 2);
		connections.add(new Connection(colors[5], towns[31], towns[32], 2, 2));
		
		//connections[95] = new Connection(colors[6], towns[32], towns[33], 2, 2);
		connections.add(new Connection(colors[6], towns[32], towns[33], 2, 2));

		//connections[96] = new Connection(colors[6], towns[32], towns[33], 2, 2);
		connections.add(new Connection(colors[6], towns[32], towns[33], 2, 2));

		//connections[97] = new Connection(colors[6], towns[33], towns[34], 2, 2);
		connections.add(new Connection(colors[6], towns[33], towns[34], 2, 2));
		
		//connections[98] = new Connection(colors[8], towns[34], towns[35], 4, 7);
		connections.add(new Connection(colors[8], towns[34], towns[35], 4, 7));
		
		//connections[99] = new Connection(colors[2], towns[7], towns[8], 3, 4);
		connections.add(new Connection(colors[2], towns[7], towns[8], 3, 4));
		
		//This one did not exist when I tested, not sure what happened here
		//connections.add(new Connection(colors[6], towns[18], towns[23], 2, 2));
		

		// creating all the mission cards
		missionCards[0] = new MissionCard(towns[11], towns[13], 4);
		missionCards[1] = new MissionCard(towns[16], towns[19], 5);
		missionCards[2] = new MissionCard(towns[31], towns[29], 6);
		missionCards[3] = new MissionCard(towns[5], towns[7], 7);
		missionCards[4] = new MissionCard(towns[21], towns[24], 7);
		missionCards[5] = new MissionCard(towns[6], towns[4], 8);
		missionCards[6] = new MissionCard(towns[20], towns[28], 8);
		missionCards[7] = new MissionCard(towns[14], towns[19], 8);
		missionCards[8] = new MissionCard(towns[25], towns[29], 9);
		missionCards[9] = new MissionCard(towns[1], towns[4], 9);
		missionCards[10] = new MissionCard(towns[21], towns[12], 9);
		missionCards[11] = new MissionCard(towns[20], towns[17], 9);
		missionCards[12] = new MissionCard(towns[26], towns[35], 10);
		missionCards[13] = new MissionCard(towns[14], towns[13], 10);
		missionCards[14] = new MissionCard(towns[10], towns[23], 11);
		missionCards[15] = new MissionCard(towns[18], towns[31], 11);
		missionCards[16] = new MissionCard(towns[2], towns[9], 11);
		missionCards[17] = new MissionCard(towns[11], towns[27], 11);
		missionCards[18] = new MissionCard(towns[30], towns[35], 12);
		missionCards[19] = new MissionCard(towns[10], towns[19], 12);
		missionCards[20] = new MissionCard(towns[0], towns[12], 13);
		missionCards[21] = new MissionCard(towns[25], towns[24], 13);
		missionCards[22] = new MissionCard(towns[5], towns[9], 13);
		missionCards[23] = new MissionCard(towns[4], towns[21], 16);
		missionCards[24] = new MissionCard(towns[2], towns[28], 17);
		missionCards[25] = new MissionCard(towns[3], towns[29], 17);
		missionCards[26] = new MissionCard(towns[0], towns[25], 20);
		missionCards[27] = new MissionCard(towns[4], towns[35], 20);
		missionCards[28] = new MissionCard(towns[4], towns[31], 21);
		missionCards[29] = new MissionCard(towns[1], towns[31], 22);

		// adding all the mission cards in a new stack called missioncardstack
		missionCardStack = new Stack(missionCards, 1);

		// Shuffle mission cards in the missioncard stack
		//missionCardStack.shuffle(missionCards);
		// Set the mouse input conditions for the collision of the missioncard stack
		missionCardStack.xPos = 1024 - missionCardStack.width;
		missionCardStack.yPos += missionCardStack.height;
		
		/*
		 * Shuffle cards
		 * Copy the shuffled cards to the array list arrayOfMissionCards	
		 */
		missionCardStack.shuffleB(missionCards, 1000);
		arrayOfMissionCards = missionCardStack.getdeckOfB();		
		System.out.println("Amount of face-down cards in the mission stack on the board: " + arrayOfMissionCards.size());
		
		/*
		 * Tasks, which should happen in 1 for loop: 
		 * copy card from arrayOfMissionCards to player1MissionHandStack
		 * the copied card in arrayOfMissionCards should be removed
		 */
		
		int handMissionCardIncrementer = 2;

		for(int i = 0; i < 3; i ++) {
			player1MissionHandStack.add(arrayOfMissionCards.get(0));
			player1MissionHandStack.get(i).yPos = 682;
			player1MissionHandStack.get(i).xPos = 643 + (i * 127);
			arrayOfMissionCards.remove(0);
		}
		
		// creating all the trainCards
		for (int i = 0; i < trainCards.length; i++) {
			if (i < 12)
				trainCards[i] = new TrainCard(colors[0]); // Blue
			else if (i >= 12 && i < 24)
				trainCards[i] = new TrainCard(colors[1]); // Red
			else if (i >= 24 && i < 36)
				trainCards[i] = new TrainCard(colors[2]); // Orange
			else if (i >= 36 && i < 48)
				trainCards[i] = new TrainCard(colors[3]); // White
			else if (i >= 48 && i < 60)
				trainCards[i] = new TrainCard(colors[4]); // Yellow
			else if (i >= 60 && i < 72)
				trainCards[i] = new TrainCard(colors[5]); // Black
			else if (i >= 72 && i < 84)
				trainCards[i] = new TrainCard(colors[7]); // Green
			else if (i >= 84 && i < 96)
				trainCards[i] = new TrainCard(colors[8]); // Pink
//			else if (i >= 96 && i < 110)
//				trainCards[i] = new TrainCard(colors[9]); // Rainbow // with jokers
		}
		// adding all the mission cards in a new stack called traincardstack
		trainCardStack = new Stack(trainCards);
		
		// x position values for the trainCards
		for (int i = 0; i < trainCards.length; i++) {
			trainCards[i].xPos = 1024 - trainCardStack.width;
		}
				
		// Set the mouse input conditions for the borders of the traincard stack
		trainCardStack.xPos = 1024 - trainCardStack.width;
		trainCardStack.yPos += trainCardStack.height;
		
		/*
		 * Shuffle cards
		 * Copy the shuffled cards to the array list arrayOfTrainCards	
		 */ 
		trainCardStack.shuffleA(1000);
		arrayOfTrainCards = trainCardStack.getdeckOfA();		
		System.out.println("Amount of face-down cards in the train stack on the board: " + arrayOfTrainCards.size());
		
		/*
		 * Tasks, which should happen in 1 for loop: 
		 * copy card from arrayOfTrainCards to displayedTrainStack
		 * the copied card in arrayOfTrainCards should be removed
		 */
		int displayedTrainCardIncrementer = 2;

		for (int i = 0; i < 5; i++) {
			displayedTrainStack.add(arrayOfTrainCards.get(0)); // card#deckOfA --> card#playerHandStack
			displayedTrainStack.get(i).yPos = 85 * displayedTrainCardIncrementer;
			arrayOfTrainCards.remove(0); // card#deckOfA --> remove
			displayedTrainCardIncrementer++;
		}
		System.out.println("Amount of face-up cards in the train stack on the board: " + displayedTrainStack.size() + "		");			// print the cards in the players hand stack
		
		/*
		 * Tasks, which should happen in 1 for loop: 
		 * copy card from arrayOfTrainCards to player1HandStack
		 * the copied card in arrayOfTrainCards should be removed
		 */
		handTrainCardIncrementer = 73;
		
		for(int i = 0; i < 4; i ++) {
			player1TrainHandStack.add(arrayOfTrainCards.get(0));
			
			// position values for a drawn blue card
			if(player1TrainHandStack.get(i).color == colors[0]) {
			player1TrainHandStack.get(i).yPos = 682;
			player1TrainHandStack.get(i).xPos = 0;
			blueColorCounter++;
			
			// position values for a drawn red card
			} else if(player1TrainHandStack.get(i).color == colors[1]) {
				player1TrainHandStack.get(i).yPos = 682;
				player1TrainHandStack.get(i).xPos = handTrainCardIncrementer;
				redColorCounter++;
				
			// position values for a drawn orange card
			} else if(player1TrainHandStack.get(i).color == colors[2]) {
				player1TrainHandStack.get(i).yPos = 682;
				player1TrainHandStack.get(i).xPos = handTrainCardIncrementer * 2;
				orangeColorCounter++;
				
			// position values for a drawn white card
			} else if(player1TrainHandStack.get(i).color == colors[3]) {
				player1TrainHandStack.get(i).yPos = 682;
				player1TrainHandStack.get(i).xPos = handTrainCardIncrementer * 3;
				whiteColorCounter++;
				
			// position values for a drawn yellow card
			} else if(player1TrainHandStack.get(i).color == colors[4]) {
				player1TrainHandStack.get(i).yPos = 682;
				player1TrainHandStack.get(i).xPos = handTrainCardIncrementer * 4;
				yellowColorCounter++;
				
			// position values for a drawn black card
			} else if(player1TrainHandStack.get(i).color == colors[5]) {
				player1TrainHandStack.get(i).yPos = 682;
				player1TrainHandStack.get(i).xPos = handTrainCardIncrementer * 5;
				blackColorCounter++;
				
			// position values for a drawn green card. NOTE! colors[6] is not used for the cards, only for the connections
			} else if(player1TrainHandStack.get(i).color == colors[7]) {
				player1TrainHandStack.get(i).yPos = 682;
				player1TrainHandStack.get(i).xPos = handTrainCardIncrementer * 6;
				greenColorCounter++;
				
			// position values for a drawn pink card
			} else if(player1TrainHandStack.get(i).color == colors[8]) {
				player1TrainHandStack.get(i).yPos = 682;
				player1TrainHandStack.get(i).xPos = handTrainCardIncrementer * 7;
				pinkColorCounter++;
			}
			arrayOfTrainCards.remove(0); // card#deckOfA --> remove
		}		

		System.out.println("Amount of cards in player 1 hand stack: " + player1TrainHandStack.size() + "		");			// print the cards in the players hand stack
		System.out.println("Blue cards: " + blueColorCounter + ", Red cards: " + redColorCounter + ", Orange cards: " + orangeColorCounter + ", White cards: " + whiteColorCounter + ", Yellow cards: " + yellowColorCounter + ", Black cards: " + blackColorCounter + ", Green cards: " + greenColorCounter + ", Pink cards: " + pinkColorCounter);
		
		System.out.println("Amount of face-down cards in the train stack on the board: " + arrayOfTrainCards.size());
		System.out.println(" "); // for spacing
		
		//PlayerPiece instantiation.
		for (int i=0; i<playerPieces.length;i++)
		{
			playerPieces[i]= new PlayerPiece(null, i+1);
		}
		
	}

	public Image getBoardPic() {
		return boardPic;
	}

	public void setBoardPic(Image boardPic) throws SlickException {
		this.boardPic = new Image("/pics/Map.jpg");
	}
}

