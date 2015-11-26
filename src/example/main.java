package example;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.java.swing.plaf.windows.WindowsPasswordFieldUI;

public class main extends JPanel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatagramSocket socket;
		
		
		
		
		
		try
		{	
			socket = new DatagramSocket(); 												//Make a socket
			
			String message = "BigAssCunt"; 												//Creates the message
			
			byte[] b = message.getBytes(); 												//Send the message to be made of bytes
			
			InetAddress host = InetAddress.getByName("172.20.10.2");  					//Put name of the server here
	
			int serverSocket = 1330; 													//name of the port
			
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
	protected void paintComponent(Graphics g)
	{
		
	}

}

