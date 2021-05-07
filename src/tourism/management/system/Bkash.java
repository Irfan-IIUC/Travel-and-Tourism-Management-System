package tourism.management.system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Bkash extends JFrame implements ActionListener {

    JButton b1;

    Bkash() {

        super("Bkash");

        JEditorPane ep = new JEditorPane();
        ep.setEditable(false);

        try {

            ep.setPage("https://nagad.com.bd");

        } catch (Exception e) {

            ep.setContentType("text/html");
            ep.setText("<html> Could not load, Error 404 </html>");
        }

        JScrollPane sp = new JScrollPane(ep);
        getContentPane().add(sp);

        b1 = new JButton("Back");
        b1.setBounds(610, 20, 100, 35);
        b1.setFont(new Font("serif", Font.PLAIN, 25));
        b1.addActionListener(this);
        add(b1);

        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            this.setVisible(false);
            new Payment().setVisible(true);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new Bkash().setVisible(true);
    }
}
