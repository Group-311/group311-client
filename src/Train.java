

public class Train {
	
	private CustomColor trainColor;
	private int amountOfTrains;
	
	Train(CustomColor _trainColor){
		this.trainColor = _trainColor;
		amountOfTrains = 45;
	}

	
	public void decrease(int amount){
		amountOfTrains -= amount;
	}
}
