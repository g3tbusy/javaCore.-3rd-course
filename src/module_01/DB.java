package module_01;

import java.sql.*;

public class DB
{
    private static final String host = "localhost";
    private static final String port = "5432";
    private static final String db_name = "module01";
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

    public static void createTablePartner() throws SQLException, ClassNotFoundException
    {
        String sql = "CREATE TABLE IF NOT EXISTS Partners (partner_id SERIAL PRIMARY KEY," +
                "partner_name VARCHAR(255) NOT NULL," +
                "partner_address VARCHAR(255)," +
                "partner_phone VARCHAR(50)," +
                "partner_email VARCHAR(100)" +
                ");";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("DEBUG.LOG: table partners created or already exists");
    }

    public static void createTablePartners_realization() throws SQLException, ClassNotFoundException
    {
        String sql = "CREATE TABLE IF NOT EXISTS partners_realization (" +
                "realization_id SERIAL PRIMARY KEY," +
                "partner_id INTEGER NOT NULL," +
                "sale_date DATE NOT NULL," +
                "product_description VARCHAR(255)," +
                "quantity INTEGER," +
                "CONSTRAINT fk_partner" +
                "   FOREIGN KEY(partner_id)" +
                "   REFERENCES partners(partner_id)" +
                "   ON DELETE CASCADE);";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("DEBUG.LOG: table partners_realization created or already exists");
    }

    public static void insertIntoPartners(String partner_name, String partner_address, String partner_phone, String partner_email) throws SQLException, ClassNotFoundException
    {
        String sql = "INSERT INTO partners (partner_name, partner_address, partner_phone, partner_email)\n" +
                "VALUES \n" +
                "  ('" + partner_name + "', '" + partner_address + "', '" + partner_phone + "', '" + partner_email + "');";

        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("DEBUG.LOG: partners data inserted");
    }

    public static void insertIntoPartners_realization(String partner_id, String sale_date, String product_description, String quantity) throws SQLException, ClassNotFoundException
    {
        String sql = "INSERT INTO partners_realization (partner_id, sale_date, product_description, quantity)\n" +
                "VALUES \n" +
                "  (" + partner_id + ", '" + sale_date + "', '" + product_description + "', " + quantity + ");\n";

        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("DEBUG.LOG: partners_realization data inserted");
    }

    public static void selectFromPartners(String tableName) throws SQLException, ClassNotFoundException
    {
        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT partner_id, partner_name FROM " + tableName);
        System.out.println("|    partner_name    |" +
                         "\n+--------------------+");
        while (resultSet.next())
        {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.printf("| %d. %s |\n", id, name);
        }
    }

    public static void updatePartners(String partner_id,
                                      String newPartner_name,
                                      String newPartner_address,
                                      String newPartner_phone,
                                      String newPartner_email) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE partners SET " +
                "partner_name = '" + newPartner_name + "', " +
                "partner_address = '" + newPartner_address + "', " +
                "partner_phone = '" + newPartner_phone + "', " +
                "partner_email = '" + newPartner_email + "' " +
                "WHERE partner_id = " + partner_id;
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);

        System.out.println("\n|  UPDATED PARTNERS  |");
        selectFromPartners("partners");
    }

    public static void delete(String tableName,
                              String partner_id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM " + tableName + " WHERE partner_id = " + partner_id;
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);

        System.out.println("\n|  DELETED PARTNERS  |");
        selectFromPartners("partners");
    }

    public static void selectFromPartnerRealizationHistory(int partnerId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT pr.realization_id, p.partner_name, pr.sale_date, pr.product_description, pr.quantity " +
                "FROM partners_realization pr " +
                "JOIN partners p ON pr.partner_id = p.partner_id " +
                "WHERE pr.partner_id = ?";

        PreparedStatement preparedStatement = getDBConnection().prepareStatement(sql);
        preparedStatement.setInt(1, partnerId);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("\n| id |     partner     |  saleDate  |  description   | quantity |");
        System.out.println("+----+-----------------+------------+----------------+----------+");
        while (resultSet.next()) {
            int realizationId = resultSet.getInt("realization_id");
            String partnerName = resultSet.getString("partner_name");
            String saleDate = resultSet.getString("sale_date");
            String productDescription = resultSet.getString("product_description");
            int quantity = resultSet.getInt("quantity");

            System.out.printf("| %2d | %-10s | %s |   %-12s |  %3d     |\n",
                    realizationId, partnerName, saleDate, productDescription, quantity);
        }
    }
}