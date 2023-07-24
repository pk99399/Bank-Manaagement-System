
package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener {
    
    String pinNumber,cardNumber;
    JButton back;
    int balance = 0;
    
    
    BalanceEnquiry(String pinNumber,String cardNumber){
    
    
        this.pinNumber = pinNumber;
        this.cardNumber=cardNumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(335,520,150,30);
        back.addActionListener(this);
        image.add(back);
        System.out.println(balance);
        
         Conn c = new Conn();
            
            try{
            
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' and cardnumber = '"+cardNumber+"'");
                
                
                while(rs.next()){                                             //rs.next ek row ko traverse(loop) karta hai
                  if(rs.getString("type").equals("Deposite"))
                      balance += Integer.parseInt(rs.getString("amount"));
                 else
                      balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            catch(Exception e){
            
                System.out.println(e);
            }
            
            JLabel text = new JLabel("Your Current Account Balance is " + balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170, 300, 400, 30);
            image.add(text);
        
            System.out.println(balance);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
        new Transactions(pinNumber,cardNumber).setVisible(true);
        
        
        
    }

   
    public static void main(String args[]) {
        
        new BalanceEnquiry("","");
        
    }
}
