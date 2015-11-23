package example;

import java.awt.image.BufferedImage;

import org.newdawn.slick.Image;

public class MissionCard extends Card{
	
	private Town townA, townB;
	private int points;
	Image image;
	private boolean isCompleted;

	MissionCard(Town townA,Town townB, int points){
		this.townA=townA;
		this.townB=townB;
		this.points=points;
		this.isCompleted = false;
		
	}
	
	/**
	 * ONLY CHECKS FIRST CONNECTION AT THE MOMENT
	 * 
	 * Checks whether any of this.townAs connection is taken, if not then the mission
	 *  could not possibly be completed.
	 *  WILL WAIT FOR GRAPH LECTURE
	 */
	public void checkComplete(){
		for(int i = 0; i < this.townA.getConnections().length; i++){
		if(townA.getConnections()[i].isTaken())
			for(int j = 0; j < townA.getConnections().length; j++){
				
			}
		}
		
		this.isCompleted = true;
	}
	
	
}
