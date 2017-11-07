package app;
import java.net.*;
import java.io.*;
import java.util.*;

public class ServerThread extends Thread {
	protected Socket socket;
    protected Map<Integer, ServerThread> m;

	public ServerThread(Socket clientSocket, Map<Integer, ServerThread> m) {
		this.socket = clientSocket;
        this.m = m;
	}

	public void run() {

		try {
			String hostname;
			System.out.println("Client connected - in thread");
			BufferedReader inFromClient=new BufferedReader(new
					InputStreamReader(socket.getInputStream()));
			DataOutputStream outToClient=new
				DataOutputStream(socket.getOutputStream());
			/* recieve input from client */
			hostname=inFromClient.readLine();
			try {
				//outToClient.writeBytes(capitalizedSentence);
				InetAddress ipaddress = InetAddress.getByName(hostname);
				/* send IP address for the input hostname */ 
				outToClient.writeBytes(ipaddress.getHostAddress() + "\n");
			} catch(Exception e) {
				outToClient.writeBytes("Error"+"\n");
			} 
		}catch ( Exception e ) {
			//outToClient.writeBytes("Error"+"\n");
		}
	}
}
