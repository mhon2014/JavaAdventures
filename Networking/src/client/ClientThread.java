package client;

import java.io.*;
import java.net.*;


class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int counter = 0;
    private int id = counter++;
    private static int threadcount = 0;
    public static int threadCount() {
        return threadcount;
    }
    public ClientThread(String addressParam, int portParam) {
        System.out.println("client " + id);
        threadcount++;
        try {
            socket = new Socket(addressParam, portParam);

        } catch(IOException e) {
            //empty exception
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            start();
        } catch(IOException e) {
            //close socket on failure
            try {
                socket.close();
            } catch(IOException e2) { //
                // empty exception
                }
        }
    }
    public void run() {
        try {
            for(int i = 0; i < 6; i++) {
                out.println("Client " + id + ": " + i);
                String str = in.readLine();
                System.out.println(str);
                System.out.println("Hello");
            }
            out.println("END");
        } catch(IOException e) {
            //empty exception
        } finally {
            try {
                socket.close();
            } catch(IOException e) {
                //empty exception
            }
            threadcount--;
        }
    }
}
