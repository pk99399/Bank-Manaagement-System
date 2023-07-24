
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;



public class SignupThree extends JFrame implements ActionListener{
    
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    JRadioButton fixedAcc,savingAcc,currAcc,depAcc;
    String formno;
    
    
    SignupThree(String formno){
        
        setLayout(null);
        this.formno=formno;
        
        setTitle("Page 3: Account Details ");
        
        JLabel title = new JLabel("Page 3: Account Details ");
        title.setFont(new Font("Raleway",Font.BOLD,28));
        title.setBounds(200, 40, 400,40);
        add(title);
        
        JLabel accType = new JLabel("Account Type :");
        accType.setFont(new Font("Raleway",Font.BOLD,20));
        accType.setBounds(110, 110, 200, 30);
        add(accType);
        
        savingAcc = new JRadioButton("Saving Account ");
        savingAcc.setBounds(140, 160, 150, 30);
        add(savingAcc);
        
        fixedAcc = new JRadioButton("Fixed Deposite Account ");
        fixedAcc.setBounds(400, 160, 300, 30);
        add(fixedAcc);

        currAcc = new JRadioButton("Current Account ");
        currAcc.setBounds(140, 210, 150, 30);
        add(currAcc);

        depAcc = new JRadioButton("Recurring Deposite Account ");
        depAcc.setBounds(400, 210, 300, 30);
        add(depAcc);
        
        ButtonGroup accountType = new ButtonGroup();
        accountType.add(savingAcc);
        accountType.add(fixedAcc);
        accountType.add(currAcc);
        accountType.add(depAcc);
        
        JLabel cardNo = new JLabel("Card Number :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));
        cardNo.setBounds(110, 260, 400,30);
        add(cardNo);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,15));
        number.setBounds(360, 260, 400,30);
        add(number);
        
        JLabel cardHint = new JLabel("(This is your 16 digit card number)");
        cardHint.setFont(new Font("Raleway",Font.BOLD,10));
        cardHint.setBounds(110, 285, 400,20);
        add(cardHint);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(110, 330, 400,30);
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway",Font.BOLD,15));
        pinNumber.setBounds(360, 330, 400,30);
        add(pinNumber);
        
        JLabel pinHint = new JLabel(" (This is 4 digit pin number)");
        pinHint.setFont(new Font("Raleway",Font.BOLD,10));
        pinHint.setBounds(110, 355, 400,20);
        add(pinHint);
        
        JLabel serviceLable = new JLabel("Service Required :");
        serviceLable.setFont(new Font("Raleway",Font.BOLD,20));
        serviceLable.setBounds(110, 400, 400,30);
        add(serviceLable);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBounds(140, 450, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internate Banking");
        c2.setBounds(400, 450, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(140, 500, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alert");
        c4.setBounds(400, 500, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setBounds(140, 550, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(400, 550, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are corrected to the best of my knowledge.");
        c7.setBounds(110, 640, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(220,700,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,700,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        

        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
        
    
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == cancel) {
        
            setVisible(false);
            new login().setVisible(true);
            
                }
        else if(ae.getSource() == submit)
        {
            
            String facility = "";
            String accType = "";
            String declaration = "";
            if(savingAcc.isSelected()){
            
                accType = "Saving Account";
            }
            else if(currAcc.isSelected()){
            
                accType = "Current Account";
            }
            else if(depAcc.isSelected()){
            
                accType = "Reccuring Deposite Account";
            }
            else if(fixedAcc.isSelected()){
            
                accType = "Fixed Account";
            }
            
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
           String pinNumber = ""+ Math.abs(random.nextLong()%9000L + 1000L);
            
           
            if(c1.isSelected()){
            
                facility = facility + " ATM Card ";
            }
            if(c2.isSelected()){
            
                facility = facility + " Internate Banking";
            }
            if(c3.isSelected()){
            
                facility = facility + " Mobile Banking";
            }
            if(c4.isSelected()){
            
                facility = facility + " EMAIL and SMS Alerts";
            }
            if(c5.isSelected()){
            
                facility = facility + " CheckBooks";
            }
            if(c6.isSelected()){
            
                facility = facility + " E-statement";
            }
            
            
            if(c7.isSelected()){
            
                declaration = "yes";
            }
            
            try{
                
                if(accType.equals("")){
                
                    JOptionPane.showMessageDialog(null,"Account type is Required");
                }
                else if(declaration.equals("")){
                
                    JOptionPane.showMessageDialog(null,"Self Declaration is Required");
                }
                
                else {
                    
                    Conn conn=new Conn();
                    String query = "insert into signupthree values('"+formno+"','"+accType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number : " + cardNumber + "\n PIN :" + pinNumber);
                    
                    setVisible(false);
                    new Deposite(pinNumber,cardNumber).setVisible(true);
                }
            
            }
            catch(Exception e){
            
                System.out.println(e);
            }
        
           
        }
        
    }

    
    public static void main(String args[]) {
        
        new SignupThree("");
        
    }
}
