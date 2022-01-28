Bill Sendewicz

October 26, 2021


### Pre-lecture HW:

For state charts:

Two pros, two cons and two examples: one that you like, one that you dislike--with reasons why. 

As everything is a little bit positively biased, also think about how easy it would be for you to integrate a run-able state chart into your favorite software system (and how you would do it).

#### State Charts:

Pros:

1. The behavior of a system is decoupled from the component itself.

2. All states of a system are explored, modeled and accounted for, which should eliminate unpredictable behavior and annoying edge cases.

Cons:

1. State charts for even a moderately complex system can become unwieldy very quickly.

2. They can introduce unnecessary abstraction that can interfere with actually building the software system. Imagine a software development shop with several large teams, and many high-revenue clients. Naturally a place like this will have lots of deadlines and pressure to complete and projects. Now imagine a hot shot product manager who loves modeling and decides to model an ecommerce site using state charts. This PM requires that everyone on his team build the software according to this extremely complex state chart. Some developers might find it useful, but some might find it unnecessary and overly complicated, leading to friction between the PM and some developers. In short, it can create more work and more opaqueness for certain developers who seek simplicity in the face of high-pressure projects.

Examples: 

1. I liked the example of a human's life on https://online.visual-paradigm.com/diagrams/tutorials/state-machine-diagram-tutorial/ because it was simple and compact, and the entire system could be gleaned from the diagram.

2. I did not like the example of an oven state chart because the diagram is already fairly complex for such a simple system. An oven is one of the simpler systems out there, so imagine the state chart of a fighter jet or personal computer--my tiny brain can't handle the complexity that would be embodied in the state charts of those objects. I had a hard time differentiating between an oven's states in my mind compared with the states shown on the state chart. In particular, the Set Time state that loops to itself confuses me.


#### Notes for Group Breakout Session



#### Model Checking

- Concepts: Model checking explores the state space to see if an error state is reachable, and produces counterexamples.

- Relation: How does this relate to state charts/state machines?

- Internals: What is really happening when checking a model?

- State explosion: What is it?


### Notes for Group Breakout Session

Moderator: Matin Manafov

Note-Taker: Ando Daichi 

Members: Adil Abdurrazakli, Bill, Kamil Aliyev

#### Opening Notes

We had a lively and scintillating discussion about state diagrams.

#### First Person Pro Notes

State diagrams allow you to draw a dynamic diagram compared to some other diagrams such as component diagrams which enable you to write only static diagrams.

#### Second Person Con Notes

Drawing state diagrams is very time-consuming and not so useful for developers to get how the system should be. It is better to start writing code without state diagrams.

#### Third Person Pro Notes

The behavior of a system is decoupled from the component itself, so we can focus only on the system’s behavior in the case of a complex system. That is, there is less complexity to worry about.

#### Fourth Person Con Notes

It is too complicated to use it in a large system. It is more error-prone.

#### Moderator Summary Notes

We all can agree that these diagrams are time-consuming to understand and use and most likely it is no use for developers, but it can be useful for researchers.	

#### Round 1 Person Challenge/Question Notes

Imagine a truly complex system like an ecomm site, the burden on the developers from having to use statecharts could stress them out. Basically, a statechart is a nice abstraction but would require more time and energy to implement than makes sense given the time and cost constraints of a real-world development project.

#### Round 1 Person Comment/Defense/Answer Notes

Everyone agrees. 

#### Round 2 Person Challenge/Question Notes

All of us were curious about who uses state charts in real life.

#### Round 2 Person Comment/Defense/Answer Notes

Someone who has enough time to draw and think will use it such as researchers. 

#### Round 3 Person Challenge/Question Notes

In the real world, these kinds of diagrams are almost impossible to implement because the cost of time for it is much more than its value.

#### Round 3 Person Comment/Defense/Answer Notes

Let’s look at the big companies that are doing huge projects with the very big business value behind them. They cannot use it because each minute they waste, they are losing millions.

#### Are state charts better than plain (and documented) code?

Not at all. 

They might be useful in certain cases, but plain, well-documented code is always useful.

#### Free discussion to find best points for and against

2 Best For

- Point 1: The behavior of a system is decoupled from the component itself, so we can focus only on the system’s behavior in the case of a complex system. That is, there is less complexity to worry about.

- Point 2: State diagrams allow you to draw a dynamic diagram compared to some other diagrams such as component diagrams which enable you to write only static diagrams.

2 Best Against

- Point 1: Imagine a truly complex system like an ecomm site, the burden on the developers from having to use statecharts could stress them out. Basically, a statechart is a nice abstraction but would require more time and energy to implement than makes sense given the time and cost constraints of a real-world development project.

- Point 2: In the real world, these kinds of diagrams are almost impossible to implement because the cost of time for it is much more than its value. Let’s look at the big companies that are doing huge projects with the very big business value behind them. They cannot use it because each minute they waste, they are losing millions.

#### My search results for model checking:

Model checking explores the state space to see if an error state is reachable. Model checking can also produce counterexamples.

In my mind, state explosion reminds me of callback hell in JavaScript: things can get out of hand quickly.
