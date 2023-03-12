import java.io.*;
import java.net.*;

public class Client {
    public static void main(String [] args){
        String serverName = "localhost";
        int port = Integer.parseInt(args[0]);
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);

            out.println(client.getLocalSocketAddress() + "says Hello");
            InputStream inFromServer = client.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("Server says " + in.readLine());
            client.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
