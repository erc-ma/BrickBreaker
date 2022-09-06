# BrickBreaker
The Full Brick Breaker Experience + Extra Power-ups

This desktop app is designed to emulate the classic game of Brick Breaker with some added features (detailed below).

## What is Brick Breaker?
Brick Breaker is a game in which the player controls a bar at the bottom of the screen that can be moved horizontally. At the beginning of each round, a ball is launched from the bar and bounces off the walls, blocks, and bar, destroying some blocks in the process. The player is given 3 lives at the start of the round, but will lose one every time the ball hits the bottom of the screen without bouncing up from the bar. The objective is to destroy all the breakable blocks. In many versions, there are also various power-ups that drop from the blocks once broken and can be picked up my the bar.

## Description

This project is made up of 11 different classes. Driver contains the main function from which the program is run. It also builds the pre-made lay-outs for the levels. ColorPanel builds the graphics for the UI and the levels. The rest of the classes are objects used directly inside the game.

The UI is made using Java swing elements. It includes a title screen, a progression of 9 levels, an index of power-ups, a level-choosing menu, as well as a "secret" level, in which the user gets the option of playing with their favorite power-up.

### Blocks:
The Block class has 2 children: Brick and ConcreteBlock. Brick contains the private instance variable strength. There are 4 levels of strength, each corresponding to a different graphical texture. When hit by the ball, a Brick will lose one (or more) level of strength and update the texture to match to the corresponding strength. ConcreteBlocks are considered non-breakable Blocks; thus, they do not break when hit, nor do they update their textures.

### Bar:
The bar has 5 sections. Depending on where the ball strikes the bar, the ball will fly off in a different angle. The farther it strikes from the middle of the bar, the greater that angle will be from the y axis.

### Powerups:
I added 10 power-ups that take the form of colored sphere icons that drop from blocks when destroyed. A random power-up is generated upon destruction of a block. The Powerup object contatins private instance variable type that determines what the power-up does and what color it is. Here is a list of power-ups in the game:

Opposite bar:

  	 * Bar goes in opposite direction 
	 * Bar becomes longer
	 * Number of balls increase
	 * Ball's power doubles (breaks through 2 levels of strength when it hits a brick)
	 * Ball slows down
	 * Ball speeds up
	 * Bar shoots lasers (that breaks blocks) when press spacebar
	 * The bottom of the level is lined with ConcreteBlocks for 20 seconds
	 * Number of lives increases by one
	 * Bar catches ball, re-launch with spacebar


### How physics of the game work?
The ball moves a constant amount of pixels directed by the angle at which it is launched. To avoid the ball going faster when moving diagonally, the location updating function takes into account the normal pixels per update and uses a Pythagorean-esk method of calculating the changes in x and y. 

When the ball hits a wall, the x or y velocity is simply assigned to its opposite to account for a bounce, according to which wall (left, top, and right) it is touching. 

When the ball hits a block, it will trigger the bounce() method within that block. To determine the direction in which the ball hits the block (as that directly correlates with whether to change the x or y sign), I use a while loop that slowly increments towards the block from the last coordinates of the ball prior to it touching the block. Depending on the original signs of the x y trajectories of the ball, it will increment until on the edge of the block and determine from which plane the ball is closest to the brick. 

The block/brick and bar objects are updated and repainted upon contact with the ball.

## How to use:

Upon starting the code, the user is brought to a title screen featuring three options. Upon clicking "Key", the user is brought to an index of power-ups and their associated colors. Upon clicking "Start", the user is brought to the first level in a progression of 9 levels. If they are able to beat all the levels without losing all of their lives, they are rewarded with a "YOU WIN" screen. If, at any point, the player loses all of their lives, they will be sent to a "GAME OVER" screen. Upon clicking "Choose Level", the user is brought to a level choosing screen where they can choose which level they want to play. This screen also includes a "secret level". If this is clicked, the user is brought to a power-up choosing screen, where the user may choose a power-up to start with when they begin the level.

### Controls:
Spacebar = launch ball / fire lasers
Left/right keys = control bar
Left click = return to menu / go back
