package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ForgotPass extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;

    ForgotPass() {

        super("Forgot Password");

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 300);
        add(p1);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(40, 20, 100, 25);
        p1.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(40, 60, 75, 21);
        p1.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(40, 100, 165, 27);
        p1.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(40, 140, 104, 21);
        p1.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(40, 180, 104, 21);
        p1.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 14));
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setBounds(220, 20, 150, 25);
        p1.add(t1);

        t2 = new JTextField();
        t2.setFont(new Font("Tahoma", Font.BOLD, 14));
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setBounds(220, 60, 150, 25);
        p1.add(t2);

        t3 = new JTextField();
        t3.setBorder(BorderFactory.createEmptyBorder());
        t3.setFont(new Font("Tahoma", Font.BOLD, 14));
        t3.setBounds(220, 100, 260, 25);
        p1.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 14));
        t4.setBorder(BorderFactory.createEmptyBorder());
        t4.setBounds(220, 140, 150, 25);
        p1.add(t4);

        t5 = new JTextField();
        t5.setFont(new Font("Tahoma", Font.BOLD, 14));
        t5.setBorder(BorderFactory.createEmptyBorder());
        t5.setBounds(220, 180, 150, 25);
        p1.add(t5);

        b1 = new JButton("Search");
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setBounds(380, 20, 100, 25);
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Retrive");
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.setBounds(380, 140, 100, 25);
        b2.addActionListener(this);
        p1.add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("Tahoma", Font.BOLD, 14));
        b3.setBounds(150, 230, 100, 25);
        b3.addActionListener(this);
        p1.add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(580, 70, 200, 200);
        add(l6);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(830, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {

            Conn con = new Conn();

            if (ae.getSource() == b1) {
                
                String query = "select * from account where username = ?";
                PreparedStatement st = con.c.prepareStatement(query);
                
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();
                
                while(rs.next()){
                    
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("security"));
                }
                
                st.close();
                con.c.close();

            } else if (ae.getSource() == b2) {
                
                String query = "select * from account where answer = ?";
                PreparedStatement st = con.c.prepareStatement(query);
                
                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();
                
                while(rs.next()){
                    
                    t5.setText(rs.getString("password"));
                }
                
                st.close();
                con.c.close();

            } else if (ae.getSource() == b3) {

                this.setVisible(false);
                new Login().setVisible(true);
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new ForgotPass().setVisible(true);
    }
}
