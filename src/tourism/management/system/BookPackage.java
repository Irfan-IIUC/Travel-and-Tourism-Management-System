package tourism.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BookPackage extends JFrame {

    JTextField t1, t2;
    Choice c1, c2, c3;
    String username;
    JButton b1, b2, b3;

    BookPackage(String user) {

        super("Book Package");
        this.username = user;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/dest9.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(420, 60, 700, 300);
        add(la1);

        JLabel l1 = new JLabel("Book Package");
        l1.setFont(new Font("serif", Font.PLAIN, 25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(150, 11, 300, 53);
        add(l1);

        JLabel la2 = new JLabel("Username :");
        la2.setFont(new Font("serif", Font.PLAIN, 17));
        la2.setBounds(35, 70, 200, 20);
        add(la2);

        JLabel l7 = new JLabel(username);
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(271, 70, 200, 25);
        add(l7);

        JLabel l2 = new JLabel("Select Package :");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(35, 110, 200, 25);
        add(l2);

        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(271, 110, 150, 25);
        c1.setFont(new Font("serif", Font.PLAIN, 17));
        add(c1);

        JLabel l3 = new JLabel("Total Persons :");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(35, 150, 200, 25);
        add(l3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(271, 150, 150, 25);
        add(t1);
        t1.setColumns(10);

        JLabel l4 = new JLabel("ID :");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(35, 190, 200, 25);
        add(l4);

        JLabel l8 = new JLabel();
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(271, 190, 200, 25);
        add(l8);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setFont(new Font("serif", Font.PLAIN, 17));
        lbl2.setBounds(35, 230, 200, 25);
        add(lbl2);

        JLabel l9 = new JLabel();
        l9.setFont(new Font("serif", Font.PLAIN, 17));
        l9.setBounds(271, 230, 200, 25);
        add(l9);

        JLabel l5 = new JLabel("Phone :");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(35, 270, 200, 25);
        add(l5);

        JLabel l10 = new JLabel();
        l10.setFont(new Font("serif", Font.PLAIN, 17));
        l10.setBounds(271, 270, 200, 25);
        add(l10);

        JLabel l11 = new JLabel("Total Price :");
        l11.setFont(new Font("serif", Font.PLAIN, 17));
        l11.setBounds(35, 310, 200, 25);
        add(l11);

        JLabel l12 = new JLabel();
        l12.setFont(new Font("serif", Font.PLAIN, 17));
        l12.setBounds(271, 310, 200, 25);
        add(l12);

        b1 = new JButton("Check Price");

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String p = c1.getSelectedItem();

                int cost = 0;

                if (p.equals("Gold Package")) {

                    cost += 12000;

                } else if (p.equals("Silver Package")) {

                    cost += 24000;

                } else if (p.equals("Bronze Package")) {

                    cost += 32000;
                }

                cost *= Integer.parseInt(t1.getText());
                l12.setText("Tk " + cost);

            }
        });

        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(50, 360, 120, 30);
        add(b1);

        b2 = new JButton("Back");

        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });

        b2.setBounds(350, 360, 120, 30);
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        add(b2);

        try {

            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from customer where username = '" + username + "'");

            while (rs.next()) {

                l8.setText(rs.getString("id"));
                l9.setText(rs.getString("number"));
                l10.setText(rs.getString("phone"));
            }

            rs.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        b3 = new JButton("Book");

        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                try {

                    Conn c = new Conn();
                    String query = "insert into bookPackage values('" + l7.getText() + "', '" + c1.getSelectedItem() + "', '" + t1.getText() + "', '" + l8.getText() + "', '" + l9.getText() + "', '" + l10.getText() + "', '" + l12.getText() + "')";
                    int rs = c.s.executeUpdate(query);

                    if (rs == 1) {

                        JOptionPane.showMessageDialog(null, "Package Booked Successfully");

                    } else {

                        JOptionPane.showMessageDialog(null, "Please Try Again !");
                    }

                    l7.setText(null);
                    t1.setText(null);
                    l8.setText(null);
                    l9.setText(null);
                    l10.setText(null);
                    l12.setText(null);

                    c.s.close();

                } catch (Exception e) {

                    System.out.println(e);
                }
            }
        });

        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(200, 360, 120, 30);
        add(b3);

        setLayout(null);
        setSize(1060, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new BookPackage("").setVisible(true);
    }
}
