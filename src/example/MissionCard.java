package example;

import java.awt.image.BufferedImage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MissionCard extends Card{
	
	private Town townA, townB;
	private int points;
	Image image;
	private boolean isCompleted;

	public MissionCard(Town townA,Town townB, int points) throws SlickException {
		super();
		
		xPos = 896;
		yPos = 0;
		
		this.townA = townA;
		this.townB = townB;
		this.points=points;
		this.isCompleted = false;
	}

	public Town getTownA() {
		return townA;
	}


	public Town getTownB() {
		return townB;
	}
	
	/**
	 * ONLY CHECKS FIRST CONNECTION AT THE MOMENT
	 * 
	 * Checks whether any of this.townAs connection is taken, if not then the mission
	 *  could not possibly be completed.
	 *  WILL WAIT FOR GRAPH LECTURE
	 */
	/*public void checkComplete(){
		for(int i = 0; i < this.townA.getConnections().size(); i++){
		if(townA.getConnection(i).getIsTaken())
			for(int j = 0; j < townA.getConnections().size(); j++){
				
			}
		}
		
		this.isCompleted = true;
		
	 // Add points to the player who completed it
	}*/
	
	
}
