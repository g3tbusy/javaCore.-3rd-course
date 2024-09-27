package operationsWithArray;

public class PersonOperations
{
    private Person[] people;
    private int count;

    public PersonOperations(int size)
    {
        people = new Person[size];
        count = 0;
    }

    public void addPerson(Person person)
    {
        if (count < people.length)
        {
            people[count] = person;
            count++;
        }

        else
        {
            System.out.println("Массив полон!");
        }
    }
}