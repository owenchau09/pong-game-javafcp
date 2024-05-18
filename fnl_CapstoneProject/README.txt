README - Pong Game


Falcons
Authors: Owen Chau and Hayden Floyd
Date: 5/17/24
Revision: 04


You are playing “pong” (table tennis) against a CPU with 4 difficulty levels from easy to difficult (with a ‘random’ difficulty) and you are trying to get the highest score possible against it. The score is calculated from how many times you are successfully able to get the ball past the paddle without the paddle hitting it.


This game is a remix of the popular game “Pong”. It features play against a cpu or a multiplayer version that you can play with your friends. There is also a variation where there are 4 paddles on the screen that can be controlled.

Target User Profile: For anyone who wants to play games and have fun!


Instructions: 
1. Select whether you would like to play against a CPU or your friend
2. Select difficulty and let the user interface load, then use up and down arrow keys to move your paddle
3. Play and enjoy!


Class List:
PongTest
* Setup window and executes Drawer
Drawer
* Runs the game 
Paddle
* Can move up and down 
* Checks collisions with ball
Side Paddle
* Extends Paddle by adding paddles on the top and bottom of the screen
Ball
* Bounces across the screen and determines when a point is scored


Team Responsibility: 
Owen: Created algorithms for collisions, game mechanics, and cpu algorithm
Hayden: Created start screen, gui, 2-player game, 4 paddle modifier, and other graphics




Known Bugs/Workarounds: When running the program, a blank green screen may pop-up. If this occurs, close the window and run again


Key Learnings: Game is reliant on coordinate systems and simple vectors that change direction when bounced


Credit List:
Rainbow Lab - Scaling of Window and making variables scalable instead of a constant
AnimationDemo - setup of graphics and implementation of keylistener to code
Snackbar - jbuttons and actionevents
GoogleBooksAPI - actionevents for buttons
Timer - constantly updating the jframe