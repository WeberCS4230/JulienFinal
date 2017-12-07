package julienBtlShypGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.btlshyp.message.AttackResponseMessage;
import main.btlshyp.model.Coordinate;
import main.btlshyp.model.Ship;
import main.btlshyp.view.View;
import main.btlshyp.view.event.AttackEvent;
import main.btlshyp.view.event.AttackListener;
import main.btlshyp.view.event.ChatEvent;
import main.btlshyp.view.event.ChatListener;
import main.btlshyp.view.event.SetShipEvent;
import main.btlshyp.view.event.SetShipListener;

public class BtlView extends View{
  
  private NotificationsPanel notificationsPanel;
  private CenterPanel centerPanel;
  private BottomPanel bottomPanel;
  private Ship shipToPlace;
  private HashSet<Coordinate> coordinates;
  private int numShipsPlaced;
  
  private boolean isMyTurn;
  
  public BtlView() {
    super();
    this.isMyTurn = false;
    this.numShipsPlaced = 0;
    this.coordinates = new HashSet<>();
    setLayout(new BorderLayout());
    
    notificationsPanel = new NotificationsPanel();
    add(notificationsPanel, BorderLayout.NORTH);
    
    centerPanel = new CenterPanel(this);
    add(centerPanel, BorderLayout.CENTER);
    
    bottomPanel = new BottomPanel(this);
    add(bottomPanel, BorderLayout.SOUTH);
    
    setTitle("Steve's BtlShyp");
    setMinimumSize(new Dimension(1200, 1000));
    setSize(1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    // TODO: REMOVE ME AFTER GUI TESTING , THE CONTROLLER WILL CALL THIS
    resetGame();
//    setVisible(true);
  }

  @Override
  public void attemptSetShip(ActionEvent e) {

      if(setShipListener != null && shipToPlace != null) {
       String strXY = e.getActionCommand();
       int x = Character.getNumericValue(strXY.charAt(1));
       int y = Character.getNumericValue(strXY.charAt(4));
        BtlButton btn = (BtlButton)e.getSource();
        coordinates.add(new Coordinate(x,y));
        
        if(coordinates.size() == shipToPlace.getShipSize()) {
          
            shipToPlace.setShipCoordinates(new ArrayList<Coordinate>(coordinates));
            coordinates.clear();
            SetShipEvent sse = new SetShipEvent(e, shipToPlace);
            setShipListener.setShipEventOccurred(sse);
          }  
        }
  }// end attempt set ship

  @Override
  public void displayAttack(AttackResponseMessage message) {
    centerPanel.displayAttack(message);
  }

  @Override
  public void displayChat(String user, String chat) {
   centerPanel.displayChat(user, chat);
  }

  @Override
  public void displayNotification(String text) {
   centerPanel.displayChat("",  text);
  }

  @Override
  public void displayOpponentAttack(AttackResponseMessage message) {
      centerPanel.displayOpponentAttack(message);
  }

  @Override
  public void displayShip(Ship ship) {
    numShipsPlaced++;
    centerPanel.displayShip(ship);
    if(numShipsPlaced == 4) {
      centerPanel.lockMySea();
    }
  }

  @Override
  public String getUsername() {
    return JOptionPane.showInputDialog(null, "Enter username: ");
  }

  @Override
  public void notYourTurn() {
//  isMyTurn = false;
//  centerPanel.notYourTurn();
//  notificationsPanel.notifyOppSea("");
//  notificationsPanel.notifyMySea("Waiting on opponent...");
  }

  @Override
  public void registerAttackListener(AttackListener listener) {
    super.registerAttackListener(listener);
  }

  @Override
  public void registerChatListener(ChatListener listener) {
    super.registerChatListener(listener);
  }

  @Override
  public void registerSetShipListener(SetShipListener listener) {
    super.registerSetShipListener(listener);
  }

  @Override
  public void resetGame() {
    centerPanel.resetGame();
    notificationsPanel.resetGame();
    bottomPanel.resetGame();
  }

  @Override
  public void sendAttack(ActionEvent e) {
   BtlButton btn = (BtlButton)e.getSource();
   AttackEvent ae = new AttackEvent(e, new Coordinate(btn.getX(), btn.getY()));
   if(attackListener != null && isMyTurn == true) {
     attackListener.attackEventOccurred(ae);
   }
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
    this.shipToPlace = ship;
    String shipName = ship.getShipType().toString();
    String sz =Integer.toString(ship.getShipSize());
    notificationsPanel.notifyMySea("Set the " + shipName + " " + sz + " squares");
  }

  @Override
  public void yourTurn() {
    centerPanel.yourTurn();
    notificationsPanel.notifyOppSea("Attack!");
    isMyTurn = true;
  }

  
}
