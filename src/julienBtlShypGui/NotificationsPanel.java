package julienBtlShypGui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NotificationsPanel extends JPanel {
  private JTextArea mySeaNotificatonArea;
  private JTextArea generalNotificatonArea;
  private JTextArea opponentSeaNotificatonArea;
  
  public NotificationsPanel() {
    mySeaNotificatonArea = new JTextArea();
    mySeaNotificatonArea.setFont(new Font("Arial", Font.PLAIN, 30));
    mySeaNotificatonArea.setEditable(false);
    
    generalNotificatonArea = new JTextArea();
    generalNotificatonArea.setFont(new Font("Arial", Font.PLAIN, 30));
    generalNotificatonArea.setEditable(false);
    
    opponentSeaNotificatonArea = new JTextArea();
    opponentSeaNotificatonArea.setFont(new Font("Arial", Font.PLAIN, 30));
    opponentSeaNotificatonArea.setEditable(false);
    
    setLayout(new GridLayout(1,3,10,10));
    add(mySeaNotificatonArea);
    add(generalNotificatonArea);
    add(opponentSeaNotificatonArea);
   
    String text = "\tTest Message Here";
    mySeaNotificatonArea.setText(text);
    generalNotificatonArea.setText(text);
    opponentSeaNotificatonArea.setText(text);
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


