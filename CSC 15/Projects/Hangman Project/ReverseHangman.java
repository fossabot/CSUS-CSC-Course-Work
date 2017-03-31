/* 
 ________  ________  ________                  _____  ________                             
|\   ____\|\   ____\|\   ____\                / __  \|\   ____\                            
\ \  \___|\ \  \___|\ \  \___|  ____________ |\/_|\  \ \  \___|_                           
 \ \  \    \ \_____  \ \  \    |\____________\|/ \ \  \ \_____  \                          
  \ \  \____\|____|\  \ \  \___\|____________|    \ \  \|____|\  \                         
   \ \_______\____\_\  \ \_______\                 \ \__\____\_\  \                        
    \|_______|\_________\|_______|                  \|__|\_________\                       
             \|_________|                               \|_________|                       
 ________  ________  ________        ___  _______   ________ _________         _______     
|\   __  \|\   __  \|\   __  \      |\  \|\  ___ \ |\   ____\\___   ___\      /  ___  \    
\ \  \|\  \ \  \|\  \ \  \ \  \     \ \  \ \   __/ \ \  \___\|___ \  \_|     /__/|_/  /|   
 \ \   ____\ \   _  _\ \  \ \  \  __ \ \  \ \  \__  \ \  \       \ \  \     |__|//  / /   
  \ \  \___|\ \  \\  \\ \  \_\  \|\  \\_\  \ \  \__ _\ \  \_____  \ \  \        /  /_/__  
   \ \__\    \ \__\\ _\\ \_______\ \________\ \_______\ \_______\  \ \__\      |\_______\
    \|__|     \|__|\|__|\|_______|\|________|\|_______|\|_______|   \|__|      \|_______|
    
Program Name: Reverse Hangman
Description: This program plays a game of hangman where the program guesses the user's word.
Version:     1.2-beta
Author:      Marc Woodyard
Class:       CSC-15
Section:     04
Author URL:  https://marcwoodyard.com
Notes:       Rember to fix the line numbers in the error messages on lines 265 & 360.
*/

//Imports all of the classes contained in the java utility package.
import java.util.*;

public class ReverseHangman
{
    //Sets the final number of incorrect guesses that can't be changed.
    public static final int MAX_INCORRECT_GUESSES = 6;
    //Sets the final number of letters that a word can be, and the value can't be changed.
    public static final int MAX_LENGTH = 8;
    //Tells the program what letters it can guess.
    public static final String LETTERS = "ABCDEFGHIJKLMONPQRSTUVWXYZ";
    //Sets the number of live the program can have while guessing the user's word.
    public static int lives = 6;
    //Keeps track of how many times the program wins.
    public static int wins = 0;
    //Keeps track of how many times the program has lost.
    public static int losses = 0;
    //Keeps track of the number of correct guessed the program has so far.
    public static int guessedCorrectly = 0;

    public static void main(String[] args)
    {
        //instalizes the scanner to get input from the user.
        Scanner GetInput = new Scanner(System.in);
        //Displays the instructions.
        firstInstructions();
        //Asks the user if they want to play.
        System.out.print("\nDo you want to play? (yes/no) ");
        //Gets input from the user (yes, no, or help).
        String playOrNah = GetInput.nextLine();
        //A do-while loop that runs the program one, the based on if the user wants to play again.
        //Will run the program again, as many times as the user wants to play.
        do
        {
            //If the uer wants to play.
            if(playOrNah.equalsIgnoreCase("yes"))
            {
                //Asks the user how many letters are in the word they're thinking about. 
                System.out.print("\nHow many letters are in your word? ");
                //Gets input from the user if he/she wants to play.
                String numberOfLettersInput = GetInput.nextLine();
                /*Creates a for loop that will prompt the user to enter a valid
                number 500 times, or display the help documentation.*/
                for (int letersCounter = 0; letersCounter < 500; letersCounter++)
                {
                    //If the user enters help, display the help documentation.
                    if(numberOfLettersInput.equalsIgnoreCase("help"))
                    {
                        displayHelpDocs();
                        letersCounter = 0;
                    }
                    //If the user is thinking of a number with zero letters in it.
                    else if(numberOfLettersInput.matches("0"))
                    {
                        System.out.println("\nI'm guessing your word is nothing.\n\nProgram exiting...\n");
                        System.exit(0);
                    }
                    //If it doesn't match any of the conditions above, run this code.
                    else
                    {
                        try
                        {
                            //Is numberOfLettersInput an Int? If so, convert to string.
                            Integer.parseInt(numberOfLettersInput);
                        }       
                        catch(NumberFormatException NotAInt)
                        {
                            //Not a int error code.
                            System.out.println("\nYou did not enter a valid number. Please check your input and try again.\nError code: 0\n");
                            //Exits the program.
                            System.exit(0);
                        }
                    }
                }
                //Convets string numberOfLettersInput to a int.
                int numberOfLetters = Integer.parseInt(numberOfLettersInput);
                //Puts a new line after the program asks how many letters.
                System.out.println();
                //Runs what's below when wantToPlay is true.
                for(int wantToPlay = 1; wantToPlay <= 1; wantToPlay++)
                {
                    //Checks if number of letters is less than 8.
                    if(MAX_LENGTH >= numberOfLetters)
                    {
                        //Runs for the amount of letters you entered.
                        for(int counter0 = 1; counter0 <= 16; counter0++)
                        {
                                //Instalizes randomLetter Random.
                                Random randomLetter = new Random();
                                //Generates a random letter.
                                char letter = (char)(randomLetter.nextInt(26) + 'a');
                                //Prints the guess, and asks the user if it's correct.
                                System.out.print("\nDoes your word contain a \"" + letter + "\"? (yes/no) ");
                                //Get the result of the guess from the user. 
                                String amICorrect = GetInput.nextLine();
                                    //If the program guessed a letter correctly.
                                    if(amICorrect.equalsIgnoreCase("yes"))
                                    {
                                        //Calculates the gallows figure based on number of incorrect guesses.
                                        gallowsCalculate();
                                        //Add one to guessedCorrectly. Needed to help calculate when the program wins the game.
                                        guessedCorrectly++;
                                        //If the program guessed correctly the same amount ot fimes as letters in the number, the pgorgram wins.
                                        if(guessedCorrectly >= numberOfLetters)
                                        {
                                            //Prints I win.
                                            System.out.println("I WIN!!!!!!!!!!!!!!\n");
                                            //Gives the program one point every time it wins.
                                            wins++;
                                            //Prints the score.
                                            System.out.println("I've lost " + losses + " time(s). And won " + wins + " time(s).");
                                            System.out.println("----------------------------------------------------------------");
                                            //Resets how many times the computer has guessed correctly.
                                            guessedCorrectly = 0;
                                            //Stop the for loop.
                                            counter0 = 500;
                                            //Asks the user if they want to play again.
                                            System.out.print("\nDo you want to play again? (yes/no) ");
                                            //Get the user's response.
                                            playOrNah = GetInput.nextLine();
                                        }
                                        else if(lives == 0)
                                        {
                                            //Adds one loss to the score board.
                                            losses++;
                                            //If the program looses, it will ask the play if they want to play again.
                                            System.out.println("I've lost " + losses + " time(s). And won " + wins + " time(s).");
                                            System.out.println("----------------------------------------------------------------");
                                            //Resets how many times the computer has guessed correctly.
                                            guessedCorrectly = 0;
                                            //Stops the for loop.
                                            counter0 = 500;
                                            //Asks the user if they want to play again.
                                            System.out.print("\nDo you want to play again? (yes/no) ");
                                            //Gets input from the user.
                                            playOrNah = GetInput.nextLine();
                                        }
                                        //If the program hasn't won yet, just stay calm and keep er' goin'.
                                        else{
                                        }
                                        //Displays how many letters the program has guessed correctly.
                                        System.out.println("\nI've got " + guessedCorrectly + " of the " + numberOfLetters + " letters so far.");
                                        System.out.println("-------------------------------------------------------------------------------------");
                                    }
                                    //If the program guessed incorrectly.
                                    else if(amICorrect.equalsIgnoreCase("no"))
                                    {
                                        //Take away one life.
                                        lives--;
                                        //Calculates the gallows figure based on number of incorrect guesses.
                                        gallowsCalculate();
                                        //If the program has guessed incorrect 6 times.
                                        if(lives == 0)
                                        {
                                            //Add one loss to the score board.
                                            losses++;
                                            //Resets how many times the computer has guessed correctly.
                                            guessedCorrectly = 0;
                                            //Stops the for loop.
                                            counter0 = 500;
                                            //Reset lives.the
                                            lives = 6;
                                            //Resets the number of letters.
                                            System.out.println("I've lost " + losses + " time(s). And won " + wins + " time(s).");
                                            System.out.println("----------------------------------------------------------------");
                                            //If the program looses, it will ask the play if they want to play again.
                                            System.out.print("\nDo you want to play again? (yes/no) ");
                                            //Gets the user's answer.
                                            playOrNah = GetInput.nextLine();
                                        }
                                        else{
                                        }
                                        while(lives > 0 && counter0 < 500)
                                        {
                                            //Displays how many letters the program has guessed correctly.
                                            System.out.println("\nAwww...I've got " + guessedCorrectly + " of the " + numberOfLetters + " letters so far."); 
                                            System.out.println("-------------------------------------------------------------------------------------");
                                            break;
                                        }
                                    }
                                    //If the user enters help, the program will display the help documentation.
                                    else if(amICorrect.equalsIgnoreCase("help"))
                                    {
                                        displayHelpDocs();   
                                    }
                                    //If the user enters anything else other than yes, no, or help. The program will display a help message.
                                    else
                                    {
                                        System.out.println("\nWhat do you mean? Oh, oh. When you nod your head yes. But you wanna say no...\n");
                                        System.out.println("Error code: 1; Not valid input.\nExiting program...\n");
                                        System.exit(0);
                                    }
                        }
                    }
                    //If the user is thinking of a letter that has too many letters.
                    else
                    {
                        System.out.println("Sorry, you're thinking of a word that is too/n long for me to guess. \n Error code: 1");
                        System.exit(0);
                    }
                }
            }
            //If the user doesn't want to play.
            else if(playOrNah.equalsIgnoreCase("no"))
            {
                System.out.println("\nAwww...Ok. See you later.\n\nProgram exiting...\n");
                System.exit(0);
            }
            //If the user wants to display the help documentation.
            else if(playOrNah.equalsIgnoreCase("help"))
            {
                displayHelpDocs();
                System.exit(0);
            }
            //If the user enters anything else other than yes, no, or help.
            else
            {
                System.out.println("\nSorry, I didn't catch that. Please view the help documentation for more help.\nError code: 1\nProgram exiting...\n");
            }
        }
        
        //Check to see if the playOrNah equals yes. If so, the user wants to play again.
        while(playOrNah.equalsIgnoreCase("yes"));
        //If the user enters no, the program will exit.
        if(playOrNah.equalsIgnoreCase("no"))
        {
            System.out.println("\nAwww...Ok. See you later.\n\nProgram exiting...\n");
            System.exit(0); 
        }
        //If the user enters help, the program will display the help documentation.
        else if(playOrNah.equalsIgnoreCase("help"))
        {
            displayHelpDocs();
        }
        //If anything else happens, the program will throw this error message.
        else
        {
            System.out.println("\nAn unknown error has occured on line 265. Please restart the program and try again.");
            System.out.println("If the prolbem continues, please contact your network administrator.\n");
            System.exit(0);
        }
    }
    
    //Calculates the gallows outline based on how many wrong guesses the program has.
    public static void gallowsCalculate()
    {
        //Switch conditions based on the input from the GetOperator variable.
        switch (lives)  
        {
            case 6:
                    //We have all of our lives left. Everything's looking good.
                    System.out.println("\n+--+");
                    System.out.println("|  |");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("+-----");
                    break;
            case 5:
                    //Just lost a life. Not the end of the world. Still staying strong.
                    System.out.println("\n+--+");
                    System.out.println("|  |");
                    System.out.println("|  O");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("+-----");
                    break;
            case 4:
                    //Ok, starting to get a litle worried. I need to step up my guessing game.
                    System.out.println("\n+--+");
                    System.out.println("|  |");
                    System.out.println("|  O");
                    System.out.println("|  |");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("+-----");
                    break;
            case 3:
                    //Shit. Three lives left. Looking pretty bleak.
                    System.out.println("\n+--+");
                    System.out.println("|  |");
                    System.out.println("|  O");
                    System.out.println("| -|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("+-----");
                    break;
            case 2:
                    //Still trying to stay positive. Two lives left.
                    System.out.println("\n+--+");
                    System.out.println("|  |");
                    System.out.println("|  O");
                    System.out.println("| -|-");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("+-----");
                    break;
            case 1:
                    //Day 3,425. I have one life left. Did I leave the stove on?
                    System.out.println("\n+--+");
                    System.out.println("|  |");
                    System.out.println("|  O");
                    System.out.println("| -|-");
                    System.out.println("| /");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("+-----");
                    break;
            case 0:
                    //Well... I'm dead. 
                    System.out.println("\n+--+");
                    System.out.println("|  |");
                    System.out.println("|  O");
                    System.out.println("| -|-");
                    System.out.println("| / \\");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("+-----");
                    //Speaking from the nether.
                    System.out.print("Well...you win. What was your word? ");
                    Scanner GetInput = new Scanner(System.in);
                    String whatWasTheAnswer = GetInput.nextLine();
                    System.out.println("\nOh. well... " + whatWasTheAnswer + ". That was going to be my next guess.\n");
                    break;
            default:
                    System.out.println("An unknown error has occured on line 360. Please restart the program and try again.");
                    System.out.println("If the prolbem continues, please contact your network administrator.");
                    break;
        }
    }
    //Displays the help documentaion when the program starts.
    public static void firstInstructions()
    {
        System.out.println("************************************************************************");
        System.out.println("This program plays a game of reverse hangman.");
        System.out.println("You think of a word and that is less than 8 letters\nI'll try to guess the letters.");
        System.out.println("The maximum numner of incorrect guesses for me is 6");
        System.out.println("The maximum number of the letters in your word is : 8");
        System.out.println("+--+");
        System.out.println("|  |");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("+-----");
        System.out.println("*************************************************************************\n");
        
        System.out.println("You must choose a number between 1 and 8.\n");
        System.out.println("If you need help, enter \"help\" (without the parenthesis) anytime \nyou are prompted for input.\n");
    }
    //Displays the help documentation.
    public static void displayHelpDocs()
    {
        System.out.println();
        System.out.println("Help Documentation:\n-------------------------------- ");
        System.out.println("This is a java program that will plays hangman. You think of a number in your head,");
        System.out.println("then tell the program how many letters are in the word you are thinking of. After");
        System.out.println("you tell the program how many letters are in your word, it will try and guess your word.");
        System.out.println("\nError Codes:\n-------------\n");
        System.out.println("Error code 0: You didn't enter a number (1,2,3..8), or help.");
        System.out.println("Error code 1: You didn't enter yes, no, or help.");
        System.out.println("\n\nReady to play?\n");
        System.exit(0);
    }
}