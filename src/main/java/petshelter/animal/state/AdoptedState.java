lackage petshelter.animal.state;

// imports
import petshelter.animal.Animal;
import petshelter.adoption.Adopter;
import petshelter.action.MedicalAction;
import petshelter.action.CareAction;
import petshelter.animal.IntakeType;

/**
 * AdoptedState class representing the adopted state of an animal in the shelter
 */
public class AdoptedState implements AnimalState
{
    /**
     * Get the name of the current state of the animal
     */
    @Override
    public String getStateName()
    {
        return "ADOPTED";
    }

    /**
     * Process the intake of the animal
     */
    @Override
    public void processIntake(Animal animal)
    {
        // cannot process intake when adopted
        throw new IllegalStateException("Cannot process intake during adopted state for ID: " + animal.getId());
    }

    /**
     * Perform medical action on the animal (e.g., intake exam or vaccination)
     */
    @Override
    public void performMedical(Animal animal, MedicalAction medicalAction)
    {
        // cannot perform medical actions when adopted
        throw new IllegalStateException("Cannot perform medical actions during adopted state for ID: " + animal.getId());
    }

    /**
     * Perform care action on the animal (e.g., feeding, cleaning, exercise, socialization)
     */
    @Override
    public void performCare(Animal animal, CareAction careAction)
    {
        // cannot perform care actions when adopted
        throw new IllegalStateException("Cannot perform care actions during adopted state for ID: " + animal.getId());
    }

    /**
     * Request adoption for the animal
     */
    @Override
    public void requestAdoption(Animal animal, Adopter adopter)
    {
        // cannot request adoption when adopted
        throw new IllegalStateException("Cannot request adoption during adopted state for ID: " + animal.getId());
    }

    /**
     * Complete the adoption process for the animal
     */
    @Override
    public void completeAdoption(Animal animal)
    {
        // cannot complete adoption when already adopted
        throw new IllegalStateException("Cannot complete adoption during adopted state for ID: " + animal.getId());
    }
}
