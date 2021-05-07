
package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Loading extends JFrame implements Runnable{
    
    JProgressBar pb;
    Thread t1;
    String username;
    
    public void run(){
        
        try{
            
            for(int i=1; i<102; i++){
                
                int m = pb.getMaximum();
                int n = pb.getValue();
                
                if(n<m){
                    
                    pb.setValue(pb.getValue() + 1);
                    
                } else{
                    
                    this.setVisible(false);
                    new Dashboard(username).setVisible(true);
                }
                
                Thread.sleep(50);
            }
            
        } catch(Exception e){
            
            System.out.println(e);
        }
    }
    
    Loading(String user){
        
        super("Loading");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/dest1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(580, 400, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 580, 400);
        add(l4);
        
        username = user;
        t1 = new Thread(this);
        
        JLabel l1 = new JLabel("Travel and Tourism Application");
        l1.setFont(new Font("serif", Font.BOLD, 35));
        l1.setForeground(Color.black);
        l1.setBounds(50, 20, 600, 40);
        l4.add(l1);
        
        pb = new JProgressBar();
        pb.setStringPainted(true);
        pb.setBounds(135, 100, 300, 25);
        l4.add(pb);
        
        JLabel l2 = new JLabel("Please Wait ...");
        l2.setFont(new Font("serif", Font.BOLD, 20));
        l2.setBounds(230, 130, 600, 40);
        l2.setForeground(Color.BLACK);
        l4.add(l2);
        
        JLabel l3 = new JLabel("Welcome  " +username);
        l3.setFont(new Font("serif", Font.PLAIN, 20));
        l3.setBounds(60, 310, 400, 25);
        l3.setForeground(Color.WHITE);
        l4.add(l3);
        
        setLayout(null);
        setSize(580, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        t1.start();
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        
        new Loading("").setVisible(true);
    }
}
