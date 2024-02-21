
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Splash1 extends JFrame implements Runnable{
    JLabel image;
    Splash1(){
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLayout(null);
 
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
    Image i2=i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    image=new JLabel(i3);
    image.setBounds(0,0,730,550);
    add(image);
    
    
    setVisible(true);   
    for(int i=1,x=1;i<600;i+=4,x++){
        setSize(i+x,i);
        setLocation(700-((i+x)/2),400-(i/2));
        try{
            Thread.sleep(5);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    }
    @Override
    public void run(){
        try{
            Thread.sleep(3000);
            setVisible(false);
            new Login1().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

public class Splash{

    public static void main(String[] args) {
        Splash1 s1=new Splash1();
        Thread t1=new Thread(s1);
        s1.setVisible(true);
        t1.start();
        
    }
    
}
