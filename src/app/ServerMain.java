package app;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) {
        ServerReliable server;
        boolean main = true;
        if(args.length > 0){
            main = false;
        }
        try {
            server = new ServerReliable(main);
            server.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
