import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import com.google.gson.Gson;
import com.sun.corba.se.spi.servicecontext.SendingContextServiceContext;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Message1_1Impl;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;

public class main extends JPanel {
	static Board b1;
	
	public static Train t;
	public static Stack t2;

	public static Stack t6;

	public static Stack t8;
	public static Connection t9;
	public static PlayerPiece t10;
	
	public static Card m1;
	
	public static Town townA,townB;
	
	public static Card missionCard;
	
	public static ArrayList<Integer> arrayTest;
	
	public static Town tempCityB, tempCityA;
	public static Card tempCard;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		main client = new main();
		
		client.run();
	}

	public void run() throws Exception {

		Socket Sock = new Socket("192.168.43.8", 2222);
		PrintStream ps = new PrintStream(Sock.getOutputStream());
		String activator = new String("1");
		b1 = new Board(4);
		
		t = new Train(null);
		t.decrease(3);
		//t2 = new Stack(null);
		//t3 = new TrainCardStack(null);
		//t4 = new DisplayedTrainStack(null);
		//t5 = new HandMissionStack(5);
		//t6 = new Stack(null);
		//t7 = new TrainTrashStack(5);
		//t8 = new Stack(5);
		//t9 = new Connection(null, b1.towns[1], b1.towns[2], 5, 6);
		arrayTest = new ArrayList<Integer>();
		arrayTest.add(2);
		arrayTest.add(5);
		arrayTest.add(100);
		
	
		
		
	
		
		t10 = new PlayerPiece(null, 4);

		
		Gson serializer = new Gson();
		//Gson serializer2 = new GsonBuilder().create();
		
		
		String json = serializer.toJson(t);
		String json1 = serializer.toJson(t2);


		String json5 = serializer.toJson(t6);

		String json7 = serializer.toJson(t8);
		String json8 = serializer.toJson(t9);
		String json9 = serializer.toJson(t10);
		
		String jsonTest = serializer.toJson(arrayTest);
		String missionTest = serializer.toJson(new MissionCard(new Town(b1.towns[1].getName(), 4, b1.connections.get(1).getTownA().getxPos(), b1.towns[1].getyPos()), new Town(b1.towns[4].getName(), 6, b1.towns[4].getxPos(), b1.towns[4].getxPos()), 2));
		//String townTest = serializer.toJson(new Town(b1.towns[1].getName(), 5, 74, 499));
	
		//jsonTest2=null;
//

		/* String jsonTest2 = serializer.toJson(
					new Connection(
					new CustomColor("red",
							 2, 
							 new Color(255,0,0)), 
					 
					new Town("piK", 
							2, 
							3, 
							4), 
					
					new Town("fisse", 
							5, 
							6, 
							7), 
					
					8, 
					9,1));*/
		 String jsontest2 = null;
		 String[] jsontest3 = new String[b1.connections.size()];
		 
		 
		 //sending the connections into a array of Strings.
		for (int i=0; i<b1.connections.size(); i++){
			
	   String temp = serializer.toJson(
			new Connection(
			new CustomColor(b1.connections.get(i).getColor().getColorName(),
					 b1.connections.get(i).getColor().getColorNum(), 
					 b1.connections.get(i).getColor().getColor()), 
			 
			new Town(b1.connections.get(i).getTownA().getName(), 
					b1.connections.get(i).getTownA().getAmountOfConnections(), 
					b1.connections.get(i).getTownA().getxPos(), 
					b1.connections.get(i).getTownA().getyPos()), 
			
			new Town(b1.connections.get(i).getTownB().getName(), 
					b1.connections.get(i).getTownB().getAmountOfConnections(), 
					b1.connections.get(i).getTownB().getxPos(), 
					b1.connections.get(i).getTownB().getyPos()), 
			
			b1.connections.get(i).getLength(), 
			b1.connections.get(i).getPoint(),1));
	   
	   jsontest3[i]=temp;
		
			   
}
		
		//Sending all the traincard from the traincardstack to the arraystring
		String[] jsonTCS = new String[b1.arrayOfTrainCards.size()];
		System.out.println(b1.arrayOfTrainCards.size());
			
		for (int i =0; i<b1.arrayOfTrainCards.size(); i++)
		{
			String temp = serializer.toJson(b1.arrayOfTrainCards.get(i));
			jsonTCS[i]=temp;
		}
		System.out.println(jsonTCS[4]);
		
		/*
		//DisplayedTrainStack to JSON string
		String[] jsonDTS = new String[b1.displayedTrainStack.size()];;
		for (int i=0; i<b1.displayedTrainStack.size(); i++)
		{
			String temp = serializer.toJson(b1.displayedTrainStack.get(i));
			jsonDTS[i] = temp;
		}
		
		//DisplayedMissionStack to JSON string
		String[] jsonMCS = new String[b1.displayedMissionStack.size()];;
		for (int i=0; i<b1.displayedMissionStack.size(); i++)
		{
			String temp = serializer.toJson(b1.displayedMissionStack.get(i));
			jsonMCS[i] = temp;
			
		}
		
		//PlayerPiece to JSON string
		String[] jsonPlP = new String[b1.players.length];;
		for (int i =0; i<b1.players.length; i++)
			{
			String temp = serializer.toJson(b1.players[i]);
			jsonPlP[i]=temp;
			}*/
		
		//Trains to JSON
		//String[] jsonTra = null;
		
		
		//Player to Json
		
		//TrashTrainCard to JSON
		
		//TrashMissionCard to JSON
		
		//MissionCards on hand to JSON
		
		//TrainCards on hand to JSON
		
		
		
		
		
		//-----------------------------------------------------------------------------------------------------------------------
		//This is where we start sending the JSONS
		ps.println(activator +"\n");


		//Sending all the connections.
		for (int i=0; i<b1.connections.size();i++)
		{
		ps.println(jsontest3[i]);
			//ps.println(activator + "\n" + jsontest3[i] +/* "\n" + json1 + "\n"+ json2 + "\n" +json3 + "\n"+json4 + "\n"+json5 + "\n"+json6 + "\n"+json7 +*/ "\n"+ jsontest3[5] + "\n"+json9 + "\n");
		}
					
		//sending the arrayoftraincards.
		for (int i =0; i<b1.arrayOfTrainCards.size();i++)
		{
			ps.println(jsonTCS[i]);
		}
		/*
		//Sending displayedTrainStack
		for (int i=0; i<b1.displayedTrainStack.size(); i++)
		{
			ps.println(jsonDTS[i] + "\n");
		}
		
		//Sending the missionCardStack
		for (int i=0; i<b1.displayedMissionStack.size(); i++)
		{
			ps.println(jsonMCS[i] + "\n");
		}
		
		//Sending the playerpieces
		for (int i =0; i<b1.players.length; i++)
		{
			ps.println(jsonPlP[i] + "\n");
		}*/
		

		
		
		InputStreamReader ir = new InputStreamReader(Sock.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		while (true) {
			String Message = br.readLine();
			System.out.println(Message);
		}
	}
}


// Commenting this out and trying with an alternative
/*
 * DatagramSocket socket;
 * 
 * 
 * 
 * 
 * 
 * try { socket = new DatagramSocket(); //Make a socket
 * 
 * String message = "BigAssCunt"; //Creates the message
 * 
 * byte[] b = message.getBytes(); //Send the message to be made of bytes
 * 
 * InetAddress host = InetAddress.getByName("172.20.10.2"); //Put name of the
 * server here
 * 
 * int serverSocket = 2222; //name of the port
 * 
 * DatagramPacket request = new DatagramPacket(b,b.length,host,serverSocket);
 * //Creating packet
 * 
 * socket.send(request); //sending the packet
 * 
 * 
 * //****************************************************************** byte []
 * buffer = new byte[1000];
 * 
 * DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
 * 
 * socket.receive(reply);
 * 
 * System.out.println(new String(reply.getData()));
 * 
 * 
 * socket.close();
 * 
 * } catch (Exception ex) {
 * 
 * } } protected void paintComponent(Graphics g) {
 * 
 * }
 * 
 * }
 */
