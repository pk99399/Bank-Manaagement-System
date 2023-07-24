
package bank.management.system;
import javax.swing.*;
import java.awt.*;              //for image class
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    
    JButton login,signUp,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    login(){
     
        setTitle("AUTOMATIC TELLER MACHINE");
        
        setLayout(null);        //for accepting custom layout of labelBounds
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pngwing.com.png"));
         Image  i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);                //we are making image class obj for customizing the logo or image//
         ImageIcon i3 = new ImageIcon(i2);                                                                    //since we cant directly pass image on the frame, but we can passImageIcon obj
         JLabel label = new JLabel(i3);                                                                      //using JLabel we can write any content on the frame
         label.setBounds(80, 20, 100, 100);                                                      //setting th boundries of the label on the frame
         add(label);        //for placing image on the frame
         
         JLabel text = new JLabel("Welcome to ATM");
         text.setFont(new Font("Osward",Font.BOLD,38));
         text.setBounds(250,40,400,40);
         add(text);
         
         JLabel cardno = new JLabel("Card No :");
         cardno.setFont(new Font("Raleway",Font.BOLD,28));
         cardno.setBounds(200, 150, 150, 30);
         add(cardno);
         
         cardTextField = new JTextField();
         cardTextField.setBounds(350, 150, 300, 30);
         cardTextField.setFont(new Font("Arial",Font.BOLD,14));
         add(cardTextField);
         
         JLabel pin = new JLabel("PIN :");
         pin.setFont(new Font("Raleway",Font.BOLD,28));
         pin.setBounds(200, 210, 150, 30);
         add(pin);
         
         pinTextField = new JPasswordField();
         pinTextField.setBounds(350, 210, 300, 30);
         add(pinTextField);
         
         
          login = new JButton("SIGN IN");
         login.setBounds(350,300,150,30);
         login.setBackground(Color.BLACK);
         //login.setForeground(Color.WHITE);
         login.addActionListener(this);
         add(login);
         
         
         clear = new JButton("CLEAR");
         clear.setBounds(500,300,150,30);
         clear.setBackground(Color.BLACK);
         //clear.setForeground(Color.WHITE);
         clear.addActionListener(this);
         add(clear);
         
          signUp = new JButton("SIGN UP");
         signUp.setBounds(350,350,300,30);
         signUp.setBackground(Color.BLACK);
         //clear.setForeground(Color.WHITE);
         signUp.addActionListener(this);
         add(signUp);
         
         getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
       
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == clear){
           cardTextField.setText("");
           pinTextField.setText("");
        
        }
        else if(ae.getSource() ==login){
        
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String Query = "select * from login where cardnumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            
            try{
            
                ResultSet rs = conn.s.executeQuery(Query);
                if(rs.next()){
                
                    setVisible(false);
                    new Transactions(pinNumber,cardNumber).setVisible(true);
                }
                else{
                
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin ");
                }
            }
            catch(Exception e){
            
                System.out.println(e);
            }
        
        }
        else if(ae.getSource()==signUp){
            setVisible(false);
            new SignupOne().setVisible(true);
        
        }
        
        
        
        
    }
    
    public static void main(String args[]){
    
       new login();
    
    }
    
}
