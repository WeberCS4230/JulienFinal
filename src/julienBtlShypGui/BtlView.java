package julienBtlShypGui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import main.btlshyp.view.View;

public class BtlView extends View{
  private NotificationsPanel notificationsPanel;
  private CenterPanel centerPanel;
  private BottomPanel bottomPanel;
  
  public BtlView() {
    super();
    
    setLayout(new BorderLayout());
    
    notificationsPanel = new NotificationsPanel();
    add(notificationsPanel, BorderLayout.NORTH);
    
    centerPanel = new CenterPanel();
    add(centerPanel, BorderLayout.CENTER);
    
    bottomPanel = new BottomPanel();
    add(bottomPanel, BorderLayout.SOUTH);
    
    setTitle("Steve's BtlShyp");
    setMinimumSize(new Dimension(1200, 1000));
    setSize(1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setVisible(true);
  }

  
}
