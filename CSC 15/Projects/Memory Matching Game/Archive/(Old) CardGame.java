import java.util.Scanner; 

public CardGame
{
	public static void main(String[] args)
	{
		//Instalizes the scanner to get input from the user.
		Scanner GetInput = new Scanner(System.in);
		//Displays the program instructions;
		displayInstructions();
		//Asks the player if they want to play;
		System.out.print("Do you want to play? (yes/no) ");
		//Gets input from user.
		String playOrNah = GetInput.nextLine();
		
		//If the user wants to play. Start the program.
		if(playOrNah.equalsIgnoreCase("yes"))
		{
			int[][] board = new int[rows][columns]
		
			for(int row = 0; row < board.length; row++)
			{
				for(int column= 0; column < board[i].length; column++)
				{
					board[rows][colums]= rows * columns;
				}
			}
		}
		//If the user doesn't want to play.
		else if(playOrNah.equalsIgnoreCase("no"))
		{
			System.out.println("Ok. I'll see you around.");
			System.exit(0);
		}
		//If the user wants to display the help documentation.
		else if(playOrNah.equalsIgnoreCase("help"))
		{
			displayHelpDocumentation();
		}
		//If something unexpected happens.
		else
		{
			System.out.println("Something went wrong. Please restart the program and try again.");
			System.out.println("Error code: 2")
		}
	}
	
	displayInstructions()
	{
		System.out.println("Error Code Documentation:\n---------------------------")
		System.out.println("Error code 0: Unknows error. Restart program and try again.");
		System.out.println("Error code 1: Unknows error. Restart program and try again.");		
		System.out.println("Error code 2: Unknows error. Restart program and try again.");
		System.exit(0);
	}
	displayHelpDocumentation()
	{
		
	}
}