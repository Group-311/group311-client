package example;

import java.awt.image.BufferedImage;

public class Board {
	
	private BufferedImage boardPic;
	Town [] towns;
	PlayerPiece [] players;
	Connection [] connections;
	Color [] colors;
	
	Board(int numOfPlayers){
		
		towns = new Town [36];
		connections = new Connection[100];
		colors = new Color[9];
		players = new PlayerPiece[numOfPlayers];
		
		colors[0] = new Color("blue", 0);
		colors[1] = new Color("red", 1);
		colors[2] = new Color("orange", 2);
		colors[3] = new Color("white", 3);
		colors[4] = new Color("yellow", 4);
		colors[5] = new Color("black", 5);
		colors[6] = new Color("grey", 6);
		colors[7] = new Color("green", 7);
		colors[8] = new Color("pink", 8);
		
		connections[0] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[1] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[2] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[3] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[4] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[5] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[6] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[7] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		connections[8] = new Connection(colors[6], towns[0], towns[5], 3, 4);
		connections[9] = new Connection(colors[6], towns[0], towns[1], 1, 1);
		
		towns[0] = new Town("Vancouver", 3, x, y, connections[0],connections[1], connections[8]);
		towns[1] = new Town("Seattle", 6, x,y, connections[0], connections[1], connections[2], connections[3], connections[9], connections[10] );
		towns[2] = new Town("Portland", 5, x,y,connections[2], connections[3], connections[4], connections[5], connections[11] );
		towns[3] = new Town("San Francisco", 6,x,y,connections[4], connections[5], connections[6], connections[7], connections[12], connections[13]);
		towns[4] = new Town("Los Angeles",5,x,y,connections[6], connections[7], connections[14], connections[15], connections[16]);
		towns[5] = new Town("Calgary",4, x,y , connections[8], connections[9], connections[17], connections[18]);
		towns[6] = new Town("Helena",7,x,y,connections[10], connections[18], connections[19], connections[25], connections[26],connections[27], connections[28]);
		towns[7] = new Town("Salt Lake City", 7,x,y, connections[11], connections[12], connections[13], connections[20], connections[21], connections[22], connections[19]);
		towns[8] = new Town("Las Vegas", 2,x,y,  connections[15], connections[22]);
		towns[9] = new Town("Phoenix", 4,x,y,  connections[15], connections[22], connections[23], connections[24]);
		towns[10] = new Town("Winnipeg",4, x,y,  connections[17], connections[25], connections[39], connections[40]);
		towns[11] = new Town("Denver", 9,x,y,  connections[20], connections[21], connections[22], connections[33], connections[32], connections[31], connections[30], connections[29], connections[28]);
		towns[12] = new Town("Santa Fe", 4, x, y,  connections[33], connections[34], connections[23], connections[33]);
		towns[13] = new Town("El Paso", 6, x, y,  connections[16], connections[24], connections[35], connections[36], connections[37], connections[38]);
		towns[14] = new Town("Duluth", 7, x, y,  connections[26], connections[40], connections[41], connections[42], connections[43], connections[44], connections[45]);
		towns[15] = new Town("Omaha",7, x, y,  connections[27], connections[29], connections[44], connections[45], connections[46], connections[47], connections[48]);
		towns[16] = new Town("Kansas City",8, x,y,  connections[30], connections[31], connections[47], connections[49], connections[50], connections[51], connections[52], connections[48]);
		towns[17] = new Town("Oklahoma City", 8, x, y,  connections[32], connections[34], connections[36], connections[51], connections[52], connections[53], connections[54], connections[55]);
		towns[18] = new Town("Dallas", 6, x, y,  connections[37], connections[54], connections[55], connections[56], connections[57], connections[58]);
		towns[19] = new Town("Houston", 4, x, y,  connections[38], connections[57], connections[58], connections[59]);
		towns[20] = new Town("Sault St Marie", 4, x, y,  connections[39], connections[41], connections[60], connections[61]);
		towns[21] = new Town("Chicago",7 ,x ,y,  connections[43], connections[46], connections[63], connections[64], connections[65], connections[66], connections[67]);
		towns[22] = new Town("Saint Louis", 7, x, y,  connections[49], connections[50], connections[66], connections[67], connections[68], connections[69], connections[70]);
		towns[23] = new Town("Little Rock", 5, x, y,  connections[53], connections[56], connections[70], connections[71], connections[72]);
		towns[24] = new Town("New Orleans", 5, x, y,  connections[59], connections[72], connections[73], connections[74], connections[75]);
		towns[25] = new Town("Montreal", 5, x, y,  connections[60], connections[62], connections[88], connections[89], connections[90]);
		towns[26] = new Town("Toronto", 5, x,y,  connections[42], connections[61], connections[62], connections[3], connections[76]);
		towns[27] = new Town("Pittsburgh",9,x,y, connections[64], connections[65], connections[68], connections[81], connections[77], connections[78], connections[79], connections[80], connections[81]);
		towns[28] = new Town("Nashville", 5, x,y, connections[71], connections[69], connections[81], connections[82], connections[83]);
		towns[29] = new Town("Atlanta", 7, x,y,  connections[73], connections[74], connections[83], connections[84], connections[85], connections[86], connections[87]);
		towns[30] = new Town("Boston", 4, x,y,  connections[88], connections[89], connections[91], connections[92]);
		towns[31] = new Town("New York", 7,x,y, connections[90], connections[91], connections[92], connections[77], connections[78], connections[93], connections[94]);
		towns[32] = new Town("Washington", 5, x, y,  connections[93], connections[94], connections[79], connections[95], connections[96]);
		towns[33] = new Town("Raleigh", 7, x, y,  connections[95], connections[96], connections[97], connections[80], connections[82], connections[84], connections[85]);
		towns[34] = new Town("Charleston", 3, x, y,  connections[86], connections[97], connections[98]);
		towns[35] = new Town("Miami", 3, x, y,  connections[75], connections[78], connections[87]);
		
	}

}
