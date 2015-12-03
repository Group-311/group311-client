



import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Connection {

	/**
	 * length is the amount of trains needed for the route point is the amount
	 * of points the route is worth color is the color type needed to build, can
	 * be grey townA and townB is the two towns that the route connects
	 */

	private int length, point;
	private CustomColor color;
	private CustomColor takenColor;
	private Town townA, townB;
	private boolean isTaken;
	private int ownedBy;

	private boolean isVisited;

	/**
	 * setting all values through the constructor No need for getters and
	 * setters Values should not be changed
	 */

	Connection(CustomColor _color, Town _townA, Town _townB, int _length, int _point) {

		this.length = _length;
		this.point = _point;
		this.color = _color;
		this.setTownA(_townA);
		this.setTownB(_townB);
		

		_townA.addConnection(this);

		_townB.addConnection(this);

		this.setTaken(false);
		isTaken = false;

		isVisited = false;
	}
	Connection(CustomColor _color, Town _townA, Town _townB, int _length, int _point, int a) {

		this.length = _length;
		this.point = _point;
		this.color = _color;
		this.setTownA(_townA);
		this.setTownB(_townB);
		

		this.setTaken(false);
		isTaken = false;

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

	public void setIsVisited(boolean b) {
		this.isVisited = b;
	}

	public boolean getIsVisited() {
		return this.isVisited;
	}

	public boolean getIsTaken() {
		return isTaken;
	}

	public void setTaken(boolean _isTaken) {
		this.isTaken = _isTaken;
	}

	public int getLength() {
		return length;
	}

	public CustomColor getColor() {
		return color;
	}
	public boolean getTakenByPlayer(Players player){
		if(ownedBy == player.playerNum)
			return true;
		
		return false;
	}
	public void setTakenByPlayer(Players player){
		ownedBy = player.playerNum;
		this.isTaken = true;
	}
	public void drawConnection(Players player, Graphics g){
		
		setTakenByPlayer(player);
		
		g.setColor(player.getPlColor().getColor());
		g.drawLine(townA.getxPos(), 768-townA.getyPos(), townB.getxPos(), 768-townB.getyPos());
		
		//movePlayerPiece(this.point);
	}
	public int getPoint() {
		return point;
	}
	
	

}