
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

class Depositdetails1 extends JFrame implements ActionListener{
    JLabel meternumber,month;
    Choice meternovalues,monthvalues;
    JTable table;
    JButton search,print;
    Depositdetails1(){
        setLayout(null);
        setSize(700,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setTitle("Deposit Details");
        
        meternumber=new JLabel("Search By Meter Number");
        meternumber.setBounds(20,20,200,30);
        meternumber.setFont(new Font("Raleway",Font.BOLD,16));
        add(meternumber);
        meternovalues =new Choice();
        meternovalues.setBounds(260,22,220,18);
        meternovalues.setFont(new Font("Raleway",Font.BOLD,14));
        add(meternovalues);
        try{
            Conn c=new Conn();
            String query="SELECT * FROM newcustomer";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next()){
                meternovalues.add(rs.getString("meternumber"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        month=new JLabel("Search By Month");
        month.setBounds(20,80,200,30);
        month.setFont(new Font("Raleway",Font.BOLD,16));
        add(month);
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
        monthvalues.setBounds(260,82,220,18);
        monthvalues.setFont(new Font("Raleway",Font.BOLD,14));
        add(monthvalues);
        
        table=new JTable();
        try{
            Conn c=new Conn();
            String query1="SELECT * FROM bill";
            ResultSet rs=c.statement.executeQuery(query1);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,180,700,600);
        add(sp);
        
        search=new JButton("Search");
        search.addActionListener(this);
        search.setBounds(20,130,80,20);
        add(search);
        
        print=new JButton("Print");
        print.addActionListener(this);
        print.setBounds(120,130,80,20);
        add(print);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                Conn c= new Conn();
                String query="SELECT * FROM bill WHERE meter_no='"+meternovalues.getSelectedItem()+"'"
                + " and WHERE month='"+monthvalues.getSelectedItem()+"'";
                ResultSet rs=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                System.out.println(e);
                }
        }
        else{
            try{
                table.print();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
public class Depositdetails {
    public static void main(String args[]){
        Depositdetails1 d=new Depositdetails1();
        d.setVisible(true);
    }
}
