package julienBtlShypGui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel {
  
  public OpponentPanel() {
    this.setLayout(new GridLayout(5,5));
    for(int i=0;i<5;i++) {
      for(int j=0;j<5;j++) {
        this.add(new WaterButton(i,j));
      }
    }
  }
}
