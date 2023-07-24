
package bank.management.system;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class MiniStatement extends JFrame {
    
    int balance;
    
    MiniStatement(String pinNumber,String cardNumber){
    
        setLayout(null);
        
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Raleway",Font.BOLD,14));
        bank.setBounds(140,20,150,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(30,80,500,20);
        add(card);
        
        
         JLabel bal = new JLabel();
        bal.setBounds(30,110,500,20);
        add(bal);
        
        card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
        
        
        try{
            
                 Conn conn= new Conn();
                 ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"' and cardnumber = '"+cardNumber+"'");
               
                 while(rs.next()){                                      //rs.next ek row ko traverse(loop) karta hai
                     
                     mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+  "&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br>" );
                 
                 if(rs.getString("type").equals("Deposite"))
                      balance += Integer.parseInt(rs.getString("amount"));
                 else
                      balance -= Integer.parseInt(rs.getString("amount"));

                 }
                 bal.setText("Available Balance is : " + balance);
           }
        
         catch(Exception e){
                 
                     System.out.println(e);
                 
            }
        
        mini.setBounds(20,140, 400, 300);
        
        
        setSize(400,600);
        setLocation(150,100);
        setVisible(true);
    }
    
    
    
    

   
//    public static void main(String args[]) {
//       
//        
//        new MiniStatement("","");
//        
//        
//    }
}
