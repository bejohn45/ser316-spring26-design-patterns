package petshelter.adoption;

import petshelter.animal.Species;

/**
 * Adopter class representing a person interested in adopting a pet from the shelter
 */
public class Adopter 
{
    private Species preferredSpecies;       // preferred species for adoption 
    private String preferredSize;           // preferred size of the pet (e.g., small, medium, large)
    private int preferredAgeMin;            // minimum preferred age of the pet
    private int preferredAgeMax;            // maximum preferred age of the pet
    private String preferredTemperament;    // preferred temperament of the pet (e.g., calm, energetic, etc.)

    /**
     * Constructor for Adopter
     */
    public Adopter(Species preferredSpecies, String preferredSize, int preferredAgeMin, int preferredAgeMax, String preferredTemperament)
    {
        this.preferredSpecies = preferredSpecies;
        this.preferredSize = preferredSize;
        this.preferredAgeMin = preferredAgeMin;
        this.preferredAgeMax = preferredAgeMax;
        this.preferredTemperament = preferredTemperament;
    }

    /**
     * Getter for preferred species
     */
    public Species getPreferredSpecies()
    {
        return preferredSpecies;
    }

    /**
     * Getter for preferred size
     */
    public String getPreferredSize()
    {
        return preferredSize;
    }

    /**
     * Getter for preferred minimum age
     */
    public int getPreferredAgeMin()
    {
        return preferredAgeMin;
    }

    /**
     * Getter for preferred maximum age
     */
    public int getPreferredAgeMax()
    {
        return preferredAgeMax;
    }

    /**
     * Getter for preferred temperament
     */
    public String getPreferredTemperament()
    {
        return preferredTemperament;
    }
    
}
