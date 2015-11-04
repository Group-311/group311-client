package example;

public class Town {
	
	private Connection [] connections;
	private String name;
	private int xPos, yPos;
	
	Town(String _name, int amountOfConnections, int _xPos, int _yPos){
		this.name = _name;
		connections = new Connection [amountOfConnections];
		this.xPos = _xPos;
		this.yPos = _yPos;
	}

}
