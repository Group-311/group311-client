package example;

public class TrainCardStack extends Stack {

	private TrainCard[] stack;
	private int currentAmount;

	public TrainCardStack(int _amount) {
		super(_amount);

		setStack(new TrainCard[this.getAmount()]);
	}

	public void shuffle() {

		// Initialize Random class so it can be used in the following shuffle
		// code
		Random rnd = ThreadLocalRandom.current();

		for (int i = stack.length - 1; i > 0; i--) {
			// initialize a new variable called index which takes a random value
			// between 0 and i+1 (i+1 = 110 at first iteration of the for loop)
			int index = rnd.nextInt(i + 1);
			// Initialize a new variable called swap that is equal to the value
			// of the trainCardStack room number #index
			int swap = stack[index];
			// Swap the two values with each other.
			stack[index] = stack[i];
			stack[i] = swap;
			// Go to next iteration of the for loop and repeat the shuffle
		}

		// Print the shuffled values
		System.out.println("TrainCardStack shuffled in the following order: ");
		for (int i = 0; i < stack.length; i++) {
			System.out.print(stack[i] + " ");
		}
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