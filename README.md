# Mancala Game

First of all to test this game, you should:

- Make sure you have installed gradle
- Clone the project 'git clone git@github.com:rabriol/mancala.git'
- Do de command line 'cd mancala'
- Do the gradle command line 'gradle clean build bootRun', wait to the server start

After having done the instructions above, you can play the game, so:

- Open a web browser and type localhost:8080/
- You should see a button called 'START', click on it.
- The Player 1 is always the first to start
- You should choose the cups of the board based on index like [0, 1, 2, 3, 4, 5]
- When is Player 1 turn, you should see the board like:

Player 2: [5, 4, 3, 2, 1, 0] - board index
Player 1: [0, 1, 2, 3, 4, 5] - board index

That means Player 1 is seing his board against Player 2.

When is Player 2 turn you should see the opposite:

Player 1: [5, 4, 3, 2, 1, 0] - board index
Player 2: [0, 1, 2, 3, 4, 5] - board index

That means Player 2 is seing his board against Player 1.
