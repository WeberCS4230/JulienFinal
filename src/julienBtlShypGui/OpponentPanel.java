package julienBtlShypGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.btlshyp.message.AttackResponseMessage;

public class OpponentPanel extends JPanel {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public static int GRID_SIZE = 5;
  private JButton[][] btlButtons;
  private BtlView owner;
  
  public OpponentPanel(BtlView owner) {
    this.owner = owner;
    this.btlButtons = new JButton[GRID_SIZE][GRID_SIZE];
    this.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));
    fillButtons(this);
  } 
  
  public void resetGame() {
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
          
        btlButtons[i][j].setBackground(Color.blue);
        btlButtons[i][j].setForeground(Color.white);
        btlButtons[i][j].setEnabled(true);
      }
    }
  }
  
  public void fillButtons(OpponentPanel panel) {
    int size = 150;
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
        JButton temp = new JButton("(" +Integer.toString(i) + ", " + Integer.toString(j) + ")");//BtlButton temp =  new BtlButton( i, j, 160, 50);
        temp.setMinimumSize(new Dimension(size,size));
        temp.setMaximumSize(new Dimension(size,size));
        temp.setPreferredSize(new Dimension(size,size));
        temp.setBackground(Color.blue);
        temp.setForeground(Color.white);
        temp.setFont(new Font("Arial", Font.PLAIN, 25));
        temp.setEnabled(false);
        temp.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            sendAttack(e);
          }
        });
        panel.add(temp);
        btlButtons[i][j] = temp;
      }
    }
  }
  public void sendAttack(ActionEvent e) {
    JButton btn = (JButton)e.getSource();
    btn.setBackground(Color.YELLOW);
    owner.sendAttack(e);
  }
  public void lockOppSea() {
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
        btlButtons[i][j].setEnabled(false);
      }
    }
  }
  
  public void unlockOppSea() {
    for(int i=0;i<GRID_SIZE;i++) {
      for(int j=0;j<GRID_SIZE;j++) {
        btlButtons[i][j].setEnabled(true);
      }
    }
  }
  public void displayAttack(AttackResponseMessage message) {
    int x = message.getCoordinate().x;
    int y = message.getCoordinate().y;
    if(message.getHitOrMiss() == AttackResponseMessage.HitOrMiss.HIT) {
      btlButtons[x][y].setBackground(Color.red);
      java.awt.Toolkit.getDefaultToolkit().beep();
    }
    else {
      btlButtons[x][y].setBackground(Color.white);
    }
    btlButtons[x][y].setEnabled(false);
  }
}
