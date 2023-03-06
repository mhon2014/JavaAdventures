
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.*;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class FilesAndAPI {
    public static void main(String[] args) throws InterruptedException, IOException {

//        System.out.println("HALOOOOO");
        System.out.println(System.getProperty("user.dir"));

//        Path path = Path.of("./test.txt");

//        boolean exists = Files.exists(path);
//        System.out.println("exists = " + exists);


        System.out.println("\nSynchronus");
        synchronousRequest();



        System.out.println("\nAsynchronus");
        asynchronousRequest();
    }

    public static void asynchronousRequest() throws IOException{
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(
                        URI.create("https://fakerapi.it/api/v1/images?_quantity=1&_type=any"))
                .timeout(Duration.of(10, SECONDS))
                .GET()
                .build();


        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
                .join();

        System.out.println("printing between async");


        //  raw stream data
        FileOutputStream fout=new FileOutputStream("async.txt");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(response);
        out.flush();
        //closing the stream
        out.close();

        System.out.println(response);

    }

    public static void synchronousRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://fakerapi.it/api/v1/images?_quantity=1&_type=any"))
                .timeout(Duration.of(10, SECONDS))
                .GET()
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        Path file = Paths.get("./sync.txt");

        System.out.println(response.body());

        Files.write(file, response.body().getBytes());

    }
}
