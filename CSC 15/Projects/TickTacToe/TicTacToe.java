//@author Marc Woodyard
/********************************************************************************************************
*Program Name: TicTackToe Program                                                                       *
*Description: Plays TickTacToe with two players.											            *
*Author: Marc Woodyard                                                                                  *
*Class: CSC-15 TuTh 12:00pm                                                                             *
*Teacher: Gita Faroughi                                                                                 *
*********************************************************************************************************/
//package ticTacToeGame;
import java.util.*; 

public class TicTacToe
{
	//Instance Variables
	private String playerX;
	private String playerO;
	private String[] board = new String[10];
   
	//Constructor
	public TicTacToe(String playerX, String playerO) {
		  this.playerX = playerX;
		  this.playerO = playerO;
		  initializeBoard();
	}

	//Set the board values.
	private void initializeBoard() {
		 for(int i = 1; i < board.length; i++) {
			 board[i] = Integer.toString(i);
		 }
	}
	
	//Controls player 1's turn.
	public void playerX(Scanner kb) {
		takeATurn(kb, "playerX", this.playerX);
	}
	
	//Controls player 2's turn.
	public void playerO(Scanner kb) {
		takeATurn(kb, "playerO", this.playerO);
	}
	
	//Print the board to the console.
	private void displayBoard () {
		for(int i = 1; i < board.length; i++) {
			System.out.print(board[i] + " | ");
			if(i == 3 || i == 6)
				System.out.println("\n------------");
		}
	}
	
	//Gets user's move.
	private void takeATurn(Scanner kb, String currentPlayer, String playerName) {
		boolean validMove;
		int userMove;
		do {
			displayBoard();
			System.out.print("\n" + playerName + ", where would you like to play? ");
			String rawUserMove = kb.nextLine();
			validMove = validMove(rawUserMove);
			if(validMove == false)
				System.out.println("is not a valid move.");
			userMove = Integer.valueOf(rawUserMove);
		} while(validMove == false);
		if(playerName.equals(playerX))
			board[userMove] = "X";
		else if(playerName.equals(playerO))
			board[userMove] = "O";
		if(isWinner(playerName) == true) {
			displayBoard();
			displayResults(playerName);
		}
	}
	
	//Check if user entered a valid move.
	private boolean validMove(String move) {
		boolean result = false;
		int userMove = 0;
		switch (move) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				userMove = Integer.valueOf(move);
				result = true;
				break;
			default:
				result = false;
				break;
		}
		if(board[userMove] == "X" || board[userMove] == "O")
			result = false;
		return result;
	}
  
	//Check if a user has three in a row.
	public boolean isWinner(String player) {
		boolean result = false;
		for(int  i = 1; i <= 3; i++) {
			//Check for horizontal Xs or Os in a row.
			if(i == 1)
				result = horizontalWinner(player);
			//Check for horizontal Xs or Os in a row.
			else if(i == 2)
				result = verticalWinner(player);
			//Check for diagonal Xs or Os in a row.
			else if(i == 3)
				result = diagonalWinner(player);
			if(result == true)
				break;
		}
		return result;
	}
	
	//Check for horizontal Xs or Os in a row.
	private boolean horizontalWinner(String player) {
		String symbol = "NaH";
		boolean result = false;
		if(player == this.playerX)
			symbol = "X";
		else if(player == this.playerO)
			symbol = "O";
		if(board[1].equalsIgnoreCase(symbol) && board[2].equalsIgnoreCase(symbol) && board[3].equalsIgnoreCase(symbol))
			result = true;
		else if(board[4].equalsIgnoreCase(symbol) && board[5].equalsIgnoreCase(symbol) && board[6].equalsIgnoreCase(symbol))
			result = true;
		else if(board[7].equalsIgnoreCase(symbol) && board[8].equalsIgnoreCase(symbol) && board[9].equalsIgnoreCase(symbol))
			result = true;
		return result;
	}
	
	//Check for horizontal Xs or Os in a row.
	private boolean verticalWinner(String player) {
		String symbol = "NaH";
		boolean result = false;
		if(player == this.playerX)
			symbol = "X";
		else if(player == this.playerO)
			symbol = "O";
		if(board[1].equalsIgnoreCase(symbol) && board[4].equalsIgnoreCase(symbol) && board[7].equalsIgnoreCase(symbol))
			result = true;
		else if(board[2].equalsIgnoreCase(symbol) && board[5].equalsIgnoreCase(symbol) && board[8].equalsIgnoreCase(symbol))
			result = true;
		else if(board[3].equalsIgnoreCase(symbol) && board[6].equalsIgnoreCase(symbol) && board[9].equalsIgnoreCase(symbol))
			result = true;
		return result;
	}
	
	//Check for diagonal Xs or Os in a row.
	private boolean diagonalWinner(String player) {
		String symbol = "NaH";
		boolean result = false;
		if(player == this.playerX)
			symbol = "X";
		else if(player == this.playerO)
			symbol = "O";
		if(board[1].equalsIgnoreCase(symbol) && board[5].equalsIgnoreCase(symbol) && board[9].equalsIgnoreCase(symbol))
			result = true;
		else if(board[3].equalsIgnoreCase(symbol) && board[5].equalsIgnoreCase(symbol) && board[7].equalsIgnoreCase(symbol))
			result = true;
		return result;
	}

	//Display the game results.
	private void displayResults(String playerName) {
		System.out.println("\nCONGRATULATIONS " + playerName + ", YOU WON!");
	}
	
	//Asks the user if they want to play again.
	public static String playAgain(String answer, Scanner kb) {
		do {
			if(!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
				System.out.println("That's not a valid answer. Please try again.");
				System.out.print("Do you want to play again? (Y/N) ");
				answer = kb.nextLine();
			}
		} while(!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")));
		return answer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}