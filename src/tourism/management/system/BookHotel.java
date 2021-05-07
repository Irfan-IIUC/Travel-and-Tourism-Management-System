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

public class BookHotel extends JFrame implements ActionListener {

    String username;
    JTextField t1, t2;
    Choice c1, c2, c3;
    JButton b1, b2, b3;

    JLabel l1, l2, l3, l4, l5;

    BookHotel(String user) {

        super("Book Hotel");
        this.username = user;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(400, 65, 700, 400);
        add(la1);

        JLabel lblName = new JLabel("Book Hotel");
        lblName.setFont(new Font("serif", Font.PLAIN, 25));
        lblName.setForeground(Color.BLUE);
        lblName.setBounds(130, 11, 300, 53);
        add(lblName);

        JLabel la2 = new JLabel("Username :");
        la2.setFont(new Font("serif", Font.PLAIN, 17));
        la2.setBounds(35, 70, 200, 25);
        add(la2);

        l1 = new JLabel(username);
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(250, 70, 200, 25);
        add(l1);

        JLabel lblId = new JLabel("Select Hotel :");
        lblId.setFont(new Font("serif", Font.PLAIN, 17));
        lblId.setBounds(35, 110, 200, 25);
        add(lblId);

        c1 = new Choice();
        Conn c = new Conn();

        try {

            ResultSet rs = c.s.executeQuery("select * from hotels");

            while (rs.next()) {

                c1.add(rs.getString("name"));
            }

            rs.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        c1.setFont(new Font("serif", Font.PLAIN, 15));
        c1.setBounds(250, 110, 150, 25);
        add(c1);

        JLabel la3 = new JLabel("Total Persons");
        la3.setFont(new Font("serif", Font.PLAIN, 17));
        la3.setBounds(35, 150, 200, 25);
        add(la3);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setText("0");
        t1.setBounds(250, 150, 150, 25);
        add(t1);
        t1.setColumns(10);

        JLabel la4 = new JLabel("Number of Days");
        la4.setFont(new Font("serif", Font.PLAIN, 17));
        la4.setBounds(35, 190, 200, 25);
        add(la4);

        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setText("0");
        t2.setBounds(250, 190, 150, 25);
        add(t2);
        t2.setColumns(10);

        JLabel la5 = new JLabel("AC / Non-AC");
        la5.setFont(new Font("serif", Font.PLAIN, 17));
        la5.setBounds(35, 230, 200, 25);
        add(la5);

        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setFont(new Font("serif", Font.PLAIN, 17));
        c2.setBounds(250, 230, 150, 25);
        add(c2);

        JLabel la6 = new JLabel("Food Included :");
        la6.setFont(new Font("serif", Font.PLAIN, 17));
        la6.setBounds(35, 270, 200, 14);
        add(la6);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setFont(new Font("serif", Font.PLAIN, 17));
        c3.setBounds(250, 270, 150, 25);
        add(c3);

        JLabel lbl1 = new JLabel("Id :");
        lbl1.setFont(new Font("serif", Font.PLAIN, 17));
        lbl1.setBounds(35, 310, 200, 25);
        add(lbl1);

        l2 = new JLabel();
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(250, 310, 200, 25);
        add(l2);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setFont(new Font("serif", Font.PLAIN, 17));
        lbl2.setBounds(35, 350, 200, 25);
        add(lbl2);

        l3 = new JLabel();
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(250, 350, 200, 25);
        add(l3);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setFont(new Font("serif", Font.PLAIN, 17));
        lbl3.setBounds(35, 390, 200, 25);
        add(lbl3);

        l4 = new JLabel();
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(250, 390, 200, 25);
        add(l4);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setFont(new Font("serif", Font.PLAIN, 17));
        lblDeposite.setBounds(35, 430, 200, 25);
        add(lblDeposite);

        l5 = new JLabel();
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(250, 430, 200, 25);
        l5.setForeground(Color.RED);
        add(l5);

        try {

            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");

            while (rs.next()) {

                l1.setText(rs.getString("username"));
                l2.setText(rs.getString("id"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));

            }

            rs.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        b1 = new JButton("Check Price");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(35, 485, 110, 35);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Book");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(195, 485, 110, 35);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(350, 485, 110, 35);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setSize(1045, 570);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotels where name = '" + c1.getSelectedItem() + "'");

                while (rs.next()) {

                    int cost = Integer.parseInt(rs.getString("cost_per_day"));
                    int food = Integer.parseInt(rs.getString("food_charges"));
                    int ac = Integer.parseInt(rs.getString("ac_charges"));

                    int person = Integer.parseInt(t1.getText());
                    int day = Integer.parseInt(t2.getText());

                    String ac_price = c2.getSelectedItem();
                    String food_price = c3.getSelectedItem();

                    if (person * day > 0) {

                        int total = 0;

                        total += ac_price.equals("AC") ? ac : 0;
                        total += food_price.equals("Yes") ? food : 0;

                        total = cost + total;

                        total = total * person * day;

                        l5.setText("Tk " + total + " Only");

                    } else {

                        l5.setText("Enter Valid Data");
                    }

                }

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {

            try {

                Conn c = new Conn();
                String s1 = c1.getSelectedItem();

                String q1 = "insert into bookHotel values('" + l1.getText() + "', '" + c1.getSelectedItem() + "', '" + t1.getText() + "', '" + t2.getText() + "', '" + c2.getSelectedItem() + "', '" + c3.getSelectedItem() + "', '" + l2.getText() + "', '" + l3.getText() + "', '" + l4.getText() + "', '" + l5.getText() + "')";
                int a = c.s.executeUpdate(q1);

                if (a == 1) {

                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error !");
                    setVisible(false);
                }

                t1.setText("0");
                t2.setText("0");
                l5.setText(null);

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }

        } else if (ae.getSource() == b3) {

            this.setVisible(false);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new BookHotel("").setVisible(true);
    }
}
