package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;

public class PlayerPiece {

	private int totalPoints, xPos, yPos;
	private Color color;
	private Circle playerPiece;

	PlayerPiece(Color color) {
		this.color = color;
		xPos = 18;
		yPos = 632;
		totalPoints = 0;

	}

	public void move(int points) {
		if (xPos == 18 && yPos <= 632 && yPos >= 104) {
			this.yPos -= points * 33;
		}
		if (yPos == 104 && xPos <= 843 && xPos >= 18) {
			this.xPos += points * 33;
		}
		if (xPos == 876 && yPos >= 104 && yPos <= 632) {
			this.yPos += points * 33;
		}
		if (yPos == 665 && xPos <= 876 && xPos > 52) {
			this.xPos -= points * 33;
		}
		if (xPos < 52 && yPos == 665) {
			xPos = 18;
			yPos = 599;
		}
		totalPoints += points;

	}

	public void setVisible(org.newdawn.slick.Graphics g) {
		playerPiece = new Circle(xPos, yPos, 5);
		g.setColor(color);
		g.fill(playerPiece);
		g.draw(playerPiece);

	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getTotalPoints() {
		return totalPoints;
	}
}
