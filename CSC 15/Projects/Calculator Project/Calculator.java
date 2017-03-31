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
  
        //Verifys that InputNumber1 is a double.
        try
        {
            //Is InputNumber1 a double?
            Double.parseDouble(InputNumber1);
        }
        catch(NumberFormatException NotADouble)
        {
            //Not a double error code.
            System.out.println("You did not enter a valid number. Please check your input and try again\nError code: 0");
            //Exits the program.
            System.exit(0);
        }
        

        //Convet string InputNumber1 to a double.
        double Number1 = Double.parseDouble(InputNumber1);

        //Instalize a scanner to get an operator from the user.
        Scanner GetOperator = new Scanner(System.in);
        //Displays the instuctions "Enter an operator:" for the user.
        System.out.print("Enter an operator: ");
        //Get the operator from the user. 
        String Operator = GetOperator.next();

        try
        {
            //Is InputNumber1 a double?
            Operator.matches("([+,-,*,/,%]{1})");
        }
        catch(NumberFormatException NotAOperator)
        {
            //Not a double error code.
            System.out.println("You did not enter a valid number. Please check your input and try again\nError code: 35");
            //Exits the program.
            System.exit(0);
        }
        
        //Displays the instuctions "Enter your second number:" for the user.
        System.out.print("Enter your second number: ");
        //Get the second number from the user.
        String InputNumber2 = GetInput.nextLine();
        
        try
        {
            //Is InputNumber2 a double?
            Double.parseDouble(InputNumber2);
        }
        catch(NumberFormatException NotADouble)
        {
            //Not a double error code. 
            System.out.println("You did not enter a valid number. Please check your input and try again\nError code: 1");
            //Exits the program.
            System.exit(0);
        }
        //Convet string InputNumber2 to a double.
        double Number2 = Double.parseDouble(InputNumber2);
        
        //Switch conditions based on the input from the GetOperator variable.
        switch (Operator)  
        {
            //Subtractions case.
            case "-":
                System.out.print(Number1);
                System.out.print(" - ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + (Number1 - Number2));
                System.out.println("");
                break;
            //Addition case.
            case "+":
                System.out.print(Number1);
                System.out.print(" + ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + (Number1 + Number2));
                System.out.println("");
                break;
            //Divison case.
            case "/":
                System.out.print(Number1);
                System.out.print(" / ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + (Number1 / Number2));
                System.out.println("");
                break;
            //Multiplication case.
            case "*":
                System.out.print(Number1);
                System.out.print(" * ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your asnwer is " + (Number1 * Number2));
                System.out.println("");
                break;
            //Modulus case.    
            case"%":
                System.out.print(Number1);
                System.out.print(" % ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your asnwer is " + (Number1 % Number2));
                System.out.println("");
                break;
            //Square Root case.    
            case"^":
                System.out.print(Number1);
                System.out.print(" ^ ");
                System.out.print(Number2);
                System.out.print(" =\n");
                System.out.println("Your answer is " + Math.pow ( Number1,Number2 ));
                System.out.println("");
                break;
            //If the input doesn't math any of the cases above, then display an error message.    
            default:
                System.out.println("You did not enter a valid operator. Please check your input and try again. \n Error code: 2");
                break;

        }
        
        
    /*    
        switch (ConvertToText)  
        {
            case "1":
                System.out.print("One");
                break;
    
            case "2":
                System.out.print("Two");
                break;
    
            case "3":
                System.out.print("Three");
                break;
    
            case "4":
                System.out.print("Four");
                break;
                
            case"5":
                System.out.print("Five");
                break;
                
            case"6":
                System.out.print("Six");
                break;
             
            case"7":
                System.out.print("Seven");
                break;
            case"8":
                System.out.print("Eight");
                break;
            case""
            default:
                System.out.println("You did not enter a valid operator. Please check your input and try again. \n Error code: 0");
                break;

        }
        */
        
        
    }
    
    public static void description()
	{
		//Displays instructions when the program starts.
	    System.out.println("");
		System.out.println("Instructions:");
		System.out.println("-------------------------------");
		System.out.println("Please only enter numbers 0-9.");
		System.out.println("The operations can only be +, -, *, /, ^, %.");
		System.out.println("Press the \"enter\" key to submit your input numbers.");

		//System.out.println("");
		//System.out.println("Type \"help\" (without the qoutes) for more detailed instructions.");
		
		System.out.println("-------------------------------");
	    System.out.println("");
	}
	
	public static void DisplayHelpDocumentation()
	{
	    System.out.println("Need some help?");
	}
	
}

