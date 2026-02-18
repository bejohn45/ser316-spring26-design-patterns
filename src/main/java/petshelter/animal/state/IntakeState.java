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
    /**
     * Get the name of the current state of the animal
     */
    @Override
    public String getStateName()
    {
        return "INTAKE";
    }

    /**
     * Set the current state of the animal to a new state
     */
    @Override
    public void setState(Animal animal, AnimalState newState)
    {
        animal.setState(newState);
    }

    /**
     * Process the intake of the animal
     */
    @Override
    public void processIntake(Animal animal)
    {
        // set animal state to available
        //setState(animal, new AvailableState());
        System.out.println("Processed intake for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies());
    }

    /**
     * Perform medical action on the animal (e.g., intake exam or vaccination)
     */
    @Override
    public void performMedical(Animal animal, MedicalAction medicalAction)
    {
        System.out.println("Performed " + medicalAction + " for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies());
    }

    /**
     * Perform care action on the animal (e.g., feeding, cleaning, exercise, socialization)
     */
    @Override
    public void performCare(Animal animal, CareAction careAction)
    {
        System.out.println("Performed  " + careAction + " for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies());
    }

    /**
     * Request adoption for the animal
     */
    @Override
    public void requestAdoption(Animal animal, Adopter adopter)
    {
        // cannot request adoption during intake state
        System.out.println("Cannot request adoption during intake for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies());
    }

    /**
     * Complete the adoption process for the animal
     */
    @Override
    public void completeAdoption(Animal animal)
    {
        // cannot complete adoption during intake state
        System.out.println("Cannot complete adoption during intake for ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies());
    }
}
