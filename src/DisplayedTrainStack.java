

public class DisplayedTrainStack extends Stack {
	
	private TrainCard[] stack;
	private int currentAmount, numberOfJokers;

	public DisplayedTrainStack(TrainCard[] _cards) {
		super(_cards);
		
		stack = new TrainCard [this.getAmount()];
		
		currentAmount = _cards.length;
	}
	
	public void draw (){
		/**
		 * again, a function that exists in a few places, unsure where to do this
		 */
	}
	
	public void checkIfThreeJokers(){
		
		
		
		
		/**
		 * 
		 * gets called every time there are new cards in the stack, if there are three jokers
		 * then call discard and replenish all
		 */
	}
	public void discardStack (){
		/**
		 * 
		 * 
		 * add the entire stack to trash, delete entire stack, call replenishAll
		 */
		
	}
	public void replenish(TrainCardStack _tcs){
		
		TrainCard tc = _tcs.getStack()[0];
		
		/**
		 * replenish one card to the five visible ones
		 */
		this.checkIfThreeJokers();
	
	}
	public void replenishAll(){
		/**
		 * replenish all 5 cards due to 3 jokers
		 */
		
	}
	
}
