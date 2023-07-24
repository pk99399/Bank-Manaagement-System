
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class FastCash extends JFrame implements ActionListener {
    
    JButton deposite,cashWithd,fastCash,miniState,pinch,bEnquiry,Back;
    String pinNumber,cardNumber;


    FastCash(String pinNumber,String cardNumber){
        this .pinNumber = pinNumber;
        this.cardNumber = cardNumber;
    
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select Amount to Withdraw");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposite = new JButton("Rs 100");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        cashWithd = new JButton("Rs 500");
        cashWithd.setBounds(355, 415, 150, 30);
        cashWithd.addActionListener(this);
        image.add(cashWithd);
        
        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniState = new JButton("Rs 2000");
        miniState.setBounds(355, 450, 150, 30);
        miniState.addActionListener(this);
        image.add(miniState);
        
        pinch = new JButton("Rs 5000");
        pinch.setBounds(170, 485, 150, 30);
        pinch.addActionListener(this);
        image.add(pinch);
        
        bEnquiry = new JButton("Rs 10000");
        bEnquiry.setBounds(355, 485, 150, 30);
        bEnquiry.addActionListener(this);
        image.add(bEnquiry);
        
        Back = new JButton("Back");
        Back.setBounds(355, 520, 150, 30);
        Back.addActionListener(this);
        image.add(Back);
        
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == Back){
            setVisible(false);
            new Transactions(pinNumber,cardNumber).setVisible(true);
        }
        else {
        
            String amount = ((JButton)ae.getSource()).getText().substring(3);    //here we are dynamically picking textLable of pressed button  //ae.getSource returns an object so typecast into JButton
            Conn c = new Conn();
            
            try{
            
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' and cardnumber = '"+cardNumber+"'");
                int balance = 0;
                
                while(rs.next()){                                             //rs.next ek row ko traverse(loop) karta hai
                  if(rs.getString("type").equals("Deposite"))
                      balance += Integer.parseInt(rs.getString("amount"));
                 else
                      balance -= Integer.parseInt(rs.getString("amount"));
                }
                
                 if(ae.getSource() != Back && balance < Integer.parseInt(amount))
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                 else{
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"','"+cardNumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + "Debited Sucessfully");
                 }
                
                setVisible(false);
                new Transactions(pinNumber,cardNumber).setVisible(true);
                 
            }
            catch(Exception e){
            
                System.out.println(e);
            }
            
        
        }
        
        
        
    
    }
//    public static void main(String args[]) {
//        
//        new FastCash("","");
//    }
}
