# 4th-year-2d-isometric-game
- Name: Kevin Barry
- Built using java 10

## Introduction
----------
The aim of the game is to collect all of the chests and proceed to the end point.
To collect a chest the user must enter the grid space and attack.
The end point is disabled untill all chests collected.

## Controls
----------
- Rotate player	: Arrow keys
- Action		: C (used to destroy chests and exit level)
- Move Player	: X

## Features
----------
- User can choose player sprite.
- User can enter player name.
- Pop up box appears when chest is collected.
- When Chest objects collected that instance is destroyed.
- Sounds activated when player collects chest, completes game or trys to leave level without collecting all chests.
- Players movement restricted to boundaries of game board.
- Only one tile for each type is saved in memory. Tiles are replicated by calling an instance.

## Design Patterns
----------
#### Factory Pattern: 
----------
Factory pattern is used twice to create both game objects and game tiles. This allows the the required object to be stated and returned.
The factory allows easy implementation for when the user decides what sprite to user for the player.

##### Singleton Patterns:
----------
To prevent the recreation of already made objects some classes are implemented as singletons.
Tile factory and sprite factory are singleton. 
Game view is also a singleton as only one game view is needed at any time.

#### Flyweight Objects:
----------
All game sprites have been implented as Extrinsic state flyweight objects. 
This allows one instance of a sprite to be created and reused many times in the game.
Only one object is created in memory.
An intrinsic state is applied in the factorys, by mapping images to keys in the factory.

#### Loading:
----------
All game sounds are loaded to memory at the start of the game and then called when needed.
Different sounds are saved as enum for easy reference.
This helps to save memory and increase the speed of the game as it doesnt need to reload the sound files everytime.
Game maps can be easily created by creating a matrix and stating the instance of the sprite desired.

#### Adjustments from original code:
----------
- All event actions are controlled by an EventManager.
- Image loading is all done in the ImageManager.
- Game properties are set in Properties class.
- Isometric co-ordinates are controlled by Isometric class.
- Resources are loaded using factory classes.
- ObjectSprite is a concrete abstract class that implements the SpriteInterface and is a parent class of sprite objects to allow each to have its own values.

#### Recommended improvements given more time
----------
-	Removing painting of objects from gameview. 
	I had initially created a Paintable class and interface that handled all painting of objects.
	This started giving issues when trying to implement flyweights, I removed this to this apply factory patterns with the aim of adapting it once everything else was working.

-	When writing the TileSprite class I added a isTrigger variable to allow for future expansion.
	I intended to use this to set more functions on a tile eg. cant walk on water, fire tile damages player etc.

-	Adding an emeny object. Using the factory pattern an enemey object is easily created.
	I have written the code to spawn a enemy but never implemented any actions.

-	Developing a state machine style structure to handle player state.

-	Additional game features such as level timer, scores and health status.
 
 