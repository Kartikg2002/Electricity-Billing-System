
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

class CalculateBill1 extends JFrame implements ActionListener{
    JLabel image,text,meterno,name,address,unit,month,fname,faddress;
    JTextField utext;
    Choice meternovalues,monthvalues;
    JButton submit,cancel;
    JPanel p1;
    CalculateBill1(){
        setLayout(null);
        setSize(800,550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        p1=new JPanel();
        p1.setBounds(200,20,600,550);
        p1.setLayout(null);
        p1.setBackground(new Color(173,216,230));
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,400 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,60,200,400);
        add(image);
        
        text=new JLabel("Calculate Electricity Bill");
        text.setBounds(150,10,400,20);
        text.setFont(new Font("monospaced",Font.BOLD,22));
        p1.add(text);
        
        meterno=new JLabel("Meter No");
        meterno.setBounds(120,70,200,30);
        meterno.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(meterno);
        meternovalues=new Choice();
        try{
            Conn c=new Conn();
            String query="SELECT*FROM newcustomer";
            ResultSet resultset=c.statement.executeQuery(query);
            while(resultset.next()){
                meternovalues.add(resultset.getString("meternumber"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        meternovalues.setBounds(320,70,230,28);
        meternovalues.setBackground(Color.WHITE);
        meternovalues.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(meternovalues);
                
        name=new JLabel("Name");
        name.setBounds(120,130,200,30);
        name.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(name);
        fname=new JLabel();
        fname.setBounds(320,130,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(fname);

        address=new JLabel("Address");
        address.setBounds(120,190,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(address);
        faddress=new JLabel();
        faddress.setBounds(320,190,200,30);
        faddress.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(faddress);
        try{
            Conn c=new Conn();
            String query="SELECT*FROM newcustomer WHERE meternumber='"+meternovalues.getSelectedItem()+"'";
            ResultSet resultset=c.statement.executeQuery(query);
            while(resultset.next()){
                fname.setText(resultset.getString("customername"));
                faddress.setText(resultset.getString("address"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        meternovalues.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c=new Conn();
            String query="SELECT*FROM newcustomer WHERE meternumber='"+meternovalues.getSelectedItem()+"'";
            ResultSet resultset=c.statement.executeQuery(query);
            while(resultset.next()){
                fname.setText(resultset.getString("customername"));
                faddress.setText(resultset.getString("address"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
            }
        });
        
        unit=new JLabel("Units Consumed");
        unit.setBounds(120,250,200,30);
        unit.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(unit);
        utext=new JTextField();
        utext.setBounds(320,250,230,28);
        utext.setBackground(Color.WHITE);
        utext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(utext);
        
        month=new JLabel("Month");
        month.setBounds(120,310,200,30);
        month.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(month);
        monthvalues=new Choice();
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
        monthvalues.setBounds(320,310,230,28);
        monthvalues.setBackground(Color.WHITE);
        monthvalues.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(monthvalues);
        
        submit=new JButton("Submit");
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(140,420,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(submit);
        
        cancel=new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(340,420,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(cancel);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String smeterno=meternovalues.getSelectedItem();
            String units=utext.getText();
            String month=monthvalues.getSelectedItem();
            int totalbill=0;
            int unitsconsumed=Integer.parseInt(units);
            try{
            Conn c=new Conn();
            String query="SELECT * FROM tax";
            ResultSet resultset=c.statement.executeQuery(query);  
            while(resultset.next()){
                totalbill+=unitsconsumed*Integer.parseInt(resultset.getString("cost_per_unit"));
                totalbill+=Integer.parseInt(resultset.getString("meter_rent"));
                totalbill+=Integer.parseInt(resultset.getString("service_charge"));
                totalbill+=Integer.parseInt(resultset.getString("service_tax"));
                totalbill+=Integer.parseInt(resultset.getString("swacch_bharat_cess"));
                totalbill+=Integer.parseInt(resultset.getString("fixed_tax"));
            } 
            }catch(Exception e){
                System.out.println(e);
            }
            try{
                Conn c =new Conn();
                String query2=String.format("INSERT INTO bill VALUES('%s','%s','%s','%s','%s')",
                smeterno,month,units,totalbill,"NOT PAID"); 
                c.statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
        }
    }
}
public class CalculateBill{
    public static void main(String args[]){
        CalculateBill1 c1=new CalculateBill1();
        c1.setVisible(true);
    }
}
