package petshelter.animal;

import petshelter.animal.MedicalAction;
import petshelter.animal.CareAction;
import petshelter.animal.state.AnimalState;
import petshelter.animal.state.IntakeState;
import petshelter.adopter.Adopter;

/**
 * Represents an animal in the pet shelter
 */
public class Animal 
{
    private int id;                         // unique id for each animal
    private Species species;                // enum for species (e.g., DOG, CAT, etc.)
    private int age;                        // age of animal
    private HealthStatus healthStatus;      // enum for health status (e.g., HEALTHY, SICK)
    private int recoveryDaysRemaining;      // number of days remaining for recovery if the animal is sick or injured

    // state pattern for animal status
    private AnimalState state;            // current state of the animal (e.g., intake, available, adopted, etc.)

    /**
     * Constructor for Animal
     */
    public Animal(int id, Species species, int age, HealthStatus healthStatus) 
    {
        this.id = id;
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        this.recoveryDaysRemaining = 0;
        // initialize as intake state when created
        this.state = new IntakeState();
    }

    /**
     * Process the intake of the animal
     */
    public void processIntake() 
    {
        state.processIntake(this);
    }

    /**
     * Perform medical action on the animal (e.g., intake exam or vaccination)
     */
    public void performMedical(MedicalAction medicalAction) 
    {
        state.performMedical(this, medicalAction);
    }

    /**
     * Perform care action on the animal (e.g., feeding, cleaning, exercise, socialization)
     */
    public void performCare(CareAction careAction)
    {
        state.performCare(this, careAction);
    }

    /**
     * Request adoption for the animal
     */
    public void requestAdoption(Adopter adopter) 
    {
        state.requestAdoption(this, adopter);
    }

    /**
     * Complete the adoption process for the animal
     */
    public void completeAdoption()
    {
        state.completeAdoption(this);
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
    public String getState()
    {
        return state.getStateName();
    }

}
