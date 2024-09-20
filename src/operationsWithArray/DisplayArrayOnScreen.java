package operationsWithArray;

import static operationsWithArray.Main.*;

public class DisplayArrayOnScreen
{
    public static void Display_array_on_screen()
    {
        for (int i = 0; i < numArray.length; i++)
        {
            System.out.print(numArray[i] + " ");
        }

        mainMenu();
    }
}
