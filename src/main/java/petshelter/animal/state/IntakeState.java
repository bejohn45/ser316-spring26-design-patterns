package petshelter.animal.state;

//imports
import petshelter.animal.Animal;
import petshelter.adoption.Adopter;
import petshelter.action.MedicalAction;
import petshelter.action.CareAction;
import petshelter.animal.IntakeType;

/**
 * State class for the intake process of an animal at the pet shelter
 * This state represents when an animal is first brought into the shelter and is being processed
 */
public class IntakeState implements AnimalState
{
    private final int sickRecoveryDays = 2;         // days it takes for sick animal to recover
    private final int injuredRecoveryDays = 3;      // days it takes for injured animal to recover

    /**
     * Get the name of the current state of the animal
     */
    @Override
    public String getStateName()
    {
        return "INTAKE";
    }

    /**
     * Process the intake of the animal
     */
    @Override
    public void processIntake(Animal animal)
    {
        // check if animal null
        if (animal == null) 
        {
            throw new IllegalArgumentException("Animal cannot be null for intake process for ID: " + animal.getId());
        }
        // do intake exam
        animal.performMedical(MedicalAction.INTAKE_EXAM);
        // check animal health status
        if (animal.getHealthStatus() == petshelter.animal.HealthStatus.SICK) 
        {
            animal.setRecoveryDaysRemaining(sickRecoveryDays);
        }
        else if (animal.getHealthStatus() == petshelter.animal.HealthStatus.INJURED) 
        {
            animal.setRecoveryDaysRemaining(injuredRecoveryDays);
        }
        System.out.println("Processed intake for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies() + " - " + getStateName());
    }

    /**
     * Perform medical action on the animal (e.g., intake exam or vaccination)
     */
    @Override
    public void performMedical(Animal animal, MedicalAction medicalAction)
    {
        // check if medical action null
        if (medicalAction == null) 
        {
            throw new IllegalArgumentException("Medical action cannot be null for ID: " + animal.getId());
        }
        animal.addMedicalAction(medicalAction);
        System.out.println("Performed " + medicalAction + " for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies() + " - " + getStateName());
    }

    /**
     * Perform care action on the animal (e.g., feeding, cleaning, exercise, socialization)
     */
    @Override
    public void performCare(Animal animal, CareAction careAction)
    {
        // check if care action null
        if (careAction == null) 
        {
            throw new IllegalArgumentException("Care action cannot be null for ID: " + animal.getId());
        }
        animal.addCareAction(careAction);
        System.out.println("Performed  " + careAction + " for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies() + " - " + getStateName());
    }

    /**
     * Request adoption for the animal
     */
    @Override
    public void requestAdoption(Animal animal, Adopter adopter)
    {
        // check if adopter null
        if (adopter == null)
        {
            throw new IllegalArgumentException("Adopter cannot be null for ID: " + animal.getId());
        }
        // cannot request adoption during intake state
        throw new IllegalStateException("Cannot request adoption during intake state for ID: " + animal.getId());
    }

    /**
     * Complete the adoption process for the animal
     */
    @Override
    public void completeAdoption(Animal animal)
    {
        // cannot complete adoption during intake state
        throw new IllegalStateException("Cannot complete adoption during intake state for ID: " + animal.getId());
    }
}
