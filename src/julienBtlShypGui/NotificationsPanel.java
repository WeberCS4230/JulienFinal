package julienBtlShypGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class NotificationsPanel extends JPanel {
  private JTextArea mySeaNotificatonArea;
  private JTextArea generalNotificatonArea;
  private JTextArea opponentSeaNotificatonArea;
  
  public NotificationsPanel() {
    
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    
    mySeaNotificatonArea = new JTextArea();
    mySeaNotificatonArea.setFont(new Font("Arial", Font.PLAIN, 25));
    mySeaNotificatonArea.setEditable(false);
    mySeaNotificatonArea.setBorder(border);
    
    generalNotificatonArea = new JTextArea();
    generalNotificatonArea.setFont(new Font("Arial", Font.PLAIN, 25));
    generalNotificatonArea.setEditable(false);
    generalNotificatonArea.setBorder(border);
    
    opponentSeaNotificatonArea = new JTextArea();
    opponentSeaNotificatonArea.setFont(new Font("Arial", Font.PLAIN, 30));
    opponentSeaNotificatonArea.setEditable(false);
    opponentSeaNotificatonArea.setBorder(border);
    
    setLayout(new GridLayout(1,3,10,10));
    add(mySeaNotificatonArea);
    add(generalNotificatonArea);
    add(opponentSeaNotificatonArea);
  }
  
  public void resetGame() {
    mySeaNotificatonArea.setText("  Your Sea");
    generalNotificatonArea.setText("\tBtlShyp");
    opponentSeaNotificatonArea.setText("\tOpponent's Sea");
  }
  
  public void notifyMySea(String text) {
    mySeaNotificatonArea.setText(text);
  }
  public void notifyGeneral(String text) {
    generalNotificatonArea.setText(text);
  }
  public void notifyOppSea(String text) {
    opponentSeaNotificatonArea.setText(text);
  }
}


