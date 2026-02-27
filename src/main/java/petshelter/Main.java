package petshelter;

//imports
import petshelter.shelter.ShelterSimulation;

/**
 * Main class to run the pet shelter simulation
 */
public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Deliverable B: Pet Shelter Simulation starting...");
        // create and run the shelter simulation
        ShelterSimulation simulation = new ShelterSimulation(7);
        simulation.setUp();
        simulation.run();
    }
}
