package tourism.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class CheckPackage extends JFrame {

    CheckPackage() {

        super("Check Package");

        //setLayout(null);
        setSize(900, 590);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        String[] arr0 = new String[]{"Gold Package", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Welcome Drinks on Arrival", "Full Day 3 Island Cruise", "English Speaking Guide", "Book Now", "Summer Special", "( Tk 12000/- )", "package2.jpg"};
        String[] arr1 = new String[]{"Silver Package", "5 Days and 6 Nights", "Entrance Free Ticket", "Meet and Greet at Airport", "Welcome Drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise With Dinner", "Book Now", "Winter Special", "( Tk 24000/- )", "package1.jpg"};
        String[] arr2 = new String[]{"Bronze Package", "6 Days and 5 Nights", "Return Airfare", "Free Clubbing & Horse Riding", "Welcome Drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "Stay In 5 Star Hotel", "Book Now", "Winter Special", "( Tk 32000/- )", "package3.jpg"};

        JTabbedPane pane = new JTabbedPane();

        JPanel p1 = createPackage(arr0);
        pane.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(arr1);
        pane.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(arr2);
        pane.addTab("Package 3", null, p3);

        add(pane, BorderLayout.CENTER);
    }

    public JPanel createPackage(String[] pack) {

        JPanel p4 = new JPanel();
        p4.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/" + pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(350, 110, 500, 300);
        l12.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        p4.add(l12);

        JLabel l1 = new JLabel(pack[0]);
        l1.setFont(new Font("serif", Font.PLAIN, 30));
        l1.setBounds(90, 10, 300, 35);
        l1.setForeground(Color.BLUE);
        p4.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setFont(new Font("serif", Font.PLAIN, 20));
        l2.setBounds(30, 60, 300, 30);
        p4.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setFont(new Font("serif", Font.PLAIN, 20));
        l3.setBounds(30, 110, 300, 30);
        p4.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setFont(new Font("serif", Font.PLAIN, 20));
        l4.setBounds(30, 160, 300, 30);
        p4.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setFont(new Font("serif", Font.PLAIN, 20));
        l5.setBounds(30, 210, 300, 30);
        p4.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setFont(new Font("serif", Font.PLAIN, 20));
        l6.setBounds(30, 260, 300, 30);
        p4.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setFont(new Font("serif", Font.PLAIN, 20));
        l7.setBounds(30, 310, 300, 30);
        p4.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setFont(new Font("serif", Font.PLAIN, 20));
        l8.setBounds(30, 360, 300, 30);
        p4.add(l8);

        JLabel l9 = new JLabel(pack[8]);
        l9.setFont(new Font("serif", Font.PLAIN, 20));
        l9.setBounds(30, 410, 300, 30);
        p4.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setFont(new Font("serif", Font.PLAIN, 20));
        l10.setBounds(30, 470, 300, 40);
        p4.add(l10);

        JLabel l11 = new JLabel(pack[10]);
        l11.setFont(new Font("serif", Font.PLAIN, 20));
        l11.setBounds(170, 470, 300, 40);
        l11.setForeground(Color.RED);
        p4.add(l11);

        return p4;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new CheckPackage().setVisible(true);
    }
}
