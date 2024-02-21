package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Updateinformation1 extends JFrame implements ActionListener{
    JLabel image,heading,name,nametext,meterno,metertext,address,city,state,email,phoneno;
    JTextField addresstext,citytext,statetext,emailtext,phonenotext;
    JButton update,back;
    String meter;
    Updateinformation1(String meter){
        this.meter=meter;
        setLayout(null);
        setSize(1000,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
     
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,300 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(530,100,400,300);
        add(image);
        
        heading=new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(100,10,400,20);
        heading.setFont(new Font("monospaced",Font.BOLD,22));
        add(heading);
        
        name=new JLabel("Name");
        name.setBounds(20,70,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,19));
        add(name);
        nametext=new JLabel("");
        nametext.setBounds(220,70,230,28);
        nametext.setBackground(Color.WHITE);
        nametext.setFont(new Font("Raleway",Font.BOLD,18));
        add(nametext);
        
        meterno=new JLabel("Meter Number");
        meterno.setBounds(20,130,200,30);
        meterno.setFont(new Font("Raleway",Font.BOLD,19));
        add(meterno);
        metertext=new JLabel("");
        metertext.setBounds(220,130,200,30);
        metertext.setFont(new Font("Raleway",Font.BOLD,19));
        add(metertext);
        
        address=new JLabel("Address");
        address.setBounds(20,190,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,19));
        add(address);
        addresstext=new JTextField();
        addresstext.setBounds(220,190,230,28);
        addresstext.setBackground(Color.WHITE);
        addresstext.setFont(new Font("Raleway",Font.BOLD,18));
        add(addresstext);
        
        city=new JLabel("City");
        city.setBounds(20,250,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,19));
        add(city);
        citytext=new JTextField();
        citytext.setBounds(220,250,230,28);
        citytext.setBackground(Color.WHITE);
        citytext.setFont(new Font("Raleway",Font.BOLD,18));
        add(citytext);
        
        state=new JLabel("State");
        state.setBounds(20,310,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,19));
        add(state);
        statetext=new JTextField();
        statetext.setBounds(220,310,230,28);
        statetext.setBackground(Color.WHITE);
        statetext.setFont(new Font("Raleway",Font.BOLD,18));
        add(statetext);
        
        email=new JLabel("Email");
        email.setBounds(20,370,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,19));
        add(email);
        emailtext=new JTextField();
        emailtext.setBounds(220,370,230,28);
        emailtext.setBackground(Color.WHITE);
        emailtext.setFont(new Font("Raleway",Font.BOLD,18));
        add(emailtext);
        
        phoneno=new JLabel("Phone Number");
        phoneno.setBounds(20,430,200,30);
        phoneno.setFont(new Font("Raleway",Font.BOLD,19));
        add(phoneno);
        phonenotext=new JTextField();
        phonenotext.setBounds(220,430,230,28);
        phonenotext.setBackground(Color.WHITE);
        phonenotext.setFont(new Font("Raleway",Font.BOLD,18));
        add(phonenotext);
        
        update=new JButton("Update");
        update.addActionListener(this);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(140,490,100,30);
        update.setFont(new Font("Raleway",Font.BOLD,19));
        add(update);
        
        back=new JButton("Back");
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(340,490,100,30);
        back.setFont(new Font("Raleway",Font.BOLD,19));
        add(back);
        try{
            Conn c=new Conn();
            String query="SELECT * FROM newcustomer where meternumber='"+meter+"'";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next()){
                nametext.setText(rs.getString("customername"));
                metertext.setText(rs.getString("meternumber"));
                addresstext.setText(rs.getString("address"));
                citytext.setText(rs.getString("city"));
                statetext.setText(rs.getString("state"));
                emailtext.setText(rs.getString("email"));
                phonenotext.setText(rs.getString("phoneno"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String smeterno=metertext.getText();
            String saddress=addresstext.getText();
            String scity=citytext.getText();
            String sstate=statetext.getText();
            String semail=emailtext.getText();
            String sphoneno=phonenotext.getText();
            try{
            Conn c=new Conn();
            
            String query=String.format("UPDATE newcustomer SET address='"+saddress+"',city='"+scity+"',state='"+sstate+"',email='"+semail+"',phoneno='"+sphoneno+"' WHERE meternumber='"+meter+"'");
            c.statement.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Information Updated Successfully");
            setVisible(false);     
            }catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==back){
            setVisible(false);
            new Project1("","").setVisible(true);
        }
    }
}
        
public class Updateinformation {
    public static void main(String args[]){
        Updateinformation1 u=new Updateinformation1("");
        u.setVisible(true);
    }
}
