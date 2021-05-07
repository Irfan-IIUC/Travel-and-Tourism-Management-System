package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dashboard extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    String username;

    Dashboard(String username) {

        super("Dashboard");

        this.username = username;

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1280, 65);
        p1.setBackground(new Color(0, 0, 102));
        add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 65, 250, 1000);
        p2.setBackground(new Color(0, 0, 102));
        add(p2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1280, 1024, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(0, 0, 1280, 1024);
        add(l6);

        JLabel l1 = new JLabel("Dashboard");
        l1.setFont(new Font("serif", Font.BOLD, 30));
        l1.setForeground(Color.WHITE);
        l1.setBounds(55, 12, 300, 40);
        p1.add(l1);

        JLabel l2 = new JLabel("Travel and Tourism Management System");
        l2.setFont(new Font("serif", Font.PLAIN, 55));
        l2.setForeground(Color.WHITE);
        l2.setBounds(320, 100, 1000, 80);
        l6.add(l2);

        b1 = new JButton("Add Personal Detail");
        b1.setFont(new Font("serif", Font.PLAIN, 20));
        b1.setBounds(0, 0, 250, 40);
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Update Personal Detail");
        b2.setFont(new Font("serif", Font.PLAIN, 20));
        b2.setBounds(0, 50, 250, 40);
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("View Detail");
        b3.setFont(new Font("serif", Font.PLAIN, 20));
        b3.setBounds(0, 100, 250, 40);
        b3.addActionListener(this);
        p2.add(b3);

        b4 = new JButton("Delete Personal Detail");
        b4.setFont(new Font("serif", Font.PLAIN, 20));
        b4.setBounds(0, 150, 250, 40);
        b4.addActionListener(this);
        p2.add(b4);

        b5 = new JButton("Check Package");
        b5.setFont(new Font("serif", Font.PLAIN, 20));
        b5.setBounds(0, 200, 250, 40);
        b5.addActionListener(this);
        p2.add(b5);

        b6 = new JButton("Book Package");
        b6.setFont(new Font("serif", Font.PLAIN, 20));
        b6.setBounds(0, 250, 250, 40);
        b6.addActionListener(this);
        p2.add(b6);

        b7 = new JButton("View Package");
        b7.setFont(new Font("serif", Font.PLAIN, 20));
        b7.setBounds(0, 300, 250, 40);
        b7.addActionListener(this);
        p2.add(b7);

        b8 = new JButton("View Hotels");
        b8.setFont(new Font("serif", Font.PLAIN, 20));
        b8.setBounds(0, 350, 250, 40);
        b8.addActionListener(this);
        p2.add(b8);

        b9 = new JButton("Book Hotel");
        b9.setFont(new Font("serif", Font.PLAIN, 20));
        b9.setBounds(0, 400, 250, 40);
        b9.addActionListener(this);
        p2.add(b9);

        b10 = new JButton("View Booked Hotel");
        b10.setFont(new Font("serif", Font.PLAIN, 20));
        b10.setBounds(0, 450, 250, 40);
        b10.addActionListener(this);
        p2.add(b10);

        b11 = new JButton("Destinations");
        b11.setFont(new Font("serif", Font.PLAIN, 20));
        b11.setBounds(0, 500, 250, 40);
        b11.addActionListener(this);
        p2.add(b11);

        b12 = new JButton("Payment");
        b12.setFont(new Font("serif", Font.PLAIN, 20));
        b12.setBounds(0, 550, 250, 40);
        b12.addActionListener(this);
        p2.add(b12);

        b13 = new JButton("Calculator");
        b13.setFont(new Font("serif", Font.PLAIN, 20));
        b13.setBounds(0, 600, 250, 40);
        b13.addActionListener(this);
        p2.add(b13);

        b14 = new JButton("Notepad");
        b14.setFont(new Font("serif", Font.PLAIN, 20));
        b14.setBounds(0, 650, 250, 40);
        b14.addActionListener(this);
        p2.add(b14);

        b15 = new JButton("About");
        b15.setFont(new Font("serif", Font.PLAIN, 20));
        b15.setBounds(0, 700, 250, 40);
        b15.addActionListener(this);
        p2.add(b15);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        //setSize(580, 400);
        //setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            new AddCustomer(username).setVisible(true);

        } else if (ae.getSource() == b2) {

            new UpdateCustomer(username).setVisible(true);

        } else if (ae.getSource() == b3) {

            new ViewCustomer(username).setVisible(true);

        } else if (ae.getSource() == b4) {

            new DeleteCustomer().setVisible(true);

        } else if (ae.getSource() == b5) {

            new CheckPackage().setVisible(true);

        } else if (ae.getSource() == b6) {

            new BookPackage(username).setVisible(true);

        } else if (ae.getSource() == b7) {

            new ViewPackage(username).setVisible(true);

        } else if (ae.getSource() == b8) {

            new CheckHotel().setVisible(true);

        } else if (ae.getSource() == b9) {

            new BookHotel(username).setVisible(true);

        } else if (ae.getSource() == b10) {

            new ViewBookedHotel(username).setVisible(true);

        } else if (ae.getSource() == b11) {

            new Destination().setVisible(true);

        } else if (ae.getSource() == b12) {

            new Payment().setVisible(true);

        } else if (ae.getSource() == b13) {

            try {

                Runtime.getRuntime().exec("calc.exe");

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b14) {

            try {

                Runtime.getRuntime().exec("notepad.exe");

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b15) {

            new About().setVisible(true);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new Dashboard("").setVisible(true);
    }

}
