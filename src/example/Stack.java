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
}