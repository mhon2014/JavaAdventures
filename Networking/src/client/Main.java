package client;
import java.io.*;


public class Main {
    static final int MAX_THREADS = 2;

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8001;
        String address = "localhost";
        while (true) {
            if (ClientThread.threadCount() < MAX_THREADS)
                new ClientThread(address, port);
            Thread.sleep(1000);
        }
    }
}
