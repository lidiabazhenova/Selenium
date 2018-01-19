package connecting.database;

import java.sql.*;

public class JDBCConnection {

    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "5740";
        String instanceName = "/Qabdt";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/qabdt", "postgres", "yourpassword");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from company");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("age"));
        }

    }
}
