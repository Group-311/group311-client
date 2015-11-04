package example;

public class TrainCardStack extends Stack{

	private TrainCard [] stack;
	private int currentAmount;
	
	public TrainCardStack(int _amount) {
		super(_amount);
		
		stack = new TrainCard [this.getAmount()];
	}
	

	public void shuffle(){
		/**
		 * shuffle the array with some shuffle function
		 */
	}
	public void drawCard(Stack _stack){
		/**
		 * removes the first or last card from the array
		 * transfers it to either a hand stack or the 5 visibile stack
		 */
	}
	
}
