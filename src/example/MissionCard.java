package example;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MissionCard extends Card{
	
	private Town townA, townB;
	private int points;
	Image image;
	private boolean isCompleted;
	
	ArrayList<Connection> visitedConnections = new ArrayList<Connection>();

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
	 * Overrides a default function which does nothing
	 * Calls the _areConnected function on the mission instances towns once for each connection of the root
	 * This is because the _areConnected funtion only works for one "branch" and needs to be called again.
	 * The _areConnected also sets a lot of towns as visited, that requires a function call for setAllUnVisited,
	 * which will set all those towns as univisited. (Untested).
	 */
	
	@Override
	public boolean areConnected(){

		boolean temp = false;
		
		for(int i = 0; i < this.townA.getConnections().size();i++){
			
			if(_areConnected(this.townA, this.townB, i )){
				temp = true;
			}
		}
		setAllUnVisited();

		return temp;

	}
	
	/**
	 * The missioncard contains an ArrayList of all towns that it has visited, this function should set them all as fales.
	 * Untested.
	 */
	void setAllUnVisited(){

		for(int i = 0; i < visitedConnections.size(); i++){

			visitedConnections.get(i).setIsVisited(false);

		}

	}
	
	/**
	 * This is the actual, recursive function that checks one branch of the graph/tree for connections.
	 * Calls it self if certain conditions are met, mostly working with two booleans "isTaken" and "isVisited"
	 * @param townA  will always be this.townA
	 * @param townB  will always be this.townB
	 * @param flf	 The incremented "i" of the for loop called in "areConnected()"
	 * @return returns false if it did not find a connecting path, returns true if it does.
	 */
	public boolean _areConnected(Town townA, Town townB, int flf){
		
		Town current = townA;

		for(int i = 0; i <  current.getConnections().size(); i++){  //check all the connections

		if(current.getConnection(i).getIsTaken()){					//if they are taken
			if(current.getConnection(i).getTownB().getName() == townB.getName() ||			//if names match the target name
						current.getConnection(i).getTownA().getName() == townB.getName()){  //if names match the target name
					
				return true;
				}
			}
		}

		boolean returnValue = false;			//variable for dynamic return value

		for(int i = 0+flf; i < current.getConnections().size(); i++){    //loop through connections to change the current town
			if(current.getConnection(i).getIsTaken() && current.getConnection(i).getIsVisited() == false){ //if its taken and not visited
				
				current.getConnection(i).setIsVisited(true);				//set it as visited
				visitedConnections.add(current.getConnection(i));			//also store it in our Arraylist
			
		 if(current.getConnection(i).getTownB().getName() == current.getName()){	//if the town on the other side of the connection is the same as current
				current = townA.getConnection(i).getTownA();				//then set current as the other town
				break;														//dont continue looping
		}else{
				current = townA.getConnection(i).getTownB();				//else set current as that town
				break;														//dont continue looping
				}
			}
		}
			
		
		for(int i = 0; i < current.getConnections().size(); i++){			//current has been changed

		if(current.getConnection(i).getIsTaken()){							//check "taken" towns
			

			if(!current.getConnection(i).getIsVisited()){					//skip visited towns
				returnValue = returnValue || _areConnected(current, townB, flf);	//call the function on it self, it might return true
				}
			}
		}
		
		return returnValue;				//returns false often, but should return true at least once if there is a connection.
		
	}
}
