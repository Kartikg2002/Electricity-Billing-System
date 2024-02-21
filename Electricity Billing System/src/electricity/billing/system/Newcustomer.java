package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

class Newcustomer1 extends JFrame implements ActionListener{
    JLabel image,randomtext,text,customername,meterno,address,city,state,email,phoneno;
    JTextField cntext,mntext,atext,ctext,stext,etext,ptext;
    JButton next,cancel;
    JPanel p1;
    Random r=new Random();
    long random=Math.abs((r.nextLong()%900000L)+100000L);
    Newcustomer1(){
        setLayout(null);
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        p1=new JPanel();
        p1.setBounds(200,20,600,600);
        p1.setLayout(null);
        p1.setBackground(new Color(173,216,230));
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(210,400 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,60,210,400);
        add(image);
        
        text=new JLabel("New Customer");
        text.setBounds(250,10,200,20);
        text.setFont(new Font("monospaced",Font.BOLD,22));
        p1.add(text);
        
        customername=new JLabel("Customer Name");
        customername.setBounds(120,70,200,30);
        customername.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(customername);
        cntext=new JTextField();
        cntext.setBounds(320,70,230,28);
        cntext.setBackground(Color.WHITE);
        cntext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(cntext);
        
        meterno=new JLabel("Meter No");
        meterno.setBounds(120,130,200,30);
        meterno.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(meterno);
        randomtext=new JLabel(""+random);
        randomtext.setBounds(320,130,200,30);
        randomtext.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(randomtext);
        
        address=new JLabel("Address");
        address.setBounds(120,190,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(address);
        atext=new JTextField();
        atext.setBounds(320,190,230,28);
        atext.setBackground(Color.WHITE);
        atext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(atext);
        
        city=new JLabel("City");
        city.setBounds(120,250,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(city);
        ctext=new JTextField();
        ctext.setBounds(320,250,230,28);
        ctext.setBackground(Color.WHITE);
        ctext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(ctext);
        
        state=new JLabel("State");
        state.setBounds(120,310,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(state);
        stext=new JTextField();
        stext.setBounds(320,310,230,28);
        stext.setBackground(Color.WHITE);
        stext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(stext);
        
        email=new JLabel("Email");
        email.setBounds(120,370,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(email);
        etext=new JTextField();
        etext.setBounds(320,370,230,28);
        etext.setBackground(Color.WHITE);
        etext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(etext);
        
        phoneno=new JLabel("Phone Number");
        phoneno.setBounds(120,430,200,30);
        phoneno.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(phoneno);
        ptext=new JTextField();
        ptext.setBounds(320,430,230,28);
        ptext.setBackground(Color.WHITE);
        ptext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(ptext);
        
        next=new JButton("Next");
        next.addActionListener(this);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(140,490,100,30);
        next.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(next);
        
        cancel=new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(340,490,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(cancel);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String scustomername=cntext.getText();
            String smeterno=String.valueOf(random);
            String saddress=atext.getText();
            String scity=ctext.getText();
            String sstate=stext.getText();
            String semail=etext.getText();
            String sphoneno=ptext.getText();
            try{
            Conn c=new Conn();
            
            String query1=String.format("INSERT INTO newcustomer VALUES('%s','%s','%s','%s','%s','%s','%s')",
                    scustomername,smeterno,saddress,scity,sstate,semail,sphoneno);
            String query2=String.format("INSERT INTO signup VALUES('%s','%s','%s','%s','%s')",
                    "Customer",smeterno,"",scustomername,"");
            
            c.statement.executeUpdate(query1);
            c.statement.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Customer Information Added Successfully");
            setVisible(false);
            new Meterinfo1(smeterno).setVisible(true);
            
            }catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
}

public class Newcustomer {
    public static void main(String[]args){
      Newcustomer1 n1=new Newcustomer1();
      n1.setVisible(true);
    }
}
