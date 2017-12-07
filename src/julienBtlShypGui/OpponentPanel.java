package julienBtlShypGui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel {
  public static int GRID_SIZE = 5;
  private BtlButton[][] btlButtons;
  private BtlView owner;
  
  public OpponentPanel(BtlView owner) {
    this.owner = owner;
    this.btlButtons = new BtlButton[GRID_SIZE][GRID_SIZE];
    this.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
        btlButtons[i][j] = new BtlButton( i, j, 160, 50);
        btlButtons[i][j].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            sendAttack(e);
          }
        });
        this.add( btlButtons[i][j]);
      }
    }
  } // end ctor
  
  public void sendAttack(ActionEvent e) {
    BtlButton btn = (BtlButton)e.getSource();
    btn.setBackground(Color.YELLOW);
    owner.sendAttack(e);
  }
}
