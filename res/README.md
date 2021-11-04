#README #
###Overview
The Project works on how a typical one on one fight game works. It is designed to add the level of randomization of
outcome that can be seen in real life scenario. We have taken inspiration and ideas from movies and games which revolve
and have been the talking point in one on one battles.

For our design we have considered a one on one battle between two players. The players get assigned their ability based
on the roll of dice. After that player is assigned a bag of gears chosen randomly from a bigger bag of equipment each 
impacting the traits of the player either positively or negatively. We have made sure that one fourth of the bag impacts 
negatively or has no effect on the traits.

Once the player gets the bag he has to use all the equipment unless he already is using it at max capacity. For example
Only one Headgear can be worn by one player, only one pair of footwear can be worn and a total of 10 units of belt can
be equipped irrespective of the size of belt. 

After the players are equipped they enter a bout and fight it out till the health of a player depletes to zero or there
is no change in health for 10 turns which will result in a draw. The user gets to choose for a rematch if he chooses to.

###Design

The design of the project consists mainly of two interfaces 
1. BasePlayer
2. AddonInterface

Base player Represents a player in the Battle. He has a name which is randomly assigned, Traits which are decided by 
rolling a die and can request for a weapon before fighting. Classes Player implements base player and class 
AddOns implements AddonInterface. AddOns is further extended by types of gears available at disposal i.e. Headgears,
FootWear, Belts, Potions. Swords is an enum with different types of swords which is assigned randomly and the weapon 
strength is determined by the traits combined with special weapons.


###How To Run

The program has an executable file(JAR). To run the file we need to run the following command in a terminal.

<code>
java -jar (path)/(filename).jar
</code>


Run  -- ExampleRun2.txt:
1. Welcome Message
2. Players fight a bout with no equipment and no gear.
3. Player Stats on creation(rolling the die).
4. Player Stats on equipping Gear.
5. Gear equipped by player listed in order.(top to bottom and alphabetically)
6. Who strikes first
7. Player stats after each strike by player
8. Verdict/Decision
9. Option for rematch


###Design/Model Changes
 After the first design meeting changes were made keeping the following points in mind.
1. Added testing and Source files in different packages.
2. Added Detailed comments for each public method.
3. Added Detailed tests for each Functionality.
4. Changed References to deep copies while returning references.
5. Used Exceptions to handle cases.

While implementing I have made changes to the design and added Hashmap to the list of data types used.


###Assumptions 
We have assumed that the user has no control on choosing equipment. We have also assumed that on choosing rematch the 
equipped gear stays and doesn't change. We have considered that after 10 strikes without a damage the match would end 
in a draw.
###Limitations
The assumptions we have made have their limitations which can be resolved when we consider user input and add more 
randomness with a wider range of equipment and weapons at disposal.
database. Apart from these the application doesn't consider the following limitations.
 * We cannot change equipment in the middle of the match.
 * We cannot choose our desired weapon/equipment.
 * We are forced to use all equipment.


###Citations
* https://www.geeksforgeeks.org/
* https://riptutorial.com/java
* https://java2blog.com/
* https://www.tutorialspoint.com/

These websites have been really helpful for learning and implementing new data types and functionalities in the prioject.
They have helped me to refine and redesign the project to best fit the requirment.