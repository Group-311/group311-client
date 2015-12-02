package example;

public class Train {
	
	private Color trainColor;
	private int amountOfTrains;
	
	Train(Color _trainColor){
		this.trainColor = _trainColor;
		amountOfTrains = 45;
	}

	
	public void decrease(int amount){
		amountOfTrains -= amount;
	}
}
