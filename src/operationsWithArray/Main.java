package operationsWithArray;

import java.util.Random;
import java.util.Scanner;

import static operationsWithArray.DeleteElement.*;
import static operationsWithArray.ElementFinder.*;
import static operationsWithArray.DisplayArrayOnScreen.*;

public class Main
{
    public static int[] numArray = new int[100];
    public static Random randomizer = new Random();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        for (int i = 0; i < numArray.length; i++)
        {
            numArray[i] = randomizer.nextInt(500);
        }

        mainMenu();
    }

    public static void mainMenu()
    {
        int choice = 0;

        System.out.print("\n\n< < < Главное меню > > >\n" +
                "[1] Вывести массив на экран\n" +
                "[2] Найти позицию по числу (числа от 1 до 500)\n" +
                "[3] Найти число по позиции (100 позиций)\n" +
                "[4] Удалить число по позиции (100 позиций)\n" +
                "[0] Завершение работы.\n" +
                "--------\n" +
                "Выбор: ");

        choice = input.nextInt();

        switch (choice)
        {
            case 1:
                Display_array_on_screen();
                break;

            case 2:
                FindPosByNumber();
                break;

            case 3:
                FindNumberByPos();
                break;

            case 4:
                DeleteElementByPos();
                break;

            case 0:
                System.out.println("{!} Завершение работы, до встречи.");

                System.exit(0);
                break;

            default:
                System.out.println("{!} Неверный ввод.");

                mainMenu();
                break;
        }

    }
}

