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
import petshelter.action.CareAction;
import petshelter.action.MedicalAction;
import petshelter.adoption.Adopter;

import java.util.List;
import java.util.ArrayList;
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
                System.out.println("No new animals arrived today.\n");
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
            System.out.println("Total new animals arrived today: " + count + "\n");
        }

        /**
         * Perform daily care for all animals in pet shelter
         */
        public void performDailyCare()
        {
            List<Animal> animals = animalManager.getAnimals();
            // do care for each animal
            for (Animal animal : animals)
            {
                // check if adopted
                if (animal.getState().equals("ADOPTED"))
                {
                    continue;
                }
                animal.performCare(CareAction.FEEDING);
                animal.performCare(CareAction.CLEANING);
                animal.performCare(CareAction.EXERCISE);
                animal.performCare(CareAction.SOCIALIZATION);
            }
            System.out.println("Morning daily care completed for all animals.\n");
        }

        /**
         * Perform vaccination for 1 random animal
         */
        public void performMedicalRandom()
        {
            List<Animal> animals = animalManager.getAnimals();
            int r = random.nextInt(animalFactory.getLastId()) + 1;
            MedicalAction medicalAction = MedicalAction.VACCINATION;

            // do medical for each animal
            for (Animal animal : animals)
            {
                // check if adopted
                if (animal.getState().equals("ADOPTED"))
                {
                    continue;
                }
                // vaccination for random animal
                if (r == animal.getId())
                {
                    animal.performMedical(medicalAction);
                }
            }
             System.out.println("VACCINATION performed for animal with ID: " + r + ".\n");
        }
}
