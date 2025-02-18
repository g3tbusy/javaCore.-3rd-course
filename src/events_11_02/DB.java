package events_11_02;

import java.sql.*;
import java.util.Scanner;

public class DB
{
    private static final String host = "localhost";
    private static final String port = "5432";
    private static final String db_name = "events";
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

    public static void createTables() throws SQLException, ClassNotFoundException
    {
        String sql = "CREATE TABLE IF NOT EXISTS events (" +
                "event_id SERIAL PRIMARY KEY," +
                "event_name VARCHAR(30) NOT NULL," +
                "event_description VARCHAR(100) NOT NULL," +
                "event_date DATE NOT NULL)";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public static void insertEvent() throws SQLException, ClassNotFoundException
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите название события: ");
        String event_name = input.nextLine();

        System.out.print("Введите описание события: ");
        String event_description = input.nextLine();

        System.out.print("Введите дату события в формате YYYY-MM-DD: ");
        String event_date = input.nextLine();

        String sql = "INSERT INTO events (event_name, event_description, event_date)\n" +
                "VALUES \n" +
                "  ('" + event_name + "', '" + event_description + "', '" + event_date + "');";

        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("inserted");

        MainMenu.mainMenu();
    }

    public static void selectFromEvents() throws SQLException, ClassNotFoundException
    {
        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM events;");

        System.out.println(" event_id |  event_name  | event_description | event_date ");
        System.out.println("----------+--------------+-------------------+------------");

        while (resultSet.next())
        {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            String date = resultSet.getString(4);

            System.out.printf(" %8d | %-12s | %-17s | %-10s \n", id, name, description, date);
        }

        MainMenu.mainMenu();
    }
}