package julienBtlShypGui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class BottomPanel extends JPanel {

  private static JButton btnSend;
  JEditorPane msgPane;
  JScrollPane scrlPane;

  public BottomPanel() {

    Dimension dim = getPreferredSize();
    dim.width = 400;
    dim.height = 100;
    setPreferredSize(dim);

    setLayout(new BorderLayout());

    btnSend = new JButton("Send");
    msgPane = new JEditorPane();

    btnSend.setFont(new Font("Arial", Font.PLAIN, 20));
    btnSend.setPreferredSize(new Dimension(70, 40));

    msgPane.setPreferredSize(new Dimension(70, 70));
    msgPane.setFont(new Font("Arial", Font.PLAIN, 20));
    msgPane.setBackground(Color.lightGray);

    // to add CTRL + Enter functionality to chat input
    CtrlEnterAction ceAction = new CtrlEnterAction();
    msgPane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, ActionEvent.CTRL_MASK), "doEnterAction");
    msgPane.getActionMap().put("doEnterAction", ceAction);

    btnSend.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        printNewChat();
      }
    });

    JPanel bs1 = new JPanel();
    JPanel bs2 = new JPanel();
    bs1.setPreferredSize(new Dimension(300, 100));
    bs2.setPreferredSize(new Dimension(300, 100));
    btnSend.setPreferredSize(new Dimension(80, 40));
    add(bs1, BorderLayout.WEST);
    add(btnSend, BorderLayout.EAST);
    scrlPane = new JScrollPane(msgPane);
    add(scrlPane, BorderLayout.CENTER);
    //add(btnSend, BorderLayout.AFTER_LAST_LINE);

    msgPane.requestFocusInWindow();
  }

  public void printNewChat() {
    String chat = "";
    if (msgPane.getText().length() > 0) {
      chat = msgPane.getText();
      // send it
      msgPane.setText("");
    }
  }

  static class CtrlEnterAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    @Override
    public void actionPerformed(ActionEvent e) {
      btnSend.doClick();
    }
  }

}