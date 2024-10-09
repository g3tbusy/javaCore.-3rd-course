package sorting;

import java.util.List;

import static sorting.Employee.*;

public class App
{
    public static void main(String[] args)
    {
        List<Employee> employees = generateEmployees(10);

        System.out.println("\nСписок сотрудников:");
        for (Employee employee : employees)
        {
            System.out.println(employee);
        }

        sortByName(employees);
        System.out.println("\nСортировка по имени:");
        for (Employee employee : employees)
        {
            System.out.println(employee);
        }

        sortByNameAndSalary(employees);
        System.out.println("\nСортировка по имени и зарплате:");
        for (Employee employee : employees)
        {
            System.out.println(employee);
        }

        sortByAllFields(employees);
        System.out.println("\nСортировка по имени, зарплате, возрасту и компании:");
        for (Employee employee : employees)
        {
            System.out.println(employee);
        }
    }
}
