package simpleCalculator;

import java.util.Scanner;

public class simpleCalculator
{
    public static Scanner input = new Scanner(System.in);

    public static float a;
    public static float b;
    public static float result;
    public static float tempAngle;

    public static int choice = 9;

    public static void main(String[] args)
    {
        mainMenu();
    }

    public static void mainMenu()
    {
        System.out.print("\n---Главное меню---\n" +
                "[1] Сложение\n" +
                "[2] Вычитание\n" +
                "[3] Умножение\n" +
                "[4] Деление\n" +
                "[5] Логарифм числа\n" +
                "[6] Синус угла\n" +
                "[7] Косинус угла\n" +
                "-----------------------\n" +
                "[0] Выход\n\n" +
                "Выбор: ");

        choiceCheck();
    }

    public static void choiceCheck()
    {
        do {
            choice = input.nextInt();
            if (choice < 0 || choice > 7)
            {
                System.out.print("[!] Неверный ввод, выберите другой пункт меню (0-7).\nВыбор: ");
                choiceCheck();
            } else if (choice == 0) {
                System.out.print("\nЗавершение работы.");
                System.exit(0);
            } else if (choice >= 1 && choice <= 4) {
                System.out.print("Введите значение A: ");
                a = input.nextFloat();

                System.out.print("Введите значение B: ");
                b = input.nextFloat();

                operations();
            } else if (choice == 5) {
                System.out.print("Введите основание логарифма: ");
                a = input.nextFloat();

                System.out.print("Введите число логарифма: ");
                b = input.nextFloat();

                operations();
            } else if (choice > 5 || choice < 8) {
                System.out.print("Введите значение угла в градусах: ");
                a = input.nextFloat();
                tempAngle = a;

                operations();
            }

        } while (choice < 1 || choice > 7);
    }

    public static void operations()
    {
        switch (choice)
        {
            case 1:
                addition(); // Сложение
                break;

            case 2:
                subtraction(); // Вычитание
                break;

            case 3:
                multiplication(); // Умножение
                break;

            case 4:
                division(); // Деление
                break;

            case 5:
                logarithm();
                break;

            case 6:
                sinus();
                break;

            case 7:
                cosine();
                break;

            default:
                mainMenu();
                break;
        }
    }

    public static void addition() // Сложение
    {
        result = a + b;
        System.out.print("A + B = " + result + "\n");

        mainMenu();
    }

    public static void subtraction() // Вычитание
    {
        result = a - b;
        System.out.print("A - B = " + result + "\n");

        mainMenu();
    }

    public static void multiplication() // Умножение
    {
        result = a * b;
        System.out.print("A * B = " + result + "\n");

        mainMenu();
    }

    public static void division() // Деление
    {
        result = a / b;
        String roundedResult = String.format("%.2f", result);
        System.out.print("A / B = " + roundedResult + "\n");

        mainMenu();
    }

    public static void logarithm() // Логарифм
    {
        if (a <= 0 || b <= 0 || a == 1)
        {
            System.out.println("Основание и число должны быть положительными, а основание не может быть равно 1.");

            mainMenu();
        }

        result = (float) (Math.log(b) / Math.log(a));
        String roundedResult = String.format("%.0f", result);

        System.out.print("log числа " + b +  " по основанию " + a + " = " + roundedResult);

        mainMenu();
    }

    public static void sinus() // Синус
    {
        b = (float) Math.toRadians(a); // Преобразуем градусы в радианы
        result = (float) Math.sin(b);
        System.out.print("Синус угла " + tempAngle + " градусов = " + result + "\n");

        mainMenu();
    }

    public static void cosine() // Косинус
    {
        b = (float) Math.toRadians(a); // Преобразуем градусы в радианы
        result = (float) Math.cos(b);
        System.out.print("Косинус угла " + tempAngle + " градусов = " + result + "\n");

        mainMenu();
    }
}