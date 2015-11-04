package example;

import java.awt.image.BufferedImage;

public class Board {
	
	private BufferedImage boardPic;
	Town [] towns;
	PlayerPiece players [];
	
	Board(int numOfPlayers){
		
		players = new PlayerPiece[numOfPlayers];
		
	}

}
