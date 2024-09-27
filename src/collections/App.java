package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class App
{
    public static void main(String[] args)
    {
        Hamster hamsterBusiness = new Hamster("хамстер богаты", 10,43);
        Hamster hamsterBroke = new Hamster("хамстер нищи", 10, 19);
        Hamster hamsterGenius = new Hamster("хамстер гений", 10, 97);
        Hamster hamsterPatau = new Hamster("патау хамстер", 667, 53);
        Hamster hamsterBald = new Hamster("лысый хамсте", 2367, 82);

        ArrayList<Hamster> hamsterListing = new ArrayList<>();

        hamsterListing.add(hamsterBusiness);
        hamsterListing.add(hamsterBroke);
        hamsterListing.add(hamsterGenius);
        hamsterListing.add(hamsterPatau);
        hamsterListing.add(hamsterBald);

        hamsterListing.add(new Hamster("инвалид хамстер", -452, -865));

        System.out.println("залистилось " + hamsterListing.size() + " хамстера урааа урааа мы все будем богатые аддаадад ыаороапвырьыд дцуу");
        System.out.println("обзор хамстеров ниже \n\n" + hamsterListing.toString() + "\n");

        for(Hamster homa:hamsterListing)
        {
            System.out.println(homa.getName());
        }

        Iterator<Hamster> iter = hamsterListing.iterator();

        while(iter.hasNext())
        {
            if(iter.next().getWeight() > 500)
            {
                iter.remove(); // убийство хамстера
            }
        }

        System.out.println("\nbig hamsters has been killed (banned)\n" + hamsterListing.toString());

        LinkedList<Hamster> LinkedHamster = new LinkedList<>();

        
    }
}