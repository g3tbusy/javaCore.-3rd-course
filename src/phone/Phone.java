package phone;

import sorting.Employee;

import java.util.*;

class Phone
{
    private String serialNumber;
    private String model;
    private int weight;
    private int price;

    public Phone(String serialNumber, String model, double weight, double price)
    {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weight = (int) weight;
        this.price = (int) price;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return "Phone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public static List<Phone> generateRandomPhones(int count)
    {
        List<Phone> phones = new ArrayList<>();
        Random rand = new Random();

        String[] models = {"iPhone", "Samsung", "Huawei", "Nokia", "Sony"};

        for (int i = 0; i < count; i++)
        {
            String serialNumber = UUID.randomUUID().toString();
            String model = models[rand.nextInt(models.length)];
            int weight = rand.nextInt(500);
            int price = rand.nextInt(100000);
            phones.add(new Phone(serialNumber, model, weight, price));
        }

        return phones;
    }
}
