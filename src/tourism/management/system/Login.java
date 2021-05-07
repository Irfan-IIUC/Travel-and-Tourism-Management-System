package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    JTextField t1, t2;

    Login() {

        super("Login");

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/dest7.jpg"));
        Image i5 = i4.getImage().getScaledInstance(690, 400, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(0, 0, 690, 400);
        add(l4);

        JLabel l2 = new JLabel("Username");
        l2.setFont(new Font("serif", Font.PLAIN, 23));
        l2.setBounds(60, 20, 100, 25);
        l4.add(l2);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setBounds(60, 60, 250, 25);
        l4.add(t1);

        JLabel l3 = new JLabel("Password");
        l3.setFont(new Font("serif", Font.PLAIN, 23));
        l3.setBounds(60, 110, 100, 25);
        l4.add(l3);

        t2 = new JPasswordField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setBounds(60, 150, 250, 25);
        l4.add(t2);

        b1 = new JButton("Login");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(60, 200, 75, 30);
        b1.addActionListener(this);
        l4.add(b1);

        b2 = new JButton("Sign-Up");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(60, 250, 75, 30);
        b2.addActionListener(this);
        l4.add(b2);

        b3 = new JButton("Forgot Password");
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(60, 300, 150, 30);
        b3.addActionListener(this);
        l4.add(b3);

        setLayout(null);
        setSize(690, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                String username = t1.getText();
                String password = t2.getText();

                Conn con = new Conn();
                String str = "select * from account where username = '" + t1.getText() + "' AND password = '" + t2.getText() + "'";

                ResultSet rs = con.s.executeQuery(str);

                if (rs.next()) {

                    this.setVisible(false);
                    new Loading(username).setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Username or Password !");

                    t1.setText(null);
                    t2.setText(null);
                }

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {

            this.setVisible(false);
            new Signup().setVisible(true);

        } else if (ae.getSource() == b3) {

            this.setVisible(false);
            new ForgotPass().setVisible(true);

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new Login().setVisible(true);
    }
}
