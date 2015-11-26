package example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Stack {

	protected int amount;
	Card[] card;
	
	public Stack(Card[] _cards){
		this.card = _cards;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int _amount) {
		this.amount = _amount;
	}
	
	public Card[] getStack() {
		return this.card;
	}

	public Card setStack(Card[] stack) {
		this.card = stack;
		return null;
	}
	
	public void shuffle(Card[] _cards) {

		// Initialize Random class so it can be used in the following shuffle code
		Random rnd = ThreadLocalRandom.current();

		for (int i = _cards.length - 1; i > 0; i--) {
			// initialize a new variable called index which takes a random value
			// between 0 and i+1 (i+1 = 110 at first iteration of the for loop)
			int index = rnd.nextInt(i + 1);
			// Initialize a new variable called swap that is equal to the value of the stack room number #index
			Card swap = _cards[index];
			// Swap the two values with each other.
			_cards[index] = _cards[i];
			_cards[i] = swap;
			// Go to next iteration of the for loop and repeat the shuffle

		}

	}
}