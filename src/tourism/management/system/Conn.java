package tourism.management.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

public class Conn {

    Statement s;
    Connection c;

    public Conn() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/projecttms", "root", "root");
            s = (Statement) c.createStatement();

        } catch (Exception e) {

            System.out.println(e);
        }

    }
}
