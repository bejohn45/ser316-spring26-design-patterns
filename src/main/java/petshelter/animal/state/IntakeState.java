package petshelter.animal.state;

import petshelter.animal.Animal;
import petshelter.adoption.Adopter;

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

}
