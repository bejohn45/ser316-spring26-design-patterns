package petshelter.shelter;

// imports
import petshelter.animal.AnimalManager;
import petshelter.animal.AnimalFactory;
import petshelter.animal.Animal;
import petshelter.animal.Species;
import petshelter.animal.IntakeType;
import petshelter.animal.Size;
import petshelter.animal.Temperament;
import petshelter.animal.HealthStatus;

import java.util.Random;

/**
 * Represents pet shelter
 */
public class PetShelter 
{
    private AnimalManager animalManager;            // manager for animals       
    private AnimalFactory animalFactory;            // factory for creating animals
    private final Random random;                    // random number generator

        /**
         * Constructor for PetShelter
         */
        public PetShelter() 
        {
            animalManager = new AnimalManager();
            animalFactory = new AnimalFactory();
            random = new Random();
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

        /**
         * Generate random animals each cycle for new arrivals
         */
        public void generateRandomAnimals()
        {
            // 0-3 new animals each cycle
            int count = random.nextInt(4);
            // check if no new animals
            if (count == 0)
            {
                System.out.println("No new animals arrived today.");
                return;
            }
            // add new animals
            for (int i = 0; i < count; i++) 
            {
                // random attributes
                Species species = Species.values()[random.nextInt(Species.values().length)];
                HealthStatus healthStatus = HealthStatus.values()[random.nextInt(HealthStatus.values().length)];
                IntakeType intakeType = IntakeType.values()[random.nextInt(IntakeType.values().length)];
                Size size = Size.values()[random.nextInt(Size.values().length)];
                Temperament temperament = Temperament.values()[random.nextInt(Temperament.values().length)];
                int age = random.nextInt(10) + 1;   // random age 1-10
                // create animal
                Animal animal = animalFactory.createAnimal(
                    species,
                    age,
                    healthStatus,
                    intakeType,
                    size,
                    temperament
                );
                animalManager.addAnimal(animal);
                System.out.println("New animal arrived with ID: " + animal.getId() + " - " + animal.getSpecies() + " - " + animal.getAge() + " - " + animal.getHealthStatus());
            }
        }
}
