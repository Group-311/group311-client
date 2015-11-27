<<<<<<< HEAD
package example;

public class Connection{

	/**
	* length is the amount of trains needed for the route
	* point is the amount of points the route is worth
	* color is the color type needed to build, can be grey
	* townA and townB is the two towns that the route connects
	*/

	private int length, point;
	private Color color;
	private Town townA, townB;
	private boolean isTaken;
	
	public boolean isVisited;

	/**
	* setting all values through the constructor
	* No need for getters and setters
	* Values should not be changed 
	*/
	
	Connection(Color _color, Town _townA, Town _townB, int _length, int _point){

		this.length = _length;
		this.point = _point;
		this.color = _color;
		this.setTownA(_townA);
		this.setTownB(_townB);
		//this.setTaken();
		
		isVisited = false;
	}
	

	public Town getTownA() {
		return townA;
	}

	public void setTownA(Town townA) {
		this.townA = townA;
	}

	public Town getTownB() {
		return townB;
	}

	public void setTownB(Town townB) {
		this.townB = townB;
	}


	public boolean isTaken() {
		return isTaken;
	}


	public void setTaken() {
		this.isTaken = true;
	}
	public void setIsVisited(){
		this.isVisited = true;
	}
	

=======
package example;

public class Connection{

	/**
	* length is the amount of trains needed for the route
	* point is the amount of points the route is worth
	* color is the color type needed to build, can be grey
	* townA and townB is the two towns that the route connects
	*/

	private int length, point;
	private Color color;
	private Town townA, townB;
	private boolean isTaken;

	/**
	* setting all values through the constructor
	* No need for getters and setters
	* Values should not be changed 
	*/
	
	Connection(Color _color, Town _townA, Town _townB, int _length, int _point){

		this.length = _length;
		this.point = _point;
		this.color = _color;
		this.setTownA(_townA);
		this.setTownB(_townB);
		this.setTaken(false);
	}
	

	public Town getTownA() {
		return townA;
	}

	public void setTownA(Town townA) {
		this.townA = townA;
	}

	public Town getTownB() {
		return townB;
	}

	public void setTownB(Town townB) {
		this.townB = townB;
	}


	public boolean isTaken() {
		return isTaken;
	}


	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	

>>>>>>> origin/master
}