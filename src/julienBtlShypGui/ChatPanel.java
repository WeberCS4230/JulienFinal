package julienBtlShypGui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatPanel extends JPanel {
  private JTextArea chatArea;
  public ChatPanel() {
    this.chatArea = new JTextArea();
    chatArea.setFont(new Font("Arial", Font.PLAIN, 20));
//    chatArea.setEditable(false);
    chatArea.setLineWrap(true);
    setLayout(new BorderLayout());

    add(new JScrollPane(chatArea), BorderLayout.CENTER);
    chatArea.setMinimumSize(new Dimension(400,900));

  }
}
