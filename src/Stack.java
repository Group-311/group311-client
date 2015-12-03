import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Stack extends Card {

	Card[] cardT, cardM;					// cardT used for constructing train card stack array list and cardM used for constructing and shuffling mission card stack array list
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
	
	/*
	 * Stack constructer 1 for mission cards
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
	 * Shuffle function for the array list that should be used after assigning
	 * the trainCards values to the listOfTraincards
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
	 * Shuffle function for the array list that should be used after assigning
	 * the missionCards values to the listOfMissioncards
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
	 * toString method that prints the array data, meaning the cards rank and
	 * suit
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
	
	// Getter and setter for amount
	public Card[] getStack() {
		return this.cardT;
	}

	public Card setStack(Card[] stack) {
		this.cardT = stack;
		return null;
	}
}