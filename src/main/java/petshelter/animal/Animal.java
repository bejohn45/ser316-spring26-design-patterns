package petshelter.animal;

import petshelter.animal.state.AnimalState;
import petshelter.animal.state.IntakeState;

import petshelter.animal.HealthStatus;
import petshelter.animal.IntakeType;
import petshelter.animal.Size;
import petshelter.animal.Temperament;

import petshelter.adoption.Adopter;

import petshelter.action.MedicalAction;
import petshelter.action.CareAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an animal in the pet shelter
 */
public class Animal 
{
    // basic attributes for an animal
    private final int id;                         // unique id for each animal
    private final Species species;                // enum for species (e.g., DOG, CAT, etc.)
    private final int age;                        // age of animal
    private HealthStatus healthStatus;            // enum for health status (e.g., HEALTHY, SICK)

    // intake attributes
    private final IntakeType intakeType;              // enum for type of intake (e.g., STRAY, SURRENDER, TRANSFER)

    // additional attributes for adoption matching
    private final Size size;                            // size of the animal (e.g., small, medium, large)
    private final Temperament temperament;              // temperament of the animal (e.g., FRIENDLY, SHY, AGGRESSIVE, ANXIOUS, ENERGETIC)
    private int recoveryDaysRemaining;                  // number of days remaining for recovery if the animal is sick or injured
    private Adopter pendingAdopter;                     // adopter who wants to adopt the animal

    // state pattern for animal status
    private AnimalState state;            // current state of the animal (e.g., intake, available, adopted, etc.)
    private List<CareAction> careHistory;           // history of care actions done on animal
    private List<MedicalAction> medicalHistory;    // history of medical actions done on animal

    /**
     * Constructor for Animal
     */
    public Animal(int id, Species species, int age, HealthStatus healthStatus, IntakeType intakeType, Size size, Temperament temperament) 
    {
        this.id = id;
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        this.intakeType = intakeType;
        this.size = size;
        this.temperament = temperament;
        this.recoveryDaysRemaining = 0;
        this.pendingAdopter = null;
        // initialize as intake state when animal created
        this.state = new IntakeState();
        this.careHistory = new ArrayList<>();
        this.medicalHistory = new ArrayList<>();
        // do intake exam when animal added
        this.state.performMedical(this, MedicalAction.INTAKE_EXAM);
        this.processIntake();
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
     * Start the recovery process for the animal when animal becomes sick or injured
     */
    public void startRecovery(int days)
    {
        // check if days positive
        if (days <= 0) 
        {
            throw new IllegalArgumentException("Recovery days must be positive for ID: " + id);
        }
        // check if animal is health
        if (healthStatus == HealthStatus.HEALTHY) 
        {
            throw new IllegalStateException("Cannot start recovery for healthy animal with ID: " + id);
        }
        // check if animal is sick or injured
        if ((healthStatus == HealthStatus.SICK) || (healthStatus == HealthStatus.INJURED)) 
        {
            // set recovery days remaining
            this.recoveryDaysRemaining = days;
        }
    }

    /**
     * Tick a day for the recovery process
     */
    public void tickRecoveryDay()
    {
        // check if recovery is in progress
        if (recoveryDaysRemaining > 0) 
        {
            recoveryDaysRemaining--;
            // check if recovery is complete
            if (recoveryDaysRemaining == 0)
            {
                healthStatus = HealthStatus.HEALTHY;
            }
        }
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
     * Getter for intake type
     */
    public IntakeType getIntakeType() 
    {
        return intakeType;
    }

    /**
     * Getter for size
     */
    public Size getSize()
    {
        return size;
    }

    /**
     * Getter for temperament
     */
    public Temperament getTemperament()
    {
        return temperament;
    }

    /**
     * Getter for recovery days remaining
     */
    public int getRecoveryDaysRemaining() 
    {
        return recoveryDaysRemaining;
    }

    /**
     * Getter for pending adopter
     */
    public Adopter getPendingAdopter()
    {
        return pendingAdopter;
    }

    /**
     * Getter for state
     */
    public String getState()
    {
        return state.getStateName();
    }

    /**
     * Getter for care history
     */
    public List<CareAction> getCareHistory() 
    {
        return careHistory;
    }

    /**
     * Getter for medical history
     */
    public List<MedicalAction> getMedicalHistory() 
    {
        return medicalHistory;
    }

    /**
     * Setter to change the lifecycle state of the animal
     */
    public void setState(AnimalState state) 
    {
        this.state = state;
    }

    /**
     * Setter for pending adopter
     */
    public void setPendingAdopter(Adopter adopter)
    {
        this.pendingAdopter = adopter;
    }

    /**
     * Remove pending adopter if adoption fails
     */
    public void removePendingAdopter()
    {
        this.pendingAdopter = null;
    }

    /**
     * Add care action to care history list
     */
    public void addCareAction(CareAction careAction)
    {
        this.careHistory.add(careAction);
    }

    /**
     * Add medical action to medical history list
     */
    public void addMedicalAction(MedicalAction medicalAction)
    {
        this.medicalHistory.add(medicalAction);
    }
}
