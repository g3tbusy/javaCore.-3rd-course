package operationsWithArray;

import static operationsWithArray.Main.*;

public class ElementFinder
{
    public static void FindPosByNumber()
    {
        boolean isFindedPos = false;
        int[] findPosArray = new int[100];

        System.out.print("\nВведите число: ");
        int findPos = input.nextInt();

        for (int i = 0; i < numArray.length; i++)
        {
            if (findPos == numArray[i])
            {
                isFindedPos = true;

                findPosArray[i] = i;
            }
        }

        if (isFindedPos)
        {
            System.out.printf("Число '" + findPos + "' имеется на позиции(-ях): ");
            for (int i = 0; i < findPosArray.length; i++)
            {
                if (findPosArray[i] != 0)
                {
                    System.out.print(findPosArray[i]+1 + " ");
                }
            }

            mainMenu();
        }

        else
        {
            System.out.println("Число '" + findPos + "' отсутствует в массиве");

            mainMenu();
        }
    }

    public static void FindNumberByPos()
    {
        System.out.print("\nВведите позицию: ");
        int findNum = input.nextInt() - 1;
        int tempSout = findNum + 1;

        if (findNum >= 0 && findNum <= 100)
        {
            System.out.println("На позиции '" + tempSout + "' находится число '" + numArray[findNum] + "'");

            mainMenu();
        }

        else
        {
            System.out.println("{!} Введите число в диапазоне 0 - 500");

            FindNumberByPos();
        }

    }
}
