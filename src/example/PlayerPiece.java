package example;

public class PlayerPiece {
	
	private int totalPoints, xPos, yPos;
	private Color color;
	private Train [] trains;
	private Connection [] completedRoutes;
	
	PlayerPiece(){
		
		completedRoutes = new Connection [36];
		
	}
	
	public void move(int points){
		this.xPos += points;
		this.yPos += points;
	}

}
