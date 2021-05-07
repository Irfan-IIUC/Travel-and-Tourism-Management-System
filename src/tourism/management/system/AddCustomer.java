package tourism.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AddCustomer extends JFrame implements ActionListener {

    private JTextField t1, t2, t3, t4, t5, t6, t7;
    JComboBox cb;
    JRadioButton r1, r2;
    Choice c1;
    JButton b1, b2;
    String username;

    AddCustomer(String username) {

        super("Add Customer");

        //this.username = username;
        JLabel l2 = new JLabel("Username : ");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(70, 50, 150, 25);
        add(l2);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 14));
        t1.setBounds(220, 50, 150, 25);
        add(t1);

        JLabel l3 = new JLabel("ID :");
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(70, 90, 150, 25);
        add(l3);

        cb = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter ID", "Driving license"});
        cb.setBounds(220, 90, 150, 25);
        cb.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(cb);

        JLabel l4 = new JLabel("Number : ");
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(70, 130, 150, 25);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(220, 130, 150, 25);
        t2.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(t2);

        JLabel l5 = new JLabel("Name : ");
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(70, 170, 150, 25);
        add(l5);

        t3 = new JTextField();
        t3.setFont(new Font("Tahoma", Font.BOLD, 14));
        t3.setBounds(220, 170, 150, 25);
        add(t3);

        JLabel l6 = new JLabel("Gender : ");
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(70, 210, 150, 25);
        add(l6);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setBounds(220, 210, 70, 25);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setBounds(300, 210, 70, 25);
        add(r2);

        JLabel l7 = new JLabel("Country : ");
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(70, 250, 150, 25);
        add(l7);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 14));
        t4.setBounds(220, 250, 150, 25);
        add(t4);

        JLabel l8 = new JLabel("Address : ");
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setBounds(70, 290, 150, 25);
        add(l8);

        t5 = new JTextField();
        t5.setFont(new Font("Tahoma", Font.BOLD, 14));
        t5.setBounds(220, 290, 150, 25);
        add(t5);

        JLabel l9 = new JLabel("Phone : ");
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setBounds(70, 330, 150, 25);
        add(l9);

        t6 = new JTextField();
        t6.setFont(new Font("Tahoma", Font.BOLD, 14));
        t6.setBounds(220, 330, 150, 25);
        add(t6);

        JLabel l10 = new JLabel("E-mail : ");
        l10.setFont(new Font("Tahoma", Font.BOLD, 14));
        l10.setBounds(70, 370, 150, 25);
        add(l10);

        t7 = new JTextField();
        t7.setFont(new Font("Tahoma", Font.BOLD, 14));
        t7.setBounds(220, 370, 150, 25);
        add(t7);

        b1 = new JButton("Add");
        b1.setBounds(70, 430, 100, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(270, 430, 100, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/newcustomer.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(330, 50, 400, 400);
        add(l1);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(700, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {

            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from account where username = '" + username + "'");

            while (rs.next()) {

                t1.setText(rs.getString("username"));
                t3.setText(rs.getString("name"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                String username = t1.getText();
                String id = (String) cb.getSelectedItem();
                String number = t2.getText();
                String name = t3.getText();

                String gender = null;

                if (r1.isSelected()) {

                    gender = "Male";

                } else if (r2.isSelected()) {

                    gender = "Female";

                }

                String country = t4.getText();
                String address = t5.getText();
                String phone = t6.getText();
                String email = t7.getText();

                Conn con = new Conn();
                String query = "insert into customer values('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + address + "', '" + phone + "', '" + email + "')";
                int a = con.s.executeUpdate(query);

                if (a > 0) {

                    JOptionPane.showMessageDialog(null, "Customer Added Successfuly");
                    this.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error !");
                }

                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                t5.setText(null);
                t6.setText(null);
                t7.setText(null);

                con.c.close();

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {

            this.setVisible(false);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new AddCustomer("").setVisible(true);
    }
}
