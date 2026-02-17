# Pet Shelter Management System #

**Course:** SER 316

---

## Project Overview

This project is a pet shelter management system that simulates daily shelter operations, including intake, adoption matching, and animal status changes across a one-week cycle. The system models animals with core attributes (ID, species, age, health status) and tracks each animal's lifecycle state as it progresses through the shelter.


## Planned Design Patterns

I plan on using Factory Pattern and State Pattern. 
- Factory Pattern will be used to create animals in a consisteny way based on intake events (stray, surrender, transfer) and species type (dog, cat, etc.). This keeps creation logic centralized.
- State Pattern will be used to model the lifecycle of an animal at the pet shelter (intake, available, pending, adopted). This keeps status logic clear.


## Integration Strategy: 

The Factory Pattern and State Pattern will work together like this:
- Animals are created using the Factory Pattern
- Each animal is initialized in the INTAKE state
- As the simulation runs:
    - Animals move to AVAILABLE after intake processing
    - When matched with an adopter, they transition to PENDING
    - Once adoption is finalized, they transition to ADOPTED
- Each state controls what operations are allowed for the animal

## Requirements Focus

- Initial set up of animals in the pet shelter with basic attributes (ID, species, age, health status)
- New animal arrivals during simulation (stray, surrender, or transfer)
- Tracking animal lifecycle states (intake, available, pending adoption, adopted)
- Adopters with basic preferences (species and age range)
- Matching adopters to compatible animals and updating adoption status
- Simulation cycles showing daily updates and state transitions over time (one week)

## Concerns/Questions

- Keeping the simulation simple while still demonstrating both Factory and State patterns
- Making sure state transitions remain valid and do not allow illegal moves (e.g., adopting an already adopted animal)
- Determining how detailed the adopter matching logic should be while staying within scope
- Making sure console output clearly demonstrates how the design patterns are being used



