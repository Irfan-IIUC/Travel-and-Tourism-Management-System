package tourism.management.system;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Splash {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        SplashFrame sf = new SplashFrame();

        sf.setVisible(true);

        for (int i = 0; i <= 700; i += 5) {

            sf.setLocationRelativeTo(null);
            sf.setSize(300 + i, i);

            try {

                Thread.sleep(5);

            } catch (Exception e) {

            }

        }

        sf.setResizable(false);
        sf.setTitle("Travel Management System");
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sf.setVisible(true);
    }
}

class SplashFrame extends JFrame implements Runnable {

    Thread t1;

    SplashFrame() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tourism/management/system/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);

        t1 = new Thread(this);
        t1.start();
    }

    public void run() {

        try {

            Thread.sleep(10000);

        } catch (InterruptedException ex) {

            Logger.getLogger(SplashFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setVisible(false);

        new Login().setVisible(true);

    }
}
