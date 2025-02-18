//package postgresql;
//
//import java.sql.*;
//
//public class DB
//{
//    private static final String host = "localhost";
//    private static final String port = "5432";
//    private static final String db_name = "db";
//    private static final String login = "first";
//    private static final String password = "";
//
//    private static Connection dbConn;
//
//    static Connection getDBConnection() throws ClassNotFoundException, SQLException {
//        String str = "jdbc:postgresql://" + host + ":" + port + "/" + db_name;
//        Class.forName("org.postgresql.Driver");
//        dbConn = DriverManager.getConnection(str, login, password);
//        return dbConn;
//    }
//
//    public void isConnection() throws SQLException, ClassNotFoundException {
//        dbConn = getDBConnection();
//        System.out.println(dbConn.isValid(1000));
//    }
//
////    public static void createTables(Connection connection) throws SQLException
////    {
////        String createUsers = "CREATE TABLE IF NOT EXISTS Users (" +
////                "user_id SERIAL PRIMARY KEY NOT NULL, " +
////                "user_name VARCHAR(20) NOT NULL, " +
////                "user_email VARCHAR(50) NOT NULL UNIQUE, " +
////                "user_password CHAR(50) NOT NULL, " +
////                "user_mobile_number VARCHAR(11) NOT NULL CHECK (LENGTH(user_mobile_number) = 11) UNIQUE)";
////        try (Statement stmt = connection.createStatement())
////        {
////            stmt.executeUpdate(createUsers);
////            System.out.println("users created or already exists");
////        }
////
////        String createCategoties = "CREATE TABLE IF NOT EXISTS Categories (" +
////                "category_id SERIAL PRIMARY KEY, " +
////                "category_name VARCHAR(50) NOT NULL UNIQUE)";
////        try (Statement stmt = connection.createStatement())
////        {
////            stmt.executeUpdate(createCategoties);
////            System.out.println("categories created or already exists");
////        }
////
////        String createProducts = "CREATE TABLE IF NOT EXISTS Products (" +
////                "product_id SERIAL PRIMARY KEY, " +
////                "product_name VARCHAR(100) NOT NULL, " +
////                "product_model VARCHAR(60), " +
////                "product_description VARCHAR(300), " +
////                "product_price NUMERIC(7, 2) CHECK (product_price >= 0) NOT NULL, " +
////                "category_name VARCHAR(50) NOT NULL, " +
////                "category_id INT NOT NULL, " +
////                "FOREIGN KEY (category_name) REFERENCES Categories (category_name), " +
////                "FOREIGN KEY (category_id) REFERENCES Categories (category_id))";
////        try (Statement stmt = connection.createStatement())
////        {
////            stmt.executeUpdate(createProducts);
////            System.out.println("products created or already exists");
////        }
////
////        String createOrders = "CREATE TABLE IF NOT EXISTS Orders (" +
////                "order_id SERIAL PRIMARY KEY, " +
////                "user_id INT NOT NULL, " +
////                "order_status VARCHAR(30) NOT NULL, " +
////                "order_date DATE DEFAULT CURRENT_DATE, " +
////                "order_time TIME DEFAULT CURRENT_TIMESTAMP, " +
////                "product_id INT NOT NULL, " +
////                "product_name VARCHAR(100) NOT NULL, " +
////                "delivery_address VARCHAR(100) NOT NULL, " +
////                "order_price NUMERIC(7, 2) NOT NULL, " +
////                "order_delivery_price INT NOT NULL, " +
////                "FOREIGN KEY (user_id) REFERENCES Users (user_id), " +
////                "FOREIGN KEY (product_id) REFERENCES Products (product_id))";
////        try (Statement stmt = connection.createStatement())
////        {
////            stmt.executeUpdate(createOrders);
////            System.out.println("orders created or already exists");
////        }
////
////        String createProductsReviews = "CREATE TABLE IF NOT EXISTS ProductReviews (" +
////                "review_id SERIAL PRIMARY KEY, " +
////                "user_id INT NOT NULL, " +
////                "product_id INT NOT NULL, " +
////                "review_text VARCHAR(500), " +
////                "review_rating NUMERIC(2, 1) CHECK (review_rating >= 1 AND review_rating <= 5), " +
////                "review_date DATE DEFAULT CURRENT_DATE, " +
////                "FOREIGN KEY (user_id) REFERENCES Users (user_id), " +
////                "FOREIGN KEY (product_id) REFERENCES Products (product_id))";
////        try (Statement stmt = connection.createStatement())
////        {
////            stmt.executeUpdate(createProductsReviews);
////            System.out.println("productsReviews created or already exists\n");
////        }
////    }
//
//    public static void createTableUsers(String tableName, String I, String II, String III, String IV, String V) throws SQLException, ClassNotFoundException {
//        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + I + ", " + II + ", " + III + ", " + IV + ", " + V + ");";
//        Statement statement = getDBConnection().createStatement();
//        statement.executeUpdate(sql);
//    }
//
//    public static void createTableCategories(String tableName, String I, String II) throws SQLException, ClassNotFoundException {
//        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + I + ", " + II + ");";
//        Statement statement = getDBConnection().createStatement();
//        statement.executeUpdate(sql);
//    }
//
//    public static void createTableProducts(String tableName, String I, String II, String III, String IV, String V, String VI, String VII) throws SQLException, ClassNotFoundException {
//        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + I + ", " + II + ", " + III + ", " + IV + ", " + V + ", " + VI + ", " + VII + ");";
//        Statement statement = getDBConnection().createStatement();
//        statement.executeUpdate(sql);
//    }
//
//    public static void createTableOrders(String tableName, String I, String II, String III, String IV, String V, String VI, String VII, String VIII, String IX, String X) throws SQLException, ClassNotFoundException {
//        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + I + ", " + II + ", " + III + ", " + IV + ", " + V + ", " + VI + ", " + VII + ", " + VIII + ", " + IX + ", " + X +");";
//        Statement statement = getDBConnection().createStatement();
//        statement.executeUpdate(sql);
//    }
//
//    public static void createTableProductsReviews(String tableName, String I, String II, String III, String IV, String V, String VI) throws SQLException, ClassNotFoundException {
//        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + I + ", " + II + ", " + III + ", " + IV + ", " + V + ", " + VI +");";
//        Statement statement = getDBConnection().createStatement();
//        statement.executeUpdate(sql);
//    }
//
//    public void insertTableUsers(String tableName, String I, String II, String III, String IV ,String V, String VI) throws SQLException, ClassNotFoundException {
//        String sql = "INSERT INTO " + tableName + " " + "(" + I + ", " + II +  ") VALUES (" + III + ", " + IV + "), (" + V + ", " + VI + ");";
//        Statement statement = getDBConnection().createStatement();
//        statement.executeUpdate(sql);
//    }
//
//    public static void insertData(Connection connection) throws SQLException
//    {
//        String insertUsers = "INSERT INTO Users (user_name, user_email, user_password, user_mobile_number) VALUES " +
//                "('Иван', 'ivan123@example.com', 'p@ssw0rd123', '79123456789'), " +
//                "('Елена', 'elena456@example.com', 'qwerty456', '79234567890'), " +
//                "('Дмитрий', 'dmitriy789@example.com', 'abc123xyz', '79345678901'), " +
//                "('Анна', 'anna101112@example.com', 'password789', '79456789012'), " +
//                "('Сергей', 'sergey131415@example.com', 'securepwd321', '79567890123')";
//        try (Statement stmt = connection.createStatement())
//        {
//            stmt.executeUpdate(insertUsers);
//            System.out.println("users inserted");
//        }
//
//        String insertCategories = "INSERT INTO Categories (category_name) VALUES " +
//                "('Холодильники'), " +
//                "('Плиты и духовки'), " +
//                "('Стиральные машины'), " +
//                "('Посудомоечные машины'), " +
//                "('Микроволновые печи'), " +
//                "('Электрочайники и кофеварки'), " +
//                "('Утюги и парогенераторы'), " +
//                "('Пылесосы'), " +
//                "('Климатическая техника'), " +
//                "('Водонагреватели'), " +
//                "('Мелкая кухонная техника'), " +
//                "('Мультиварки и скороварки'), " +
//                "('Кофемашины'), " +
//                "('Тостеры и сэндвичницы'), " +
//                "('Мясорубки и миксеры для мяса'), " +
//                "('Фильтры и пылесборники'), " +
//                "('Аксессуары для пылесосов'), " +
//                "('Кондиционеры и вентиляторы'), " +
//                "('Обогреватели и радиаторы'), " +
//                "('Очистители воздуха и увлажнители'), " +
//                "('Системы умного дома'), " +
//                "('Встраиваемая бытовая техника'), " +
//                "('Аксессуары для кухонной техники'), " +
//                "('Уход за одеждой и обувью'), " +
//                "('Уход за волосами'), " +
//                "('Уход за телом и зубами'), " +
//                "('Массажеры и тренажеры'), " +
//                "('Электронные весы и измерители'), " +
//                "('Электробритвы и триммеры')";
//        try (Statement stmt = connection.createStatement())
//        {
//            stmt.executeUpdate(insertCategories);
//            System.out.println("categories inserted");
//        }
//
//
//       String insertProducts = "INSERT INTO Products (product_name, product_model, product_description, product_price, category_name, category_id) VALUES " +
//                "('Холодильник \"Атлант\"', 'ATL-123', 'Холодильник \"Атлант\" с объемом камеры 300 литров и энергопотреблением класса A+', 25000.00, 'Холодильники', 1), " +
//                "('Духовка с электрической плитой \"Electrolux\"', 'ELE-456', 'Духовка с электрической плитой от \"Electrolux\" с функцией конвекции', 35000.00, 'Плиты и духовки', 2), " +
//                "('Стиральная машина \"Bosch\"', 'BOS-789', 'Стиральная машина \"Bosch\" с загрузкой 7 кг и функцией защиты от протечек', 30000.00, 'Стиральные машины', 3), " +
//                "('Посудомоечная машина \"Siemens\"', 'SIE-101', 'Посудомоечная машина \"Siemens\" с функцией сушки и возможностью установки встраиваемой панели', 40000.00, 'Посудомоечные машины', 4), " +
//                "('Микроволновая печь \"LG\"', 'LGM-202', 'Микроволновая печь \"LG\" с объемом камеры 20 литров и функцией быстрого размораживания', 8000.00, 'Микроволновые печи', 5)";
//        try (Statement stmt = connection.createStatement())
//        {
//            stmt.executeUpdate(insertProducts);
//            System.out.println("products inserted");
//        }
//
//        String insertReviews = "INSERT INTO ProductReviews (user_id, product_id, review_text, review_rating, review_date) VALUES " +
//                "(1, 1, 'Холодильник работает отлично но инструкция не очень понятная', 4.5, '2023-07-12'), " +
//                "(2, 2, 'Духовка нагревается очень быстро удобно пользоваться', 5.0, '2023-09-28'), " +
//                "(3, 3, 'Стиральная машина Bosch поломалась через месяц использования', 2.5, '2023-11-05'), " +
//                "(4, 4, 'Посудомоечная машина Siemens отлично моет посуду но долго сушит', 4.0, '2023-04-19'), " +
//                "(5, 5, 'Микроволновая печь LG выглядит стильно но слабо нагревает', 3.0, '2023-10-07')";
//        try (Statement stmt = connection.createStatement())
//        {
//            stmt.executeUpdate(insertReviews);
//            System.out.println("product reviews inserted");
//        }
//
//        String insertOrders = "INSERT INTO Orders (user_id, order_status, order_date, order_time, product_id, product_name, delivery_address, order_price, order_delivery_price) VALUES " +
//                "(1, 'В обработке', '2023-07-12', '16:28:02', 1, 'Встраиваемая микроволновая печь Whirlpool', 'ул. Ленина, д. 10, кв. 5', 15000.00, 500), " +
//                "(2, 'На сборке', '2023-09-28', '09:33:30', 2, 'Электрическая зубная щетка Oral-B', 'ул. Пушкина, д. 15, кв. 3', 4000.00, 350), " +
//                "(3, 'В пути', '2023-11-05', '03:11:52', 3, 'Мясорубка Bosch', 'ул. Гагарина, д. 25, кв. 7', 7000.00, 720), " +
//                "(4, 'Доставлен', '2023-04-19', '08:14:17', 4, 'Кондиционер настенный Mitsubishi Electric', 'ул. Советская, д. 30, кв. 12', 60000.00, 900), " +
//                "(5, 'Отменен', '2023-10-07', '12:26:34', 5, 'Микроволновая печь LG', 'ул. Жукова, д. 12, кв. 8', 8000.00, 400)";
//        try (Statement stmt = connection.createStatement())
//        {
//            stmt.executeUpdate(insertOrders);
//            System.out.println("orders inserted");
//        }
//    }
//}