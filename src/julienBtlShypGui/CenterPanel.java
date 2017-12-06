package julienBtlShypGui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CenterPanel extends JPanel {
  private MySeaPanel mySea;
//  private ChatPanel chatPanel;
  private JTextArea chatDisplayArea;
  private OpponentPanel opponentSea;

  public CenterPanel() {
    this.mySea = new MySeaPanel();
//    this.chatPanel = new ChatPanel();
    this.opponentSea = new OpponentPanel();
    this.chatDisplayArea = new JTextArea();
    chatDisplayArea.setFont(new Font("Arial", Font.PLAIN, 20));
    //  chatArea.setEditable(false);
  chatDisplayArea.setLineWrap(true);
  chatDisplayArea.setText("Welcome");

    // setLayout(new BorderLayout());
    // add(mySea,BorderLayout.CENTER);
    // add(chatPanel, BorderLayout.WEST);
    // add(opponentSea, BorderLayout.EAST);

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    
    

    // natural height, maximum width
    c.fill = GridBagConstraints.VERTICAL;
    
//    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipadx = -2;
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 0.4;
    c.weighty = 1.0;
    add(mySea, c);
    
    c.fill = GridBagConstraints.VERTICAL;
//    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipadx = 6;
    c.gridx = 1;
    c.gridy = 0;
    c.weightx = 0.2;
    c.weighty = 1.0;
//    add(chatPanel, c);
    add(chatDisplayArea, c);
    
    c.fill = GridBagConstraints.VERTICAL;
//    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipadx = -2;
    c.gridx = 2;
    c.gridy = 0;
    c.weightx = 0.4;
    c.weighty = 1.0;
    add(opponentSea, c);
  }
  
  public void displayChat(String user, String chat) {
    String from = (user == null) ? "******  " : user;
    if(chat!=null &&chat.length()>0) {
      chatDisplayArea.append(from + ": " + chat);
    }
  
  }

}
