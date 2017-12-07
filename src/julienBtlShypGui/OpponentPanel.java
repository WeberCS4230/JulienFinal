package julienBtlShypGui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel {
  public static int GRID_SIZE = 5;
  private BtlButton[][] btlButtons;
  
  public OpponentPanel() {
    
    this.btlButtons = new BtlButton[GRID_SIZE][GRID_SIZE];
    this.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
        btlButtons[i][j] = new BtlButton( i, j, 160, 50);
        btlButtons[i][j].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            // fire missile
          }
        });
        this.add( btlButtons[i][j]);
      }
    }
  }
}
