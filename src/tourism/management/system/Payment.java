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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Payment extends JFrame implements ActionListener {

    Payment() {

        super("Payment");

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/bkash.jpg"));
        Image i8 = i7.getImage().getScaledInstance(600, 920, Image.SCALE_REPLICATE);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 0, 600, 920);
        add(l4);

        JButton pay = new JButton("Pay");

        pay.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new Bkash().setVisible(true);
            }
        });

        pay.setBounds(110, 770, 100, 35);
        pay.setFont(new Font("serif", Font.PLAIN, 25));
        l4.setForeground(Color.RED);
        l4.add(pay);

        JButton back = new JButton("Back");

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });

        back.setBounds(385, 770, 100, 35);
        back.setFont(new Font("serif", Font.PLAIN, 25));
        l4.add(back);

        setLayout(null);
        setSize(600, 950);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new Payment().setVisible(true);
    }
}
