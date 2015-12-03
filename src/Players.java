

import java.net.*;
import java.util.ArrayList;

public class Players {
	
	public Socket sock;
	public String name;
	public int numOfTrains;
	private ArrayList<MissionCard> handOfMissions = new ArrayList<MissionCard>();
	private ArrayList<TrainCard> handOfTrainCards = new ArrayList<TrainCard>();
	boolean canPlay = false;
	private CustomColor playerColor;
	private int playerNum;
	
	
	public Players(Socket sock, int playerNum, CustomColor c) {
		
		playerColor = c;
		this.sock = sock;
		this.playerNum = playerNum;
	}
	
	public CustomColor getCustomColor(){
		return playerColor;
	}
	
	public int getNum(){
		return playerNum;
	}

	public int getNumOfTrains() {
		return numOfTrains;
	}

	public void setNumOfTrains(int numOfTrains) {
		this.numOfTrains = numOfTrains;
	}

	public ArrayList<MissionCard> getHandOfMissions() {
		return handOfMissions;
	}

	public void setHandOfMissions(ArrayList<MissionCard> handOfMissions) {
		this.handOfMissions = handOfMissions;
	}

	public ArrayList<TrainCard> getHandOfTrainCards() {
		return handOfTrainCards;
	}

	public void setHandOfTrainCards(ArrayList<TrainCard> handOfTrainCards) {
		this.handOfTrainCards = handOfTrainCards;
	}
	
	//Add one or two train cards to player hand
	public void AddTrainCard(TrainCard TC)
	{
		handOfTrainCards.add(TC);
	}
	
	public void AddTrainCard(TrainCard TC1, TrainCard TC2)
	{
		handOfTrainCards.add(TC1);
		handOfTrainCards.add(TC2);
	}
	
	// add 1-3 mission cards
	public void AddMissionCard(MissionCard MC)
	{
		handOfMissions.add(MC);
	}
	
	public void AddMissionCard(MissionCard MC1, MissionCard MC2)
	{
		handOfMissions.add(MC1);
		handOfMissions.add(MC2);
	}
	
	public void AddMissionCard(MissionCard MC1, MissionCard MC2, MissionCard MC3)
	{
		handOfMissions.add(MC1);
		handOfMissions.add(MC2);
		handOfMissions.add(MC3);
	}
	
	
	//
	
	
	
	

}
