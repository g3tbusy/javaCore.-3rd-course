package bank_14_01;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

import static bank_14_01.DB.createTableUsers;

public class App
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        SwingUtilities.invokeLater(() -> GUI.createAndShowGUI());

        DB db = new DB();
        db.isConnection();

        Connection connection = db.getDBConnection();

        //createTableUsers("Users", "user_id SERIAL PRIMARY KEY NOT NULL", "status VARCHAR(9)", "surname VARCHAR(50)", "name VARCHAR(50)", "patronymic VARCHAR(50)", "balance NUMERIC(15,2)");
        //db.insertUsers(Users.userList);
    }
}