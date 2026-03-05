# AI Tic-Tac-Toe (Java)

A console-based Tic-Tac-Toe game developed in Java where a human player competes against an AI opponent. 
The AI uses the Minimax algorithm to make optimal moves, making it very difficult to beat.

## Features
- Human vs AI gameplay
- AI uses Minimax algorithm for intelligent decisions
- Console-based user interface
- Win and draw detection
- Input validation for player moves

## Technologies Used
- Java
- Object-Oriented Programming
- Minimax Algorithm

## Project Structure

src/
 ├── TicTacToe2.java   // Handles board creation and win logic
 ├── AI.java          // Implements the Minimax algorithm for AI moves
 └── LaunchGame.java  // Main class to run the game

## How the Game Works
1. The human player plays with 'X'.
2. The AI plays with 'O'.
3. The player enters row and column positions (0–2).
4. The AI calculates the best move using the Minimax algorithm.
5. The game continues until a player wins or the board is full (draw).

## How to Run the Project
1. Clone or download this repository.
2. Open the project in Eclipse or any Java IDE.
3. Compile and run `LaunchGame.java`.

## Example Gameplay

-------------
|   |   |   |
-------------
|   | X |   |
-------------
|   |   |   |
-------------

AI places 'O' in the best possible position using the Minimax algorithm.

## Learning Outcomes
- Implemented Object-Oriented Programming concepts in Java
- Learned how the Minimax algorithm works in game AI
- Practiced problem-solving and game logic implementation

## Author
Ashwini GH
