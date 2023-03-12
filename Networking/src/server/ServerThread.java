package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

//https://www.tutorialspoint.com/javaexamples/net_multisoc.htm
//https://www.geeksforgeeks.org/multithreaded-servers-in-java/
//https://gyawaliamit.medium.com/multi-client-chat-server-using-sockets-and-threads-in-java-2d0b64cad4a7
public class ServerThread extends Thread{
    private Socket socket;
    private ArrayList<ServerThread> threadArrayList;
    private PrintWriter out;
    private BufferedReader in;

    public ServerThread(Socket socketParam, ArrayList<ServerThread> threadsParam){
        this.socket = socketParam;
        this.threadArrayList = threadsParam;
        this.in = null;
        this.out = null;
    }

    public void run() {
        System.out.println(
                "Accepted Client Address - " + socket.getInetAddress().getHostName());
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            for (ServerThread threads : threadArrayList) {
                System.out.println(threads.getId());
            }

            out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;

            while (true) {
                inputLine = in.readLine();

                if (inputLine.equals("END")) {
                    out.println("bye");
                    break;
                }

                out.println(inputLine);

                System.out.println("Received " + inputLine);
//                printToAllClients(inputLine);
            }

            System.out.println("closing...");

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                System.out.println("...Stopped");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printToAllClients(String outputParam){
        for (ServerThread st: threadArrayList){
            st.out.print(outputParam);
        }
    }
}
