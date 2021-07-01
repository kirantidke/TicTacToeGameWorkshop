package com.bridgelabz.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	private static final char empty = ' ';
	private static final char cross = 'X';
	private static final char round = 'O';
	private static char playerSymbol;
	private static char computerSymbol;

	private char[] board;

	TicTacToeGame() {
		board = new char[10];
		for (int i = 0; i < board.length; i++)
			this.board[i] = empty;
	}

	private static int getIndex(int row, int col) {
		return 3 * (row - 1) + (col - 1);
	}

	public void choosePlayerSymbol(char playerSymbol) {
		if (playerSymbol == cross) {
			this.playerSymbol = cross;
			this.computerSymbol = cross;
		} else if (playerSymbol == round) {
			this.playerSymbol = round;
			this.computerSymbol = cross;
		} else
			System.out.println("Invalid Symbol");
	}

	public char getPlayerSymbol() {
		return playerSymbol;
	}

	public void showBoard() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 3)
					System.out.print(board[getIndex(i, j)]);
				else
					System.out.print(board[getIndex(i, j)] + " | ");

			}
			System.out.println("");
			if (i != 3)
				System.out.println("-------------------");
		}
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a symbol (X or O): ");
		String symbol = sc.next();
		game.choosePlayerSymbol(symbol.charAt(0));
		System.out.println("Player has chosen: " + game.getPlayerSymbol());

		System.out.println("Game Board is: ");

		game.showBoard();
	}
}
