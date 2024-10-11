package phone;

import java.util.*;

public class App
{
    public static void main(String[] args)
    {
        List<Phone> phones = Phone.generateRandomPhones(30);

        phones.sort(Comparator.comparingDouble(Phone::getPrice));
        System.out.println("Телефоны, отсортированные по цене:");
        for (Phone phone : phones)
        {
            System.out.println(phone);
        }

        phones.sort(Comparator.comparingDouble(Phone::getWeight));
        System.out.println("\nТелефоны, отсортированные по весу:");
        for (Phone phone : phones)
        {
            System.out.println(phone);
        }
    }
}
