------------------------------------------------------------------------------Battleship--------------------------------------------------

This project us made using Java, java swing
to start the program open the project in an editor (intellij or eclipse)


In the battleship code there will be a player class. To create the two different players you create 2 different objects of them (player 1 and player 2)
The player class has its own battlegrid and each battlegrid has 2 different modes off battlegrid. One battlegrid with the ship locations and one battlegrid with what the enemy can see of your battlegrid

All actions goes to through the player class no matter if you play on the gui or the command line this is done because you can then create 2 players from the same code reducing duplicate code 



Each ship has its own boolean, so when placing the players ships the code loops in a while loop waiting for all booleans to become true (iscruiserPlaced)
Placing a ship requires 4 parameters (type : horisontal or vertical ship) (size : how long the ship is in battlegrid squares) (y cordinate it shall begin on) (x cordinate it shall begin on)
After the player has entered the data needed the program will check for input errors misspellings or illegal numbers 
After that the program will check for collition with alredy placed ships 
If both these checks are passed the ship will be placed on the battlegrid if it didnt pass the program will try to place the same ship again since the ships boolean dont become true untill its placed


After all ship booleans have become true for both players the player can choose either to play on the command line or on the gui by simply typing either gui or text 
To place the ships the command player.PlaceAllShips(); is called after all ships are placed the player refernce is passed either to gui or commandline


Gui
The gui is made of one Jframe and 2 panels titlepanel (it shows which players turn it is) and mainpanel were all the battlegrid tiles will be placed 
When its one players turn(player 1 )it loops trough the grid and fetches each tile character from the oponent. The player can the click on the tile to reveal whats under it by clicking the tile 
By clicking the tile the program checks if the tile was a boat or not and then updates what player1 can see on the enemys battlegrid. In the same process it switches to the other players turn and trigger the gui to repaint 
If the tile was a boat the player who owns the boat get 1- lives. Each time a tile is clicked the game checkes if any players has 0 life and when one player reaches zero the other player wins 


Commandline
The game will loop as long neither of the players has 0 lifes 
The players will the take turns write x and y cordinates to fire torpedos at the oponent. The input will go through the same CorrectInputCheck as when placing the ships since the parameters to check for are the same as for a 1 tile ship
Each loop will print out the players wiev of the oponents battle grid and update it after each torpedo fired (each torpedo also reduce enemy life if hit)
When one player reaches 0 lifes the game stops looping and prints game over and calculates winner depending on lives left