

public class HandTrainStack extends Stack {
	
	private TrainCard [] stack;
	private int currentAmount;

	public HandTrainStack(int _amount) {
		//super(_amount);
		
		stack = new TrainCard [this.getAmount()];
	}
	
	public void drawCard(){
		/**
		 * draw card from main stack, perhaps just call that function?
		 */
	}
	public void playCard(){
		/**
		 *  play cards, perhaps just call the function within TrainCard?
		 */
	}
	public void drawFourCards(){
		/**
		 * draw four cards from main stack, perhaps just call that function?
		 * only in set up
		 */
	}
	public void ShowHideHand(){
		/**
		 * toggle display of hand to player GUI
		 */
	}
}