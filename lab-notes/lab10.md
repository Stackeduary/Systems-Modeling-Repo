Bill Sendewicz

November 9, 2021

## Lab 10 notes

Link to the group work is [here](lab-challenges/lab10/README.md).

### Main responsibilities

### Notes from Software Stories Guide paper

A **software story** consists of a number of steps. 

A **step** describes a concrete situation and actions executed in that situation; 

also describes when this step has been (or will be) executed and who participated in this step or who executed it.

Each step should have a

- name
- time and date
- location

as well as 

- some actors that participate in the step
- some picture or bullet list outlining the content of the step
- some example data showing what information is processed and produced in this step

Each Story Step should provide a time and date when this example step has been executed or will be executed. 

The first purpose of the example execution time is to help the people developing the Software Story to focus on the example level.

It is not "The 'Register Thesis' dialog is opened by somebody". Instead, it is "On July 28th at 10:42 AM, Albert, Daniel and Marcel". 

We experienced that forcing domain experts and other Software Story developers to start with a concrete point in time helps them enormously to stick to a concrete example and avoid going to a more abstract rule level description.

Concrete times and dates help to deal with parallel and concurrent actvities. 

At the rule level, concurrency issues require a lot of careful design of

- when a certain activity might be executed
- which other activities need to be completed first, and 
- which set of activities might be mutual exclusive. 

In a concrete example, it is much easier to specify just when the activity is executed in this example. One may choose similar dates for two activities done by different actors in a single Software Story in order to give a hint that these two activities are independent from each other. 

One may also choose a sequence of points in time for a number of Story Steps in order to emphasize that the involved Story Steps trigger each other. 

One may also indicate that some Story Step happens, say, several days later as another department or another organization is responsible for it and information has to be sent around and the issue may need to wait before it is scheduled. 

In general, timing and concurrency issues are complicated topics that need sound analysis. However, in early requirements engineering where domain experts are involved, it is hardly possible to address such issues in detail. Thus, in our experience, domain experts as well as software engineers can do a reasonable job in detailing concurrency issues just by providing timestamps for Story Steps.

The location where a Story Step is executed again helps the Software Story developers to focus on a concrete example. It also gives an idea of the kind of infrastructure you might expect for the execution of such a step.

Each Story Step should provide the actors that are involved in its execution. To focus on the concrete example we use individual names to refer to the involved actors and we also use individual icons for each of them. These different Actors represent different roles or different
kinds of users. These roles may be given as a second name or an a second name line like Albert Prof, Daniel Student or Tina Student Service. We frequently provide the role of an actor on its first occurence in our Software Story and omit it later on.

Different people doing the same job my execute it differently. The same user role in the same process may function quite differently depending on the concrete person doing it. One might argue that such cases indicate missing process standardization and strictness. However, even with good standardization, in practice, different people do the same job differently. Thus, processes and the accompanying tools need to deal with different personalities and need to be flexibly adaptable to such issues. During requirements engineering this means that when developing a Software Story, knowing the concrete person who is doing a certain step will greatly facilitate describing that step. It is much easier to describe how Tina handles the submission of Daniel's Thesis than to describe how some Student Service representative handles the submission of some student. It's the software developer's job to generalize from the concrete example to the rule level later on.

If an active piece of software is involved in a Story step, it should be represented as an actor with some icon--such as its logo or a robot, computer, cashier or hardware icon--representing it.

The main content of a Story Step is some kind of slide that outlines what is going on in this step.
This outline may contain any pictures, drawings or bullet items. This content is mainly read by humans and helps domain experts and software engineers get an idea of what this step entails.

Another important part of the main Story Step content is the depiction of example data, which helps the software engineers to derive a data model for the desired software. Software engineers will most likely use some UML class diagrams to specify that data model for later implementation. While such class diagrams are very valuable for the software engineers and developers, domain experts usually do not understand class diagrams very well and they will not be able to spot faults in the class diagram design. Thus class diagrams will not help to clarify details and to resolve misunderstandings. Example data shown to the domain experts in a familiar way does a much better job. Then deriving the formal data model is easy for the software engineers to do in a later step. In our experience, example data contained in Software Stories is the most valuable part of a software story and thus we strongly suggest that Software Stories should always
contain a lot of example data. Example data also helps you to find the right level of abstraction for your Software Story. In our experience, as soon as you are able to give example data, you have reached the right level of abstraction.

Usecase diagrams may be used during requirments engineering to group and complement Software Stories and to give a general overview of the requirements. 

Usecase diagrams may help to structure the whole system while Software Stories explain the usecases in more detail. Thus, usecases will help to structure the whole software development process and to group system functionality and to prioritize software development tasks. A thorough analysis of alternative scenarios may result in a larger number of Software Stories for a given System. 

Following the ideas of Story Driven Modeling, Software Stories should be turned into automatic tests using a tool like JUnit. These Story tests serve two main purposes. First, a Story Step ensures that the described functionality is implemented and working for the example scenarios. Secondly, the Story tests help to ensure consistency across multiple related Software Stories. Without such a consistency check, multiple Software Stories may easily contradict each other on how a certain step is done and why a certain decision is made and which example data is used and stored in a certain step. By turning Software Stories into JUnit tests, software engineers will identify such inconsistencies and may revisit the domain experts to resolve such issues. Once you have achieved a consistent set of JUnit tests for your Software Stories, these JUnit tests ensure the consistency and completeness of all your requirements. 

Your final system will need more tests than just the Story tests. You may also need a thorough system design using, for example, component, deployment and class diagrams. When designing algorithms, you may again use Software Stories or Storyboards for more fine-grained internal analysis. 

#### I would like to see the following two suggestions from the Stories Guide paper in our user stories:

1. Specific dates, times and locations
2. Example data displayed
