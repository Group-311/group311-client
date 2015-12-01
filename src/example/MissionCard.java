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
				System.out.println("IT HAPPENED AT LEAST ONCE!!!");
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
public boolean _areConnected(Town townA, Town townB, int forloopfucker){
		
		System.out.println("Checking if "+townA.getName()+" and "+townB.getName()+" are connected!");
		
		Town previous = null;
		Town current = townA;

		for(int i = 0; i <  current.getConnections().size(); i++){

		if(current.getConnection(i).getIsTaken()/* && current.getConnection(i).getIsVisited() == false*/){
			
			
			
				if(current.getConnection(i).getTownB().getName() == townB.getName() ||
						current.getConnection(i).getTownA().getName() == townB.getName()){
					
				return true;
				}
			}
		}

		boolean returnValue = false;
		
		previous = current;

		for(int i = 0+forloopfucker; i < current.getConnections().size(); i++){
			if(current.getConnection(i).getIsTaken() /*&& current.getConnection(i).getTownA().getName() != previous.getName() /*&&
					current.getConnection(i).getTownB().getName() != previous.getName()*/&& current.getConnection(i).getIsVisited() == false){
				
				current.getConnection(i).setIsVisited(true);
				visitedConnections.add(current.getConnection(i));
				System.out.println("A connection between "+current.getConnection(i).getTownA().getName()+" and "+current.getConnection(i).getTownB().getName()+" is set to visited" );
			
		 if(current.getConnection(i).getTownB().getName() == current.getName()){
			 
				System.out.println("I set current from "+current.getName());
				current = townA.getConnection(i).getTownA();
				System.out.println("I set current to "+current.getName());
				break;
				
				
				
			}else{
				
				
				System.out.println("I set current from "+current.getName());
				current = townA.getConnection(i).getTownB();
				System.out.println("I set current to "+current.getName());
				break;
				
				
				}
			}
		}
			
		
		for(int i = 0; i < current.getConnections().size(); i++){

		if(current.getConnection(i).getIsTaken()/* && current.getConnection(i).getIsVisited() == false*/){
			

			if(!current.getConnection(i).getIsVisited()){
				System.out.println("Calling recursive funtion on "+current.getName());
				returnValue = returnValue || _areConnected(current, townB, forloopfucker);
			}

			}
		}
		
		return returnValue;
		
	}
}
