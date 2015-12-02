



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
		if(ownedBy == player.getNum())
			return true;
		
		return false;
	}
	public void setTakenByPlayer(Players player, Graphics g){
		ownedBy = player.getNum();
		this.isTaken = true;
		
		//g.setColor(player.getCustomColor().getColor());
		g.setColor(player.getCustomColor().getColor());
	
		
		g.drawLine(townA.getxPos(), 768-townA.getyPos(), townB.getxPos(), 768-townB.getyPos());
		
		
		//return g;
	}

}