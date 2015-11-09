package example;

public class Town {
	
	private Connection [] connections;
	private String name;
	private int xPos, yPos;
	
	Town(String _name, int amountOfConnections, int _xPos, int _yPos){
		this.name = _name;
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
	}

	public Connection [] getConnections() {
		return connections;
	}

	public void setConnections(Connection [] connections) {
		this.connections = connections;
	}
	
	

}
