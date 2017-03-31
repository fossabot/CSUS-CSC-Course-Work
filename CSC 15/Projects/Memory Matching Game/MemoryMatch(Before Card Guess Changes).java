/*
 ________  ________  ________                  _____  ________                             
|\   ____\|\   ____\|\   ____\                / __  \|\   ____\                            
\ \  \___|\ \  \___|\ \  \___|  ____________ |\/_|\  \ \  \___|_                           
 \ \  \    \ \_____  \ \  \    |\____________\|/ \ \  \ \_____  \                          
  \ \  \____\|____|\  \ \  \___\|____________|    \ \  \|____|\  \                         
   \ \_______\____\_\  \ \_______\                 \ \__\____\_\  \                        
    \|_______|\_________\|_______|                  \|__|\_________\                       
              \|_________|                               \|_________|                       
 ________  ________  ________        ___  _______   ________ _________        ________     
|\   __  \|\   __  \|\   __  \      |\  \|\  ___ \ |\   ____\\___   ___\     |\_____  \    
\ \  \|\  \ \  \|\  \ \  \|\  \     \ \  \ \   __/ \ \  \___\|___ \  \_|     \|____|\ /_   
 \ \   ____\ \   _  _\ \  \\\  \  __ \ \  \ \  \    \ \  \       \ \  \            \|\  \  
  \ \  \___|\ \  \\  \\ \  \\\  \|\  \\_\  \ \  \___ \ \  \____   \ \  \          __\_\  \ 
   \ \__\    \ \__\\ _\\ \_______\ \________\ \_______\ \_______\  \ \__\        |\_______\
    \|__|     \|__|\|__|\|_______|\|________|\|_______|\|_______|   \|__|        \|_______|

Program Name: Memmory Matching game
Description: This program plays a game of hangman where the program guesses the user's word.
Version:     0.1 Alpha
Author:      Marc Woodyard
Class:       CSC-15
Section:     04
Author URL:  https://marcwoodyard.com
Notes:       
*/

//Imports all of the classes contained in the java utility package.
import java.util.*;

public class MemoryMatch
{
    static int card1Guess = 0; //Replace with guesses[0]
    static int card2Guess = 0; //Replace with guesses[1]
    static int[] guesses = new int[3];
    static int firstOrSecondCard = 1;
    static int[] coordinates = new int[] {11,12,13,14,21,22,23,24,31,32,33,34,41,42,43,44};
    static int[] boardValues = new int[16];
    static Scanner GetInput = new Scanner(System.in);
    static int boardCompleted = 0;
    static int guessesTheSame = 0;
    static int haveBothGuesses = 0;
    //Instalizes randomNumber Random.
    static Random randomNumber = new Random();
    
    public static void main(String[] args)
    {
        //Generates the values for the board.
        generateBoardValues();
        //Displays the instructions.
        instructions();
        //Displays a blank game board.
        blankGameBoard();
        do
        {
            do
            {
               do
               {
                    //Ask the user which card cordinates they would like to guess.
                    whichCard();
                    //Displays "coordinates" text.
                    System.out.print("Coordinates: ");
                    //Gets the coordinates from the user.
                    String coordinateGuess = GetInput.nextLine();
                    //Verifys if the user enter help, or anything else.
                    needHelpNotValid(coordinateGuess);
                    //Decides which card to verify.
                    if(firstOrSecondCard == 1)
                    {
                        //Verifys that the coordinate is on the board.
                        verifyCoordinate(card1Guess);
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        //Verifys that the coordinate is on the board.
                        verifyCoordinate(card2Guess);
                    }
                    else
                    {
                        //If anything else happens. Display this error message.
                        System.out.println("Error occured when deciding which card cordinate guess to verify.\nProgram exiting to prevent crash...");
                        //Exit the program.
                        System.exit(0);
                    }  
            
                        
                    //Are the two card guesses equal?
                    if(card1Guess == card2Guess)
                    {
                        //If so, display an error message.
                        System.out.println("\nThose are the same coordinates. Of corse they're goint to match. Try again.\n");
                        guessesTheSame = 1;
                    }
                    else if(card1Guess != card2Guess)
                    {
                        /*If they're not equal, then set guessesTheSame to 0.
                        Because if the first round of guesses was the same, I need to hagne guessesTheSame 
                        to 0 if they're different now.*/
                        guessesTheSame = 0;
                    }
                    else
                    {
                        //If anything else happens, throw an error message.
                        System.out.println("An error occured when testing if card1Guess and card2Guess are the same.\nProgram exiting to prevent crash.");
                        //Exit the program.
                        System.exit(0);
                    }
                }
                while(guessesTheSame == 1);
                //We have both guesses. Lets exit this do-while loop.
                haveBothGuesses = 1;
            }
            while(haveBothGuesses == 0);
            //Reset haveBothGuesses.
            haveBothGuesses = 0;
            //Are the two coordinates a match?
            coordinatesEqual()
            //Are the two coordinates a match?
            coordinatesEqual()
            //Resets haveBothGuesses;
            if(card1Guess == card2Guess)
            {
                //Edit the board.
            }
            else if(card1Guess != card2Guess)
            {
                //Not a match.
            }
            else
            {
                //Display an error message
                System.out.println("An error occured while compairing both coordinates after coordinatesEqual ran.\nExiting program to prevent crash...");
                //Exits the program.
                System.exit(0);
            }
        }
        while(boardCompleted != 1);
    }
    
    public static void instructions()
    {
        System.out.println("Welcome to the Memory Game!\n");
        System.out.println("The goal is to find all the matching pairs in as few turns as possible.");
        System.out.println("At each turn select two different positions on the board to see if they match.\n");
        //Press the "enter" key to continue.
        System.out.print("Press the \"enter\" key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        System.out.println();
    }
    
    public static void displayHelpDocs()
    {
        System.out.println("Here are the help docs. They need to be filled in");
    }

    public static void needHelpNotValid(String x)
    {
        if(x.equalsIgnoreCase("help"))
        {
            //Displays help docs.
            displayHelpDocs();
            //Exits the program.
            System.exit(0);
        }
        else
        {
            try
            {
                //Is coordinateGuess an int?
                Integer.parseInt(x);
            }
            catch(NumberFormatException NotAIn)
            {
                //If coordinateGuess is not an int, display and error message.
                System.out.println("\nYou did not enter a valid coordinate. Please check your input and try again.\nError code: 1\n");
                //Exits the try catch.
                System.exit(0);
            }
        }
        int convertToInt = Integer.parseInt(x);
        if(firstOrSecondCard == 1)
        {
            card1Guess = convertToInt;
        }
        else if(firstOrSecondCard == 2)
        {
            card2Guess = convertToInt;
        }
        else
        {
            System.out.println("Error occured when updating values for card1Guess or card2Guess.\nProgram exiting to prevent crash.");
            System.exit(0);
        }
        
    }

    public static void verifyCoordinate(int x)
    {    
        int convertToInt = x;

        if(convertToInt == coordinates[0] || convertToInt == coordinates[1] || convertToInt == coordinates[2]
         ||convertToInt == coordinates[3] || convertToInt == coordinates[4] || convertToInt == coordinates[5]
         ||convertToInt == coordinates[6] || convertToInt == coordinates[7] || convertToInt == coordinates[8]
         || convertToInt == coordinates[9]|| convertToInt == coordinates[10]|| convertToInt == coordinates[11]
         || convertToInt == coordinates[12] || convertToInt == coordinates[13] || convertToInt == coordinates[14]
         || convertToInt == coordinates[15])
        {
            if(firstOrSecondCard == 1)
            {
                firstOrSecondCard++;
            }
            else if(firstOrSecondCard >= 2)
            {
                firstOrSecondCard = 1;
            }
            else
            {
                System.out.println("An error occured while verifying coordinates.\nExiting program to prevent crash...");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("Error when checking valid coordinates.\nProgram exiting to prevent a crash...");
            System.exit(0);
        }
    }

    public static void whichCard()
    {
        if(firstOrSecondCard == 1)
        {
            System.out.println("Where is the first card you wish to see?");
        }
        else if(firstOrSecondCard == 2)
        {
            System.out.println("Where is the second card you wish to see?");
        }
        else
        {
            System.out.println("firstOrSecondCard no = to 1 or 2.\nExiting to prevent system crash.");
            System.exit(0);
        }
    }

    public static void generateBoardValues()
    {
        //Generates duplicated values to be refferenced by coordinates.
        for(int numberGeneratorCounter = 0; numberGeneratorCounter <= 7; numberGeneratorCounter++)
        {
            //Generates a random number.
            int randomallyGeneratedNumber = (int)(randomNumber.nextInt(99) + 1);
            //Set the boardValue arrary that the counter is on equal to the randon number generated.    
            boardValues[numberGeneratorCounter] = randomallyGeneratedNumber;
            //Create a copy of the numberGeneratorCounter.
            int counterCopy = numberGeneratorCounter;
            //Example: numberGeneratorCounter = 0; .
            int calculateBoardValuesToMatch = counterCopy + 8;
            //Example: boardValues[0] = boardValues[8].                 
            boardValues[calculateBoardValuesToMatch] = boardValues[counterCopy]; 
        }
    }

    public static void gameBoardCoordinates()
    {
        System.out.println("    1 2 3 4");
        System.out.println("  ===========");
        System.out.println("1 |" + coordinates[0] + coordinates[1] + coordinates[2] + coordinates[3] + "|");
        System.out.println("2 |" + coordinates[4] + coordinates[5] + coordinates[6] + coordinates[7] + "|");
        System.out.println("3 |" + coordinates[8] + coordinates[9] + coordinates[10] + coordinates[11] + "|");
        System.out.println("4 |" + coordinates[12] + coordinates[13] + coordinates[14] + coordinates[15] + "|");
        System.out.println("  ===========\n");
    }
    
    public static void showValues()
    {
            System.out.println("    1 2 3 4");
            System.out.println("  ===========");
            System.out.println("1 |" + coordinates[0] + coordinates[1] + coordinates[2] + coordinates[3] + "|");
            System.out.println("2 |" + coordinates[4] + coordinates[5] + coordinates[6] + coordinates[7] + "|");
            System.out.println("3 |" + coordinates[8] + coordinates[9] + coordinates[10] + coordinates[11] + "|");
            System.out.println("4 |" + coordinates[12] + coordinates[13] + coordinates[14] + coordinates[15] + "|");
            System.out.println("  ===========\n");
    }
    
    public static void blankGameBoard()
    {
        System.out.println("    1 2 3 4");
        System.out.println("  ==========");
        System.out.println("1 | * * * * |");
        System.out.println("2 | * * * * |");
        System.out.println("3 | * * * * |");
        System.out.println("4 | * * * * |");
        System.out.println("  ==========\n");
    }
    
    //Displays debug information.
    public static void debug()
    {
        //Displays the board values. 
        System.out.println(boardValues[0]);
        System.out.println(boardValues[1]);
        System.out.println(boardValues[2]);
        System.out.println(boardValues[3]);
        System.out.println(boardValues[4]);
        System.out.println(boardValues[5]);
        System.out.println(boardValues[6]);
        System.out.println(boardValues[7]);
        //Start of second half of board.
        System.out.println();
        System.out.println(boardValues[8]);
        System.out.println(boardValues[9]);
        System.out.println(boardValues[10]);
        System.out.println(boardValues[11]);
        System.out.println(boardValues[12]);
        System.out.println(boardValues[13]);
        System.out.println(boardValues[14]);
        System.out.println(boardValues[15]);
    }

    public static void coordinatesEqual()
    {
        //Creates a int called "x", and set it to zero.
        int x = 0;
        //If firstOrSecondCard 
        if(firstOrSecondCard == 1)
        {
            x = card1Guess;
            firstOrSecondCard++;
        }
        else if(firstOrSecondCard == 2)
            x = card2Guess;
            firstOrSecondCard = 1;
        }
        else
        {
            System.out.println("An error occured in coordinatesEqual.\nExiting program to prevent crash...");
            System.exit(0);
        }
        
        switch(x)
        {
            case 11:
                x = boardValues[0];
            case 12:
                x = boardValues[1];
            case 13:
                x = boardValues[2];
            case 14:
                x = boardValues[3];
            case 21:
                x = boardValues[4];
            case 22:
                x = boardValues[5];
            case 23:
                x = boardValues[6];
            case 24:
                x = boardValues[7];
            case 31:
                x = boardValues[8];
            case 32:
                x = boardValues[9];
            case 33:
                x = boardValues[10];
            case 34:
                x = boardValues[11];
            case 41:
                x = boardValues[12];
            case 42:
                x = boardValues[13];
            case 43:
                x = boardValues[14];
            case 44:
                x = boardValues[15];
            default:
                System.out.println("An error occured during the switch statment.\nExiting program to prevent crash...");
                System.exit(0):   
        }
    }
}
/*
To Do:
-Set boardValues arrary to final.
-Same board values generated evey time the program runs.
-Fix cordinate control. User can edter 38 or 18 then an error is produced.
-Add more instructions to the header when the program starts.
-Inform the user how to enter cordinates.
-Implement help features.
-Fix the instructions. 
-Fill in help docs. 
-Save game data to a file.
*/