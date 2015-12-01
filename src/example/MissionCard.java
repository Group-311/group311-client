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
	void setAllUnVisited(){

		for(int i = 0; i < visitedConnections.size(); i++){

			visitedConnections.get(i).setIsVisited(false);

		}

	}
	public boolean _areConnected(Town townA, Town townB, int flf){
		
		Town current = townA;

		for(int i = 0; i <  current.getConnections().size(); i++){

		if(current.getConnection(i).getIsTaken()){
			if(current.getConnection(i).getTownB().getName() == townB.getName() ||
						current.getConnection(i).getTownA().getName() == townB.getName()){
					
				return true;
				}
			}
		}

		boolean returnValue = false;

		for(int i = 0+flf; i < current.getConnections().size(); i++){
			if(current.getConnection(i).getIsTaken() && current.getConnection(i).getIsVisited() == false){
				
				current.getConnection(i).setIsVisited(true);
				visitedConnections.add(current.getConnection(i));
			
		 if(current.getConnection(i).getTownB().getName() == current.getName()){
				current = townA.getConnection(i).getTownA();
				break;
		}else{
				current = townA.getConnection(i).getTownB();
				break;
				}
			}
		}
			
		
		for(int i = 0; i < current.getConnections().size(); i++){

		if(current.getConnection(i).getIsTaken()){
			

			if(!current.getConnection(i).getIsVisited()){
				returnValue = returnValue || _areConnected(current, townB, flf);
				}
			}
		}
		
		return returnValue;
		
	}
}
