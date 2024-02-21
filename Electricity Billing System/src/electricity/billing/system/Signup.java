
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Signup1 extends JFrame implements ActionListener{
    JLabel image,account,username,name,password,meternumber;
    JTextField usernametext,nametext,meternumbertext;
    JPasswordField passwordtext;
    JComboBox account1;
    JButton create,back;
    JPanel p1;
    Signup1(){
        setLayout(null);
        setSize(720,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        p1=new JPanel();
        p1.setBounds(10,10,685,380);
        p1.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,Color.BLUE));
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250,250 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(485,10,200,250);
        p1.add(image);
        
        account=new JLabel("Create Account As");
        account.setBounds(20,30,200,30);
        account.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(account);
        String accountvalues[]={"Admin","Customer"};
        account1=new JComboBox(accountvalues);
        account1.setBounds(250,30,200,28);
        account1.setBackground(Color.LIGHT_GRAY);
        account1.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(account1);
        
        meternumber=new JLabel("Meter Number");
        meternumber.setBounds(20,85,200,30);
        meternumber.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(meternumber);
        meternumber.setVisible(false);
        meternumbertext=new JTextField();
        meternumbertext.setBounds(250,85,200,28);
        meternumbertext.setBackground(Color.LIGHT_GRAY);
        meternumbertext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(meternumbertext);
        meternumbertext.setVisible(false);
        
   
        username=new JLabel("Username");
        username.setBounds(20,140,200,30);
        username.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(username);
        usernametext=new JTextField();
        usernametext.setBounds(250,140,200,28);
        usernametext.setBackground(Color.LIGHT_GRAY);
        usernametext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(usernametext);
        
        name=new JLabel("Name");
        name.setBounds(20,200,200,30);
        name.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(name);
        nametext=new JTextField();
        nametext.setBounds(250,200,200,28);
        nametext.setBackground(Color.LIGHT_GRAY);
        nametext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(nametext);
        meternumbertext.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent fe){
                
            }
            public void focusLost(FocusEvent fe){
                try{
                    Conn c =new Conn();
                    ResultSet rs=c.statement.executeQuery("SELECT * FROM signup WHERE meternumber='"+meternumbertext.getText()+"'");
                    while(rs.next()){
                        nametext.setText(rs.getString("name"));
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        
        password=new JLabel("Password");
        password.setBounds(20,260,200,30);
        password.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(password);
        passwordtext=new JPasswordField();
        passwordtext.setBounds(250,260,200,28);
        passwordtext.setBackground(Color.LIGHT_GRAY);
        passwordtext.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(passwordtext);
        
        create=new JButton("Create");
        create.addActionListener(this);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(80,330,100,30);
        create.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(create);
        
        back=new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250,330,100,30);
        back.setFont(new Font("Raleway",Font.BOLD,18));
        p1.add(back);
        
        account1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                String user=(String)account1.getSelectedItem();
                if(user.equals("Customer")){
                    meternumber.setVisible(true);
                    meternumbertext.setVisible(true);
                    nametext.setEditable(false);
                    
                }
                else{
                    meternumber.setVisible(false);
                    meternumbertext.setVisible(false);
                    nametext.setEditable(true);
                }
            }
        });

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String saccount1 = (String)account1.getSelectedItem();
            String smeternumber = meternumbertext.getText();
            String susername = usernametext.getText();
            String sname = nametext.getText();
            String spassword = passwordtext.getText();
            
            try{
                Conn c = new Conn();
                String query=null;
                if(saccount1.equals("Admin")){
                        query=String.format("INSERT INTO signup VALUES('%s','%s','%s','%s','%s')",
                saccount1,smeternumber,susername,sname,spassword);
                }else{
                 query=String.format("UPDATE signup SET username='"+susername+"',password='"+spassword+"',account='"+saccount1+"'");
                }
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"ACCOUNT CREATED SUCCESSFULLY");
                setVisible(false);
                new Login1().setVisible(true);
            }catch(SQLException e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==back){
             setVisible(false);
             new Login1().setVisible(true);
        }
    }
         
}

public class Signup {
    public static void main(String args[]){
    Signup1 s1 = new Signup1();
    s1.setVisible(true);
    }
}
