package javaBasics.rdbms;

import java.sql.*;

public class RefactoredCRUD {
    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/abhishekdas/Desktop/abhishek/learn-java/src/javaBasics/rdbms/" + DB_NAME;
    public static final String TABLE_EMPLOYEE = "employee";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_EMPLOYEE +
                                                                "(" + COLUMN_NAME + " TEXT, " +
                                                                COLUMN_PHONE + " INTEGER, " +
                                                                COLUMN_EMAIL + " TEXT )";
    public static final String INSERT_INTO_EMPLOYEE_QUERY = "INSERT INTO " + TABLE_EMPLOYEE +
                                                                             "("+ COLUMN_NAME +
                                                                             ", " + COLUMN_PHONE +
                                                                             ", " + COLUMN_EMAIL +
                                                                             ") VALUES ";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
            statement.execute(CREATE_TABLE_QUERY);

            insert(statement, "Abhishek", 1234567, "a@a.com");
            insert(statement, "Sutapa", 1234568, "b@a.com");
            insert(statement, "Akash", 1234569, "c@a.com");

            ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_EMPLOYEE);

            printResultSet(result);

            result.close();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public static void insert(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute(INSERT_INTO_EMPLOYEE_QUERY +
                "('"+ name + "', " + phone +", '" + email +"')");
    }

    public static void printResultSet(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            System.out.println(resultSet.getString(COLUMN_NAME) + " | " +
                    resultSet.getString(COLUMN_EMAIL) + " | " +
                    resultSet.getInt(COLUMN_PHONE)
                    );
        }
    }

}
