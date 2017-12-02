package julienBtlShypGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MySeaPanel extends JPanel {
  
  public MySeaPanel() {
    this.setLayout(new GridLayout(5,5));
    for(int i=0;i<5;i++) {
      for(int j=0;j<5;j++) {
        this.add(new WaterButton(i,j));
      }
    }
  }
}
