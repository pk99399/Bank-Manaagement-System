
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;



public class Deposite extends JFrame implements ActionListener {
    
    JButton back,deposite;
    JTextField  amount;
    String pinNumber,cardNumber;
    
    Deposite(String pinNumber,String cardNumber){
        
        this.pinNumber = pinNumber;
        this.cardNumber=cardNumber;
    
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposite");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        deposite = new JButton("deposite");
        deposite.setBounds(355,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
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
        else if (ae.getSource() == deposite){
        
            String amountValue = amount.getText();
            Date date = new Date();
            if(amountValue.equals("")){
            
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposite");
            }
            else{
                try{
            
                Conn conn= new Conn();
                String query = "insert into bank values('"+pinNumber+"','"+cardNumber+"','"+date+"','Deposite','"+amountValue+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs  "+amountValue+"Deposited Successfully");
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
        
        new Deposite("","");
        
    }
}
