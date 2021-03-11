package javaBasics.rdbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabasePrimitive {
    public static void main(String[] args) {
        // in this new style of try catch
        // the resources are closed automatically.
        // If the database do not exist, it will create a new one.
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/abhishekdas/Desktop/abhishek/learn-java/src/javaBasics/rdbms/test.db");
             Statement statement = con.createStatement()) {

            // semicolon is added, driver will take care of that
            // create table will throw error, if table already exists, so insert `IF NOT EXISTS`
            statement.execute("CREATE TABLE IF NOT EXISTS contacts "+
                                        " (name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO contacts"+
                                        " VALUES ('Abhishek', 123456, 'a@a.com')");


            // the below lines are not required, as we hae kept the objects within the database
            /*statement.close();
            //con.close();*/
        } catch(SQLException e) {
            System.out.println("Err" + e.getMessage());
        }
    }
}
