package javaBasics.rdbms;

import java.sql.*;

public class RetrieveDataExecuteQuery {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/abhishekdas/Desktop/abhishek/learn-java/src/javaBasics/rdbms/music.db");
             Statement statement = con.createStatement()) {

            // statement.executeQuery returns a resultSet directly
            ResultSet resultSet = statement.executeQuery("SELECT * FROM songs LIMIT 10");
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
