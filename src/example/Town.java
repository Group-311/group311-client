package example;

public class Town {
	
	private Connection [] connections;
	private String name;
	private int xPos, yPos;
	
	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2){
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
	}
	
	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2,
			Connection connection3){
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
		connections[2] = connection3;
	}

	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2,
			Connection connection3, Connection connection4) {
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
		connections[2] = connection3;
		connections[3] = connection4;
	}
	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2,
			Connection connection3, Connection connection4, Connection connection5) {
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
		connections[2] = connection3;
		connections[3] = connection4;
		connections[4] = connection5;
	}
	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2,
			Connection connection3, Connection connection4, Connection connection5, Connection connection6) {
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
		connections[2] = connection3;
		connections[3] = connection4;
		connections[4] = connection5;
		connections[5] = connection6;
	}
	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2,
			Connection connection3, Connection connection4, Connection connection5, Connection connection6, Connection connection7) {
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
		connections[2] = connection3;
		connections[3] = connection4;
		connections[4] = connection5;
		connections[5] = connection6;
		connections[6] = connection7;
	}
	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2,
			Connection connection3, Connection connection4, Connection connection5, Connection connection6, Connection connection7, 
			Connection connection8) {
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
		connections[2] = connection3;
		connections[3] = connection4;
		connections[4] = connection5;
		connections[5] = connection6;
		connections[6] = connection7;
		connections[7] = connection8;
	}
	public Town(String _name, int amountOfConnections, int _xPos, int _yPos, Connection connection, Connection connection2,
			Connection connection3, Connection connection4, Connection connection5, Connection connection6, Connection connection7,
			Connection connection8, Connection connection9) {
		this.setName(_name);
		setConnections(new Connection [amountOfConnections]);
		this.xPos = _xPos;
		this.yPos = _yPos;
		
		connections[0] = connection;
		connections[1] = connection2;
		connections[2] = connection3;
		connections[3] = connection4;
		connections[4] = connection5;
		connections[5] = connection6;
		connections[6] = connection7;
		connections[7] = connection8;
		connections[8] = connection9;
	}

	public Connection [] getConnections() {
		return connections;
	}
	public Connection getConnection(int i) {
		return connections[i];
	}


	public void setConnections(Connection [] connections) {
		this.connections = connections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	

}
