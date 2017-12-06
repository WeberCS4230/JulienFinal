package julienBtlShypGui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatPanel extends JPanel {
  private JTextArea chatDisplayArea;
  public ChatPanel() {
    this.chatDisplayArea = new JTextArea();
    chatDisplayArea.setFont(new Font("Arial", Font.PLAIN, 20));
    chatDisplayArea.setEditable(false);
    chatDisplayArea.setLineWrap(true);
    setLayout(new BorderLayout());

    add(new JScrollPane(chatDisplayArea), BorderLayout.CENTER);
    chatDisplayArea.setMinimumSize(new Dimension(400,900));

  }
  
  public void displayChat(String user, String chat) {
    chatDisplayArea.append("/t"+ user + ": " + chat);
  }
}
