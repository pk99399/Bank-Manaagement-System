
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Transactions extends JFrame implements ActionListener {
    
    JButton deposite,cashWithd,fastCash,miniState,pinch,bEnquiry,exit;
    String pinNumber,cardNumber;


    Transactions(String pinNumber,String cardNumber){
        this .pinNumber = pinNumber;
        this.cardNumber = cardNumber;
    
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        cashWithd = new JButton("Cash Withdrawl");
        cashWithd.setBounds(355, 415, 150, 30);
        cashWithd.addActionListener(this);
        image.add(cashWithd);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniState = new JButton("Mini Statement");
        miniState.setBounds(355, 450, 150, 30);
        miniState.addActionListener(this);
        image.add(miniState);
        
        pinch = new JButton("Pin Change");
        pinch.setBounds(170, 485, 150, 30);
        pinch.addActionListener(this);
        image.add(pinch);
        
        bEnquiry = new JButton("Blance Enquiry");
        bEnquiry.setBounds(355, 485, 150, 30);
        bEnquiry.addActionListener(this);
        image.add(bEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == exit)
            System.exit(0);
        
        else if(ae.getSource() == deposite){
            setVisible(false);
            new Deposite(pinNumber,cardNumber).setVisible(true);
                   
        }
        else if(ae.getSource() == cashWithd){
        
            setVisible(false);
            new CashWithdrawl(pinNumber,cardNumber).setVisible(true);
        }
        else if(ae.getSource() == fastCash){
        
            setVisible(false);
            new FastCash(pinNumber,cardNumber).setVisible(true);
        }
        else if(ae.getSource()== pinch){
     
            setVisible(false);
            new PinChange(pinNumber,cardNumber).setVisible(true);
     }
        else if(ae.getSource() == bEnquiry){
        
            setVisible(false);
            new BalanceEnquiry(pinNumber,cardNumber).setVisible(true);
        }
        else if(ae.getSource() == miniState){
        
            setVisible(false);
            new MiniStatement(pinNumber,cardNumber).setVisible(true);
        }
    
    }
    public static void main(String args[]) {
        
        new Transactions("","");
    }
}
