import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    Client c;

    JPanel backgroundPanel = new JPanel();
    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameField = new JTextField("Anonymous", 15);
    JLabel ipLabel = new JLabel("Server IP: ");
    public static JTextField ipField = new JTextField("127.0.0.1", 15);
    JLabel portLabel = new JLabel("Port: ");
    public static JTextField portField = new JTextField("12345", 5);
    public static JTextArea chattArea = new JTextArea(33, 70);
    public static JScrollPane chatPane = new JScrollPane(chattArea);
    public static JScrollBar verticalChatScroll = chatPane.getVerticalScrollBar();
    JTextField chatField = new JTextField(70);

    GUI(Client c) {
        this.c = c;

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(backgroundPanel);
        backgroundPanel.add(nameLabel);
        backgroundPanel.add(nameField);
        backgroundPanel.add(ipLabel);
        backgroundPanel.add(ipField);
        backgroundPanel.add(portLabel);
        backgroundPanel.add(portField);
        backgroundPanel.add(chatPane);
        backgroundPanel.add(chatField);

        chatField.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chatField) {
            c.sendMessage(nameField.getText() + " : " + chatField.getText());
            chatField.setText("");
            verticalChatScroll.setValue(verticalChatScroll.getMaximum());
        }
    }
}
