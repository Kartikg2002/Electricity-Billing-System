
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Meterinfo1 extends JFrame implements ActionListener{
    JLabel image,text,meterno,metertext,meterlocation,metertype,phasecode,billtype,days,dtext,note,ntext;
    JComboBox mltext,mttext,pctext,bttext;
    JButton submit,cancel;
    JPanel p1;
    String meternumber;
    Meterinfo1(String meternumber){
        this.meternumber=meternumber;
        setLayout(null);
        setSize(880,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        p1=new JPanel();
        p1.setBounds(200,20,680,600);
        p1.setLayout(null);
        p1.setBackground(new Color(173,216,230));
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(210,400 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,60,210,400);
        add(image);
        
        text=new JLabel("Meter Information");
        text.setBounds(250,10,300,20);
        text.setFont(new Font("monospaced",Font.BOLD,22));
        p1.add(text);
        text=new JLabel("Meter Information");
        text.setBounds(250,10,300,20);
        text.setFont(new Font("monospaced",Font.BOLD,22));
        p1.add(text);
        
        meterno=new JLabel("Meter Number");
        meterno.setBounds(120,70,200,30);
        meterno.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(meterno);
        metertext=new JLabel(meternumber);
        metertext.setBounds(320,70,200,30);
        metertext.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(metertext);
        
        meterlocation=new JLabel("Meter Location");
        meterlocation.setBounds(120,130,200,30);
        meterlocation.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(meterlocation);
        String mlvalues[]={"Outside","Inside"};
        mltext=new JComboBox(mlvalues);
        mltext.setBounds(320,130,230,30);
        mltext.setBackground(Color.WHITE);
        mltext.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(mltext);
        
        metertype=new JLabel("Meter Type");
        metertype.setBounds(120,190,200,30);
        metertype.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(metertype);
        String mtvalues[]={"Solar Meter","Electric Meter","Smart Meter"};
        mttext=new JComboBox(mtvalues);
        mttext.setBounds(320,190,230,28);
        mttext.setBackground(Color.WHITE);
        mttext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(mttext);
        
        phasecode=new JLabel("Phase Code");
        phasecode.setBounds(120,250,200,30);
        phasecode.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(phasecode);
        String pcvalues[]={"011","022","033","044","055","066","077","088","099"};
        pctext=new JComboBox(pcvalues);
        pctext.setBounds(320,250,230,28);
        pctext.setBackground(Color.WHITE);
        pctext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(pctext);
        
        billtype=new JLabel("Bill Type");
        billtype.setBounds(120,310,200,30);
        billtype.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(billtype);
        String btvalues[]={"Normal","Industrial"};
        bttext=new JComboBox(btvalues);
        bttext.setBounds(320,310,230,28);
        bttext.setBackground(Color.WHITE);
        bttext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(bttext);
        
        days=new JLabel("Days");
        days.setBounds(120,370,200,30);
        days.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(days);
        dtext=new JLabel("30 Days");
        dtext.setBounds(320,370,230,28);
        dtext.setBackground(Color.WHITE);
        dtext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(dtext);
        
        note=new JLabel("Note:");
        note.setBounds(120,430,200,30);
        note.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(note);
        ntext=new JLabel("By Default Bill is Calculated For 30 Days Only.");
        ntext.setBounds(320,430,350,28);
        ntext.setBackground(Color.WHITE);
        ntext.setFont(new Font("Raleway",Font.BOLD,15));
        p1.add(ntext);
        
        submit=new JButton("Submit");
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(270,502,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,19));
        p1.add(submit);
    }
        
        public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==submit){
            String smeternumber = meternumber;
            String smeterlocation=(String)mltext.getSelectedItem();
            String smetertype=(String)mttext.getSelectedItem();
            String sphasecode=(String)pctext.getSelectedItem();
            String sbilltype=(String)bttext.getSelectedItem();
            String days="30";
            
            
            try{
            Conn c=new Conn();
            String query1=String.format("INSERT INTO meterinformation VALUES('%s','%s','%s','%s','%s','%s')",
                    smeternumber,smeterlocation,smetertype,sphasecode,sbilltype,days); 
            c.statement.executeUpdate(query1);  
            
            JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
            setVisible(false);
            
            }catch(Exception e){
                System.out.println(e);
            }
        }
           
        }
}
public class Meterinfo {
    public static void main(String args[]){
        Meterinfo1 mi1 =new Meterinfo1("");
        mi1.setVisible(true);
    }
}
