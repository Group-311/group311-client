package example;

public class MissionCardStack extends Stack{
	
	private MissionCard [] stack;
	private int currentAmount;

	public MissionCardStack(int _amount) {
		super(_amount);
		
		setStack(new MissionCard [this.getAmount()]);
		
		currentAmount = _amount;
	}
	
	public void shuffle(){
		/**
		 * shuffle the deck
		 */
	}
	public void draw(){
		/**
		 * 
		 * draw mission cards to hand stack, not sure if function goes here
		 */
	}
	public boolean isEmpty(){
		
		if(currentAmount == 0){
			return true;
		}else
			return false;
	}

	public MissionCard [] getStack() {
		return stack;
	}

	public void setStack(MissionCard [] stack) {
		this.stack = stack;
	}

}
