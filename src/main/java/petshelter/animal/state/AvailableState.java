package petshelter.animal.state;

//imports
import petshelter.animal.Animal;
import petshelter.action.CareAction;
import petshelter.action.MedicalAction;
import petshelter.adoption.Adopter;

public class AvailableState implements AnimalState
{
    private final int sickRecoveryDays = 2;         // days it takes for sick animal to recover
    private final int injuredRecoveryDays = 3;      // days it takes for injured animal to recover

    /**
     * Get the name of the current state of the animal
     */
    @Override
    public String getStateName()
    {
        return "AVAILABLE";
    }

    /**
     * Available animals have already been processed through intake
     */
    @Override
    public void processIntake(Animal animal)
    {
        throw new IllegalStateException("Cannot process intake during available state for ID: " + animal.getId());
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
        // check if medical action is intake exam
        if (medicalAction == MedicalAction.INTAKE_EXAM) 
        {
            throw new IllegalArgumentException("Cannot perform intake exam during available state for ID: " + animal.getId());
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
        // set pending adopter and set to pending state
        animal.setPendingAdopter(adopter);
        animal.setState(new PendingState());
        System.out.println("Adoption requested by " + adopter.getName() + " for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies() + " - " + getStateName());
    }

    /**                                                 
     * Complete the adoption process for the animal
     */
    @Override
    public void completeAdoption(Animal animal)
    {
        // cannot complete adoption during available state
        throw new IllegalStateException("Cannot complete adoption during available state for ID: " + animal.getId());
    }

}
