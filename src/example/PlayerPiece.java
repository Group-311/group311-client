package example;

public class PlayerPiece {
	
	private int totalPoints, xPos, yPos;
	private Color color;
	private Train [] trains;
	
	PlayerPiece(){
		
	}
	
	public void move(int points){
		this.xPos += points;
		this.yPos += points;
	}

}
