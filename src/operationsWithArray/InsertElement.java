package operationsWithArray;

import static operationsWithArray.DisplayArrayOnScreen.Display_array_on_screen;
import static operationsWithArray.Main.*;

public class InsertElement
{
    public static void InsertElementByPos()
    {
        int insertPos;
        int insertNumber;

        System.out.print("Введите позицию: ");
        insertPos = input.nextInt() - 1;

        System.out.print("Введите число: ");
        insertNumber = input.nextInt();

        for (int i = numArray.length - 1; i > insertPos; i--)
        {
            numArray[i] = numArray[i - 1];
        }
        numArray[insertPos] = insertNumber;

        System.out.println("Успешно вставлено");

        Display_array_on_screen();
        mainMenu();
    }
}