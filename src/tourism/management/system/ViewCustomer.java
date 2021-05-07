package tourism.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.proteanit.sql.DbUtils;

public class ViewCustomer extends JFrame {

    JButton b1;
    String username;
    JTable table;

    ViewCustomer(String username) {

        super("View Customer");

        //this.username = username;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/dest2.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l10 = new JLabel(i2);
        l10.setBounds(0, 0, 1200, 650);
        add(l10);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(35, 15, 69, 25);
        l10.add(l1);

        JLabel l2 = new JLabel("ID Type");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(175, 15, 76, 25);
        l10.add(l2);

        JLabel l3 = new JLabel("Number");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(305, 15, 55, 25);
        l10.add(l3);

        JLabel l4 = new JLabel("Name");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(450, 15, 76, 25);
        l10.add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(575, 15, 90, 25);
        l10.add(l5);

        JLabel l6 = new JLabel("Country");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(705, 15, 90, 25);
        l10.add(l6);

        JLabel l7 = new JLabel("Address");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(845, 15, 90, 25);
        l10.add(l7);

        JLabel l8 = new JLabel("Phone");
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(980, 15, 90, 25);
        l10.add(l8);

        JLabel l9 = new JLabel("Email");
        l9.setFont(new Font("serif", Font.PLAIN, 17));
        l9.setBounds(1105, 15, 90, 25);
        l10.add(l9);

        table = new JTable();
        table.setOpaque(false);
        table.setFont(new Font("serif", Font.PLAIN, 17));
        table.setBounds(0, 60, 1200, 400);
        l10.add(table);

        b1 = new JButton("Back");
        b1.setBounds(35, 460, 100, 30);
        b1.setFont(new Font("serif", Font.PLAIN, 17));

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
            }
        });

        l10.add(b1);

        try {

            Conn con = new Conn();
            String sql = "select * from customer";
            ResultSet rs = con.s.executeQuery(sql);

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            e.printStackTrace();
        }

        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1200, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new ViewCustomer("").setVisible(true);
    }
}
