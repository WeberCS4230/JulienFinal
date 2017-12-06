package julienBtlShypGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class BtlButton extends JButton {
  public int x;
  public int y;
  public int size;
  
  public BtlButton(int x, int y, int size, int fontSize) {
    super("O");
    this.x = x;
    this.y = y;
    this.size = size;
    setMinimumSize(new Dimension(size,size));
    setMaximumSize(new Dimension(size,size));
    setPreferredSize(new Dimension(size,size));

    setBackground(Color.blue);

    //setForeground(Color.blue);
    setFont(new Font("Arial", Font.PLAIN, fontSize));
  }
  
}

