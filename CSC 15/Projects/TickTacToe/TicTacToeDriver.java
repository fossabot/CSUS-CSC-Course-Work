//@author Marc Woodyard
/********************************************************************************************************
*Program Name: TicTackToe Program                                                                       *
*Description: Plays TickTacToe with two players.											            *
*Author: Marc Woodyard                                                                                  *
*Class: CSC-15 TuTh 12:00pm                                                                             *
*Teacher: Gita Faroughi                                                                                 *
*********************************************************************************************************/
import java.util.*;

public class TicTacToeDriver {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String playAgain;
		String player1;
		String player2;
		String temp = "NaH";
		do {
			//Get player info.
			System.out.print("What is the Name of the player who will play X's? ");
			player1 = kb.nextLine();
			do {
				System.out.print("What is the Name of the player who will play O's? ");
				player2 = kb.nextLine();
				if(player1.equals(player2))
					System.out.println("Player name taken, please try agian.");
			} while(player1.equals(player2));

			//Create two new player objects.
			TicTacToe players = new TicTacToe(player1, player2);
			
			//Play the game.
			for(int i = 1; i <= 9; i++) {
				//Player 1's turn.
				players.playerX(kb);
					if(players.isWinner(player1) == true)
						break;
				//Player 2's turn.
				players.playerO(kb);
				if(players.isWinner(player2) == true)
					break;
				//Game is a draw.
				if(i == 9)
					System.out.println("Draw. Nobody wins.");
			}
			
			//Are we going to play another game?
			System.out.print("\nDo you want to play again? (Y/N) ");
			playAgain = kb.nextLine();
			temp = TicTacToe.playAgain(playAgain, kb);
		} while(temp.equalsIgnoreCase("y"));
		System.out.println("Thank-you for playing Tic Tac Toe.\nHAVE A NICE DAY!");
	}
}
