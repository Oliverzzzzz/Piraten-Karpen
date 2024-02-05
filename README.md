# A1 - Piraten Karpen

  * Author: < Oliver Zhao >
  * Email: < zhaoc59@mcmaster.ca >

## Build and Execution    
* *** WARNINGGGG: PLEASE DO NOT COPY PASTE THE COMMANDS INSTEAD TYPE THEM OUT, I NOTICED THE COMMANDS DO NOT RUN CORRECTLY WHEN I COPY PASTE THEM.***


  * To clean your working directory:
    * mvn clean
  * To compile the project:
    * mvn compile
  * To run the project without TRACE mode (player1) vs (player2) :  (choose strategies for player 1 then 2 ex: "random combo") random for player 1 and combo for player 2
    * mvn exec:java -D exec.args="random combo"
  * To run the project in TRACE mode (player1) vs (player2) :  (choose strategies for player 1 then 2 ex: "random combo") random for  * * player 1 and combo for player 2
    * mvn exec:java -D exec.args="random combo" -D TRACE
 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Quick overview of the classes
* Scoring class: Controls the scoring methods such as counting the gold and diamonds
* Strategy class: Holds the functions that return if a player should reroll (and if yes how many dice) or not to reroll               (random strategies and combo strategies)
* Dice class: Holds the functions that allow rerolling (different types of rerolling) of dice and tracking of dice faces.
* Player class: Holds the data structures,variables, methods that are related to a player (array of dice, hashmap that tracks faces in dice...)
* Playturn class: Holds the functions that simulate the logic of one turn of a game (split into combo logic, or random logic).
* Game class: Holds the functions that simulate the logic of one game (uses the turns and the score to keep track)
* Card class: The structure of one card
* Card deck: The mechanisms of a card deck and a stack that holds the cards in it

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < when all conditions a feature are satisfied and ready for the user to be used>



### Fixed Backlog 

* | MVP? | Id  | Feature                                                       | Status   |  Started  | Delivered |
* | :-:  |:-:  |---                                                            | :-:      | :-:       | :-:       |
* | YES  | F01 | Roll a dice                                                   |  D       |  16/01/23 | 16/01/23  |
* | YES  | F02 | Roll eight dices                                              |  D       |  16/01/23 | 16/01/23  |
* | YES  | F03 | Receive 100 score per gold or diamond                         |  D       |  16/01/23 | 16/01/23  |
* | YES  | F04 | Reroll feature                                                |  D       |  17/01/23 | 17/01/23  |
* | YES  | F05 | Player pick # of dice to reroll or to end turn(strategy)      |  D       |  17/01/23 | 17/01/23  |
* | YES  | F06 | Show total score (Win once player reaches 6000)               |  D       |  18/01/23 | 18/01/23  |
* | YES  | F07 | Play 42 games and calculate percentage win of each            |  D       |  18/01/23 | 18/01/23  |
* | NO   | F08 | Add logging user can see wins and rolls                       |  D       |  21/01/23 | 21/01/23  |
* | NO   | F09 | Add group scoring in the game                                 |  D       |  24/01/23 | 24/01/23  |
* | NO   | F10 | Reroll smarter dice feature (don't reroll gold and diamond)   |  D       |  24/01/23 | 24/01/23  |
* | NO   | F11 | Combo strategy where player should prioritize combos          |  D       |  24/01/23 | 25/01/23  |
* | NO   | F12 | Combo strategy accessible from command line                   |  D       |  25/01/23 | 25/01/23  |
* | NO   | F13 | Make a functioning card and card deck                         |  D       |  26/01/23 | 26/01/23  |
* | NO   | F14 | Add pirate card and pirate card strategy to be used           |  D       |  27/01/23 | 27/01/23  |
* | NO   | F15 | Add a Monkey Business card to be used                         |  D       |  28/01/23 | 28/01/23  |





