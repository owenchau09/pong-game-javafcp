README - Pong Game


Falcons
Authors: Owen Chau and Hayden Floyd
Date: 5/2/24
Revision: 01


You are playing “pong” (table tennis) against an unbeatable CPU, you are trying to get the highest score possible against it. The score is calculated from how many times you are successfully able to deflect the ball.


This game is a remix of the popular game “Pong”. It features play against a cpu or a multiplayer version that you can play with your friends. For the cpu version, your score is how many times you can successfully hit the ball with the paddle, and users can toggle between that and traditional mode against their friends.

Target User Profile: For anyone who wants to play games!


Instructions: 
1. Select whether you would like to play against a CPU or your friend
2. Let the user interface load, then use up and down arrow keys to move your paddle
3. Play until you or one person lose


Class List:
PongTest
* Setup window and executes Drawer
Drawer
* Runs the game 
Paddle
* Can move up and down 
* Checks collisions with ball
Ball
* Bounces across the screen and determines when a point is scored


Team Responsibility: 
Owen: Created algorithms for collisions, game mechanics, and cpu algorithm
Hayden: Created start screen, gui, 2-player game, and other graphics
Hayden To-Do List
- Scoreboard
Owen To-Do List
- Limit the y value for paddle so it doesnt go out of bounds




Known Bugs/Workarounds:


Key Learnings: Game is reliant on coordinate systems and simple vectors that change direction when bounced


Credit List:
Rainbow Lab - Scaling of Window and making variables scalable instead of a constant
AnimationDemo - setup of graphics and implementation of keylistener to code
Hayden Floydadd ur credits for the gui stuff