
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewInformation1 extends JFrame{
    JLabel image,heading,name,fetchname,meterno,fetchmeterno,address,fetchaddress,city,fetchcity,state,fetchstate,email,fetchemail,phoneno,fetchphoneno;
    JButton cancel;
    String meter;
    ViewInformation1(String meter){
        this.meter=meter;
        setLayout(null);
        setSize(850,650);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setTitle("View Information");
        
        heading=new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(270,0,500,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,19));
        add(heading);
        
        name=new JLabel("Name");
        name.setBounds(70,80,100,20);
        name.setFont(new Font("Tahoma",Font.BOLD,16));
        add(name);
        
        fetchname=new JLabel("");
        fetchname.setBounds(225,80,200,20);
        fetchname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchname);
        
        meterno=new JLabel("Meter Number");
        meterno.setBounds(70,140,150,20);
        meterno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(meterno);
        
        fetchmeterno=new JLabel("");
        fetchmeterno.setBounds(225,140,200,20);
        fetchmeterno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchmeterno);
        
        address=new JLabel("Address");
        address.setBounds(70,200,100,20);
        address.setFont(new Font("Tahoma",Font.BOLD,16));
        add(address);
        
        fetchaddress=new JLabel("");
        fetchaddress.setBounds(225,200,200,20);
        fetchaddress.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchaddress);
        
        city=new JLabel("City");
        city.setBounds(70,260,100,20);
        city.setFont(new Font("Tahoma",Font.BOLD,16));
        add(city);
        
        fetchcity=new JLabel("");
        fetchcity.setBounds(225,260,200,20);
        fetchcity.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchcity);
        
        state=new JLabel("State");
        state.setBounds(450,80,100,20);
        state.setFont(new Font("Tahoma",Font.BOLD,16));
        add(state);
        
        fetchstate=new JLabel("");
        fetchstate.setBounds(600,80,200,20);
        fetchstate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchstate);
        
        email=new JLabel("Email");
        email.setBounds(450,140,100,20);
        email.setFont(new Font("Tahoma",Font.BOLD,16));
        add(email);
        
        fetchemail=new JLabel("");
        fetchemail.setBounds(600,140,250,20);
        fetchemail.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchemail);
        
        phoneno=new JLabel("Phone No.");
        phoneno.setBounds(450,200,100,20);
        phoneno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(phoneno);
        
        fetchphoneno=new JLabel("");
        fetchphoneno.setBounds(600,200,200,20);
        fetchphoneno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchphoneno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.statement.executeQuery("SELECT * FROM newcustomer WHERE meternumber='"+meter+"'");
            while(rs.next()){
                fetchname.setText(rs.getString("customername"));
                fetchmeterno.setText(rs.getString("meternumber"));
                fetchaddress.setText(rs.getString("address"));
                fetchcity.setText(rs.getString("city"));
                fetchstate.setText(rs.getString("state"));
                fetchemail.setText(rs.getString("email"));
                fetchphoneno.setText(rs.getString("phoneno"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        cancel=new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350,340,100,30);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);
    }

}

public class ViewInformation {
    public static void main(String args[]){
        ViewInformation1 v=new ViewInformation1("");
        v.setVisible(true);
    }
}
