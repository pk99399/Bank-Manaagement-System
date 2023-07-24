
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;



public class CashWithdrawl extends JFrame implements ActionListener {
    
    JButton back,withdrawl;
    JTextField  amount;
    String pinNumber,cardNumber;
    
    CashWithdrawl(String pinNumber,String cardNumber){
        
        this.pinNumber = pinNumber;
        this.cardNumber=cardNumber;
    
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        withdrawl = new JButton("Withdrawl Amount");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    
    }
    
    public void actionPerformed (ActionEvent ae){
    
        if(ae.getSource() == back)
        {
        
            setVisible(false);
            new Transactions(pinNumber,cardNumber);
            
        }
        else if (ae.getSource() == withdrawl){
        
            String amountValue = amount.getText();
            Date date = new Date();
            if(amountValue.equals("")){
            
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            }
            else{
                
                try{
            
                 Conn conn= new Conn();
                 ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"' and cardnumber = '"+cardNumber+"'");
                 int balance = 0;
                
                 while(rs.next()){                                             //rs.next ek row ko traverse(loop) karta hai
                   if(rs.getString("type").equals("Deposite"))
                      balance += Integer.parseInt(rs.getString("amount"));
                   else
                      balance -= Integer.parseInt(rs.getString("amount"));
                }
                
                 if(ae.getSource() != back && balance < Integer.parseInt(amountValue))
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                 
                 else{
                    String query = "insert into bank values('"+pinNumber+"','"+cardNumber+"','"+date+"','withdrawl','"+amountValue+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs  "+amountValue+"Withdraw Successfully");
                 }
                
                
                setVisible(false);
                new Transactions(pinNumber,cardNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
            }
        
        }
    }
    

   
    public static void main(String args[]) {
        
        new CashWithdrawl("","");
        
    }
}
