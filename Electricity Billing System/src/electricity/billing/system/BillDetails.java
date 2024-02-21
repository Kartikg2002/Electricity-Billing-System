
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

class BillDetails1 extends JFrame{
    String meter;
    BillDetails1(String meter){
        this.meter=meter;
        setLayout(null);
        setSize(700,650);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        JTable table =new JTable();
        try{
            Conn c=new Conn();
            String query="SELECT * FROM bill WHERE meter_no='"+meter+"'";
            ResultSet rs = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);
    }
}
public class BillDetails {
    public static void main(String args[]){
    BillDetails1 d1= new BillDetails1("");
    d1.setVisible(true);
    }
}
