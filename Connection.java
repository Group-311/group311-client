public class Connection{

	/**
	** length is the amount of trains needed for the route
	** point is the amount of points the route is worth
	** color is the color type needed to build, can be grey
	** townA and townB is the two towns that the route connects
	**/

	private int length, point;
	private Color color;
	private Town townA, townB;

	/**
	** setting all values through the constructor
	** 
	**
	**/
	
	Connection(Color _color, Town _townA, Town _townB, int _length, _point){

		this.length = _length;
		this.point = _point;
		this.color = _color;
		this.townA = _townA;
		this.townB = _townB;
	}

	public void setLength(){

	}
	public void setPoint(){
		
	}
	public void setColor(){
		
	}
	public void setTownA(){
		
	}
	public void setLength(){
		
	}

}