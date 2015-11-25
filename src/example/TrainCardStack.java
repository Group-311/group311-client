package example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class TrainCardStack extends Stack {

	private TrainCard[] stack;
	private int currentAmount;

	public TrainCardStack(int _amount) {
		super(_amount);

		setStack(new TrainCard[this.getAmount()]);
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