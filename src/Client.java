import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    PrintWriter out;
    BufferedReader in;
    String hostName = GUI.ipField.getText();
    int portNumber = Integer.parseInt(GUI.portField.getText());

    public Client() throws IOException {
        try (
                Socket addressSocket = new Socket(hostName, portNumber);

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
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
