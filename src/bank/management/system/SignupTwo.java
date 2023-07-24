
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField panTextField,adharTextField;
    JButton next;
    JRadioButton eAccountYes,eAccountNo,sCitizenYes,sCitizenNo;
    JComboBox religionComboBox,catagoryComboBox,incomeComboBox,eduComboBox,occupationComboBox;
    String formnoOne;

    
    SignupTwo(String formno){
        
        setLayout(null);
        
        this.formnoOne = formno;
        
     
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        additionalDetails.setBounds(240, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(110, 150, 200, 30);
        add(religion);
        
        String rel[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionComboBox = new JComboBox(rel);
        religionComboBox.setBounds(310, 150, 400, 30);
        add(religionComboBox);
        
       
        
        JLabel catagory = new JLabel("Catagory :");
        catagory.setFont(new Font("Raleway",Font.BOLD,20));
        catagory.setBounds(110, 200, 200, 30);
        add(catagory);
        
        String cat[] = {"General","OBC","SC","ST","PWD","Tribal"};
        catagoryComboBox = new JComboBox(cat);
        catagoryComboBox.setBounds(310,200,400,30);
        add(catagoryComboBox);
        
        
        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(110, 250, 200, 30);
        add(income);
        
        String incom[] = {"Null","<1,50,00","<2,50,000","<5,00,000","Upto 10,00,000"};
        incomeComboBox = new JComboBox(incom);
        incomeComboBox.setBounds(310,250,400,30);
        add(incomeComboBox);
        
        
        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(110, 300, 200, 30);
        add(edu);
        JLabel qual = new JLabel("Qualification :");
        qual.setFont(new Font("Raleway",Font.BOLD,20));
        qual.setBounds(110, 330, 200, 30);
        add(qual);
        
        String eduu[] = {"Maticulation","Intermediate","Graduation","Post Graduation","Doctorate","Other"};
        eduComboBox = new JComboBox(eduu);
        eduComboBox.setBounds(310,330,400,30);
        add(eduComboBox);

      
        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(110, 400, 200, 30);
        add(occupation);
        
        String occu[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupationComboBox = new JComboBox(occu);
        occupationComboBox.setBounds(310,400,400,30);
        add(occupationComboBox);
        
        
        JLabel pan = new JLabel("PAN No :");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(110, 450, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial",Font.BOLD,18));
        panTextField.setBounds(310,450,400,30);
        add(panTextField);
        
        JLabel adhar = new JLabel("Adhar No :");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(110, 500, 200, 30);
        add(adhar);
        
        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Arial",Font.BOLD,18));
        adharTextField.setBounds(310,500,400,30);
        add(adharTextField);
        
        JLabel sCitizen = new JLabel("Senior citizen :");
        sCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        sCitizen.setBounds(110, 550, 200, 30);
        add(sCitizen);
        
        sCitizenYes = new JRadioButton("Yes");
        sCitizenYes.setBounds(350,550,120,30);
        add(sCitizenYes);
        
        sCitizenNo = new JRadioButton("No");
        sCitizenNo.setBounds(450,550,120,30);
        add(sCitizenNo);
        
        ButtonGroup sCitizenStat = new ButtonGroup();
        sCitizenStat.add(sCitizenYes);
        sCitizenStat.add(sCitizenNo);
       
        
         JLabel eAccount = new JLabel("Existing Account :");
        eAccount.setFont(new Font("Raleway",Font.BOLD,20));
        eAccount.setBounds(110, 600, 200, 30);
        add(eAccount);
        
        eAccountYes = new JRadioButton("Yes");
        eAccountYes.setBounds(350,600,120,30);
        add(eAccountYes);
        
        eAccountNo = new JRadioButton("No");
        eAccountNo.setBounds(450,600,120,30);
        add(eAccountNo);
        
        ButtonGroup eAccountStat = new ButtonGroup();
        eAccountStat.add(eAccountYes);
        eAccountStat.add(eAccountNo);
        
        
        next = new JButton("Next");
        next.setBounds(600,700,100,40);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
    
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){                    //since action class runs only if button is pressed  , but
       //                                                               here ther is only one button so no need to check for which button is pressed.
        
       
        String religion = (String) religionComboBox.getSelectedItem();
        String catagory = (String) catagoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String education = (String) eduComboBox.getSelectedItem();
        
        String occupation = (String) occupationComboBox.getSelectedItem();
        String seniorCitizen = null;
       if(sCitizenYes.isSelected()){
        
            seniorCitizen = "Yes";
        }
        else if(eAccountNo.isSelected()){
            seniorCitizen = "No";
        }
        
        String pan = panTextField.getText();
        String adhar = adharTextField.getText();
        String formno = this.formnoOne;
        System.out.println("formno is : "+formno);
        String ExistingAccount = null;
        if(eAccountYes.isSelected()){
        
            ExistingAccount = "Yes";
        }
        else if(eAccountNo.isSelected()){
            ExistingAccount = "No";
        }
      //here we are writing validation for name field
        try{
           
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+catagory+"','"+income+"','"+education+"','"+occupation+"','"+seniorCitizen+"','"+pan+"','"+adhar+"','"+ExistingAccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
            }
        catch (Exception e){
                    System.out.println(e);
            }
      
    }
    
//    public static void main(String args[]) {
//        
//        new SignupTwo("");
//     
//    }
}

