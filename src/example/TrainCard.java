package example;

public class TrainCard extends Card {

	protected Color color;
	
	public TrainCard(){
		
	}
	
	public TrainCard(Color _color){
		
		this.color = _color;
		//this.frontImage = trainImage;
	}
	



	public void playCard(){
		
		
		
		/**
		 * if selected connection color == this.color or this.color == joker color or
		 * selected color == grey
		 * then decrease these cards from the TrainCardHandStack
		 * Add these cards to the TrainTrashStack
		 * Make the connection isTaken true by calling makeTaken();
		 * Give points to the player by accessing playerPiece
		 * Move playerPiece
		 */
	}
}
