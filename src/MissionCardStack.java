

public class MissionCardStack extends Stack {

	private MissionCard[] stack;
	private int currentAmount;

	public MissionCardStack(MissionCard[] _cards) {
		super(_cards);

		setStack(new MissionCard[this.getAmount()]);

		currentAmount = _cards.length;
	}

	public void draw() {
		/**
		 * 
		 * draw mission cards to hand stack, not sure if function goes here
		 */
	}

	public boolean isEmpty() {

		if (currentAmount == 0) {
			return true;
		} else
			return false;
	}

	public MissionCard[] getStack() {
		return stack;
	}

	public void setStack(MissionCard[] stack) {
		this.stack = stack;
	}

}
