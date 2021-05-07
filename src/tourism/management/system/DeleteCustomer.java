package tourism.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DeleteCustomer extends JFrame {

    Choice c1;

    DeleteCustomer() {

        super("Delete Customer");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/delete.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(430, 80, 300, 300);
        add(l1);

        JLabel lblName = new JLabel("Delete Customer Details");
        lblName.setFont(new Font("serif", Font.PLAIN, 25));
        lblName.setForeground(Color.BLUE);
        lblName.setBounds(118, 5, 300, 53);
        add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setFont(new Font("serif", Font.PLAIN, 17));
        lb3.setBounds(35, 70, 200, 25);
        add(lb3);

        c1 = new Choice();
        Conn c = new Conn();

        try {

            ResultSet rs = c.s.executeQuery("select * from customer");

            while (rs.next()) {

                c1.add(rs.getString("username"));
            }

            rs.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        c1.setBounds(271, 70, 150, 25);
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        add(c1);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 110, 200, 25);
        lblId.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 150, 25);
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        add(l2);

        JLabel lb2 = new JLabel("Number :");
        lb2.setBounds(35, 150, 200, 25);
        lb2.setFont(new Font("serif", Font.PLAIN, 17));
        add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 25);
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        add(l3);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 25);
        lblName_1.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 25);
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        add(l4);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 25);
        lblGender.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 25);
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        add(l5);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 25);
        lblCountry.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 25);
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        add(l6);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 25);
        lblReserveRoomNumber.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(271, 310, 200, 25);
        add(l7);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(35, 350, 200, 25);
        lblCheckInStatus.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblCheckInStatus);

        JLabel l8 = new JLabel();
        l8.setBounds(271, 350, 200, 25);
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        add(l8);

        JLabel lblDeposite = new JLabel("Email :");
        lblDeposite.setBounds(35, 390, 200, 25);
        lblDeposite.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblDeposite);

        JLabel l9 = new JLabel();
        l9.setBounds(271, 390, 200, 25);
        l9.setFont(new Font("serif", Font.PLAIN, 17));
        add(l9);

        JButton b1 = new JButton("Check");

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                try {

                    Conn c = new Conn();
                    String str = "select * from customer where username = '" + c1.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        l2.setText(rs.getString(2));
                        l3.setText(rs.getString(3));
                        l4.setText(rs.getString(4));
                        l5.setText(rs.getString(5));
                        l6.setText(rs.getString(6));
                        l7.setText(rs.getString(7));
                        l8.setText(rs.getString(8));
                        l9.setText(rs.getString(9));
                    }

                } catch (Exception e) {

                    System.out.println(e);
                }
            }
        });

        b1.setBounds(35, 440, 100, 30);
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        add(b1);

        JButton b2 = new JButton("Delete");

        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                try {

                    Conn c = new Conn();

                    c.s.executeUpdate("delete from account where username = '" + c1.getSelectedItem() + "'");
                    c.s.executeUpdate("delete from bookhotel where username = '" + c1.getSelectedItem() + "'");
                    c.s.executeUpdate("delete from bookpackage where username = '" + c1.getSelectedItem() + "'");
                    c.s.executeUpdate("delete from customer where username = '" + c1.getSelectedItem() + "'");

                    JOptionPane.showMessageDialog(null, "Customer Deleted Successfully");
                    System.exit(0);

                    c.s.close();

                } catch (Exception e) {

                    System.out.println(e);
                }
            }
        });

        b2.setBounds(180, 440, 100, 30);
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        add(b2);

        JButton b3 = new JButton("Back");

        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
            }
        });

        b3.setBounds(325, 440, 100, 30);
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        add(b3);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(730, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new DeleteCustomer().setVisible(true);
    }
}
