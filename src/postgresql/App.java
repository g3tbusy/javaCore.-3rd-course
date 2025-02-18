//package postgresql;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class App
//{
//    public static void main(String[] args) throws SQLException, ClassNotFoundException
//    {
//        DB db = new DB();
//        db.isConnection();
//
//        Connection connection = db.getDBConnection();
//
//        // createTables(connection);
//
//        DB.createTableUsers("Users", "user_id", "user_name VARCHAR(20) NOT NULL", "user_email VARCHAR(50) NOT NULL", "user_password CHAR(50) NOT NULL", "user_mobile_number VARCHAR(11) NOT NULL");
//        DB.createTableCategories("Categories", "category_id", "category_name VARCHAR(50) NOT NULL");
//        DB.createTableProducts("Products", "product_id", "product_name VARCHAR(100) NOT NULL", "product_model VARCHAR(60)", "product_description VARCHAR(300)", "product_price NUMERIC(7, 2) CHECK (product_price >= 0) NOT NULL", "category_name VARCHAR(50) NOT NULL", "category_id INT NOT NULL");
//        DB.createTableOrders("Orders", "order_id", "user_id INT NOT NULL", "order_status VARCHAR(30)", "order_date DATE DEFAULT CURRENT_DATE", "order_time TIME DEFAULT CURRENT_TIMESTAMP", "product_id INT NOT NULL", "product_name VARCHAR(100) NOT NULL", "delivery_address VARCHAR(100) NOT NULL", "order_price NUMERIC(7, 2) NOT NULL", "order_delivery_price INT NOT NULL");
//        DB.createTableProductsReviews("ProductReviews", "review_id", "user_id INT NOT NULL", "product_id INT NOT NULL", "review_text VARCHAR(500)", "review_rating NUMERIC(2, 1) CHECK (review_rating >= 1 AND review_rating <= 5)", "review_date DATE DEFAULT CURRENT_DATE");
//
//        db.insertTable2("categories ", "id", "name", "1", "'Bobi'", "3", "'Murat'");
//
//
//        //insertData(connection);
//    }
//}