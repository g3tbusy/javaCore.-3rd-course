package module_01;

import java.sql.Connection;
import java.sql.SQLException;

public class App
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        // task on page 32: https://bom.firpo.ru/file/public/77752/%D0%9A%D0%9E%D0%94%2009.02.07-2-2025%20%D0%A2%D0%BE%D0%BC%201.pdf

        DB.isConnection();
        Connection connection = DB.getDBConnection();

        DB.createTablePartner();
        DB.createTablePartners_realization();

        DB.insertIntoPartners("ООО \"Партнер 1\"", "ул. Ленина, 1", "+7 111 111-11-11", "partner1@example.com");
        DB.insertIntoPartners("ООО \"Партнер 2\"", "ул. Гагарина, 2", "+7 222 222-22-22", "partner2@example.com");
        DB.insertIntoPartners("ООО \"Партнер 3\"", "ул. Мира, 3", "+7 333 333-33-33", "partner3@example.com");
        DB.insertIntoPartners("ООО \"Партнер 4\"", "ул. Победы, 4", "+7 444 444-44-44", "partner4@example.com");
        DB.insertIntoPartners("ООО \"Партнер 5\"", "ул. Свободы, 5", "+7 555 555-55-55", "partner5@example.com");

        DB.insertIntoPartners_realization("1", "2025-01-10", "Продукт A", "100");
        DB.insertIntoPartners_realization("2", "2025-02-11", "Продукт B", "150");
        DB.insertIntoPartners_realization("3", "2025-03-12", "Продукт C", "200");
        DB.insertIntoPartners_realization("4", "2025-04-13", "Продукт D", "250");
        DB.insertIntoPartners_realization("5", "2025-05-14", "Продукт E", "300");

        DB.selectFromPartners("partners");

        DB.updatePartners("1", "ООО new partner", "new addres", "+7newphone", "newemail@new.new");

        DB.delete("partners", "2");

        DB.selectFromPartnerRealizationHistory(3);
    }
}
