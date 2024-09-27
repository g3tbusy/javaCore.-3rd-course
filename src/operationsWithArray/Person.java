package operationsWithArray;

public class Person
{
    private String personFirstName;
    private String personLastName;
    private int personAge;

    public Person(String personFirstName, String personLastName, int personAge)
    {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.personAge = personAge;
    }

    public String getPersonFirstName()
    {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName)
    {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName()
    {
        return personLastName;
    }

    public void setPersonLastName(String personLastName)
    {
        this.personLastName = personLastName;
    }

    public int getPersonAge()
    {
        return personAge;
    }

    public void setPersonAge(int personAge)
    {
        this.personAge = personAge;
    }

    public String getInfo()
    {
        return "Имя: " + personFirstName + ", Фамилия: " + personLastName + ", Возраст: " + personAge;
    }
}