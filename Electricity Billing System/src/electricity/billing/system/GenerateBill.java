package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class GenerateBill1 extends JFrame implements ActionListener{
    JLabel heading,meternumber;
    JPanel p;
    Choice monthvalues;
    JTextArea area;
    JButton bill;
    String meter;
    GenerateBill1(String meter){
        this.meter=meter;
        setSize(550,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocation(450,30);
        
        p=new JPanel();
        p.setBackground(Color.RED);
        
        
        heading =new JLabel("Generate Bill");
        heading.setBounds(185,10,400,30);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        add(heading);
        
        meternumber=new JLabel(meter);
        meternumber.setFont(new Font("Raleway",Font.BOLD,25));
        
        monthvalues =new Choice();
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
        monthvalues.setFont(new Font("Raleway",Font.BOLD,14));
        add(monthvalues);
        
        area=new JTextArea(50,15);
        area.setBackground(Color.BLUE);
        area.setText("\n\n\t  ---------Click on the---------\n\t   Generate Bill Button to get\n\t  the bill of the Selected Month");
        area.setFont(new Font("Sensserif",Font.ITALIC,18));
        JScrollPane pane=new JScrollPane(area);
        
        
        bill=new JButton("Generate Bill");
        bill.addActionListener(this);
        
        p.add(heading);
        p.add(meternumber);
        p.add(monthvalues);
        add(p,"North");
        add(pane,"Center");
        add(bill,"South");

    }
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c= new Conn();
            
            String smonth=monthvalues.getSelectedItem();
            
            area.setText("\t    Reliance Power Limited\n      ELECTRICITY BILL GENERATED FOR THE MONTH OF\n\t         "+smonth+""
                    + ",2022");
            
            ResultSet rs=c.statement.executeQuery("SELECT * FROM newcustomer WHERE meternumber='"+meter+"'");
            
            if(rs.next()){
                area.append("\n\n\n\n    Customer Name: "+rs.getString("customername"));
                area.append("\n    Meter Number : "+rs.getString("meternumber"));
                area.append("\n    Address      : "+rs.getString("address"));
                area.append("\n    City         : "+rs.getString("city"));
                area.append("\n    State        : "+rs.getString("state"));
                area.append("\n    Email        : "+rs.getString("email"));
                area.append("\n    Phone No.    : "+rs.getString("phoneno"));
                area.append("\n------------------------------------------------------------------------");
            }
            
            rs=c.statement.executeQuery("SELECT * FROM meterinformation WHERE meternumber='"+meter+"'");
            
            if(rs.next()){
                area.append("\n    Meter Location: "+rs.getString("meterlocation"));
                area.append("\n    Meter Type : "+rs.getString("metertype"));
                area.append("\n    Phasecode      : "+rs.getString("phasecode"));
                area.append("\n    BillType         : "+rs.getString("billtype"));
                area.append("\n    Days        : "+rs.getString("days"));
                area.append("\n------------------------------------------------------------------------");
            }
            
            rs=c.statement.executeQuery("SELECT * FROM tax");
            
            if(rs.next()){
                area.append("\n    Cost Per Unit: "+rs.getString("cost_per_unit"));
                area.append("\n    Meter Rent : "+rs.getString("meter_rent"));
                area.append("\n    Service Charge      : "+rs.getString("service_charge"));
                area.append("\n    Service Tax         : "+rs.getString("service_tax"));
                area.append("\n    Swacch Bharat Cess  : "+rs.getString("swacch_bharat_cess"));
                area.append("\n    Fixed Tax       : "+rs.getString("fixed_tax"));
                area.append("\n------------------------------------------------------------------------");
            }
            
            rs=c.statement.executeQuery("SELECT * FROM bill WHERE meter_no='"+meter+"' AND month='"+smonth+"'");
            
            if(rs.next()){
                area.append("\n    Current Month: "+rs.getString("month"));
                area.append("\n    Units Consumed : "+rs.getString("units"));
                area.append("\n    Total Charges   : "+rs.getString("totalbill"));
                area.append("\n------------------------------------------------------------------------");
                area.append("\n\n   Total Payable         : "+rs.getString("totalbill"));                
            }
            
            }catch(Exception e){
            
        }
    }
}

public class GenerateBill {
    public static void main(String args[]){
        new GenerateBill1("").setVisible(true);
    }
}
