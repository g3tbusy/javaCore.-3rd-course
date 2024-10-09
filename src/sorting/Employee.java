package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Employee
{
    String name;
    String company;
    int salary;
    int age;

    public Employee(String name, String company, int salary, int age)
    {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public String getCompany()
    {
        return company;
    }

    public int getSalary()
    {
        return salary;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static List<Employee> generateEmployees(int count)
    {
        List<Employee> employees = new ArrayList<>();
        String[] maleNames = {"Алексей", "Иван", "Дмитрий", "Михаил", "Николай"};
        String[] femaleNames = {"Екатерина", "Анна", "Мария", "Ольга", "Светлана"};
        String[] companies = {"Google", "Microsoft", "Apple", "Amazon", "Izhorskiy College", "5ka", "Tesla"};
        Random rand = new Random();

        for (int i = 0; i < count; i++)
        {
            String name = (i % 2 == 0) ? maleNames[rand.nextInt(maleNames.length)]
                    : femaleNames[rand.nextInt(femaleNames.length)];
            String company = companies[rand.nextInt(companies.length)];
            int salary = 30000 + rand.nextInt(90001);
            int age = 21 + rand.nextInt(40);
            employees.add(new Employee(name, company, salary, age));
        }
        return employees;
    }

    public static void sortByName(List<Employee> employees)
    {
        employees.sort(Comparator.comparing(Employee::getName));
    }

    public static void sortByNameAndSalary(List<Employee> employees)
    {
        employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
    }

    public static void sortByAllFields(List<Employee> employees)
    {
        employees.sort(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary)
                .thenComparing(Employee::getAge)
                .thenComparing(Employee::getCompany));
    }
}