package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String [] args){
        boolean ServerOn = true;

        int PORT = 8001;

        ArrayList<ServerThread> threadList = new ArrayList<>();
        System.out.println("Server starting...");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch(IOException e) {
            System.out.println("Could not create server socket on port "+PORT+". Quitting.");
            System.exit(-1);
        }

        System.out.println("Server running at " + PORT);
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(
                "E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("It is now : " + formatter.format(now.getTime()));
        while(ServerOn){
            Socket socket;
            try {
                socket= serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, threadList);
                serverThread.start();
                threadList.add(serverThread);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
         try{
            serverSocket.close();
        }catch (IOException e){
             e.printStackTrace();
        }


    }
}
