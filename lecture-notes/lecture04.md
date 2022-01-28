Bill Sendewicz

September 28, 2021


### Pre-lecture HW:

For both use case diagrams and personas:

Two pros, two cons and two examples (one that you like, one that you dislike--with reasons why) for each of the two new concepts (therefore, a total of four pro, four con, four examples).

#### Use cases:

Pros:

1. Written in natural language, so they're easy to understand and they convey a high-level view of the system quickly.

2. Can be used in an agile manner, which allows the designer to create only the most important use cases and prioritize them in the backlog, along with just-in-time and just-enough development. Contrast this with creating the entire universe of use case diagrams in a waterfall methodology.

Cons:

1. A designer/architect must create use case diagrams for each type of actor that interacts with the system. If the number of actors is large (or there is overlap with the different types of actors), the designer/architect must create many similar diagrams that may repeat information.

2. The distinction between business use cases and ordinary use cases can be hazy.

Examples: 

1. I liked the ATM use case example because I understood everything about the system in less than two seconds.

2. I disliked the Document Management System and Broadcasting System examples because they were less clear than the ATM case, and I thought they could have included more details, actions and users depicted in the system.

#### Personas:

Pros:

1. User personas add concreteness to a model of a system.

2. Can unite developers, product designers/architects, copywriters and product managers in serving the needs of users and keep everyone on the same path of the product or service's lifecycle.

Cons:

1. User personas are only as good as the research done to support them, meaning that if more time and energy is put into user research and analytics, the user personas will more accurately reflect a product's users. This could clash with just-in-time development and a minimum viable product approach and force designers/architects/entrepreneurs into analysis paralysis. 

2. People's initial assumptions and estimates are rarely correct. There are countless cases of a product or service that was designed for one target audience, but that target audience never adopted the product/service and a completely different demographic became the core user base. It's hard to know who the most important  users will be, and user personas require knowing (or pretending to know) who the users will be. This can also fly in the face of an MVP approach. 

Examples: 

1. I don't like the Narrative example. It can always go deeper, so one never knows when enough is enough or when more details are needed.

2. I like the Quick-and-Dirty approach because it's more nimble and agile than the Narrative approach: get enough of starting plan in place and then iteratively decide who the core users are and which direction to take the product/service.



#### Class Diagram Example: 

What do you like?
1. Most relevant classes are captured, which models the scenario well in my opinion.
2. There is no irrelevant or superfluous information, classes or attributes in this diagram.

What is curious?
1. Money is an integer, not a float
2. There are no methods whatsoever
3. Withdrawal shouldn't be its own class; it should be a method as well as an attribute (withdrawalAmount)
4. I'm a bit confused about why the designers chose to give the Money class cardinality of n

Ulno's highlights:
1. Look at inheritance first. Is there a design pattern that would justify that? The white arrow says that the withdrawal class is a type of a transaction (inherits from Transaction class). Maybe should be a boolean instead.
2. Follows UML, no glaring design errors ***come back to this***
3. Use camelCase (Java) instead of Pythonic snake_case
4. The Client and ATM cardinality relationship might be off; can have several clients ***come back, watch lecture video
5. Several cards can access an ATM machine, so Card to ATM shouldn't be 1:1
6. Client and Bank Account only connected via an ATM and a transaction. Maybe a Bank class is needed too.


#### Class Diagram vs. Domain Model:

- What do you think is the advantage of “Domain Modeling” vs. Class and Object modeling?
    - Domain modeling can capture more parts/concepts/elements of the phenomenon that you're trying to model than just class and object modeling, because it is more open-ended and less restrictive than the latter two, which have very rigid rules.


- What could be confusing here and lead to bad design?
    - Because domain modeling is more open-ended and less restrictive, it can allow more complexity than is needed to enter the model, making it more cluttered and busy. This can obfuscate the meaning we're trying to convey with the model and confuse the audience.


### Notes for Group Breakout Session

Moderator: Joanna Mae Cabuyadao

Note-Taker: Daichi Ando

Team Members: Bill Sendewicz, Matin Manafov

#### Opening Notes

We introduced each other in the classroom and quickly decided each other's roles.

#### First Person Pro Notes:

Use cases are indivisible. They are the smallest element in the model.

#### Second Person Con Notes

You can have multiple personas for one use case. They’re not 1:1

#### Third Person Pro Notes

Persona gives the background behind the system modeling such as what is the motivation of the person.

#### Fourth Person Con Notes

Persona is very restrictive. One persona cannot be used in other use cases. 

#### Moderator Summary Notes

We are a peaceful group. We didn’t need that many rounds of fighting. Kumbaya :)

#### Round 1 Person Challenge/Question Notes

Joanna argued that their restrictiveness allows them to show the specific need but not look further away from that. So it is faster to architect the modeling. 

#### Round 1 Person Comment/Defense/Answer Notes

Bill counters that it is still a disadvantage because the persona needs to be the smallest element so it is very hard to narrow it down. It is confusing how to narrow down the massive spectrum of users to one specific persona. 

#### Round 2 Person Challenge/Question Notes

If we create the personas all the time, it takes too much time. Although the class diagram has inheritance so the system architecture is much more organized and easier to draw. 

#### Round 2 Person Comment/Defense/Answer Notes

We all agreed that was right.

#### Round 3 Person Challenge/Question Notes

Matin: I think that multiple personas for one use case is rather a pro than a con, because in this case we can see all possible roles in one use case and how they interact.

#### Round 3 Person Comment/Defense/Answer Notes


2 Best For: 

- Use cases are indivisible. They are the smallest element in the model. 
- Persona gives the background behind the system modeling such as what is the motivation of the person.

2 Best Against: 

- You can have multiple personas for one use case. They’re not 1:1. 
- If we create the personas all the time, it takes too much time. Inheritance in class diagrams allows for minimizing repetition.

#### Fulib

- What was the most unexpected feature you saw me implementing and why?
    - The amount of code Fulib generating was unexpected but very cool.

- What was the hardest part to follow and why?
    - The object diagrams became busy and complex rather quickly. They're also hard to read in the tiny window on Fulib.
    - The syntax in the Scenario window seemed to have a very specific structure and not exactly how I would phrase things in natural language.

#### Umple

- What was the most unexpected feature you saw me implementing and why?
    - That class diagrams can be produced from a drag-and-drop interface, which will then create sample code.

- What was the hardest part to follow and why?
    - The demo was less than two minutes long, and it was at the tail end of class when our brains were already saturated, so we didn't get the fullest sense of how the software works.
    - How some of the less common features work. One can figure out how the software works on a very high level from watching a demo < 2 minutes long and from playing around on the site, but it looks like edge cases or complex systems will be quite difficult to model with Umple.
