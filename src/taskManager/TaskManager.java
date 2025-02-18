package taskManager;

import java.util.*;

import static taskManager.Menu.*;

public class TaskManager
{
    static ArrayList<Task> tasks = new ArrayList<>();
    private static final List<Task> recentTasks = new LinkedList<>();

    static void addTask(Scanner scanner)
    {
        System.out.print("Введите заголовок задачи: ");
        String title = scanner.nextLine();

        System.out.print("Введите суть задачи: ");
        String text = scanner.nextLine();

        Task task = new Task(title, text, new Date());
        tasks.add(task);
        System.out.println("Задача добавлена");

        mainMenu();
    }

    static void viewTasks(Scanner scanner)
    {
        System.out.print("Выберите период просмотра ([1] - День [2] - Неделя): ");
        String period = scanner.nextLine();

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        List<Task> filteredTasks = new ArrayList<>();

        if (period.equalsIgnoreCase("1"))
        {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);

            Date startOfDay = calendar.getTime();
            calendar.add(Calendar.DATE, 1);
            Date endOfDay = calendar.getTime();

            filteredTasks = tasks.stream()
                    .filter(task -> task.getDate().after(startOfDay) && task.getDate().before(endOfDay))
                    .toList();
        }

        else if (period.equalsIgnoreCase("2"))
        {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            calendar.set(Calendar.HOUR_OF_DAY, 0);

            Date startOfWeek = calendar.getTime();
            calendar.add(Calendar.DATE, 7);
            Date endOfWeek = calendar.getTime();

            filteredTasks = tasks.stream()
                    .filter(task -> task.getDate().after(startOfWeek) && task.getDate().before(endOfWeek))
                    .toList();
        }

        else
        {
            System.out.println("{!} Ошибка ввода");
            mainMenu();
        }

        if (filteredTasks.isEmpty())
        {
            System.out.println("На данный период нет задач");
            mainMenu();
        }

        else
        {
            System.out.println("\nЗадачи на " + period + ":");
            for (Task task : filteredTasks)
            {
                System.out.println(task);
                recentTasks.add(task);

                if (recentTasks.size() > 5)
                {
                    recentTasks.remove(0);
                }
            }
            mainMenu();
        }
    }

    static void viewRecentTasks()
    {
        if (recentTasks.isEmpty())
        {
            System.out.println("История пуста");
            mainMenu();
        }

        else
        {
            System.out.println("\nПоследние просмотренные задачи: ");
            for (Task task : recentTasks)
            {
                System.out.println(task);
            }
            mainMenu();
        }
    }
}