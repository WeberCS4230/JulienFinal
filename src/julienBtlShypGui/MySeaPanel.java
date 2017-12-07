package julienBtlShypGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MySeaPanel extends JPanel {
  public static int GRID_SIZE = 5;
  private BtlButton[][] btlButtons;
  private CenterPanel centerPanel;
  
  public MySeaPanel(CenterPanel centerPanel) {
    this.centerPanel = centerPanel;
    this.btlButtons = new BtlButton[GRID_SIZE][GRID_SIZE];
    this.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
        btlButtons[i][j] = new BtlButton( i, j, 160, 50);
        btlButtons[i][j].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            setCoordinate((BtlButton)e.getSource());
          }
        });
        this.add( btlButtons[i][j]);
      }
    }
  }
  
  public void setCoordinate(BtlButton btn) {
    btn.setBackground(Color.GRAY);
    centerPanel.setCoordinate(btn.getX(),btn.getY());
  }
}
