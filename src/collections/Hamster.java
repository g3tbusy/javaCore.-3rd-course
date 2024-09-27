package collections;

import java.util.ArrayList;

public class Hamster
{
    String name;
    int weight;
    int height;

    public Hamster(String name, int weight, int height)
    {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() // hamster listing
    {
        return "Hamster{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}