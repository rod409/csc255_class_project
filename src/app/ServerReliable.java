package app;
import java.net.*;
import java.io.*;

public class ServerReliable  {
    private boolean backup;
    private ServerSocket welcomeSocket;
    private Socket socket;
    
    public ServerReliable(boolean main) throws IOException{
        this.backup = !main;
    }
    
    public void start() throws IOException, InterruptedException{
        if(backup){
            backup();
        } else {
            run(true);
        }
    }
    
    private void run(boolean writeToBackup) throws IOException{
        welcomeSocket=new ServerSocket(7767);
        HeartBeat pulseThread;
        if(writeToBackup){
            pulseThread = new HeartBeat(InetAddress.getByName("Enter IP address"), 12100);
            pulseThread.run();
        }
        while(true) {
            socket = welcomeSocket.accept();
            System.out.println("Client connected");
          //Todo: Remove second parameter from ServerThread
            new ServerThread(socket, null).start();
        }
    }
    
    private void backup() throws IOException, InterruptedException{
        BufferedReader inFromServer;
        int failCount = 0;
        try {
            welcomeSocket = new ServerSocket(12100);
            socket = welcomeSocket.accept();
            inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                Thread.sleep(100);
                if(inFromServer.ready()){
                    String s = inFromServer.readLine();
                    System.out.println(s);
                    failCount = 0;
                } else {
                    ++failCount;
                    if(failCount == 3){
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
        System.out.println("backup taking over");
        run(false);
    }
}
