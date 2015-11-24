package example;

import java.awt.image.BufferedImage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Board {
	
	private Image boardPic;
	Town [] towns;
	PlayerPiece [] players;
	Connection [] connections;
	Color [] colors;
	Card  summaryCard;
	Card[] missionCards;
	Card[] trainCards;
	
	Board(int numOfPlayers) throws SlickException  {
		
		towns = new Town [36];
		connections = new Connection[99];
		colors = new Color[10];
		players = new PlayerPiece[numOfPlayers];

		
		summaryCard = new SummaryCard();
		missionCards = new MissionCard[30];
		trainCards = new TrainCard[110];
		
		
		
		
		colors[0] = new Color("blue", 0);
		colors[1] = new Color("red", 1);
		colors[2] = new Color("orange", 2);
		colors[3] = new Color("white", 3);
		colors[4] = new Color("yellow", 4);
		colors[5] = new Color("black", 5);
		colors[6] = new Color("grey", 6);
		colors[7] = new Color("green", 7);
		colors[8] = new Color("pink", 8);
		colors[9] = new Color("rainbow", 9);
		
		towns[0] = new Town("Vancouver", 3, 94, 591, connections[0],connections[1], connections[8]);
		towns[1] = new Town("Seattle", 6, 92,542, connections[0], connections[1], connections[2], connections[3], connections[9], connections[10] );
		towns[2] = new Town("Portland", 5, 74,499,connections[2], connections[3], connections[4], connections[5], connections[11] );
		towns[3] = new Town("San Francisco", 6,61,325,connections[4], connections[5], connections[6], connections[7], connections[12], connections[13]);
		towns[4] = new Town("Los Angeles",5,128,233,connections[6], connections[7], connections[14], connections[15], connections[16]);
		towns[5] = new Town("Calgary",4, 210, 605, connections[8], connections[9], connections[17], connections[18]);
		towns[6] = new Town("Helena",7,297,489,connections[10], connections[18], connections[19], connections[25], connections[26],connections[27], connections[28]);
		towns[7] = new Town("Salt Lake City", 7,233,382, connections[11], connections[12], connections[13], connections[20], connections[21], connections[22], connections[19]);
		towns[8] = new Town("Las Vegas", 2, 1, 286,  connections[15], connections[22]);
		towns[9] = new Town("Phoenix", 4,235,228,  connections[15], connections[22], connections[23], connections[24]);
		towns[10] = new Town("Winnipeg",4, 407,596,  connections[17], connections[25], connections[39], connections[40]);
		towns[11] = new Town("Denver", 9,349,354,  connections[20], connections[21], connections[22], connections[33], connections[32], connections[31], connections[30], connections[29], connections[28]);
		towns[12] = new Town("Santa Fe", 4, 342, 274,  connections[33], connections[34], connections[23], connections[33]);
		towns[13] = new Town("El Paso", 6, 338, 196,  connections[16], connections[24], connections[35], connections[36], connections[37], connections[38]);
		towns[14] = new Town("Duluth", 7, 504, 495,  connections[26], connections[40], connections[41], connections[42], connections[43], connections[44], connections[45]);
		towns[15] = new Town("Omaha",7, 478, 415,  connections[27], connections[29], connections[44], connections[45], connections[46], connections[47], connections[48]);
		towns[16] = new Town("Kansas City",8, 497,370,  connections[30], connections[31], connections[47], connections[49], connections[50], connections[51], connections[52], connections[48]);
		towns[17] = new Town("Oklahoma City", 8, 479, 293,  connections[32], connections[34], connections[36], connections[51], connections[52], connections[53], connections[54], connections[55]);
		towns[18] = new Town("Dallas", 6, 497, 217,  connections[37], connections[54], connections[55], connections[56], connections[57], connections[58]);
		towns[19] = new Town("Houston", 4, 532, 184,  connections[38], connections[57], connections[58], connections[59]);
		towns[20] = new Town("Sault St Marie", 4, 616, 553,  connections[39], connections[41], connections[60], connections[61]);
		towns[21] = new Town("Chicago",7 ,612 ,441,  connections[43], connections[46], connections[63], connections[64], connections[65], connections[66], connections[67]);
		towns[22] = new Town("Saint Louis", 7, 573, 386,  connections[49], connections[50], connections[66], connections[67], connections[68], connections[69], connections[70]);
		towns[23] = new Town("Little Rock", 5, 557, 290,  connections[53], connections[56], connections[70], connections[71], connections[72]);
		towns[24] = new Town("New Orleans", 5, 613, 192,  connections[59], connections[72], connections[73], connections[74], connections[75]);
		towns[25] = new Town("Montreal", 5, 784, 611,  connections[60], connections[62], connections[88], connections[89], connections[90]);
		towns[26] = new Town("Toronto", 5, 712,534,  connections[42], connections[61], connections[62], connections[3], connections[76]);
		towns[27] = new Town("Pittsburgh",9,726,453, connections[64], connections[65], connections[68], connections[81], connections[77], connections[78], connections[79], connections[80], connections[81]);
		towns[28] = new Town("Nashville", 5, 654,335, connections[71], connections[69], connections[81], connections[82], connections[83]);
		towns[29] = new Town("Atlanta", 7, 669,304,  connections[73], connections[74], connections[83], connections[84], connections[85], connections[86], connections[87]);
		towns[30] = new Town("Boston", 4, 845,559,  connections[88], connections[89], connections[91], connections[92]);
		towns[31] = new Town("New York", 7,800,493, connections[90], connections[91], connections[92], connections[77], connections[78], connections[93], connections[94]);
		towns[32] = new Town("Washington", 5, 807, 414,  connections[93], connections[94], connections[79], connections[95], connections[96]);
		towns[33] = new Town("Raleigh", 7, 756, 355,  connections[95], connections[96], connections[97], connections[80], connections[82], connections[84], connections[85]);
		towns[34] = new Town("Charleston", 3, 781, 298,  connections[86], connections[97], connections[98]);
		towns[35] = new Town("Miami", 3, 809, 159,  connections[75], connections[78], connections[87]);
		
		connections[0] = new Connection(colors[6], towns[0], towns[1], 1, 1);			connections[10] = new Connection(colors[4], towns[1], towns[6], 6, 13);	
		connections[1] = new Connection(colors[6], towns[0], towns[1], 1, 1);			connections[11] = new Connection(colors[0], towns[2], towns[7], 6, 13);	
		connections[2] = new Connection(colors[6], towns[1], towns[2], 1, 1);			connections[12] = new Connection(colors[2], towns[3], towns[7], 5, 10);	
		connections[3] = new Connection(colors[6], towns[1], towns[2], 1, 1);			connections[13] = new Connection(colors[3], towns[3], towns[7], 5, 10);	
		connections[4] = new Connection(colors[7], towns[2], towns[3], 5, 10);			connections[14] = new Connection(colors[6], towns[3], towns[8], 2, 2);	
		connections[5] = new Connection(colors[8], towns[2], towns[3], 5, 10);			connections[15] = new Connection(colors[6], towns[4], towns[9], 3, 4);	
		connections[6] = new Connection(colors[4], towns[3], towns[4], 3, 4);			connections[16] = new Connection(colors[5], towns[4], towns[13], 6, 13);	
		connections[7] = new Connection(colors[8], towns[3], towns[4], 3, 4);			connections[17] = new Connection(colors[3], towns[5], towns[10], 6, 13);	
		connections[8] = new Connection(colors[6], towns[0], towns[5], 3, 4);			connections[18] = new Connection(colors[6], towns[5], towns[6], 4, 7);	
		connections[9] = new Connection(colors[6], towns[1], towns[5], 4, 7);			connections[19] = new Connection(colors[8], towns[6], towns[7], 3, 4);
		
		connections[20] = new Connection(colors[1], towns[7], towns[11], 3, 4);			connections[30] = new Connection(colors[5], towns[11], towns[16], 4, 7);	
		connections[21] = new Connection(colors[4], towns[7], towns[11], 3, 4);			connections[31] = new Connection(colors[2], towns[11], towns[16], 4, 7);	
		connections[22] = new Connection(colors[3], towns[9], towns[11], 5, 10);		connections[32] = new Connection(colors[1], towns[11], towns[7], 4, 7);	
		connections[23] = new Connection(colors[6], towns[9], towns[12], 3, 4);			connections[33] = new Connection(colors[6], towns[11], towns[12], 2, 2);	
		connections[24] = new Connection(colors[6], towns[9], towns[13], 3, 4);			connections[34] = new Connection(colors[0], towns[12], towns[17], 3, 4);	
		connections[25] = new Connection(colors[0], towns[6], towns[10], 4, 7);			connections[35] = new Connection(colors[6], towns[12], towns[13], 2, 2);	
		connections[26] = new Connection(colors[2], towns[6], towns[14], 6, 13);		connections[36] = new Connection(colors[4], towns[13], towns[17], 5, 10);	
		connections[27] = new Connection(colors[1], towns[6], towns[15], 5, 10);		connections[37] = new Connection(colors[1], towns[13], towns[18], 4, 7);	
		connections[28] = new Connection(colors[7], towns[6], towns[11], 4, 7);			connections[38] = new Connection(colors[7], towns[13], towns[19], 6, 13);	
		connections[29] = new Connection(colors[8], towns[11], towns[15], 4, 7);		connections[39] = new Connection(colors[6], towns[10], towns[20], 6, 13);
		
		connections[40] = new Connection(colors[5], towns[10], towns[14], 4, 7);		connections[50] = new Connection(colors[8], towns[16], towns[22], 2, 2);	
		connections[41] = new Connection(colors[6], towns[14], towns[20], 3, 4);		connections[51] = new Connection(colors[6], towns[16], towns[17], 2, 2);	
		connections[42] = new Connection(colors[8], towns[14], towns[26], 6, 13);		connections[52] = new Connection(colors[6], towns[16], towns[17], 2, 2);	
		connections[43] = new Connection(colors[1], towns[14], towns[21], 3, 4);		connections[53] = new Connection(colors[6], towns[17], towns[23], 2, 2);	
		connections[44] = new Connection(colors[6], towns[14], towns[15], 2, 2);		connections[54] = new Connection(colors[6], towns[17], towns[18], 2, 2);	
		connections[45] = new Connection(colors[6], towns[14], towns[15], 2, 2);		connections[55] = new Connection(colors[6], towns[17], towns[18], 2, 2);	
		connections[46] = new Connection(colors[0], towns[15], towns[21], 4, 7);		connections[56] = new Connection(colors[6], towns[18], towns[23], 2, 2);	
		connections[47] = new Connection(colors[6], towns[15], towns[16], 1, 1);		connections[57] = new Connection(colors[6], towns[18], towns[19], 1, 1);	
		connections[48] = new Connection(colors[6], towns[15], towns[16], 1, 1);		connections[58] = new Connection(colors[6], towns[18], towns[19], 1, 1);	
		connections[49] = new Connection(colors[0], towns[16], towns[22], 2, 2);		connections[59] = new Connection(colors[6], towns[18], towns[24], 2, 2);
		
		connections[60] = new Connection(colors[5], towns[20], towns[25], 5, 10);		connections[70] = new Connection(colors[6], towns[22], towns[23], 2, 2);	
		connections[61] = new Connection(colors[6], towns[20], towns[26], 2, 2);		connections[71] = new Connection(colors[3], towns[23], towns[28], 3, 4);	
		connections[62] = new Connection(colors[6], towns[26], towns[25], 3, 4);		connections[72] = new Connection(colors[7], towns[23], towns[24], 3, 4);	
		connections[63] = new Connection(colors[3], towns[21], towns[26], 4, 7);		connections[73] = new Connection(colors[4], towns[24], towns[29], 4, 7);	
		connections[64] = new Connection(colors[2], towns[21], towns[27], 3, 4);		connections[74] = new Connection(colors[2], towns[24], towns[29], 4, 7);	
		connections[65] = new Connection(colors[5], towns[21], towns[27], 3, 4);		connections[75] = new Connection(colors[1], towns[24], towns[35], 6, 13);	
		connections[66] = new Connection(colors[7], towns[21], towns[22], 2, 2);		connections[76] = new Connection(colors[6], towns[26], towns[27], 2, 2);	
		connections[67] = new Connection(colors[3], towns[21], towns[22], 2, 2);		connections[77] = new Connection(colors[3], towns[27], towns[31], 2, 2);	
		connections[68] = new Connection(colors[7], towns[22], towns[27], 5, 10);		connections[78] = new Connection(colors[7], towns[27], towns[31], 2, 2);	
		connections[69] = new Connection(colors[6], towns[22], towns[28], 2, 2);		connections[79] = new Connection(colors[6], towns[27], towns[32], 2, 2);
		
		connections[80] = new Connection(colors[6], towns[27], towns[33], 2, 2);		connections[90] = new Connection(colors[1], towns[25], towns[31], 3, 4);	
		connections[81] = new Connection(colors[4], towns[27], towns[28], 4, 7);		connections[91] = new Connection(colors[4], towns[30], towns[31], 2, 2);	
		connections[82] = new Connection(colors[5], towns[28], towns[33], 3, 4);		connections[92] = new Connection(colors[1], towns[30], towns[31], 2, 2);	
		connections[83] = new Connection(colors[6], towns[28], towns[29], 1, 1);		connections[93] = new Connection(colors[2], towns[31], towns[32], 2, 2);	
		connections[84] = new Connection(colors[6], towns[29], towns[33], 2, 2);		connections[94] = new Connection(colors[5], towns[31], towns[32], 2, 2);	
		connections[85] = new Connection(colors[6], towns[29], towns[33], 2, 2);		connections[95] = new Connection(colors[6], towns[32], towns[33], 2, 2);	
		connections[86] = new Connection(colors[6], towns[29], towns[34], 2, 2);		connections[96] = new Connection(colors[6], towns[32], towns[33], 2, 2);	
		connections[87] = new Connection(colors[0], towns[29], towns[35], 5, 10);		connections[97] = new Connection(colors[6], towns[33], towns[34], 2, 2);	
		connections[88] = new Connection(colors[6], towns[25], towns[30], 2, 2);		connections[98] = new Connection(colors[8], towns[34], towns[35], 4, 7);
		connections[89] = new Connection(colors[6], towns[25], towns[30], 2, 2);			
		
		
		towns[0] = new Town("Vancouver", 3, 94, 591, connections[0],connections[1], connections[8]);
		towns[1] = new Town("Seattle", 6, 92,542, connections[0], connections[1], connections[2], connections[3], connections[9], connections[10] );
		towns[2] = new Town("Portland", 5, 74,499,connections[2], connections[3], connections[4], connections[5], connections[11] );
		towns[3] = new Town("San Francisco", 6,61,325,connections[4], connections[5], connections[6], connections[7], connections[12], connections[13]);
		towns[4] = new Town("Los Angeles",5,128,233,connections[6], connections[7], connections[14], connections[15], connections[16]);
		towns[5] = new Town("Calgary",4, 210, 605, connections[8], connections[9], connections[17], connections[18]);
		towns[6] = new Town("Helena",7,297,489,connections[10], connections[18], connections[19], connections[25], connections[26],connections[27], connections[28]);
		towns[7] = new Town("Salt Lake City", 7,233,382, connections[11], connections[12], connections[13], connections[20], connections[21], connections[22], connections[19]);
		towns[8] = new Town("Las Vegas", 2, 1, 286,  connections[15], connections[22]);
		towns[9] = new Town("Phoenix", 4,235,228,  connections[15], connections[22], connections[23], connections[24]);
		towns[10] = new Town("Winnipeg",4, 407,596,  connections[17], connections[25], connections[39], connections[40]);
		towns[11] = new Town("Denver", 9,349,354,  connections[20], connections[21], connections[22], connections[33], connections[32], connections[31], connections[30], connections[29], connections[28]);
		towns[12] = new Town("Santa Fe", 4, 342, 274,  connections[33], connections[34], connections[23], connections[33]);
		towns[13] = new Town("El Paso", 6, 338, 196,  connections[16], connections[24], connections[35], connections[36], connections[37], connections[38]);
		towns[14] = new Town("Duluth", 7, 504, 495,  connections[26], connections[40], connections[41], connections[42], connections[43], connections[44], connections[45]);
		towns[15] = new Town("Omaha",7, 478, 415,  connections[27], connections[29], connections[44], connections[45], connections[46], connections[47], connections[48]);
		towns[16] = new Town("Kansas City",8, 497,370,  connections[30], connections[31], connections[47], connections[49], connections[50], connections[51], connections[52], connections[48]);
		towns[17] = new Town("Oklahoma City", 8, 479, 293,  connections[32], connections[34], connections[36], connections[51], connections[52], connections[53], connections[54], connections[55]);
		towns[18] = new Town("Dallas", 6, 497, 217,  connections[37], connections[54], connections[55], connections[56], connections[57], connections[58]);
		towns[19] = new Town("Houston", 4, 532, 184,  connections[38], connections[57], connections[58], connections[59]);
		towns[20] = new Town("Sault St Marie", 4, 616, 553,  connections[39], connections[41], connections[60], connections[61]);
		towns[21] = new Town("Chicago",7 ,612 ,441,  connections[43], connections[46], connections[63], connections[64], connections[65], connections[66], connections[67]);
		towns[22] = new Town("Saint Louis", 7, 573, 386,  connections[49], connections[50], connections[66], connections[67], connections[68], connections[69], connections[70]);
		towns[23] = new Town("Little Rock", 5, 557, 290,  connections[53], connections[56], connections[70], connections[71], connections[72]);
		towns[24] = new Town("New Orleans", 5, 613, 192,  connections[59], connections[72], connections[73], connections[74], connections[75]);
		towns[25] = new Town("Montreal", 5, 784, 611,  connections[60], connections[62], connections[88], connections[89], connections[90]);
		towns[26] = new Town("Toronto", 5, 712,534,  connections[42], connections[61], connections[62], connections[3], connections[76]);
		towns[27] = new Town("Pittsburgh",9,726,453, connections[64], connections[65], connections[68], connections[81], connections[77], connections[78], connections[79], connections[80], connections[81]);
		towns[28] = new Town("Nashville", 5, 654,335, connections[71], connections[69], connections[81], connections[82], connections[83]);
		towns[29] = new Town("Atlanta", 7, 669,304,  connections[73], connections[74], connections[83], connections[84], connections[85], connections[86], connections[87]);
		towns[30] = new Town("Boston", 4, 845,559,  connections[88], connections[89], connections[91], connections[92]);
		towns[31] = new Town("New York", 7,800,493, connections[90], connections[91], connections[92], connections[77], connections[78], connections[93], connections[94]);
		towns[32] = new Town("Washington", 5, 807, 414,  connections[93], connections[94], connections[79], connections[95], connections[96]);
		towns[33] = new Town("Raleigh", 7, 756, 355,  connections[95], connections[96], connections[97], connections[80], connections[82], connections[84], connections[85]);
		towns[34] = new Town("Charleston", 3, 781, 298,  connections[86], connections[97], connections[98]);
		towns[35] = new Town("Miami", 3, 809, 159,  connections[75], connections[78], connections[87]);
		
		
		missionCards[0] = new MissionCard(towns[11], towns[13],4);
		missionCards[1] = new MissionCard(towns[16], towns[19],5);
		missionCards[2] = new MissionCard(towns[31], towns[29],6);
		missionCards[3] = new MissionCard(towns[5], towns[7],7);
		missionCards[4] = new MissionCard(towns[21], towns[24],7);
		missionCards[5] = new MissionCard(towns[6], towns[4],8);
		missionCards[6] = new MissionCard(towns[20], towns[28],8);
		missionCards[7] = new MissionCard(towns[14], towns[19],8);
		missionCards[8] = new MissionCard(towns[25], towns[29],9);
		missionCards[9] = new MissionCard(towns[1], towns[4],9);
		missionCards[10] = new MissionCard(towns[21], towns[12],9);
		missionCards[11] = new MissionCard(towns[20], towns[17],9);
		missionCards[12] = new MissionCard(towns[26], towns[35],10);
		missionCards[13] = new MissionCard(towns[14], towns[13],10);
		missionCards[14] = new MissionCard(towns[10], towns[23],11);
		missionCards[15] = new MissionCard(towns[18], towns[31],11);
		missionCards[16] = new MissionCard(towns[2], towns[9],11);
		missionCards[17] = new MissionCard(towns[11], towns[27],11);
		missionCards[18] = new MissionCard(towns[30], towns[35],12);
		missionCards[19] = new MissionCard(towns[10], 	towns[19],12);
		missionCards[20] = new MissionCard(towns[0], towns[12],13);
		missionCards[21] = new MissionCard(towns[25], towns[24],13);
		missionCards[22] = new MissionCard(towns[5], towns[9],13);
		missionCards[23] = new MissionCard(towns[4], towns[21],16);
		missionCards[24] = new MissionCard(towns[2], towns[28],17);
		missionCards[25] = new MissionCard(towns[3],towns[29] ,17);
		missionCards[26] = new MissionCard(towns[0], towns[25],20);
		missionCards[27] = new MissionCard(towns[4], towns[35],20);
		missionCards[28] = new MissionCard(towns[4], towns[31],21);
		missionCards[29] = new MissionCard(towns[1], towns[31],22);
		
		// Creating all the trainCards
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
			else if (i >= 96 && i < 110) 
				trainCards[i] = new TrainCard(colors[9]); // Rainbow
		}

	}
	
	public Image getBoardPic() {
		return boardPic;
	}

	public void setBoardPic(Image boardPic) throws SlickException {
		this.boardPic = new Image("/Map.jpg");
	}
}
	
