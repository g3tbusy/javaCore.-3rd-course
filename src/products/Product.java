package products;

public class Product
{
    String name;
    double proteins;
    double fats;
    double carbs;
    double calories;

    public Product(String name, double proteins, double fats, double carbs, double calories)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }

        if (proteins < 0 || fats < 0 || carbs < 0 || calories < 0)
        {
            throw new IllegalArgumentException("Значения белков, жиров, углеводов или калорий не могут быть отрицательными");
        }

        this.name = name;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.calories = calories;
    }

    // Конструктор без калорий
    public Product(String name, double proteins, double fats, double carbs)
    {
        this(name, proteins, fats, carbs, 4 * proteins + 9 * fats + 4 * carbs);
    }

    // Конструктор только с названием
    public Product(String name)
    {
        this(name, 0, 0, 0, 0);
    }

    // Конструктор без углеводов
    public Product(String name, double proteins, double fats)
    {
        this(name, proteins, fats, 0, 4 * proteins + 9 * fats);
    }

    public String getName() {
        return name;
    }

    public double getProteins() {
        return proteins;
    }


    public double getFats() {
        return fats;
    }


    public double getCarbs() {
        return carbs;
    }


    public double getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbs=" + carbs +
                ", calories=" + calories +
                '}';
    }
}