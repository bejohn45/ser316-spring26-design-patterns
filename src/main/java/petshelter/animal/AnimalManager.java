package petshelter.animal;

// imports
import java.util.List;
import java.util.ArrayList;


/**
 * Manager class for animals in pet shelter
 */
public class AnimalManager 
{
    private List<Animal> animals;       // list of animals

    /**
     * Constructor for AnimalManager
     */
    public AnimalManager() 
    {
        animals = new ArrayList<>();
    }

    /**
     * Add an animal to the shelter
     */
    public void addAnimal(Animal animal) 
    {
        animals.add(animal);
    }

    /**
     * Get list of animals in the shelter
     */
    public List<Animal> getAnimals() 
    {
        return new ArrayList<>(animals);
    }

    /**
     * Get an animal by id
     */
    public Animal getAnimalById(int id) 
    {
        for (Animal animal : animals) 
        {
            if (animal.getId() == id) 
            {
                return animal;
            }
        }
        // no animal with id
        return null;
    }
}
