package example;

public class TrainCardStack extends Stack {

	private TrainCard[] stack;
	private int currentAmount;

	public TrainCardStack(TrainCard[] _cards) {
		super(_cards);

		setStack(new TrainCard[this.getAmount()]);
		
		currentAmount = _cards.length;
	}

	public void drawCard(Stack _stack) {
		/**
		 * removes the first or last card from the array transfers it to either
		 * a hand stack or the 5 visibile stack
		 */
	}

	public TrainCard[] getStack() {
		return this.stack;
	}

	public void setStack(TrainCard[] stack) {
		this.stack = stack;
	}

}