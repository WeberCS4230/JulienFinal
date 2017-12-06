package julienBtlShypGui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import main.btlshyp.message.AttackResponseMessage;
import main.btlshyp.model.Ship;
import main.btlshyp.view.View;
import main.btlshyp.view.event.AttackListener;
import main.btlshyp.view.event.ChatEvent;
import main.btlshyp.view.event.ChatListener;
import main.btlshyp.view.event.SetShipListener;

public class BtlView extends View{
  
  private NotificationsPanel notificationsPanel;
  private CenterPanel centerPanel;
  private BottomPanel bottomPanel;
  
  public BtlView() {
    super();
    setLayout(new BorderLayout());
    
    notificationsPanel = new NotificationsPanel();
    add(notificationsPanel, BorderLayout.NORTH);
    
    centerPanel = new CenterPanel();
    add(centerPanel, BorderLayout.CENTER);
    
    bottomPanel = new BottomPanel(this);
    add(bottomPanel, BorderLayout.SOUTH);
    
    setTitle("Steve's BtlShyp");
    setMinimumSize(new Dimension(1200, 1000));
    setSize(1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setVisible(true);
  }

  @Override
  public void attemptSetShip(ActionEvent e) {
    // TODO Auto-generated method stub
    super.attemptSetShip(e);
  }

  @Override
  public void displayAttack(AttackResponseMessage message) {
    // TODO Auto-generated method stub
    super.displayAttack(message);
  }

  @Override
  public void displayChat(String user, String chat) {
   centerPanel.displayChat(user, chat);
  }

  @Override
  public void displayNotification(String text) {
   centerPanel.displayChat("******* ",  text + " *******");
  }

  @Override
  public void displayOpponentAttack(AttackResponseMessage message) {
    // TODO Auto-generated method stub
    super.displayOpponentAttack(message);
  }

  @Override
  public void displayShip(Ship ship) {
    // TODO Auto-generated method stub
    super.displayShip(ship);
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public void notYourTurn() {
    // TODO Auto-generated method stub
    super.notYourTurn();
  }

  @Override
  public void registerAttackListener(AttackListener listener) {
    // TODO Auto-generated method stub
    super.registerAttackListener(listener);
  }

  @Override
  public void registerChatListener(ChatListener listener) {
    // TODO Auto-generated method stub
    super.registerChatListener(listener);
  }

  @Override
  public void registerSetShipListener(SetShipListener listener) {
    // TODO Auto-generated method stub
    super.registerSetShipListener(listener);
  }

  @Override
  public void resetGame() {
    // TODO Auto-generated method stub
    super.resetGame();
  }

  @Override
  public void sendAttack(ActionEvent e) {
    // TODO Auto-generated method stub
    super.sendAttack(e);
  }

  @Override
  public void sendChat(ActionEvent e) {
    String chat = bottomPanel.inputPane.getText();
    if(chat!=null && chat.length()>0) {
      ChatEvent chatEvent = new ChatEvent(e,chat);
      if(chatListener != null) {
        chatListener.chatEventOccurred(chatEvent);
      }
    }
  }

  @Override
  public void setShip(Ship ship) {
    // TODO Auto-generated method stub
    super.setShip(ship);
  }

  @Override
  public void yourTurn() {
    // TODO Auto-generated method stub
    super.yourTurn();
  }

  
}
