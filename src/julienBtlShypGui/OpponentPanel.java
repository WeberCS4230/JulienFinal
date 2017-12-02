package julienBtlShypGui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel {
  
  public OpponentPanel() {
    this.setLayout(new GridLayout(5,5));
    for(int i=0;i<25;i++) {
      this.add(new JButton("btn asdfsadfasdfsadf" + Integer.toString(i)));
    }
  }
}
