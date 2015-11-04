package example;

public class MissionCardStack extends Stack{
	
	private MissionCard [] stack;
	private int currentAmount;

	public MissionCardStack(int _amount) {
		super(_amount);
		
		stack = new MissionCard [this.getAmount()];
	}
	
	

}
