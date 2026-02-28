package petshelter.shelter;

//imports
import java.util.List;
import java.util.ArrayList;

import petshelter.shelter.PetShelter;
import petshelter.animal.Animal;
import petshelter.animal.AnimalManager;
import petshelter.animal.Size;
import petshelter.animal.IntakeType;
import petshelter.animal.state.IntakeState;
import petshelter.animal.state.AvailableState;
import petshelter.animal.state.PendingState;
import petshelter.animal.state.AdoptedState;
import petshelter.animal.HealthStatus;
import petshelter.action.MedicalAction;




/**
 * Represents simulation for pet shelter
 */
public class ShelterSimulation 
{
    private PetShelter petShelter;
    private int cycle;                      // current cycle of simulation
    private final int totalCycles;          // total cycles for simulation

    /**
     * Constructor for ShelterSimulation
     */
    public ShelterSimulation(int totalCycles) 
    {
        petShelter = new PetShelter();
        this.cycle = 1;
        this.totalCycles = totalCycles;
    }

    /**
     * Set up initial animals in shelter
     */
    public void setUp() 
    {
        petShelter.setUpAnimals();
    }

    /**
     * Run shelter simulation for total cycles
     */
    public void run() 
    {
        for (cycle = 1; cycle <= totalCycles; cycle++) 
        {
            System.out.println("\n-------------------- Day " + cycle + " --------------------\n");
            
            // generate random new animals (0-3) each cycle
            petShelter.generateRandomAnimals();     

            // print summary
            dailySummary();
            printAnimalsList();
        }
    }



    /**
     * Print daily summary of animal states in shelter
     */
    public void dailySummary()
    {
        int intake = 0;
        int available = 0;
        int pending = 0;
        int adopted = 0;

        // get list of animals and get counts of states
        List<Animal> animals = petShelter.getAnimalManager().getAnimals();
        for (Animal animal : animals)
        {
            switch (animal.getState())
            {
                case "INTAKE":
                    intake++;
                    break;
                case "AVAILABLE":
                    available++;
                    break;
                case "PENDING":
                    pending++;
                    break;
                case "ADOPTED":
                    adopted++;
                    break;
            }
        }
        // print summary
        System.out.println("\n----- Animals Daily Summary -----");
        System.out.println("\n Intake: " + intake);
        System.out.println("\n Available: " + available);
        System.out.println("\n Pending: " + pending);
        System.out.println("\n Adopted: " + adopted);
    }

    /**
     * Print list of animals in shelter
     */
    public void printAnimalsList()
    {
        List<Animal> animals = petShelter.getAnimalManager().getAnimals();
        System.out.println("\n ----- Animals List -----");
        for (Animal animal : animals)
        {
            System.out.println("\n ID: " + animal.getId() + " - " + animal.getIntakeType() + " - " + animal.getSpecies() + " - " + animal.getAge() + " - " + animal.getHealthStatus() + " - " + animal.getState());
        }
    }
}
