package events_11_02;

import java.sql.SQLException;
import java.util.Scanner;

import static taskManager.TaskManager.*;

public class MainMenu
{
    static void mainMenu() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.print("\n> > > Главное меню < < <\n" +
                "[1] Просмотреть эвенты\n" +
                "[2] Добавить эвент\n" +
//                "[3] Удалить эвент\n" +
//                "[4] Редактировать эвент\n" +
                "-----------------------\n" +
                "[0] Выход\n" +
                "Выбор: ");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice)
        {
            case 1:
                DB.selectFromEvents();
                break;

            case 2:
                DB.insertEvent();
                break;

            case 3:

                break;

            case 0:
                System.exit(0);
                break;

            default:
                System.out.println("{!} Ошибка ввода");
                break;
        }
    }
}
