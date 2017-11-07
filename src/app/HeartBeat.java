package app;

import java.io.*;
import java.net.*;

public class HeartBeat extends Thread{
    private Socket echoSocket;
    private DataOutputStream out;
    
    public HeartBeat(InetAddress ip, int port) throws IOException{
        echoSocket = new Socket(ip, port);
        out=new DataOutputStream(echoSocket.getOutputStream());
    }
    
    public void run(){
        while(true) {
            try {
                Thread.sleep(100);
                out.writeChars("running\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
