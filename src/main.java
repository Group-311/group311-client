import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.google.gson.Gson;

public class main extends JPanel {
	static Board b1;
	
	static Train t;
	static Stack t2;
	static TrainCardStack t3;
	static DisplayedTrainStack t4;
	static HandMissionStack t5;
	static Stack t6;
	static TrainTrashStack t7;
	static Stack t8;
	static Connection t9;
	static PlayerPiece t10;
	
	
	static Town townA,townB;
	
	static Card missionCard;
	
	static ArrayList<Integer> arrayTest;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		main client = new main();

		client.run();
	}

	public void run() throws Exception {

		Socket Sock = new Socket("172.20.10.2", 2222);
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
		
		townA = new Town("Seattle", 6, 92, 542);
		townB = new Town("Portland", 5, 74, 499);
		
		
		missionCard = b1.missionCards[5];
				
		t10 = new PlayerPiece(null, 4);

		
		Gson serializer = new Gson();
		//Gson serializer2 = new GsonBuilder().create();
		

		String json = serializer.toJson(t);
		String json1 = serializer.toJson(t2);
		String json2 = serializer.toJson(t3);
		String json3 = serializer.toJson(t4);
		String json4 = serializer.toJson(t5);
		String json5 = serializer.toJson(t6);
		String json6 = serializer.toJson(t7);
		String json7 = serializer.toJson(t8);
		String json8 = serializer.toJson(t9);
		String json9 = serializer.toJson(t10);
		
		String jsonTest = serializer.toJson(arrayTest);
		String missionTest = serializer.toJson(missionCard);
		

		

		ps.println(activator + "\n" + json +/* "\n" + json1 + "\n"+ json2 + "\n" +json3 + "\n"+json4 + "\n"+json5 + "\n"+json6 + "\n"+json7 +*/ "\n"+missionTest + "\n"+json9 + "\n");

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
