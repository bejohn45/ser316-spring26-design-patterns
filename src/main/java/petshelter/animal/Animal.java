package petshelter.animal;

/**
 * Represents an animal in the pet shelter
 */
public class Animal 
{
    private int id;                         // unique id for each animal
    private Species species;                // enum for species (e.g., DOG, CAT, etc.)
    private int age;                        // age of animal
    private HealthStatus healthStatus;      // enum for health status (e.g., HEALTHY, SICK)
    // state pattern for animal status
    private AnimalStatus status;            // current status of the animal (e.g., intake, available, adopted, etc.)

    /**
     * Constructor for Animal
     */
    public Animal(int id, Species species, int age, HealthStatus healthStatus) 
    {
        this.id = id;
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        // initialize as intake state when created
        this.status = new IntakeState();
    }



    /**
     * Getter for id
     */
    public int getId() 
    {
        return id;
    }

    /**
     * Getter for species
     */
    public Species getSpecies() 
    {
        return species;
    }

    /**
     * Getter for age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Getter for health status
     */
    public HealthStatus getHealthStatus()
    {
        return healthStatus;
    }

    /**
     * Getter for state
     */
    public AnimalState getStatus()
    {
        return status;
    }

}
