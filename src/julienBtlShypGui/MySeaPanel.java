package julienBtlShypGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.btlshyp.model.Coordinate;
import main.btlshyp.model.Ship;
import main.btlshyp.view.event.SetShipEvent;
import main.btlshyp.view.event.SetShipListener;

public class MySeaPanel extends JPanel {
  public static int GRID_SIZE = 5;
  private BtlButton[][] btlButtons;
  private BtlView owner;
  

  
  public MySeaPanel(BtlView owner) {
    
    this.owner = owner;
    this.btlButtons = new BtlButton[GRID_SIZE][GRID_SIZE];
    this.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
        btlButtons[i][j] = new BtlButton( i, j, 160, 50);
        btlButtons[i][j].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            setCoordinate(e);
          }
        });
        this.add( btlButtons[i][j]);
      }
    }
  } // end ctor
  

  
public void setCoordinate(ActionEvent e) {
  BtlButton btn = (BtlButton)e.getSource();
  btn.setBackground(Color.GRAY);
  owner.attemptSetShip(e);
}
  
  public void displayShip(Ship ship) {
    if(ship != null && ship.isValid()) {
      for(Coordinate c : ship.getShipCoordinates()) {
        btlButtons[c.x][c.y].setBackground(Color.red);//setEnabled(false);
      }
    }
  }
  
}
