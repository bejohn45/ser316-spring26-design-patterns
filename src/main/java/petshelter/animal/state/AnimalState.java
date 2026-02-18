package petshelter.animal.state;

import petshelter.animal.Animal;
import petshelter.adoption.Adopter;

/**
 * State interface for Animal lifecycle states (e.g., intake, available, pending, adopted)
 */
public interface AnimalState 
{
    /**
     * Get the name of the current state of the animal
     */
    String getStateName();


    void setState(Animal animal, AnimalState newState)
    {
        //
    }

    /**
     * Process the intake of the animal
     */
    void processIntake(Animal animal);

    /**
     * Perform medical action on the animal (e.g., intake exam or vaccination)
     */
    void performMedical(Animal animal, MedicalAction medicalAction);

    /**
     * Perform care action on the animal (e.g., feeding, cleaning, exercise, socialization)
     */
    void performCare(Animal animal, CareAction careAction);

    /**
     * Request adoption for the animal
     */
    void requestAdoption(Animal animal, Adopter adopter);

    /**
     * Complete the adoption process for the animal
     */
    void completeAdoption(Animal animal);

}
