
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {
    String meter;
    JButton back;
    Paytm(String meter){
        this.meter=meter;
        
        
        setSize(1000,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        
        try{
            j.setPage("https://paytm.com/online-payments");
        }catch(Exception e){
          j.setContentType("text/html");
          j.setText("<html>COULD NOT LOAD</html>");
        }
        JScrollPane pane= new JScrollPane(j);
        add(pane);
        
        back=new JButton("Back");
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(640,20,100,30);
        back.setFont(new Font("Raleway",Font.BOLD,19));
        j.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new PayBill1(meter).setVisible(true);
    }
    public static void main(String args[]){
        new Paytm(""); 
    }
}
