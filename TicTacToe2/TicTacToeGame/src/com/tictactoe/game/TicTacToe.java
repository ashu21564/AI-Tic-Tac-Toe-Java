package com.tictactoe.game;

public class TicTacToe {
	char[][] board;

    // Constructor
    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }

    // Initialize board with spaces
    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the board
    void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Place a mark (X or O) on the board
    void placeMark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            board[row][col] = mark;
        } else {
            System.out.println("Invalid position!");
        }
    }

    // Check column win
    boolean checkColumnWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    // Check row win
    boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    // Check diagonal win
    boolean checkDiagonalWin() {
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    // Check if anyone has won
    boolean checkWin() {
        return checkRowWin() || checkColumnWin() || checkDiagonalWin();
    }

    // Check if board is full (draw)
    boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}
