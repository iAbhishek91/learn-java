package javaBasics.rdbms;

import java.sql.*;

public class RetrieveDataExecute {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/abhishekdas/Desktop/abhishek/learn-java/src/javaBasics/rdbms/music.db");
             Statement statement = con.createStatement()) {

            // statement.execute returns a boolean value and not the result
            statement.execute("SELECT * FROM songs LIMIT 10");
            /* Note: Statement object can have only one resultSet associated with it.
            the resultSet is closed automatically if there is another resultSet.
            So if we want to work with multiple resultSet, we need to use different instance of statements.*/

            /* Cursor
            * Every result set have a cursor, which not same as db cursor.
            * We may have different resultSet object from different statement instance
            * and each one should have a cursor.
            * Cursor moves with ".next()" method.
            * getMethods will be returned from the current position of cursor.*/
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("title") + " | " +
                                        resultSet.getInt("album"));
            }
            resultSet.close();

        } catch(SQLException e) {
            System.out.println("Err" + e.getMessage());
        }
    }
}
