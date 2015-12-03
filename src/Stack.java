

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Color;

public class Stack extends Card {

	protected int amount;
	Card[] cardT, cardM;
	public static final int TCARDS = 96; 	// Train cards in total - no jokers

	/*
	 * Card array called trainCards that should include 96 cards
	 */
	private Card[] trainCards, missionCards;
	/*
	 * Card array list called listOfTraincards that should copy all the cards from the Card[] trainCards
	 */
	private ArrayList<Card> listOfTraincards = new ArrayList<Card>();
	
	/*
	 * Card array list called listOfTraincards that should copy all the cards from the Card[] trainCards
	 */
	private ArrayList<Card> listOfMissioncards = new ArrayList<Card>();
	
//	/*
//	 * Stack constructer 1
//	 */
//	public Stack() {
//		trainCards = new Card[TCARDS]; // Card[] trainCards has 96 Card objects in total
//		int i = 0; // Goes through the trainCards rooms
//
//		/*
//		 * This for loop goes through the different kinds of suits from PINK to
//		 * GREEN - see the Card class for more information It also goes through
//		 * the ranks 1 to 12 because there are 12 of each card All the array
//		 * positions in trainCards will have a card now ranging from the 1st
//		 * pink card to the last green card
//		 */
//		for (int suit = Card.PINK; suit <= Card.GREEN; suit++) {
//			for (int rank = 1; rank <= 12; rank++) {
//				trainCards[i++] = new Card(suit, rank);
//			}
//		}
//
//		/*
//		 * The array list called listOfTraincards will now add all the Cards from the
//		 * trainCards array. Thus, the array list will copy all the cards from
//		 * the trainCards array including the same array positions
//		 */
//		for (int j = 0; j < trainCards.length; j++) {
//			listOfTraincards.add(trainCards[j]);
//		}
//	}
	
	/*
	 * Stack constructer 2 for mission cards
	 */
	public Stack(Card[] _cards, int a) {
		this.cardM = _cards;
		
		for(int j = 0; j < cardM.length; j++) {
			listOfMissioncards.add(cardM[j]);
		}
	}
	
	/*
	 * Stack constructer 3 for train cards
	 */
	public Stack(Card[] _cards){
		this.cardT = _cards;
		
//		int i = 0;
//		for (int suit = Card.PINK; suit <= Card.GREEN; suit++) {
//			for (int rank = 1; rank <= 12; rank++) {
//				card[i].suit();
//				card[i].rank();
//			}
//		}

		/*
		 * The array list called listOfTraincards will now add all the Cards from the
		 * trainCards array. Thus, the array list will copy all the cards from
		 * the trainCards array including the same array positions
		 */
		for (int j = 0; j < cardT.length; j++) {
			listOfTraincards.add(cardT[j]);
		}
	}
	
	/*
	 * Shuffle function for the array list that should be used after assigning the trainCards values to the listOfTraincards 
	 */
	public void shuffleA(int n) {
		int i, j, k;

		for (k = 0; k < n; k++) {
			i = (int) (TCARDS * Math.random()); // Pick 2 random cards
			j = (int) (TCARDS * Math.random()); // in the deck
			/*
			 * swap these randomly picked cards
			 */
			Card tmp = listOfTraincards.get(i);
			listOfTraincards.set(i, listOfTraincards.get(j));
			listOfTraincards.set(j, tmp);
		}
	}
	
	/*
	 * Shuffle function for the array list that should be used after assigning the missionCards values to the listOfMissioncards
	 */
	public void shuffleB(Card[] _cards, int n) {
		this.cardM = _cards;
		int i, j, k;

		for (k = 0; k < n; k++) {
			i = (int) (cardM.length * Math.random()); // Pick 2 random cards
			j = (int) (cardM.length * Math.random()); // in the deck
			/*
			 * swap these randomly picked cards
			 */
			Card tmp = listOfMissioncards.get(i);
			listOfMissioncards.set(i, listOfMissioncards.get(j));
			listOfMissioncards.set(j, tmp);
		}
	}
	
	/*
	 * toString method that prints the array data, meaning the cards rank and suit
	 */
	public String toString() {
		String s = "";
		int k;

		k = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 1; j <= 12; j++)
				s += (trainCards[k++] + " ");

			s += "\n";
		}
		return (s);
	}

	/*
	 * ArrayList<Card> get function to be able to get the arraylist data
	 */
	public ArrayList<Card> getdeckOfA() {
		return listOfTraincards;
	}
	
	/*
	 * ArrayList<Card> get function to be able to get the arraylist data
	 */
	public ArrayList<Card> getdeckOfB() {
		return listOfMissioncards;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int _amount) {
		this.amount = _amount;
	}
	
	public Card[] getStack() {
		return this.cardT;
	}

	public Card setStack(Card[] stack) {
		this.cardT = stack;
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