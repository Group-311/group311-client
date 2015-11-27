package example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MissionCardStack extends Stack {
	
	private MissionCard [] stack;
	private int currentAmount;

	public MissionCardStack(MissionCard[] _cards) {
		super(_cards);
		
		shuffle(_cards);
		
		setStack(new MissionCard [this.getAmount()]);
		
		
		currentAmount = _cards.length;
	}
	
	public void shuffle(MissionCard[] stack){

		// Initialize Random class so it can be used in the following shuffle
		// code
		Random rnd = ThreadLocalRandom.current();

		for (int i = stack.length - 1; i > 0; i--) {
			// initialize a new variable called index which takes a random value
			// between 0 and i+1 (i+1 = 110 at first iteration of the for loop)
			int index = rnd.nextInt(i + 1);
			// Initialize a new variable called swap that is equal to the value
			// of the trainCardStack room number #index
			MissionCard swap = stack[index];
			// Swap the two values with each other.
			stack[index] = stack[i];
			stack[i] = swap;
			// Go to next iteration of the for loop and repeat the shuffle
	
		}
		
	}
	public void draw(){
		/**
		 * 
		 * draw mission cards to hand stack, not sure if function goes here
		 */
	}
	public boolean isEmpty(){
		
		if(currentAmount == 0){
			return true;
		}else
			return false;
	}

	public MissionCard [] getStack() {
		return stack;
	}

	public void setStack(MissionCard [] stack) {
		this.stack = stack;
	}

}
