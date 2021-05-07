package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ViewPackage extends JFrame {

    String username;

    ViewPackage(String user) {

        super("View Package");

        this.username = user;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(400, 37, 350, 350);
        add(la1);

        JLabel lblName = new JLabel("View Package Detail");
        lblName.setFont(new Font("serif", Font.PLAIN, 25));
        lblName.setBounds(90, 11, 350, 53);
        lblName.setForeground(Color.BLUE);
        add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setFont(new Font("serif", Font.PLAIN, 17));
        lb3.setBounds(35, 70, 200, 20);
        add(lb3);

        JLabel l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        add(l1);

        JLabel lblId = new JLabel("Package :");
        lblId.setFont(new Font("serif", Font.PLAIN, 17));
        lblId.setBounds(35, 110, 200, 20);
        add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 200, 20);
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        add(l2);

        JLabel lb2 = new JLabel("Number of Persons :");
        lb2.setFont(new Font("serif", Font.PLAIN, 17));
        lb2.setBounds(35, 150, 200, 20);
        add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 20);
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        add(l3);

        JLabel lblName_1 = new JLabel("ID :");
        lblName_1.setFont(new Font("serif", Font.PLAIN, 17));
        lblName_1.setBounds(35, 190, 200, 20);
        add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 20);
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        add(l4);

        JLabel lblGender = new JLabel("Number :");
        lblGender.setBounds(35, 230, 200, 20);
        lblGender.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblGender);

        JLabel l5 = new JLabel();
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(271, 230, 200, 20);
        add(l5);

        JLabel lblCountry = new JLabel("Phone :");
        lblCountry.setFont(new Font("serif", Font.PLAIN, 17));
        lblCountry.setBounds(35, 270, 200, 20);
        add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(271, 270, 200, 20);
        add(l6);

        JLabel lblReserveRoomNumber = new JLabel("Price :");
        lblReserveRoomNumber.setFont(new Font("serif", Font.PLAIN, 17));
        lblReserveRoomNumber.setBounds(35, 310, 200, 20);
        add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setBounds(271, 310, 200, 20);
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        add(l7);

        try {

            Conn c = new Conn();
            String sql = "select * from bookPackage";
            ResultSet rs = c.s.executeQuery(sql);

            while (rs.next()) {

                l1.setText(rs.getString("username"));
                l2.setText(rs.getString("package"));
                l3.setText(rs.getString("persons"));
                l4.setText(rs.getString("id"));
                l5.setText(rs.getString("number"));
                l6.setText(rs.getString("phone"));
                l7.setText(rs.getString("price"));
            }

            c.s.close();

        } catch (Exception e) {

            System.out.println(e);
        }

        setLayout(null);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new ViewPackage("").setVisible(true);
    }
}
