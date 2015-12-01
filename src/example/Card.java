package example;

import java.awt.image.BufferedImage;

import org.lwjgl.opengl.Drawable;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.sun.corba.se.spi.monitoring.StatisticsAccumulator;

public class Card{
	protected static int height, width;
	protected  int xPos, yPos;
	protected Image frontImage,backImage;
	protected Image displayedImage;
	private int visible=0;
	protected Color color;

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
