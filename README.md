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

## Screencast Link and Pattern Explanation

- Screencast Link: https://youtu.be/eK3z25Vf5Y0
- Github link: https://github.com/bejohn45/ser316-spring26-design-patterns
- Factory pattern makes the creation of animals in a consistent way. Having an AnimalFactory lets it create animals and assign it a unique id.
- State pattern lets an object be allowed to do certain things based on it's current state. Each state is it's own class that allow the animal to move to another state with a specific action.

## Design Justification and Process Documentation

- Pattern Selection Rationale:
    - I chose Factory pattern, since it allowed the creation of animals to be consistent with all animals created the same way in the same place. I chose State pattern to go along with this, since it was easy to keep track of the lifecycle of an animal in the shelter, based on what state it was in.
    - Factory pattern solved the issue of Animal creation being consistent. State pattern solved the issue of having an animal be allowed to do certain things depending on which state it was in.
    - These were a good fit for my pet shelter, since animals in my shelter would need to be created with the same attributes and after creating they would be intaked with having to do a medical action of intake exam.

- Trade-off Analysis:
    - Instead of State pattern, I considered using Strategy pattern. 
    - The pros of State pattern are that it let me set what behaviors an animal was allowed to do in a state. It made transitions to another state easy. The pros of Strategy was that an animal can have a behavior object for care and even medical, to know what that animal can do. This would be beneficial if I wanted to do daily care more than twice a day like doing it different amounts of time everyday. The cons though are that for Strategy it is hard to have animal keep switching behaviors allowed.
    - I ultimately chose my patterns, because it made the most sense as my pet shelter will have a lot of animals be created and will need to store some sort of state.

- Design Evolution and Process:
    - For my initial design plan, I wanted to use Factory and State. I wanted to use Factory for making animals. I wanted State to model the lifecycle of an animal at the shelter.
    - As I implemented the system, I stuck to my design, but added things like having a random amount of animals between 0-3 arrive a day. I also added lists to track medical and care actions done on animals. As I worked on this, I found better ways to seperate the simulation logic from my pet shelter logic.
    - The most challenging aspects was implementing the State pattern while making sure animals were able to only do things intended for the state they are in.
    - If I could start over, I would have planned out what classes I wanted to have and make diagrams to plan out how the classes interact with one another. This would have made the implementation be a lot easier.

- Resources Used:
    - I used slides and google to get more information on what each design pattern was. Based on the example from our assignment document with using Factory and State, I thought that to be the best fit.

- Challenges Faced:
    - I had challenges with having states transition correctly. Initially I was trying to do this in my Animal.java class, but realized it was better to do this in the state classes.
    - I had challenges with trying to do care actions to all animals. I was intially trying to do it in the shelter simulation, but found it best to seperate the logic with shelter and have a shelter have the logic for that.



