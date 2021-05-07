package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ViewBookedHotel extends JFrame implements ActionListener {

    String username;
    JButton b1;
    JLabel l11, l21, l31, l41, l51, l61, l71, l81, l91, l101;

    ViewBookedHotel(String user) {

        super("View Booked Hotel");
        this.username = user;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 55, 500, 400);
        add(la1);

        JLabel head = new JLabel("View Booked Hotel");
        head.setBounds(100, 5, 300, 30);
        head.setForeground(Color.BLUE);
        head.setFont(new Font("serif", Font.PLAIN, 25));
        add(head);

        JLabel l1 = new JLabel("Username :");
        l1.setBounds(30, 50, 100, 30);
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        add(l1);

        l11 = new JLabel();
        l11.setBounds(250, 50, 100, 30);
        l11.setFont(new Font("serif", Font.PLAIN, 17));
        add(l11);

        JLabel l2 = new JLabel("Hotel Name :");
        l2.setBounds(30, 90, 100, 30);
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        add(l2);

        l21 = new JLabel();
        l21.setBounds(250, 90, 130, 30);
        l21.setFont(new Font("serif", Font.PLAIN, 17));
        add(l21);

        JLabel l3 = new JLabel("Total Persons :");
        l3.setBounds(30, 130, 120, 30);
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        add(l3);

        l31 = new JLabel();
        l31.setBounds(250, 130, 100, 30);
        l31.setFont(new Font("serif", Font.PLAIN, 17));
        add(l31);

        JLabel l4 = new JLabel("Total Days :");
        l4.setBounds(30, 170, 100, 30);
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        add(l4);

        l41 = new JLabel();
        l41.setBounds(250, 170, 100, 30);
        l41.setFont(new Font("serif", Font.PLAIN, 17));
        add(l41);

        JLabel l5 = new JLabel("AC Included :");
        l5.setBounds(30, 210, 100, 30);
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        add(l5);

        l51 = new JLabel();
        l51.setBounds(250, 210, 100, 30);
        l51.setFont(new Font("serif", Font.PLAIN, 17));
        add(l51);

        JLabel l6 = new JLabel("Food Included :");
        l6.setBounds(30, 250, 120, 30);
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        add(l6);

        l61 = new JLabel();
        l61.setBounds(250, 250, 100, 30);
        l61.setFont(new Font("serif", Font.PLAIN, 17));
        add(l61);

        JLabel l7 = new JLabel("ID :");
        l7.setBounds(30, 290, 100, 30);
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        add(l7);

        l71 = new JLabel();
        l71.setBounds(250, 290, 100, 30);
        l71.setFont(new Font("serif", Font.PLAIN, 17));
        add(l71);

        JLabel l8 = new JLabel("Number :");
        l8.setBounds(30, 330, 100, 30);
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        add(l8);

        l81 = new JLabel();
        l81.setBounds(250, 330, 100, 30);
        l81.setFont(new Font("serif", Font.PLAIN, 17));
        add(l81);

        JLabel l9 = new JLabel("Phone :");
        l9.setBounds(30, 370, 100, 30);
        l9.setFont(new Font("serif", Font.PLAIN, 17));
        add(l9);

        l91 = new JLabel();
        l91.setBounds(250, 370, 100, 30);
        l91.setFont(new Font("serif", Font.PLAIN, 17));
        add(l91);

        JLabel l10 = new JLabel("Total Cost :");
        l10.setBounds(30, 410, 100, 30);
        l10.setFont(new Font("serif", Font.PLAIN, 17));
        add(l10);

        l101 = new JLabel();
        l101.setBounds(250, 410, 130, 30);
        l101.setFont(new Font("serif", Font.PLAIN, 17));
        add(l101);

        b1 = new JButton("Back");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(130, 465, 100, 30);
        b1.addActionListener(this);
        add(b1);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookHotel where username = '" + username + "'");

            while (rs.next()) {

                l11.setText(rs.getString("username"));
                l21.setText(rs.getString("hotel"));
                l31.setText(rs.getString("persons"));
                l41.setText(rs.getString("days"));
                l51.setText(rs.getString("ac"));
                l61.setText(rs.getString("food"));
                l71.setText(rs.getString("id"));
                l81.setText(rs.getString("number"));
                l91.setText(rs.getString("phone"));
                l101.setText(rs.getString("cost"));
            }

            c.s.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        setLayout(null);
        setSize(995, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            this.setVisible(false);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new ViewBookedHotel("").setVisible(true);
    }
}
