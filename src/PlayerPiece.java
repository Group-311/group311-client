

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;

public class PlayerPiece {

	private int totalPoints, xPos, yPos;
	private Color color;
	private Circle playerPiece;
	private int playerNum;

	PlayerPiece(Color color, int playerNum) {
		this.color = color;
		xPos = 10 + playerNum * 4;
		yPos = 632;
		totalPoints = 0;
		this.playerNum = playerNum;

	}

	public void move(int points) {
		for (int i = 0; i < points; i++) {
			if (xPos == 10 + playerNum * 4 && yPos > 104) {
				this.yPos -= 33;
			}
			if (yPos == 104 && xPos < 843 + playerNum*4) {
				this.xPos += 33;
			}
			if (xPos == 868 + playerNum*4) {
				this.yPos += 33;
			}
			if (yPos == 665 ) {
				this.xPos -= 33;
			}
			if (xPos < 52 + playerNum*4 && yPos == 665) {
				xPos = 10 + playerNum*4;
				yPos = 599;
			}
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

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getTotalPoints() {
		return totalPoints;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
