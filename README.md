# BrickBreaker
The Full Brick Breaker Experience + Extra Power-ups

This desktop app is designed to emulate the classic game of Brick Breaker with some added features (detailed below).

## What is Brick Breaker?
Brick Breaker is a game in which the player controls a bar at the bottom of the screen that can be moved horizontally. At the beginning of each round, a ball is launched from the bar and bounces off the walls and blocks, destroying some blocks in the process. The objective is to destroy all the breakable blocks. In many versions, there are also various power-ups that drop from the blocks once broken and can be picked up my the bar.

## Description

The UI is made using Java swing elements. It includes a title screen, a progression of 9 levels, an index of power-ups, a level-choosing menu, as well as a "secret" level, in which the user gets the option of playing with their favorite power-up.

### Level Progression (Start):
The player plays through 9 levels in chronological order. 


### Powerups
I added 10 power-ups that take the form of colored icons that drop from blocks when destroyed. A random power-up is generated upon destruction of a block.


### Blocks:
The player beats the level once all breakable blocks are destroyed. 

### How physics of the game work?
The ball moves a constant amount of pixels directed by the angle at which it is launched. To avoid the ball going faster when moving diagonally, the location updating function takes into account the normal pixels per update and uses a Pythagorean-esk method of calculating the changes in x and y. When the ball hits a wall, the x or y velocity is simply assigned to its opposite to account for a bounce, according to which wall (left, top, and right) it is touching. To bounce off blocks, the ball!!!!!HERE HERE HERE

The block/brick and bar objects are updated and repainted upon contact with the ball.

## How to use:

Upon starting the code, the user is brought to a title screen featuring three options. Upon clicking "Key", the user is brought to an index of power-ups and their associated colors. Upon clicking "Start", the user is brought to the first level in a progression of 9 levels. If they are able to beat all the levels without losing all of their lives, they are rewarded with a "YOU WIN" screen. If, at any point, the player loses all of their lives, they will be sent to a "GAME OVER" screen. Upon clicking "Choose Level", the user is brought to a level choosing screen where they can choose which level they want to play. This screen also includes a "secret level". If this is clicked, the user is brought to a power-up choosing screen, where the user may choose a power-up to start with when they begin the level.
