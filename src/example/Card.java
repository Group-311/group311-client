package example;

import java.awt.image.BufferedImage;

import org.lwjgl.opengl.Drawable;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.sun.corba.se.spi.monitoring.StatisticsAccumulator;

public class Card{
	/*
	 * Overview:
	 *      Suit: 8 = GREEN, 7 = RED, 6 = BLACK, 5 = ORANGE, 4 = YELLOW, 3 = BLUE, 2 = WHITE, 1 = PINK
	 *      
	 *      Rank:  1 - 12
	 *      
	 *      Card:
	 *      byte cardSuit;                -- contain 1, 2, 3, 4, 5, 6, 7 or 8
	 *      byte cardRank;                -- contain 1, 2, ... 11, 12
	 */
	public static final int GREEN = 8;
	public static final int RED = 7;
	public static final int BLACK = 6;
	public static final int ORANGE = 5;
	public static final int YELLOW = 4;
	public static final int BLUE = 3;
	public static final int WHITE = 2;
	public static final int PINK = 1;

	private static final String[] Suit = { "*", "PINK", "WHITE", "BLUE", "YELLOW", "ORANGE", "BLACK", "RED", "GREEN" };
	private static final String[] Rank = { "*", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	private byte cardSuit;
	private byte cardRank;
	
	protected static int height, width;
	protected  int xPos, yPos;
	protected Image frontImage,backImage;
	protected Image displayedImage;
	private int visible=0;
	protected Color color;
	
	/*
	 * Card constructer. 
	 */
	public Card(int suit, int rank) {
		if (rank == 1)
			cardRank = 1; // Give last train the rank 12
		else
			cardRank = (byte) rank;

		cardSuit = (byte) suit;
	}
	
	public Card() {
		
	}

	public int suit() {
		return (cardSuit); // This is a shorthand for:
							// this.cardSuit
	}

	public int rank() {
		return (cardRank);
	}

	public String toString() {
		return (Rank[cardRank] + Suit[cardSuit]);
	}

	public void setFrontImage(Image frontImage) throws SlickException {
		this.frontImage = frontImage;
	}
	public Image getFrontImage() {
		return frontImage;
	}

	public void setBackImage(Image backImage) throws SlickException {
		this.backImage = backImage;
	}
	public Image getBackImage() {
		return backImage;
	}

	public static void setWidth(int width) {
		Card.width = width;
	}
	public static int getWidth() {
		return width;
	}
	
	public static void setHeight(int height) {
		Card.height = height;
	}
	public static int getHeight() {
		return height;
	}
	
	public void flipCard() {
		if (visible==0)
			visible=1;
		else
			visible=0;
	System.out.println("Card has been flipped");
		return;
	}
	
	public void setVisible(){
		if (visible==0)
			backImage.draw(xPos,yPos,width,height);
		else
			frontImage.draw(xPos,yPos,width,height);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	
	public boolean areConnected(){
		return false;
	}

}
