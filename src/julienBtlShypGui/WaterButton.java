package julienBtlShypGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class WaterButton extends JButton {
  public int x;
  public int y;
  
  public WaterButton(int x, int y) {
    super("O");
    this.x = x;
    this.y = y;
    int size = 160;
    setMinimumSize(new Dimension(size,size));
    setMaximumSize(new Dimension(size,size));
    setPreferredSize(new Dimension(size,size));

    setBackground(Color.blue);

    //setForeground(Color.blue);
    setFont(new Font("Arial", Font.PLAIN, 50));
  }
  
}
