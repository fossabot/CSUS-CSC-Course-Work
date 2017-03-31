import java.util.scanner;

public class programSearch
{

	//Instalize scanner.
	kb new = System.in();
	String numberOrAnimal = "Nothing yet :(";
	String userInput = "Nothing yet :(";
	int numberArray[] = {53,67,2,3123,453432,321};
	String animalArrary[] = {dog, cat, pig, cow, bird, fish, fox, ferret, wolf};

	public static void main(String[] args)
	{
		//Get and verify the user's data.
		System.out.println("Would you like to search the number database or the animal database? (Number/Animal");
		String numberOrAnimal = kb System.in();
		if(numberOrAnimal.equalsIgnoreCase("number"))
		{
			System.out.println("Search: ");
			String userInput = kb System.in();
			verifyValidImput(userInput);
			for(int i = 0; i < numberArray.length; i++)
			{
				if(numberArray[i] == userInput);
				{
					//If so, return the result and exit the program.
					System.out.println("We found a match! You were searching for " + userInput + " ,and we found it.")
					System.out.println("Here is your data: " + numberArray[i] + " was located in block" i + " in the number database.");
					//Well... we found the data and return it to our user, so lets exit the program.
					System.exit(0);
				}
				else
				{
					//If not, then keep searching.
				}
			}
		}
		else if(numberOrAnimal.equalsIgnoreCase("animal"))
		{
			System.out.println("Search: ");
			String userInput = kb System.in();
			verifyValidImput(userInput);
			for(int i = 0; i < animalArrary.length; i++)
			{
				if(animalArrary[i] == userInput);
				{
					//If so, return the result and exit the program.
					System.out.println("We found a match! You were searching for " + userInput + " ,and we found it.")
					System.out.println("Here is your data: " + animalArrary[i] + " was was located in block " + i + " in the animal database.");
					//Well... we found the data and return it to our user, so lets exit the program.
					System.exit(0);
				}
				else
				{
					//If not, then keep searching.
				}
			}
		}
		else if(numberOrAnimal.equalsIgnoreCase("Nothing yet :("))
		{
			System.out.println("Looks like \"numberOrAnimal\" is set to \"Nothing yet :(\"");
		}
		else
		{
			System.out.println("Looks like we encountered an unknown error. Please review the debug information below./nProgram terminating...");
			System.out.println("Debug Information:\n------------------");
			System.out.println("numberOrAnimal: " + numberOrAnimal);
			System.out.println("userInput: " + userInput);

			//Terminate the program.
			System.exit(0);
		}
	}

	public static void verifyValidImput (String x)
	{

		if(x.contiansIgnoreCase("1,2,3,4,5,6,7,8,9,0,a,b,c,d,e,f,g
								h,i,j,k,l,m,n,o.p,q,r,s,t,u,v,w,x,y,z"))
		{
			//Contians valid imput. Nothing to see here...Carry on.
		}
		else
		{
			//Terminate the program with an error message.
			System.out.println("Looks like you enter invalid input.\nProgram terminating...");
			System.exit(0);
		}
	}
}