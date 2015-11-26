package example;

public class MissionTrashStack extends Stack {
	
	private MissionCard [] stack;
	private int currentAmount;

	public MissionTrashStack(int _amount) {
		super(_amount);
		
		stack = new MissionCard [this.getAmount()];
	}
	
	public void checkMissionStack(MissionCardStack _mss){
		if( _mss.isEmpty() ){
			this.shuffle();
			this.returnToStack(_mss);
		}
	}
	public void shuffle(){
		/**
		 * shuffle the deck
		 */
	}
	public void returnToStack(MissionCardStack _mss){
		for(int i = 0; i < _mss.getStack().length; i++){
			_mss.getStack()[i] = this.stack[i];
		}
	}

}
