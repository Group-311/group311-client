package example;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.java.swing.plaf.windows.WindowsPasswordFieldUI;
import com.sun.security.ntlm.Client;

import jdk.nashorn.internal.ir.WhileNode;

public class main extends JPanel {
	static Train t;
static Players p1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		main client = new main();

		client.run();
	}

	public void run() throws Exception {

		Socket Sock = new Socket("172.20.10.2", 2222);
		PrintStream ps = new PrintStream(Sock.getOutputStream());
		String activator = new String("2");

		t = new Train(null);
		t.decrease(3);

		Gson serializer = new Gson();
		String json = serializer.toJson(t);

		ps.println(activator + "\n" + json + "\n");

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
