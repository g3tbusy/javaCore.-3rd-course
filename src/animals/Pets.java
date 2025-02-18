package animals;

abstract public class Pets
{
    private String name;
    private double weight;

    public void sleep()
    {
        System.out.println("я сплю");
    }

    public abstract void play();

    public abstract void voice();

    public abstract void eats();

    
}
