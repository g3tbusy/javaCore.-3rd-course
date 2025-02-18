package bank_14_01;

import java.sql.*;
import java.util.List;

public class DB
{
    private static final String host = "localhost";
    private static final String port = "5432";
    private static final String db_name = "bank";
    private static final String login = "first";
    private static final String password = "";

    private static Connection dbConn;

    static Connection getDBConnection() throws ClassNotFoundException, SQLException
    {
        String str = "jdbc:postgresql://" + host + ":" + port + "/" + db_name;
        Class.forName("org.postgresql.Driver");
        dbConn = DriverManager.getConnection(str, login, password);
        return dbConn;
    }

    public static void isConnection() throws SQLException, ClassNotFoundException
    {
        dbConn = getDBConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public static void createTableUsers(String tableName, String user_id, String status, String surname, String name, String patronymic, String balance) throws SQLException, ClassNotFoundException
    {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + user_id + ", " + status + ", " + surname + ", " + name + ", " + patronymic +  ", " + balance + ");";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("table users created");
    }

    public static void insert(Users user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Users (user_id, status, surname, name, patronymic, balance) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getStatus());
            pstmt.setString(3, user.getSurname());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getPatronymic());
            pstmt.setDouble(6, user.getBalance());

            pstmt.executeUpdate();
        }
    }

    public void insertUsers(List<Users> users)
    {
        for (Users client : users) {
            try {
                DB.insert(client);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("ошибка при добавлении юзера: " + client.getSurname() + " - " + e.getMessage());
            }
        }
    }
}
