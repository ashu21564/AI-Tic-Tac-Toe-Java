package com.tictactoe.game;
import java.util.Scanner;
public class LaunchGame {

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
        AI ai          = new AI('O', 'X');
        Scanner sc     = new Scanner(System.in);

        System.out.println("=============================");
        System.out.println("   Welcome to Tic-Tac-Toe!  ");
        System.out.println("   You = X  |  AI = O       ");
        System.out.println("=============================");

        game.displayBoard();

        while (true) {

            // ---- Human Turn (X) ----
            System.out.println("Your turn! Enter row (0-2) and column (0-2):");

            int row = -1, col = -1;
            boolean validInput = false;

            while (!validInput) {
                row = sc.nextInt();
                col = sc.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Out of bounds! Enter row and column between 0 and 2:");
                } else if (game.board[row][col] != ' ') {
                    System.out.println("Cell already taken! Try another:");
                } else {
                    validInput = true;
                }
            }

            game.placeMark(row, col, 'X');
            game.displayBoard();

            // Check if human won
            if (game.checkWin()) {
                System.out.println("Congratulations! You win!");
                break;
            }

            // Check draw after human move
            if (game.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            // ---- AI Turn (O) ----
            System.out.println("AI is thinking...");
            int[] bestMove = ai.getBestMove(game);
            game.placeMark(bestMove[0], bestMove[1], 'O');

            System.out.println("AI placed O at row " + bestMove[0] + ", column " + bestMove[1]);
            game.displayBoard();

            // Check if AI won
            if (game.checkWin()) {
                System.out.println("AI wins! Better luck next time.");
                break;
            }

            // Check draw after AI move
            if (game.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
        }

        sc.close();

	}

}


