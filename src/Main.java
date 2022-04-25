import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Client c = new Client(args);
        } catch (Exception e) {
            System.out.println("Usage: java Client <host> <port>");
            System.exit(1);
        }
    }
}