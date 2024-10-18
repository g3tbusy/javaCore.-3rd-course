package playlist.classic;

public class Artist
{
    public String name;

    public Artist(String name)
    {
        this.name = name;
    }

    public void getName()
    {
        System.out.println(name);
    }

    public String getName2()
    {
        return name;
    }
}
