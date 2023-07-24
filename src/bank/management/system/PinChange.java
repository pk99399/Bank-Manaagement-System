package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    String pinNumber,cardNumber;
    JPasswordField newPin1,newPin2,oldPin;
    JButton change, back;
    
    
    PinChange(String pinNumber,String cardNumber){
    
        this.pinNumber = pinNumber;
        this.cardNumber=cardNumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("New PIN:");
        text.setBounds(165,320,180,25);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        newPin1 = new JPasswordField();
        newPin1.setBounds(300,320,180,25);
        image.add(newPin1);
        
        JLabel retext = new JLabel("Re-Enter New PIN:");
        retext.setBounds(165,370,180,25);
        retext.setForeground(Color.WHITE);
        image.add(retext);
        
        newPin2 = new JPasswordField();
        newPin2.setBounds(300,370,180,25);
        image.add(newPin2);
        
        JLabel text2 = new JLabel("Old PIN:");
        text2.setBounds(165,420,180,25);
        text2.setForeground(Color.WHITE);
        image.add(text2);
        
        oldPin = new JPasswordField();
        oldPin.setBounds(300,420,180,25);
        image.add(oldPin);
        
        change = new JButton("Change");
        change.setBounds(335, 470, 150 , 30);
        change.addActionListener(this);
        image.add(change);
        
         back = new JButton("back");
        back.setBounds(335, 500, 150 , 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()== back){
        
            setVisible(false);
            new Transactions(pinNumber,cardNumber).setVisible(true);
        }
        else if(ae.getSource()== change){
    
             try{
                 
                 String npin= newPin1.getText();
                 String rpin = newPin2.getText();
                 String opin = oldPin.getText();
                 
                 if(!npin.equals(rpin) || npin.equals("")){
                 
                     JOptionPane.showMessageDialog(null, "Plese Re-Enter New PIN");
                     newPin1.setText("");
                     newPin2.setText("");
                     
                 }
                 else if(!opin.equals(pinNumber)){
                 
                     JOptionPane.showMessageDialog(null, "Please Enter Correct Pin");
                 }
                 else{
                 Conn conn = new Conn();
                 String queryb = "update bank set pin = '"+npin+"' where cardNumber = '"+cardNumber+"' ";
                 String queryl = "update login set pin = '"+npin+"' where cardNumber = '"+cardNumber+"' ";
                 String querys = "update signupthree set pin = '"+npin+"' where cardNumber = '"+cardNumber+"' ";
                 conn.s.executeUpdate(queryb);
                 conn.s.executeUpdate(queryl);
                 conn.s.executeUpdate(querys);
                 
                 JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                 
                 setVisible(false);
                 new Transactions(npin,cardNumber).setVisible(true);
                 
                 }
                 
             }
             catch(Exception e){
             
                 System.out.println(e);
             }
             
             }
    
        }
    

    
   
    
    

   
    public static void main(String args[]) {
        new PinChange("","");
    }
}
