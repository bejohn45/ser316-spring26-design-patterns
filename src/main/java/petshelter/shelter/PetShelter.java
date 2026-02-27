package petshelter.shelter;

// imports
import petshelter.animal.AnimalManager;
import petshelter.animal.AnimalFactory;

/**
 * Represents pet shelter
 */
public class PetShelter 
{
    private AnimalManager animalManager;            // manager for animals       
    private AnimalFactory animalFactory;            // factory for creating animals

        /**
         * Constructor for PetShelter
         */
        public PetShelter() 
        {
            animalManager = new AnimalManager();
            animalFactory = new AnimalFactory();
        }
    
        /**
         * Set up initial animals in shelter
         */
        public void setUpAnimals()
        {
            animalFactory.animalSetUp(animalManager);
        }

        /**
         * Getter for animal manager
         */
        public AnimalManager getAnimalManager() 
        {
            return animalManager;
        }
}
