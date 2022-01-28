Bill Sendewicz

November 9, 2021

### Pre-lecture HW:

Two arguments for event storming:

1. Allows everyone on the team--from the most key people to more tangentially-related people--to contribute to the event storming session, so in that way it's very democratic. 

2. Allows the team to uncover any and all events that are relevant to the system. 

Two arguments against event storming:

1. Can be a very chaotic process (and a waste of sticky notes).

2. May not be efficient since people can go down rabbit holes or present suggestions that aren't super relevant, such as my Bootup Screen Started event from the in-class event storming session on Nov. 2, or a classmate's suggestion about DDoS attacks.

Two examples of event storming (one you like, and one you dislike) and state why.

1. I liked the Roave event storming discussion because it was controlled--with only three people or thereabouts--yet informative. I feel like I understood the various events in a hotel booking system at a detailed level after watching that video. Link: https://www.youtube.com/watch?v=xIB_VQVVWKk

2. I liked Alberto Brandolini's talk less because it didn't explain what event storming _is_ as well as I would have liked. It was aimed at people who were alread familiar with event storming and seemed like his suggested recipe for how to do it. I would have appreciated more background about the process before he dove into the how-to aspect.


### Notes for Group Breakout Session

Notes for Group Number 1

Moderator: Jonas

Note-Taker: Bill/Matin Manafov

Members: Daichi Ando, Iryna Halenok, Adil, Kamil Aliyev, Joanna

#### Opening Notes

We had a very sweet and warm discussion about event storming.

#### First Person Pro Notes

Event storming uses no diagrams, only words. And words are understood by everyone; Requires only
knowledge of the business and/or processes of the system.

#### Second Person Con Notes

Not applicable to tightly-coupled systems and best applicable for microservices where the
separation of concern is clear and visible.

#### Third Person Pro Notes

Event storming includes everybody on the team and doesn’t require any background
knowledge in the way that object, class, activity, etc. diagram requires

#### Fourth Person Con Notes

Design can get lost in a sea of post-it notes. Lots of sticky notes! Not environment-friendly
(but I got to take home the sticky notes from the last time I did it :D)
The moderator plays a crucial role in the process. This person needs to direct the team in
the needed direction, not to dive into the tech details. Gathering all events and grouping
them seems to be challenging.

#### Moderator Summary Notes

Event storming is fun but meant mainly for microservices and relatively small projects.
We had a really great discussion with eight people and it went smooth like clockwork.

#### Round 1 Person Challenge/Question Notes

Everyone speaks the language of diagrams but in event storming people use actual human languages that not everyone speaks. In other words, diagram-based methods are even more widely understood.

#### Round 1 Person Comment/Defense/Answer Notes

But diagrams also have “captions” in a certain language. Event storming can use the language
that the team and/or customer speaks.

#### Round 2 Person Challenge/Question Notes

To the con about event storming only being applicable to microservice-based architecture:
isn’t that pretty much how all applications are architected these days? In other words, who
actually builds monolithic apps these days?

#### Round 2 Person Comment/Defense/Answer Notes

We can never be sure that it’s all microservices these days. I don’t think monoliths will ever
go away. As such, the con will still hold that ES is not for everything (as with all other models
we have discussed:sweaty_smile:)


#### 2 Best For event storming

Point 1: There are no diagrams, only words. And words are understood by everyone;
Requires only knowledge of the business and/or processes of the system.

Point 2: Event storming includes everybody on the team and doesn’t require any specialized background knowledge in the way that object, class, activity, etc. diagrams require

#### 2 Best Against

Point 1: Everyone speaks diagrams but in event storming people use actual human languages
that not everyone speaks. In other words, diagram-based methods are even more widely
understood.

Point 2: Not applicable to tightly-coupled systems and best applicable for microservices
where the separation of concern is clear and visible.

### Jack Herrington YouTube video "5 Design Patterns Every Engineer Should Know" Reflection

#### Which patterns are presented?
1. Singleton
2. Facade
3. Bridge/adapter
4. Strategy
5. Observer

#### Pick your two favorites and why.

I liked the facade and observer patterns best because Herrington's short, simple discussion of them taught me so much. The facade pattern is really cool because there can be lots of complexity--almost like microservices and abstraction in OOP--under the hood of an application, but a user of that service or object does not need to be concerned with the internal components. However, careful planning must go into designing that application so that it isn't oversimplified and not very usable as a result. On the other end, it can't be over-verticalized, i.e., the use case of the application is so specific that it isn't applicable to any other use case.

The observer pattern was really eye-opening because it showed me how ubiquitous it is among all of the apps we use on a daily basis. 

#### Pick your two most interesting cons. Think of an example for how they could play out.

I wouldn't say any of the five are cons, just as I wouldn't characterize a hammer as more of a con than a screwdriver. They're both tools at the end of the day with specialized uses. Instead, I'd say that I understand the singleton case the least well since I've interacted with it the least. And the fact that we can only really point to the database driver or the list of all configuration settings for an application as an exampole of the singleton suggests that singleton pattern is the least used in the wild. I also didn't understand what Herrington said in the case of a database driver, that if it's patterned as a simpleton and the designers later decide that they need to undo that design choice, users cannot access it directly and it needs to be piped down to whomever the consumers are. So I would characterize the singleton as the most foreign of the five patterns he discusses.

I also didn't understand the strategy pattern very well either. I'll need to learn more about that one on my own time.

Another caveat he discusses about the observer pattern is that if it's overused, it can create nasty event loops that are very hard to debug. My head is swimming just thinking about how bad it could be.
