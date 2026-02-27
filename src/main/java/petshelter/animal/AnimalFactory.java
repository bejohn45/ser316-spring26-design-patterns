package petshelter.animal;

// imports

/**
 * Factory for creating animals
 */
public class AnimalFactory 
{
    private static int lastId = 0;      // track of last assigned id

    /**
     * Create an animal instance
     */
    public static Animal createAnimal(Species species, int age, HealthStatus healthStatus, IntakeType intakeType, Size size,Temperament temperament) 
    {
        int id = ++lastId; 
        return new Animal(id, species, age, healthStatus, intakeType, size, temperament);
    }

    /**
     * Set up animals
     */
    public void animalSetUp(AnimalManager animalManager)
    {
        // create some animals and add to shelter
        animalManager.addAnimal(createAnimal(Species.DOG, 3, HealthStatus.HEALTHY, IntakeType.STRAY, Size.MEDIUM, Temperament.FRIENDLY));
        animalManager.addAnimal(createAnimal(Species.CAT, 2, HealthStatus.SICK, IntakeType.SURRENDER, Size.SMALL, Temperament.SHY));
        animalManager.addAnimal(createAnimal(Species.RABBIT, 1, HealthStatus.INJURED, IntakeType.STRAY, Size.SMALL, Temperament.ANXIOUS));
        System.out.println("Animal setup complete. Total animals in shelter: " + animalManager.getAnimals().size());
    }
}
