package products;

import java.util.ArrayList;
import java.util.List;

public class MyProducts
{
    private double maxProteins;
    private double maxFats;
    private double maxCarbs;
    private double maxCalories;
    private List<Product> products;

    public MyProducts(double maxProteins, double maxFats, double maxCarbs, double maxCalories)
    {
        if (maxProteins < 0 || maxFats < 0 || maxCarbs < 0 || maxCalories < 0)
        {
            throw new IllegalArgumentException("Максимальные значения не могут быть отрицательными");
        }

        this.maxProteins = maxProteins;
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxCalories = maxCalories;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product)
    {
        if (product.getProteins() > maxProteins)
        {
            System.out.println("Продукт " + product.getName() + " не может быть добавлен: слишком много белков.");
        }

        else if (product.getFats() > maxFats)
        {
            System.out.println("Продукт " + product.getName() + " не может быть добавлен: слишком много жиров.");
        }

        else if (product.getCarbs() > maxCarbs)
        {
            System.out.println("Продукт " + product.getName() + " не может быть добавлен: слишком много углеводов.");
        }

        else if (product.getCalories() > maxCalories)
        {
            System.out.println("Продукт " + product.getName() + " не может быть добавлен: слишком много калорий.");
        }

        else
        {
            products.add(product);
            System.out.println("Продукт " + product.getName() + " добавлен.");
        }
    }

    public void listProducts()
    {
        if (products.isEmpty())
        {
            System.out.println("Список продуктов пуст.");
        }

        else
        {
            System.out.println("Продукты в списке:");
            for (Product product : products)
            {
                System.out.println(product.getName());
            }
        }
    }
}
