package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class About extends JFrame implements ActionListener {

    JButton b1;
    String str;

    About() {

        super("About");

        b1 = new JButton("Exit");
        b1.setBounds(175, 610, 100, 30);
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.addActionListener(this);
        add(b1);

        str = "The objective ofthe Travel and Tourism Management System\n"
                + "project is to develop a system that automates the processess\n"
                + "and activities of  travel and tourism the purposes is to design\n"
                + "system using  which one can performs  all  operation related\n"
                + "traveling.\n\n"
                + "This application will help  accessing the information related\n"
                + "to the travel to the particular destination with great ease.The\n"
                + "users can  track the  information  related to their  tours with\n"
                + "great ea through this application. Travel agency information\n"
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project :"
                + "\n\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification";

        JTextArea t1 = new JTextArea(str);
        t1.setEditable(false);
        t1.setBounds(20, 100, 411, 485);
        t1.setBackground(Color.WHITE);
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        add(t1);

        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setBounds(27, 10, 420, 80);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("serif", Font.PLAIN, 24));
        add(l1);

        JLabel l2 = new JLabel("Developed By Quazi Hasnat Irfan");
        l2.setBounds(90, 630, 420, 80);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("serif", Font.PLAIN, 20));
        add(l2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(455, 730);
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

        new About().setVisible(true);
    }
}
