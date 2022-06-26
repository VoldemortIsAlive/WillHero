# WillHero
Clone/Adapation of the popular game [WILL HERO](https://play.google.com/store/apps/details?id=com.zplay.willhero&hl=en_IN&gl=US) develeoped ZPlay games available on google playstore, the game was developed as part of the course CSE231 (Advanced Programming) using Java and JavaFX.

**Game summary:**
The Hero jumps between  islands where he encounters enemies known as Orcs and some obstacles. The main objective of this was to make the Hero manoeuvre through these
islands and defeat the Boss. Boss is also an Orc, although with more power and of a bigger size. The Hero can kill Orcs either by pushing them into the abyss or by killing them using some weapons. the Hero can find treasure chests that could give him some weapon or some coins that the Hero has to collect. The player loses the game if the Hero falls into the abyss or fails to defeat the Boss.

**Features and description**:

The game starts with an intro scene wherein a single click leads to starting of a new game. The first scene has options to play,pause or to open settings pane
Load Game - to select from your saved games (if any) and resume gameplay.
Pause game - Pauses your current game without losing any access to your current progress
End game Screen - Gives option to player whether to play again or not.

**Design and implementation:**
Screens are displayed through Scene Builder which are stored as FXML files.
Abstract class: Common Animation serves as an Abstract Class and generates different types of animations.
Interfaces: Serializable and deserializable for saving and loading the game
Threading: Threads are added to move the objects through the scene such that it does not result in deadlocks resulting further in wrong results.
Design Pattern: Singleton - Player , Iterator - To iterate through data.


1. Loading screen
<img width="508" alt="image" src="https://user-images.githubusercontent.com/88495622/175826671-581976d6-ee94-4f50-b45c-d9c99f3e02b7.png">

2. GamePlay
<img width="500" alt="image" src="https://user-images.githubusercontent.com/88495622/175826643-00816cfd-bbf6-4b2c-8efd-cc3a2ed97739.png">

3. Ingame play
<img width="442" alt="image" src="https://user-images.githubusercontent.com/88495622/175827097-562df5d8-7208-4703-8e02-fea8f37b15d0.png">

4. Game over screen
<img width="525" alt="image" src="https://user-images.githubusercontent.com/88495622/175827034-9a70a0e5-ba79-4788-8cf2-82d5e64fbb64.png">





UML Diagram:

<img width="806" alt="image" src="https://user-images.githubusercontent.com/88495622/175826176-327cd7d6-ad5b-4ac9-8d5b-0268874724c2.png">

Use Case Diagram:

<img width="716" alt="image" src="https://user-images.githubusercontent.com/88495622/175826274-9ca7fb8e-06f4-4d80-9577-e160251c37e8.png">


