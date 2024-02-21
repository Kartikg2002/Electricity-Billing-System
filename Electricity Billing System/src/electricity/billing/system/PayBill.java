package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class PayBill1 extends JFrame implements ActionListener{
    JLabel image,heading,meternumber,fetchmeternumber,name,fetchname,month,units,fetchunits,totalbill,fetchtotalbill,status,fetchstatus;
    Choice monthvalues;
    String meter;
    JButton back,pay;
    PayBill1(String meter){
        this.meter=meter;
        setLayout(null);
        setSize(880,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2=i1.getImage().getScaledInstance(400,300 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(530,100,400,300);
        add(image);
        
        
        heading=new JLabel("Electricity Bill");
        heading.setBounds(350,10,400,30);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        add(heading);
        
        meternumber=new JLabel("Meter No.");
        meternumber.setBounds(70,80,100,20);
        meternumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(meternumber);
        
        fetchmeternumber=new JLabel("");
        fetchmeternumber.setBounds(300,80,200,20);
        fetchmeternumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchmeternumber);
        
        name=new JLabel("Name");
        name.setBounds(70,140,100,20);
        name.setFont(new Font("Tahoma",Font.BOLD,16));
        add(name);
        
        fetchname=new JLabel("");
        fetchname.setBounds(300,140,200,20);
        fetchname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchname);
        
        month=new JLabel("Month");
        month.setBounds(70,200,100,20);
        month.setFont(new Font("Tahoma",Font.BOLD,16));
        add(month);
        
        monthvalues =new Choice();      
        monthvalues.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.statement.executeQuery("SELECT * FROM bill WHERE meter_no='"+meter+"' AND month='"+monthvalues.getSelectedItem()+"'");
                    while(rs.next()){
                            fetchunits.setText(rs.getString("units"));
                            fetchtotalbill.setText(rs.getString("totalbill"));
                            fetchstatus.setText(rs.getString("status"));
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        monthvalues.add("January");
        monthvalues.add("February");
        monthvalues.add("March");
        monthvalues.add("April");
        monthvalues.add("May");
        monthvalues.add("June");
        monthvalues.add("July");
        monthvalues.add("August");
        monthvalues.add("September");
        monthvalues.add("October");
        monthvalues.add("November");
        monthvalues.add("December");
        monthvalues.setBounds(300,200,220,18);
        monthvalues.setFont(new Font("Raleway",Font.BOLD,14));
        add(monthvalues);
        
        units=new JLabel("Units");
        units.setBounds(70,260,100,20);
        units.setFont(new Font("Tahoma",Font.BOLD,16));
        add(units);
        
        fetchunits=new JLabel("");
        fetchunits.setBounds(300,260,200,20);
        fetchunits.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchunits);
        
        totalbill=new JLabel("Total Bill");
        totalbill.setBounds(70,320,100,20);
        totalbill.setFont(new Font("Tahoma",Font.BOLD,16));
        add(totalbill);
        
        fetchtotalbill=new JLabel("");
        fetchtotalbill.setBounds(300,320,200,20);
        fetchtotalbill.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchtotalbill);
        
        status=new JLabel("Status");
        status.setBounds(70,380,100,20);
        status.setFont(new Font("Tahoma",Font.BOLD,16));
        status.setForeground(Color.RED);
        add(status);
        
        fetchstatus=new JLabel("");
        fetchstatus.setBounds(300,380,200,20);
        fetchstatus.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fetchstatus);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.statement.executeQuery("SELECT * FROM newcustomer WHERE meternumber='"+meter+"'");
            while(rs.next()){
                fetchname.setText(rs.getString("customername"));
                fetchmeternumber.setText(rs.getString("meternumber"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        pay=new JButton("Pay");
        pay.addActionListener(this);
        pay.setForeground(Color.WHITE);
        pay.setBackground(Color.BLACK);
        pay.setBounds(140,490,100,30);
        pay.setFont(new Font("Raleway",Font.BOLD,19));
        add(pay);
        
        back=new JButton("Back");
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(340,490,100,30);
        back.setFont(new Font("Raleway",Font.BOLD,19));
        add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
            try{
                Conn c=new Conn();
                c.statement.executeUpdate("UPDATE bill SET status='Paid' WHERE meter_no='"+meter+"' AND month='"+monthvalues.getSelectedItem()+"'");
            }catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);
            new Paytm(meter).setVisible(true);
        }
        else{
            new Project1("","").setVisible(true);
        }
    }
        
}

public class PayBill {
    public static void main(String args[]){
    PayBill1 p =new PayBill1("");
    p.setVisible(true);
    }
}
