package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

class Customerdetails1 extends JFrame implements ActionListener{
    JLabel meternumber,month;
    Choice meternovalues,monthvalues;
    JTable table;
    JButton search,print;
    Customerdetails1(){
        setSize(1200,650);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setTitle("Customer Details");
        
        table=new JTable();
        try{
            Conn c=new Conn();
            String query1="SELECT * FROM newcustomer";
            ResultSet rs=c.statement.executeQuery(query1);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        JScrollPane sp=new JScrollPane(table);
        add(sp);
    
        print=new JButton("Print");
        print.addActionListener(this);
        add(print,"South");
        
    }
    
    public void actionPerformed(ActionEvent ae){
            try{
                table.print();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

public class Customerdetails {
    public static void main(String args[]){
        Customerdetails1 c=new Customerdetails1();
        c.setVisible(true);
    }
}
