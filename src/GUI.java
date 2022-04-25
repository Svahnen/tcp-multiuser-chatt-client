import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    Client c;

    JPanel backgroundPanel = new JPanel();
    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameField = new JTextField("Anonymous", 15);
    public JTextArea chattArea = new JTextArea(33, 70);
    public JScrollPane chatPane = new JScrollPane(chattArea);
    public JScrollBar verticalChatScroll = chatPane.getVerticalScrollBar();
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
        backgroundPanel.add(chatPane);
        backgroundPanel.add(chatField);

        chatField.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chatField) {
            if (!chatField.getText().equals("")) {
                c.sendMessage(nameField.getText() + ": " + chatField.getText());
                chatField.setText("");
                verticalChatScroll.setValue(verticalChatScroll.getMaximum());
            }
        }
    }
}
