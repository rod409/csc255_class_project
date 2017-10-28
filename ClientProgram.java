/* 
Author: Anju Geetha Nair
The following code is a client program which send
host name strings to a TCP client and receives back the
IP address of the host. */
import java.io.*;
import java.net.*;
import java.util.*;
/** TCP Client opens a connection to a server that is listening for connection
  requests at port 7777 on "localhost". It reads input from user, sends it to the server,
  which returns a capitalized form of the sentence. The client then displays the returned
  sentence
  */
class ClientProgram{
	public static void main(String[] argv)throws Exception{
		String hostname;  //Holds user input hostname
		String nslookup;  //Holds ipaddress sent from server
		/* inFromUser object for instream from user */
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		/*Client socket with hostip and port created */
		//for(int i=0;i<10000000;i++) {
			Socket clientSocket=new Socket("localhost",7767);
			DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer=new BufferedReader(new
					InputStreamReader(clientSocket.getInputStream()));
			hostname = inFromUser.readLine(); 
			outToServer.writeBytes(hostname+"\n");
			/* Read from server input stream */
			nslookup=inFromServer.readLine();
			System.out.println("\nFrom Server----->"+nslookup);
			clientSocket.close();
	}
}
