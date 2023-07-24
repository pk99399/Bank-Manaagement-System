
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {
    
    long apliNo;
    JTextField nameTextField,fatherTextField,dobTextField,emailTextField,addressTextField,cityTextField,pinCodeTextField,stateTextField;
    JRadioButton male,female,other,married,unmarried;
     JDateChooser dateChooser;
    JButton next;

    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        apliNo = Math.abs((ran.nextLong() % 9000L)+1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + apliNo );
        formno.setFont(new Font("Raleway",Font.BOLD,32));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel pageOne = new JLabel("Page 1 : Personal Details");
        pageOne.setFont(new Font("Raleway",Font.BOLD,25));
        pageOne.setBounds(240, 80, 400, 30);
        add(pageOne);
        
        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(110, 150, 200, 30);
        add(name);
        
         nameTextField = new JTextField();
        nameTextField.setBounds(310, 150, 400, 30);
        nameTextField.setFont(new Font("Arial",Font.BOLD,18));
        add(nameTextField);
        
        JLabel fatherName = new JLabel("Father,s Name :");
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(110, 200, 200, 30);
        add(fatherName);
        
         fatherTextField = new JTextField();
        fatherTextField.setFont(new Font("Arial",Font.BOLD,18));
        fatherTextField.setBounds(310,200,400,30);
        add(fatherTextField);
        
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(110, 250, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(310,250,400,30);
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(110, 300, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(350,300,120,30);
        add(male);
        
         female = new JRadioButton("Female");
        female.setBounds(500,300,120,30);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(110, 350, 200, 30);
        add(email);
        
         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial",Font.BOLD,18));
        emailTextField.setBounds(310,350,400,30);
        add(emailTextField);
        
        JLabel maritalStat = new JLabel("Marital Status :");
        maritalStat.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStat.setBounds(110, 400, 200, 30);
        add(maritalStat);
        
         married = new JRadioButton("Married");
        married.setBounds(350,400,120,30);
        add(married);
        
         unmarried = new JRadioButton("Un Married");
        unmarried.setBounds(450,400,120,30);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(550,400,120,30);
        add(other);

        ButtonGroup marriedStat = new ButtonGroup();
        marriedStat.add(married);
        marriedStat.add(unmarried);
        marriedStat.add(other);
        

        
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(110, 450, 200, 30);
        add(address);
        
         addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial",Font.BOLD,18));
        addressTextField.setBounds(310,450,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(110, 500, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial",Font.BOLD,18));
        cityTextField.setBounds(310,500,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(110, 550, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial",Font.BOLD,18));
        stateTextField.setBounds(310,550,400,30);
        add(stateTextField);
        
         JLabel pinCode = new JLabel("Pin Code :");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(110, 600, 200, 30);
        add(pinCode);
        
        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Arial",Font.BOLD,18));
        pinCodeTextField.setBounds(310,600,400,30);
        add(pinCodeTextField);
        
        
        next = new JButton("Next");
        next.setBounds(600,700,100,40);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
    
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){                    //since action class runs only if button is pressed  , but
       //                                                               here ther is only one button so no need to check for which button is pressed.
        
        String formno = "" + apliNo; //long so concate as string
        String name = nameTextField.getText();
        String fname = fatherTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
        
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String maritalStat = null;
        if(married.isSelected()){
            maritalStat = "Married";
        }
        else if (unmarried.isSelected()){
            maritalStat = "Unmarried";
        }
        else if (other.isSelected()){
            maritalStat =  "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinCodeTextField.getText();
        
        //here we are writing validation for name field
        try{
            //Class.forName("com.mysql.jdbc.Driver");

        
            if(name.equals("")){       //if name field is blank
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStat+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                
            }
        }
        catch (Exception e){
                    System.out.println(e);
         }
            
        
        
    
    }
    
    public static void main(String args[]) {
        
        new SignupOne();
     
    }
}

