import java.util.scanner;

public class bookDatabase extends verifyValidImput
{
	Scanner GetInput = new Scanner(System.in);
	String whichDatabase = "Nothing yet :(";
	String bookTitle = "Nothing yet :(";
	String submitAnother = "No";
	String nonFiction[] = [10];
	String fiction[] = [10];

	public static void main(string[] args)
	{
		System.out.println("Is your book fiction or non-fiction? (Fiction/Non-Fiction)");
		String whichDatabase = GetInput.nextLine();
		verifyValidImput(whichDatabase);
		if(whichDatabase.equalsIgnoreCase("fiction"))
		{
			do
			{
				System.out.println("Enter the book's title: ");
				do
				{
					String bookTitle = GetInput.nextLine();
					verifyValidImput(bookTitle);
					if(verifyValidImput = false)
					{
						System.out.println("Looks like you enter some text we don't understand, please enter your book again.");
					}
				}
				while(verifyValidImput = false);
				System.out.println("Thanks! Your book has been recorded. Would you like to submit another book? (Yes/No): ");
				String submitAnother = GetInput.nextLine();
				verifyValidImput(submitAnother);
				//Just cleaning up here a little bit.
				bookTitle = "Nothing yet :(";
			}
			while(submitAnother.equalsIgnoreCase("yes"));
			System.out.println("Ok. Thank you for imputing your book(s). See ya later.");
		}
		else if(whichDatabase.equalsIgnoreCase = "non-fiction")
		{
			do
			{
				System.out.println("Enter the book's title: ");
				do
				{
					String bookTitle = GetInput.nextLine();
					verifyValidImput(bookTitle);
					if(verifyValidImput = false)
					{
						System.out.println("Looks like you enter some text we don't understand, please enter your book again.")
					}
				}
				while(verifyValidImput = false);
				System.out.println("Thanks! Your book has been recorded. Would you like to submit another book? (Yes/No): ");
				String submitAnother = GetInput.nextLine();
				verifyValidImput(submitAnother);
				//Just cleaning up here a little bit.
				bookTitle = "Nothing yet :(";
			}
			while(submitAnother.equalsIgnoreCase("yes"));
			System.out.println("Ok. Thank you for imputing your book(s). See ya later.");
		}
		else if(whichDatabase.equalsIgnoreCase("help"))
		{
			//Fill in support documention.
			System.out.println("For more information, please visit Support.Company.com.\n\nThanks :D");
		}
		else
		{
			System.out.println("Looks like an error ocured when we were deciding if your book was fiction or non-fiction. Please contacct 
				your local system administrator.\nProgram terminating...");
			System.exit(0);
		}

	}

}