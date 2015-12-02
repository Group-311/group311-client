

public class TrainTrashStack extends Stack {
	
	private TrainCard [] stack;
	private int currentAmount;
	
	public TrainTrashStack(int _amount) {
		super(_amount);
		
		stack = new TrainCard [this.getAmount()];
	}
	
	public void checkTrainStack(){
		/**
		 * checks if the main TrainCardStack is empty
		 * this function gets called super often
		 * if the stack is zero the call shuffle and return to stack
		 */
	}
	public void shuffle(){
		/**
		 * 
		 * shuffle the stack
		 */
	}
	public void returnToStack(){
		/**
		 * 
		 * TrainCardStack [] = TrainTrashStack[];
		 * TrainTrashStack [] = null;
		 */
	}

}
