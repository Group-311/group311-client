import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Card {

	protected static int height, width;
	protected int xPos, yPos;
	protected Image frontImage, backImage;
	protected Image displayedImage;
	private int visible = 0;
	protected CustomColor color;
	private Town townA, townB;
	
	public Card() {
		
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
		if (visible == 0)
			visible = 1;
		else
			visible = 0;
		System.out.println("Card has been flipped");
		return;
	}

	// Flipping the card from backImage to frontImage to backImage to frontImage etc.
	public void setVisible() {
		if (visible == 0)
			backImage.draw(xPos, yPos, width, height);
		else
			frontImage.draw(xPos, yPos, width, height);
	} 

	// Flipping the card to frontImage
	public void setVisible1() {

		frontImage.draw(xPos, yPos, width, height);

		
	}
	public void setVisible1(Graphics g)
	{
		if (color.getColorName()!=null){
		g.drawString(color.getColorName(), xPos, yPos);
		}
		else 
			g.drawString("waiting", xPos, yPos);
	}

	public void setColor(CustomColor color) {
		this.color = color;
	}

	public CustomColor getColor() {
		return color;
	}

	public boolean areConnected(Players player) {
		return false;
	}
	
	// Drawing strings that provide information on for instance amount of train cards in a specific color
	public void drawTrainCard(Graphics g, String subject, int xP, int yP) {
		g.setColor(new Color(0, 0, 0));
		g.drawString(subject, xP, yP);
	}
	
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	
	public Town getTownA() {
		return townA;
	}


	public Town getTownB() {
		return townB;
	}

	public int getPoints() {
		return 0;
	}
}