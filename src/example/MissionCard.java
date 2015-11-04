package example;

import java.awt.image.BufferedImage;

public class MissionCard extends Card{
	
	private Town townA, townB;
	private int points;
	private BufferedImage image;
	private boolean isCompleted;

	MissionCard(){
		
		this.isCompleted = false;
		
	}
	
	public void complete(){
		this.isCompleted = true;
	}
}
