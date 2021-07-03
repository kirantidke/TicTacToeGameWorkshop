package com.bridgelabz.tictactoegame;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static final char EMPTY = ' ';
	private static final char CROSS = 'X';
	private static final char ROUND = 'O';

	private char playerSymbol;
	private char computerSymbol;
	private char[] board;

	TicTacToeGame() {
		board = new char[10];
		Arrays.fill(board, EMPTY);

	}

	private static int getIndex(int row, int col) {
		return 3 * (row - 1) + (col - 1);
	}

	public void choosePlayerSymbol(char playerSymbol) {
		if (playerSymbol == CROSS) {
			this.playerSymbol = CROSS;
			this.computerSymbol = ROUND;
		} else if (playerSymbol == ROUND) {
			this.playerSymbol = ROUND;
			this.computerSymbol = CROSS;
		} else
			System.out.println("Invalid Symbol");
	}

	public char getPlayerSymbol() {
		return playerSymbol;
	}

	private boolean isFree(int row, int col) {
		if (row > 3 || row < 1 || col > 3 || col < 1)
			System.out.println("Invalid position!");

		if (board[getIndex(row, col)] == EMPTY)
			return true;
		return false;
	}

	private boolean isFree(int position) {
		if (position < 1 || position > 9)
			System.out.println("Invalid position!");
		if (board[position - 1] == EMPTY)
			return true;
		return false;
	}

	public void playerMove(int row, int col) {
		if (row > 3 || row < 1 || col > 3 || col < 1) {
			System.out.println("Invalid move!");
			return;
			
		}

		if (isFree(row, col)) {
			board[getIndex(row, col)] = playerSymbol;
			System.out.println("After player move");
			showBoard();
		} else
			System.out.println("Illegal move!");

	}

	public void playerMove(int position) {
		if (position < 1 || position > 9) {
			System.out.println("Invalid move!");
			return;
		}

		if (isFree(position)) {
			board[position - 1] = playerSymbol;
			System.out.println("After player move");
			showBoard();
		} else
			System.out.println("Illegal move!");
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
				System.out.println("---------");
		}
	}
	/**
	 * Toss to select who plays first
	*/ 
	private void toss() {
		int tossResult = (int) Math.floor(Math.random() * 10) % 2;
		if (tossResult == 1)
			System.out.println("User plays first");
		else {
			System.out.println("Computer plays first");
		}
	}
	
	public int winningPosition(char symbol) {
		// horizontal
		if (board[getIndex(1, 1)] == symbol && board[getIndex(1, 2)] == symbol && board[getIndex(1, 3)] == symbol)
			return 1;
		if (board[getIndex(2, 1)] == symbol && board[getIndex(2, 2)] == symbol && board[getIndex(2, 3)] == symbol)
			return 2;
		if (board[getIndex(3, 1)] == symbol && board[getIndex(3, 2)] == symbol && board[getIndex(3, 3)] == symbol)
			return 3;

		// vertical
		if (board[getIndex(1, 1)] == symbol && board[getIndex(2, 1)] == symbol && board[getIndex(3, 1)] == symbol)
			return 4;
		if (board[getIndex(1, 2)] == symbol && board[getIndex(2, 2)] == symbol && board[getIndex(3, 2)] == symbol)
			return 5;
		if (board[getIndex(1, 3)] == symbol && board[getIndex(2, 3)] == symbol && board[getIndex(3, 3)] == symbol)
			return 6;

		// diagonal
		if (board[getIndex(1, 1)] == symbol && board[getIndex(2, 2)] == symbol && board[getIndex(3, 3)] == symbol)
			return 7;

		// off diagonal
		if (board[getIndex(1, 3)] == symbol && board[getIndex(2, 2)] == symbol && board[getIndex(3, 1)] == symbol)
			return 8;

		return 0;

	}


	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a symbol (X or O): ");
		String symbol = sc.next();
		game.choosePlayerSymbol(symbol.charAt(0));
		System.out.println("Player has chosen: " + game.getPlayerSymbol());
		System.out.println("initial:");
		game.showBoard();
		game.playerMove(1);
		game.playerMove(5);
		game.playerMove(9);
		
		System.out.println("Winning Position of player"+game.winningPosition(game.getPlayerSymbol()));
		sc.close();
	}
}