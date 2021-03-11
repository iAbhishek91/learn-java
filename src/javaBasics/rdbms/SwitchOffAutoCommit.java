package javaBasics.rdbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SwitchOffAutoCommit {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/abhishekdas/Desktop/abhishek/learn-java/src/javaBasics/rdbms/test.db");
             Statement statement = con.createStatement()) {

            // NOTE: that by default JDBC will auto commit all the changes in the db.
            // If auto commit is not done, make sure that you are commit the changes later. Else we will loose the data.
            // Change the default behaviour
            con.setAutoCommit(false);

            statement.execute("CREATE TABLE IF NOT EXISTS contacts "+
                    " (name TEXT, phone INTEGER, email TEXT)");
            statement.execute("UPDATE contacts "+
                    "SET name='Abhishek Das' WHERE phone=123456");

            // manually commit later
            con.commit();
        } catch(SQLException e) {
            System.out.println("Err" + e.getMessage());
        }
    }
}
