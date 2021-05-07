package tourism.management.system;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Signup extends JFrame implements ActionListener {

    JButton b1, b2;
    JTextField t1, t2, t4;
    JPasswordField t3;
    Choice c1;

    Signup() {

        super("Sign-Up");

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 430, 400);
        p1.setLayout(null);
        add(p1);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(50, 20, 100, 25);
        p1.add(l1);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 14));
        t1.setBounds(190, 20, 180, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(50, 60, 100, 25);
        p1.add(l2);

        t2 = new JTextField();
        t2.setFont(new Font("Tahoma", Font.BOLD, 14));
        t2.setBounds(190, 60, 180, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        JLabel l3 = new JLabel("Password");
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(50, 100, 100, 25);
        p1.add(l3);

        t3 = new JPasswordField();
        t3.setFont(new Font("Tahoma", Font.BOLD, 14));
        t3.setBounds(190, 100, 180, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        JLabel l4 = new JLabel("Security Question");
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(50, 140, 125, 25);
        p1.add(l4);

        c1 = new Choice();
        c1.add("Your Lucky Number");
        c1.add("Your Childhood Hero");
        c1.add("Your Favourite Movie");
        c1.setBounds(190, 140, 180, 25);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(c1);

        JLabel l5 = new JLabel("Answer");
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(50, 180, 100, 25);
        p1.add(l5);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 14));
        t4.setBounds(190, 180, 180, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(420, 40, 250, 250);
        add(l6);

        b1 = new JButton("Create");
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setBounds(80, 250, 100, 30);
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.setBounds(245, 250, 100, 30);
        b2.addActionListener(this);
        p1.add(b2);

        setLayout(null);
        setSize(700, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();

            String query = "insert into account values('" + username + "', '" + name + "', '" + password + "', '" + security + "', '" + answer + "')";

            try {

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfuly");
                this.setVisible(false);
                new Login().setVisible(true);

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {

            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new Signup().setVisible(true);
    }
}
