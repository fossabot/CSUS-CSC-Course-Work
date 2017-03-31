/********************************************************************************************************
*Program Name: Credit Card Verification Program                                                         *
*Description: Checks if a credit card is valid, and tells the user what type of credit card it is.      *
*Author: Marc Woodyard                                                                                  *
*Class: CSC-15 TuTh 12:00pm                                                                             *
*Teacher: Gita Faroughi                                                                                 *
*                                                                                                       *
*Notes:                                                                                                 *
*--------                                                                                               *       
*My output was different than what was on the instructions.                                             *
*53999907134818                                                                                         *
*----------------                                                                                       *
*What the instructions said: Not valid too short.                                                       *
*My output: Not valid, can't match credit card provider. Not too short because it 14 digits long.       *
*                                                                                                       *
*372357384805028                                                                                        *
*----------------                                                                                       *
*What the instructions said: Valid American Express card number.                                        *
*My output: Valid Master card because it starts with 37 and it is 15 digits long.                       *
*For it to be a Master card number it has to start with 51 or 55 and be between 16-19 digits long.      *
*********************************************************************************************************/
import java.util.*;

public class CreditCardValidator {
    public static void main(String[] args) 
    {
        Scanner kb = new Scanner(System.in);
        String programControl = "y";
        description();
        do
        {
            long creditCardNumber;
            System.out.print("\nEnter a credit card number: "); 
            
            //Check input validation
            while(!kb.hasNextLong()) {
                System.out.println("That's not a valid credit card number. Please try again.");
                System.out.print("\nEnter a credit card number: "); 
                kb.next();
            }
            
            //Get credit card number from user.
            creditCardNumber = kb.nextLong();
            //Check if credit card is valid.
            boolean valid = isValid(creditCardNumber);
            //If not valid, tell user it's not valid and ask them if they want to try again.
            if(valid == false)
                System.out.println("\nThis is not a valid credit card number.");
            System.out.print("\nWould you like to validate another credit card? (Y/N) ");
            //Clear the input buffer.
            kb.nextLine();
            
            //Check input validation
            while(!kb.hasNextLine()) {
                System.out.println("That's not a valid option. Please try again.");
                System.out.print("\nWould you like to validate another credit card? (Y/N) "); 
                kb.next();
            }
            
            //Get the user's answer if they want to try again.
            programControl = kb.nextLine();
            
            do {
                if(programControl.equalsIgnoreCase("y") || programControl.equalsIgnoreCase("n")) {
                    //Do nothing and continue. Valid option.
                } else {
                    //Not a valid option.
                    System.out.println("That's not a valid option. Please try again.");
                    System.out.print("\nWould you like to validate another credit card? (Y/N) "); 
                    programControl = kb.nextLine();
                }
            } while (!(programControl.equalsIgnoreCase("y") || programControl.equalsIgnoreCase("n")));
 
            System.out.println();
        }
        //If they want to enter another credit card, then start the process over.
        while(programControl.equalsIgnoreCase("y"));
        //Looks like the user is finished, so tell them to have a nice day.
        System.out.println("Have a nice day!");
        //Safely shutdowns the program.
        System.exit(0);
    }
    
    //Checks the user's credit to make sure it's valid.          
    public static boolean isValid(long creditCardNumber) 
    {
        int calculateForDivTen = sumOfOddPlaced(creditCardNumber) + sumOfEvenPlaced(creditCardNumber);
        
        if(LengthValidation(creditCardNumber) == false) {
            System.out.println("\nThe credit card number entered is not 13 or 16 numbers long.");
            return false;
        } else if(prefixDigitValidation(creditCardNumber) == false) {
            return false;
        } else if(isDivisableByTen(calculateForDivTen) == false) {
            return false;
        } else {
            return true;
        }
    }

    //Check how long the credit card provided by the user is.
    public static boolean LengthValidation(long creditCardNumber) 
    {
        int length = 0;
        
        while (creditCardNumber > 0) {
            length += 1;
            creditCardNumber = (creditCardNumber / 10);
        }
        
        if(length >= 13 && length <= 19)
            return true;
        else
            return false;
    }
    
    //Checks if the sum of the even and odd credit card calculation is divisible by 10.
    public static boolean isDivisableByTen(int result)
    {
        if(result % 10 == 0)
            return true;
        else
            return false;
    }
    
    //Checks the credit card prefix and matches it to a credit card provider.
    public static boolean prefixDigitValidation(long creditCardNumber)
    {
        
        int length = 0;
        long tempCreditCardNumber = creditCardNumber;
        boolean result = false;
        
        //Get the length of the credit card.
        while (tempCreditCardNumber > 0) {
            length = length + 1;
            tempCreditCardNumber = (tempCreditCardNumber / 10);
        }
        
        //Match the prefix to a credit card provider.
        while (creditCardNumber > 0) {
            creditCardNumber = (creditCardNumber / 10);

            //Java doesn't support switch statements using long values? WTF!?
            switch ((new Long(creditCardNumber)).intValue()) {
                //Visa
                case 4:
                    if(length >= 13 && length <= 16) {
                        System.out.println("\nThis is a valid \"Visa\" credit card number");
                        result = true;
                    }
                    break;                  
                //American Express
                case 34:
                case 37:
                    if(length == 15) {
                        System.out.println("\nThis is a valid \"Master Card\" credit card number");
                        result = true;
                    }
                    break;
                //Master Card
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                    if(length >= 16 && length <= 19) {
                        System.out.println("\nThis is a valid \"Master Card\" credit card number");
                        result = true;
                    }
                    break;
                //Discover Card
                case 65:
                case 644:
                case 655:
                case 656:
                case 657:
                case 658:
                case 659:
                case 6011:
                    if(length == 16) {
                        System.out.println("\nThis is a valid \"Discover Card\" credit card number");
                        result = true;
                    }
                    break; 
                default:
                    //Discover Card
                    if(creditCardNumber >= 622126 && creditCardNumber <= 622925) {
                        if(length == 16) {
                            System.out.println("\nThis is a valid \"Discover Card\" credit card number");
                            result = true;
                        }
                    } 
                    break;
            }
        }
        return result;
    }
    
    //Calculates the sum of odd placed digits in the credit card.
    public static int sumOfOddPlaced(long creditCardNumber)
    {
        int result = 0;

        do {
            //Store it as an int even though we're working with a long.
            //Get odd numbers and split them up.
            result = result + (int) (creditCardNumber % 10);
            //Move to the next number
            creditCardNumber = creditCardNumber / 100;
        } while (creditCardNumber > 0);

        return result;
    }
    
    //Calculates the sum of even placed digits in the credit card.
    public static int sumOfEvenPlaced(long creditCardNumber)
    {
        int result = 0;
        long tempCardNumber;

        //Do while we still some numbers to work with. 
        do {
            //Get the last two digits.
            tempCardNumber = creditCardNumber % 100;
            //Store and send it as an int even though we're working with a long.
            result = result + (splitDoubleDigit((int) (tempCardNumber / 10) * 2));
            //Move two places since we want even placed values.
            creditCardNumber = creditCardNumber / 100;
        } while (creditCardNumber > 0);

        return result;
    }

    //Splits up numbers greater than 9 into two numbers, then adds both numbers together.
    public static int splitDoubleDigit(int numberToSplit)
    {
        int result = numberToSplit;
        int number1;
        int number2;
        
        //If the number we're passed is greater than or equal to 10, then split the number into two then add them.
        if (numberToSplit >= 10) {
            number1 = (numberToSplit / 10);
            number2 = (numberToSplit % 10);
            result = number1 + number2; 
        }
        return result;
    }
    
    //Outputs the program description when it starts for the first time.
    public static void description()
    {
        System.out.println("*********************************************");
        System.out.println("This program will determine if you\nhave entered a valid credit card number.");
        System.out.println("Credit cards that we check includes Visa, Master\nCard, Discover cars, and American Express. Written");
        System.out.println("by Marc Woodyard\n*********************************************");
    }
}