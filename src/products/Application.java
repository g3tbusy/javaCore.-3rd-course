package products;

public class Application
{
    public static void main(String[] args)
    {
        Product apple = new Product("Яблоко", 0.3, 0.2, 14, 52);
        Product chicken = new Product("Курица", 31, 3.6, 0, 165);
        Product bread = new Product("Хлеб", 7.2, 2.5, 45, 248);
        Product butter = new Product("Масло", 0.9, 81, 0.1, 717);
        Product milk = new Product("Молоко", 3.3, 1.0, 5.0, 42);
        Product eggs = new Product("Яйца", 13, 11, 1.1, 155);

        MyProducts myDiet = new MyProducts(30, 10, 50, 500);

        myDiet.addProduct(apple);
        myDiet.addProduct(chicken);
        myDiet.addProduct(bread);
        myDiet.addProduct(butter);
        myDiet.addProduct(milk);
        myDiet.addProduct(eggs);

        myDiet.listProducts();
    }
}
