
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login1 extends JFrame implements ActionListener{
    JLabel image,username,password,logging;
    JTextField text;
    JPasswordField passwordtext;
    JComboBox logging1;
    JButton login,cancel,signup;
    Login1(){
        setLayout(null);
        setSize(720,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,300 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(2,10,250,300);
        add(image);
        
        username=new JLabel("Username");
        username.setBounds(290,60,140,30);
        username.setFont(new Font("Raleway",Font.BOLD,22));
        add(username);
        
        text=new JTextField();
        text.setBounds(450,60,200,28);
        text.setFont(new Font("Raleway",Font.BOLD,22));
        add(text);
        
        password=new JLabel("Password");
        password.setBounds(290,140,140,30);
        password.setFont(new Font("Raleway",Font.BOLD,22));
        add(password);
        
        passwordtext=new JPasswordField();
        passwordtext.setBounds(450,140,200,28);
        passwordtext.setFont(new Font("Raleway",Font.BOLD,22));
        add(passwordtext);
        
        logging=new JLabel("Logging in as");
        logging.setBounds(290,220,140,30);
        logging.setFont(new Font("Raleway",Font.BOLD,22));
        add(logging);
        
        String loggingvalues[]={"Admin","Customer"};
        logging1=new JComboBox(loggingvalues);
        logging1.setBounds(450,220,200,28);
        logging1.setBackground(Color.LIGHT_GRAY);
        logging1.setFont(new Font("Raleway",Font.BOLD,22));
        add(logging1);
  
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i5=i4.getImage().getScaledInstance(30,26 , Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        login=new JButton("Login",i6);
        login.addActionListener(this);
        login.setBounds(330,300,140,28);
        login.setFont(new Font("Raleway",Font.BOLD,22));
        add(login);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i8=i7.getImage().getScaledInstance(30,26 , Image.SCALE_DEFAULT);
        ImageIcon i9 =new ImageIcon(i8);
        cancel=new JButton("Cancel",i9);
        cancel.addActionListener(this);
        cancel.setBounds(500,300,140,28);
        cancel.setFont(new Font("Raleway",Font.BOLD,22));
        add(cancel);
        
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i11=i10.getImage().getScaledInstance(30,26 , Image.SCALE_DEFAULT);
        ImageIcon i12 =new ImageIcon(i11);
        signup=new JButton("Signup",i12);
        signup.addActionListener(this);
        signup.setBounds(412,360,140,28);
        signup.setFont(new Font("Raleway",Font.BOLD,22));
        add(signup);
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String susername=text.getText();
            String spassword=passwordtext.getText();
            String user=(String)logging1.getSelectedItem();
            try{
                Conn c=new Conn();
                String query=String.format("SELECT * From signup where username='"+susername+"' "
                + "and password='"+spassword+"' and account='"+user+"'");
                ResultSet resultset=c.statement.executeQuery(query);
                if(resultset.next()){
                    String meter=resultset.getString("meternumber");
                    setVisible(false);
                    new Project1(user,meter).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "INVALID DATA");
                    text.setText(null);
                    passwordtext.setText(null);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
}

public class Login {
    public static void  main(String args[]){
        Login1 l1=new Login1();
        l1.setVisible(true);
    }
}
