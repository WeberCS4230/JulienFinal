package julienBtlShypGui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class BtlView extends JFrame{
  private NotificationsPanel notificationsPanel;
  private CenterPanel centerPanel;
  
  public BtlView() {
    super();
    
    setLayout(new BorderLayout());
    
    notificationsPanel = new NotificationsPanel();
    add(notificationsPanel, BorderLayout.NORTH);
    
    centerPanel = new CenterPanel();
    add(centerPanel, BorderLayout.CENTER);
    
    setTitle("Steve's BtlShyp");
    setMinimumSize(new Dimension(1200, 1000));
    setSize(1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setVisible(true);
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setVisible(true);
  }
  //display notifications
  
  //display my board
  // select ship placement my board
  // send chose boat place
  
  //display opp board
  // select attack coords opponent board
  // send attack
  
  
  // display chat
  
  // input chat
  // send chat
  
}
