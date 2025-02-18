package events_11_02;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

import static events_11_02.DB.*;

public class App
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        DB db = new DB();
        db.isConnection();

        createTables();

        MainMenu.mainMenu();

        Connection connection = getDBConnection();
    }
}
