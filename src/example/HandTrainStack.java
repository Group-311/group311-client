package example;

public class HandTrainStack extends Stack {
	
	private TrainCard [] stack;
	private int currentAmount;

	public HandTrainStack(int _amount) {
		super(_amount);
		
		stack = new TrainCard [this.getAmount()];
	}
	
	public void drawCard(){
		/**
		 * draw card from main stack, perhaps just call that function?
		 */
	}
	
}
