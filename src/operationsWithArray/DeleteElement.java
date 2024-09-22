package operationsWithArray;

import static operationsWithArray.DisplayArrayOnScreen.*;
import static operationsWithArray.Main.*;

public class DeleteElement
{
    public static void DeleteElementByPos()
    {
        int deleteNumByPos;
        System.out.print("Введите позицию числа для удаления: ");

        deleteNumByPos = input.nextInt() - 1;

        for (int i = deleteNumByPos; i < numArray.length - 1; i++)
        {
            numArray[i] = numArray[i+1]; // сдвиг влево
        }

        numArray[numArray.length - 1] = 0; // обнуляем

        System.out.println("Успешно удалено");

        Display_array_on_screen();
        mainMenu();
    }
}
