package example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatagramSocket socket;
		
		Connection c1 = new Connection(new Color(), new Town(), new Town(), 4, 7);
		
		
		
		try
		{	
			socket = new DatagramSocket(); 												//Make a socket
			
			String message = "BigAssCunt"; 												//Creates the message
			
			byte[] b = message.getBytes(); 												//Send the message to be made of bytes
			
			InetAddress host = InetAddress.getByName("172.20.10.3");  					//Put name of the server here
	
			int serverSocket = 2000; 													//name of the port
			
			DatagramPacket request = new DatagramPacket(b,b.length,host,serverSocket); 	//Creating packet
			
			socket.send(request); 														//sending the packet
			
			
			//******************************************************************
			byte [] buffer = new byte[1000]; 
			
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			
			socket.receive(reply);
			
			System.out.println(new String(reply.getData()));
			
			
			socket.close();
		
		}
		catch (Exception ex)
		{
			
		}
	}

}

