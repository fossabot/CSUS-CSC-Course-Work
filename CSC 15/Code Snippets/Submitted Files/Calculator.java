/*
 ________  ________  ________                  _____  ________                                              
|\   ____\|\   ____\|\   ____\                / __  \|\   ____\                                             
\ \  \___|\ \  \___|\ \  \___|  ____________ |\/_|\  \ \  \___|_                                            
 \ \  \    \ \_____  \ \  \    |\____________\|/ \ \  \ \_____  \                                           
  \ \  \____\|____|\  \ \  \___\|____________|    \ \  \|____|\  \                                          
   \ \_______\____\_\  \ \_______\                 \ \__\____\_\  \                                         
    \|_______|\_________\|_______|                  \|__|\_________\                                        
             \|_________|                               \|_________|                                        
                                                                                                            
                                                                                                            
 ________  ________  ________        ___  _______   ________ _________                            _____     
|\   __  \|\   __  \|\   __  \      |\  \|\  ___ \ |\   ____\\___   ___\                         / __  \    
\ \  \_\  \ \  \_\  \ \  \\\  \     \ \  \ \   __/ \ \  \___\|___ \  \_|      ____________      |\/_|\  \   
 \ \   ____\ \   _  _\ \  \\\  \  __ \ \  \ \  \   _\ \  \       \ \  \      |\____________\    \|/ \ \  \  
  \ \  \___|\ \  \\  \\ \  \\\  \|\  \\_\  \ \  \_|\ \ \  \____   \ \  \     \|____________|         \ \  \ 
   \ \__\    \ \__\\ _\\ \_______\ \________\ \_______\ \_______\  \ \__\                             \ \__\
    \|__|     \|__|\|__|\|_______|\|________|\|_______|\|_______|   \|__|                              \|__|                                                                                                           
*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculator {

    public static void main(String[] args) 
    {
        
        //Displays header text when the program starts.  
        System.out.println("");
	    System.out.println("Microsoft Calculator Express [Version 3.7.59216]");
	    System.out.println("(c) Microsoft Corporation. All rights reserved.");
	    System.out.println("");
        
        //Intalize the scanner & console to get input fron the user.
        Scanner GetInput = new Scanner(System.in);
        //Display the calculator instructions.
        description();
        //Displays the instuctions "Enter your first number:" for the user.
        System.out.print("Enter your first number: ");
        //Get the first input from the user.
        String InputNumber1 = GetInput.nextLine();
        /*Create a for loop that will prompt the user to enter a valid
        number 500 times, or display the help documentation.*/
        
        for (int counter = 0; counter < 500; counter++)
        {
            if(InputNumber1.matches("help"))
            {
                DisplayHelpDocumentation();
                counter = 500;
                System.exit(0);
            }
            else
            {
                try
                {
                    //Is InputNumber1 a double? If so, convert to string.
                    Double.parseDouble(InputNumber1);
                }       
                catch(NumberFormatException NotADouble)
                {
                    //Not a double error code.
                    System.out.println("You did not enter a valid number. Please check your input and try again\nError code: 0");
                    //Exits the program.
                    //System.exit(0);
                }
            }
        }

        //Convet string InputNumber1 to a double.
        double Number1 = Double.parseDouble(InputNumber1);

        //Instalize a scanner to get an operator from the user.
        Scanner GetOperator = new Scanner(System.in);
        //Displays the instuctions "Enter an operator:" for the user.
        System.out.print("Enter an operator: ");
        //Get the operator from the user. 
        String Operator = GetOperator.next();
        
        for (int counter = 0; counter < 500; counter++)
        {
            if(Operator.matches("help"))
            {
                DisplayHelpDocumentation();
                counter = 500;
                System.exit(0);
            }
            else if (Operator.matches("([+,-,*,/,%]{1})"))
            {
                counter = 500;
            }
            else
            {
            //Not a double error code.
            System.out.println("You did not enter a valid operator. Please check your input and try again\nError code: 1");
            //Exits the program.
            System.exit(0);
            }
        }

        //Displays the instuctions "Enter your second number:" for the user.
        System.out.print("Enter your second number: ");
        //Get the second number from the user.
        String InputNumber2 = GetInput.nextLine();
        
        for (int counter = 0; counter < 500; counter++)
        {
            if(InputNumber2.matches("help"))
            {
                DisplayHelpDocumentation();
                counter = 500;
                System.exit(0);
            }
            else
            {
                try
                {
                    //Is InputNumber1 a double?
                    Double.parseDouble(InputNumber2);
                }       
                catch(NumberFormatException NotADouble)
                {
                    //Not a double error code.
                    System.out.println("You did not enter a valid number. Please check your input and try again\nError code: 2");
                    //Exits the program.
                    //System.exit(0);
                }
            }
        }
        //Convet string InputNumber2 to a double.
        double Number2 = Double.parseDouble(InputNumber2);
        
        //Switch conditions based on the input from the GetOperator variable.
        switch (Operator)  
        {
            //Subtractions case.
            case "-":
                System.out.println("***************************************");
                System.out.print(Number1);
                System.out.print(" - ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + (Number1 - Number2));
                System.out.println("***************************************");
                System.out.println("");
                break;
            //Addition case.
            case "+":
                System.out.println("***************************************");
                System.out.print(Number1);
                System.out.print(" + ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + (Number1 + Number2));
                System.out.println("***************************************");
                System.out.println("");
                break;
            //Divison case.
            case "/":
                System.out.println("***************************************");
                System.out.print(Number1);
                System.out.print(" / ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + (Number1 / Number2));
                System.out.println("***************************************");
                System.out.println("");
                break;
            //Multiplication case.
            case "*":
                System.out.println("***************************************");
                System.out.print(Number1);
                System.out.print(" * ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your asnwer is " + (Number1 * Number2));
                System.out.println("***************************************");
                System.out.println("");
                break;
            //Modulus case.    
            case"%":
                System.out.println("***************************************");
                System.out.print(Number1);
                System.out.print(" % ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your asnwer is " + (Number1 % Number2));
                System.out.println("***************************************");
                System.out.println("");
                break;
            //Exponents case.    
            case"^":
                System.out.println("***************************************");
                System.out.print(Number1);
                System.out.print(" ^ ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + Math.pow ( Number1,Number2 ));
                System.out.println("***************************************");
                System.out.println("");
                break;
            //If the input doesn't math any of the cases above, then display an error message.    
            default:
                System.out.println("You did not enter a valid operator. Please check your input and try again. \n Error code: 2");
                break;
        }
        
    }

    public static void description()
	{
		//Displays instructions when the program starts.
		System.out.println("\nInstructions:");
		System.out.println("-------------------------------");
		System.out.println("Please only enter numbers 0-9.");
		System.out.println("The operations can only be +, -, *, /, ^, %.");
		System.out.println("Press the \"enter\" key to submit your input numbers.\n");

		System.out.println("Type \"help\" (without the qoutes) for more detailed instructions.");
		System.out.println("-------------------------------\n");
	}
	
	public static void DisplayHelpDocumentation()
	{
	    System.out.println("\nNeed some help?");
	    System.out.println("-------------------");
	    System.out.println("The first prompt that will be displayed will prompt you to enter a number.");
	    System.out.println("For example, you can enter 1, 2, 3, 42, 45.7, 3.14, all the way to 1.7976931348623157 x 10^308.");
	    System.out.println("To submit your answer, hit the \"enter\" key on your keyboard.");
	    System.out.println("The second prompt will ask you to enter an operator.");
	    System.out.println("Some possible values include -, +, /, *, %, ^. Please refer to the table below for furthur explanation.");
	    System.out.println("The last prompt will ask you to enter in your second number, which is the same as I said before.");
	    System.out.println("\"For example, you can enter 1, 2, 3, 42, 45.7, 3.14, all the way to 1.7976931348623157 x 10^308.\"");
	    System.out.println("And once you hit \"enter\", this program will calculate your answer, \"spared no expense.\"");
	    System.out.println("I think there's a movie refference in there somewhere. But as promised, here's the table.\n");
	    
	    System.out.println("Operators:\n---------------------------------------------");
	    System.out.println("Addition = +");
	    System.out.println("Subtraction = -");
	    System.out.println("Multiplication = *");
	    System.out.println("Division = /");
	    System.out.println("Modulus = %");
	    System.out.println("Exponents = ^\n");
	    
	    System.out.println("Error Codes:\n---------------------------------------------");
	    System.out.println("Error code 0: Issue with first number.");
	    System.out.println("Error code 1: Issue with operator.");
	    System.out.println("Error code 2: Issue with second number.\n");

	    
	    System.out.println("And as alaways, have a nice day!\n");
	    System.out.println("-Marc Woodyard");
	    System.out.println("https://marcwoodyard.com\n");
	}
	
}