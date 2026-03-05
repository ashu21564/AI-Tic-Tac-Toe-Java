package com.tictactoe.game;

public class AI {
	char aiMark;    // AI is 'O'
    char humanMark; // Human is 'X'

    // Constructor
    public AI(char aiMark, char humanMark) {
        this.aiMark    = aiMark;
        this.humanMark = humanMark;
    }

    // --- Minimax Algorithm ---
    // isMaximizing = true  means it's AI's turn  (wants highest score)
    // isMaximizing = false means it's Human's turn (wants lowest score)
    int minimax(TicTacToe game, boolean isMaximizing) {

        // Check terminal states
        if (game.checkWin()) {
            // If AI just won → +10, if Human just won → -10
            return isMaximizing ? -10 : 10;
        }
        if (game.isBoardFull()) {
            return 0; // Draw
        }

        if (isMaximizing) {
            // AI's turn — try to maximize score
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game.board[i][j] == ' ') {
                        game.board[i][j] = aiMark;         // Try move
                        int score = minimax(game, false);  // Recurse
                        game.board[i][j] = ' ';            // Undo move
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;

        } else {
            // Human's turn — try to minimize score
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game.board[i][j] == ' ') {
                        game.board[i][j] = humanMark;      // Try move
                        int score = minimax(game, true);   // Recurse
                        game.board[i][j] = ' ';            // Undo move
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }

    // Find the best move for AI
    int[] getBestMove(TicTacToe game) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.board[i][j] == ' ') {
                    game.board[i][j] = aiMark;              // Try move
                    int score = minimax(game, false);       // Get score
                    game.board[i][j] = ' ';                 // Undo move

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove; // Returns [row, col]
    }

}

