package petshelter.shelter;

//imports
import java.util.List;
import java.util.ArrayList;

import petshelter.shelter.PetShelter;


/**
 * Represents simulation for pet shelter
 */
public class ShelterSimulation 
{
    private PetShelter petShelter;
    private int cycle;
    private final int totalCycles;

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

    public void run() 
    {
        System.out.println("Running shelter simulation...");
    }
}
