
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java .util.*;

class Project1 extends JFrame implements ActionListener{
    JLabel image;
    String atype,meter;
    Project1(String atype,String meter){
        this.atype=atype;
        this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,850 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0, 0, 1550, 850);
        add(image);
        
        JMenuBar mb= new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.addActionListener(this);
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        newcustomer.setForeground(Color.RED);
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1=icon1.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('C');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.addActionListener(this);
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.WHITE);
        customerdetails.setForeground(Color.RED);
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2=icon2.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.setMnemonic('D');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        master.add(customerdetails);
        
        
        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.addActionListener(this);
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.WHITE);
        depositdetails.setForeground(Color.RED);
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3=icon3.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.setMnemonic('M');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        master.add(depositdetails);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.addActionListener(this);
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.WHITE);
        calculatebill.setForeground(Color.RED);
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4=icon4.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.setMnemonic('C');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        master.add(calculatebill);
        
        JMenu information = new JMenu("Information");
        information.setForeground(Color.RED);
        
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.addActionListener(this);
        updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinformation.setBackground(Color.WHITE);
        updateinformation.setForeground(Color.RED);
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5=icon5.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(image5));
        updateinformation.setMnemonic('U');
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        information.add(updateinformation);
        
        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.addActionListener(this);
        viewinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinformation.setBackground(Color.WHITE);
        viewinformation.setForeground(Color.RED);
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6=icon6.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(image6));
        viewinformation.setMnemonic('V');
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        information.add(viewinformation);
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.addActionListener(this);
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.WHITE);
        paybill.setForeground(Color.RED);
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7=icon7.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('P');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        user.add(paybill);
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.addActionListener(this);
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.WHITE);
        billdetails.setForeground(Color.RED);
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8=icon8.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('L');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        
        JMenuItem generatebill= new JMenuItem("Generate Bill");
        generatebill.addActionListener(this);
        generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebill.setBackground(Color.WHITE);
        generatebill.setForeground(Color.RED);
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9=icon9.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('G');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        report.add(generatebill);
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        
        JMenuItem notepad = new JMenuItem("NotePad");
        notepad.addActionListener(this);
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        notepad.setForeground(Color.RED);
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10=icon10.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('U');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        JMenuItem calculator= new JMenuItem("Calculator");
        calculator.addActionListener(this);
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setBackground(Color.WHITE);
        calculator.setForeground(Color.RED);
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11=icon11.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        utility.add(calculator);
       
        JMenu exits = new JMenu("Exit");
        exits.setForeground(Color.RED);
        
        JMenuItem exit= new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.RED);
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12=icon12.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('E');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        exits.add(exit);
        if(atype.equals("Admin")){
        mb.add(master);
        }
        else{
        mb.add(information);
        mb.add(user);
        mb.add(report);
        }
        mb.add(utility);
        mb.add(exits);
       
        setLayout(new FlowLayout());
        
    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("New Customer")){
            new Newcustomer1().setVisible(true);
        }
        else if(msg.equals("Customer Details")){
            new Customerdetails1().setVisible(true);
        }
        else if(msg.equals("Deposit Details")){
            new Depositdetails1().setVisible(true);
        }
        else if(msg.equals("Calculate Bill")){
           new CalculateBill1().setVisible(true);
        }
        else if(msg.equals("View Information")){
            new ViewInformation1(meter).setVisible(true);
        }
        else if(msg.equals("Update Information")){
            new Updateinformation1(meter).setVisible(true);
        }
        else if(msg.equals("Bill Details")){
            new BillDetails1(meter).setVisible(true);
        }
        else if(msg.equals("NotePad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(msg.equals("Pay Bill")){
            new PayBill1(meter).setVisible(true);
        }
        else if(msg.equals("Generate Bill")){
            setVisible(false);
            new GenerateBill1(meter).setVisible(true);
        }
        else if(msg.equals("Exit")){
            setVisible(false);
            new Login1().setVisible(true);
        }
    }
}
public class Project {
    public static void main(String args[]){
        Project1 p1=new Project1("","");
        p1.setVisible(true);
        
    }
}
