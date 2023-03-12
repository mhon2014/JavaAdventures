import java.net.*;
import java.io.*;
public class Server extends Thread{
    // File Name GreetingServer.java
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket clientSocket = serverSocket.accept();

                System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF("Thank you for connecting to " + clientSocket.getLocalSocketAddress()
                        + "\nGoodbye!");
                clientSocket.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String [] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new Server(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
