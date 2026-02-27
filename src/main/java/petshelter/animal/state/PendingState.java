package petshelter.animal.state;

// imports
import petshelter.animal.Animal;
import petshelter.adoption.Adopter;
import petshelter.action.MedicalAction;
import petshelter.action.CareAction;
import petshelter.animal.IntakeType;

public class PendingState implements AnimalState
{
    /**
     * Get the name of the current state of the animal
     */
    public String getStateName()
    {
        return "PENDING";
    }

    /**
     * Process the intake of the animal
     */
    public void processIntake(Animal animal)
    {
        // cannot process intake when pending
        throw new IllegalStateException("Cannot process intake during pending state for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies());
    }

    /**
     * Perform medical action on the animal (e.g., intake exam or vaccination)
     */
    public void performMedical(Animal animal, MedicalAction medicalAction)
    {
        // check if medical action null
        if (medicalAction == null) 
        {
            throw new IllegalArgumentException("Medical action cannot be null for ID: " + animal.getId());
        }
        // cannot perform intake exam when pending
        if (medicalAction == MedicalAction.INTAKE_EXAM) 
        {
            throw new IllegalArgumentException("Cannot perform intake exam during pending state for ID: " + animal.getId());
        }
        animal.addMedicalAction(medicalAction);
        System.out.println("Performed " + medicalAction + " for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies());

    }

    /**
     * Perform care action on the animal (e.g., feeding, cleaning, exercise, socialization)
     */
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
    public void requestAdoption(Animal animal, Adopter adopter)
    {
        // cannot request adoption when pending
        throw new IllegalStateException("Cannot request adoption during pending state for ID: " + animal.getId());
    }

    /**
     * Complete the adoption process for the animal
     */
    public void completeAdoption(Animal animal)
    {
        // set to adopted state
        animal.setState(new AdoptedState());
        System.out.println("Adoption completed for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies() + " - " + getStateName());
    }
}
