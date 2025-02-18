package taskManager;

import java.util.Scanner;

import static taskManager.TaskManager.*;

public class Menu
{
    static void mainMenu()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("\n> > > Главное меню < < <\n" +
                "[1] Добавить задачу\n" +
                "[2] Просмотреть задачи\n" +
                "[3] Недавние задачи\n" +
                "-----------------------\n" +
                "[0] Выход\n" +
                "Выбор: ");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice)
        {
            case 1:
                addTask(input);
                break;

            case 2:
                viewTasks(input);
                break;

            case 3:
                viewRecentTasks();
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
