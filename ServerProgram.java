/* 
Author: Anju Geetha Nair
The following code is a server program which receives
host name strings from clients and sends back the
IP address of the host to client using nslookup.
*/
import java.net.*;
import java.io.*;
import java.util.*;

/** The Server accepts connections at TCP port 7777.
*/
class ServerProgram{
	public static void main(String[] argv) throws IOException {
		Map<Integer, ServerThread> m = new HashMap<Integer, ServerThread>();
		String hostname;
		/* Create socket */
		ServerSocket welcomeSocket=new ServerSocket(7767);
		Socket socket=null;
		while(true) {	

			try {
				socket = welcomeSocket.accept();
			} catch (IOException e) {
				System.out.println("I/O error: " + e);
			}
			System.out.println("Client connected");
			// new thread for a client
			new ServerThread(socket, m).start();
		}
	}
}
