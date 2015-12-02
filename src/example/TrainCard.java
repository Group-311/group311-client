package example;

import org.newdawn.slick.SlickException;

public class TrainCard extends Card {
	


	public TrainCard() throws SlickException {
		super();
		
		xPos = 0;
		yPos = 0;
	}

	public TrainCard(CustomColor color) {

		this.color = color;

		// this.frontImage = trainImage;
	}



	public void playCard() {

		/**
		 * if selected connection color == this.color or this.color == joker
		 * color or selected color == grey then decrease these cards from the
		 * TrainCardHandStack Add these cards to the TrainTrashStack Make the
		 * connection isTaken true by calling makeTaken(); Give points to the
		 * player by accessing playerPiece Move playerPiece
		 */
	}
	@Override
	public void setColor(CustomColor color) {
		// TODO Auto-generated method stub
		super.setColor(color);
	}
	@Override
	public CustomColor getColor() {

		// TODO Auto-generated method stub
		return super.getColor();
	}
}
