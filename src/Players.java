

import java.net.*;
import java.util.ArrayList;


public class Players {
	
	public Socket sock;
	public int playerNum;
	public int numOfTrains = 45;
	public ArrayList<Card> handOfMissions = new ArrayList<Card>();
	public ArrayList<Card> handOfTrainCards = new ArrayList<Card>();
	CustomColor playerColor;
	boolean canPlay = false;
	
	//add socket sock 
	public Players(int playerNum, CustomColor c) {
		
		//this.sock = sock;
		this.playerNum = playerNum;
		this.playerColor = c;
	}
	
	

	
	
	public Socket getSock() {
		return sock;
	}





	public void setSock(Socket sock) {
		this.sock = sock;
	}





	public int getNumOfTrains() {
		return numOfTrains;
	}



	public ArrayList<Card> getHandOfMissions() {
		return handOfMissions;
	}





	public void setHandOfMissions(ArrayList<Card> handOfMissions) {
		this.handOfMissions = handOfMissions;
	}





	public ArrayList<Card> getHandOfTrainCards() {
		return handOfTrainCards;
	}





	public void setHandOfTrainCards(ArrayList<Card> handOfTrainCards) {
		this.handOfTrainCards = handOfTrainCards;
	}





	public CustomColor getPlColor() {
		return playerColor;
	}





	public void setPlColor(CustomColor playerColor) {
		this.playerColor = playerColor;
	}





	//Add one or two train cards to player hand
//	public void AddTrainCard(Card TC)
//	{
//		handOfTrainCards.add(TC);
//	}
	
	public void AddTrainCard(Card TC1, Card TC2)
	{
		handOfTrainCards.add(TC1);
		handOfTrainCards.add(TC2);
	}
	
	public void AddTrainCard(Card TC1, Card TC2, Card TC3, Card TC4)
	{
		handOfTrainCards.add(TC1);
		handOfTrainCards.add(TC2);
		handOfTrainCards.add(TC3);
		handOfTrainCards.add(TC4);
	}
	
	 //add 1-3 mission cards
	public void AddMissionCard(Card MC)
	{
		handOfMissions.add(MC);
	}
	
	public void AddMissionCard(Card MC1, Card MC2)
	{
		handOfMissions.add(MC1);
		handOfMissions.add(MC2);
	}
	
//	public void AddMissionCard(Card MC1, Card MC2, Card MC3)
//	{
//		handOfMissions.add(MC1);
//		handOfMissions.add(MC2);
//		handOfMissions.add(MC3);
//	}
//	
	
	
	public void removeTrainCard(String color, int num)
	{
		boolean go = false;	//to check that there's enough desired colors in hand
		int count = 0;
		for(int i = 0; i<handOfTrainCards.size(); i++ )
		{
			if(handOfTrainCards.get(i).getColor().getColorName() == color)
			{
				count++;
				if(count == num)
				{
					go = true;
					
				}
				
			}
		}
		if(!go)
		{
			System.out.println("Not enough colors to perform this action!");
		}
		
		if(go)
			
		{
			
			count = 0;
			
			for(int i = handOfTrainCards.size()-1; i>=0; i-- )
			{
				
				if(handOfTrainCards.get(i).getColor().getColorName() == color && count < num)
				{
					
					handOfTrainCards.remove(i);
					System.out.println("removed "+i);
					count++;
					System.out.println("count= "+count);
					
					System.out.println(handOfTrainCards.size());

				}
				
			}
			
			numOfTrains -= num;
		}
		
	}
	

public int numOfColor(String color)
{
	int count = 0;
	
	for(int i = 0; i<handOfTrainCards.size(); i++)
	{
		if(handOfTrainCards.get(i).getColor().getColorName() == color)
		{
			count++;
		}
	}
	return count;
}

}
