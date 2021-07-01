package com.bridgelabz.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	private static final char empty = ' ';
	private char[] board;

	TicTacToeGame() {
		board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = empty;
		}
	}

	public static void main(String[] args) {
		System.out.println("welcome to TicTacToe game");

		TicTacToeGame game = new TicTacToeGame();
		 game.TicTacToeGame();
	}
}
