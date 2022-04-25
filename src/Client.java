import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    PrintWriter out;
    BufferedReader in;

    public Client(String[] args) throws IOException {
        try (
                Socket addressSocket = new Socket(args[0], Integer.parseInt(args[1]));

                PrintWriter printOut = new PrintWriter(addressSocket.getOutputStream(), true);
                BufferedReader readIn = new BufferedReader(
                        new InputStreamReader(addressSocket.getInputStream()));) {

            this.out = printOut;
            this.in = readIn;

            GUI g = new GUI(this);
            while (true) {
                GUI.chattArea.append(readIn.readLine() + "\n");
                GUI.verticalChatScroll.setValue(GUI.verticalChatScroll.getMaximum());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + args[0]);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + args[0]);
            System.exit(1);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
