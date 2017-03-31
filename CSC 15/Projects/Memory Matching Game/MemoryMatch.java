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
Version:     1.2 Beta
Author:      Marc Woodyard
Class:       CSC-15
Section:     04
Author URL:  https://marcwoodyard.com
Notes:       A visual representaion of my project http://bit.ly/1jN5L1E
*/

//Imports all of the classes contained in the java utility package.
import java.util.*;

public class MemoryMatch
{
    //static int card1Guess = 0; //Replaced with guesses[0]
    //static int card2Guess = 0; //Replaced with guesses[1]
    //Guess coordinates = guesses[2] & guesses[3]
    
    static int[] guesses = new int[4];
    static int firstOrSecondCard = 1;
    static final int[] coordinates = new int[] {11,12,13,14,21,22,23,24,31,32,33,34,41,42,43,44};
    static int[] boardValues = new int[16];
    static String[] stars = new String[16];
    static Scanner GetInput = new Scanner(System.in);
    static int boardCompleted = 0;
    static int guessesTheSame = 0;
    static int haveBothGuesses = 0;
    static int starOneTemp = 20;
    static int starTwoTemp = 20;
    static int whereAmI1 = 0;
    static int whereAmI2 = 0;
    //Instalizes randomNumber Random.
    static Random randomNumber = new Random();
    
    public static void main(String[] args)
    {
        //Generates the values for the board.
        generateBoardValues();
        //Displays the instructions.
        instructions();
        //Displays a blank game board.
        //blankGameBoard();
        //Is the board complete?
        do
        {
            //Do we have both guesses?
            do
            {
                //Are the guesses the same?
                do
                {
                    //Ask the user which card cordinates they would like to guess.
                    whichCard();
                    //Displays "coordinates" text.
                    System.out.print("Coordinates: ");
                    //Gets the coordinates from the user.
                    String coordinateGuess = GetInput.nextLine();
                    //Puts a space below the user input.
                    System.out.println();
                    //Verifys if the user enter help, or anything else.
                    needHelpNotValid(coordinateGuess);
                    //Decides which card to verify.
                    if(firstOrSecondCard == 1)
                    {
                        //Verifys that the coordinate is on the board.
                        verifyCoordinate(guesses[0]);
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        //Verifys that the coordinate is on the board.
                        verifyCoordinate(guesses[1]);
                    }
                    else
                    {
                        //If anything else happens. Display this error message.
                        System.out.println("Error occurred when deciding which card cordinate guess to verify.\nProgram exiting to prevent crash...");
                        //Exit the program.
                        System.exit(0);
                    }  
    
                    //Are the two card guesses equal?
                    if(guesses[0] == guesses[1])
                    {
                        //If so, display an error message.
                        System.out.println("\nThose are the same coordinates. Of corse they're goint to match. Try again.\n");
                        guessesTheSame = 1;
                    }
                    else if(guesses[0] != guesses[1])
                    {
                        /*If they're not equal, then set guessesTheSame to 0.
                        Because if the first round of guesses was the same, I need to hagne guessesTheSame 
                        to 0 if they're different now.*/
                        guessesTheSame = 0;
                    }
                    else
                    {
                        //If anything else happens, throw an error message.
                        System.out.println("An error occurred when testing if guesses[0] and guesses[1] are the same.\nProgram exiting to prevent crash.");
                        //Exit the program.
                        System.exit(0);
                    }
                    //Are the two coordinates a match?
                    coordinatesEqual();
                    }
                    while(guessesTheSame == 1);
                    //We have both guesses. Lets exit this do-while loop.
                    haveBothGuesses = 1;
                }
                while(haveBothGuesses == 0);
                
                //Show game board.
                //displayBoardValues();
            /*}
            while(pressToContinue == 0);
            //Tells the user to oress the "enter" key to continue.
            System.out.print("\n\nPress the \"enter\" key to continue...");
            try
            {
                System.in.read();
            }  
            catch(Exception e)
            {}
            System.out.println();*/

            //Erases the screen. Cheaters never prosper.
            //eraseScreen();

            //Uncommend to debug program.
            //debug();

            //Need to figure this out.
            /*if(guesses[0] == guesses[1])
            {
                //Edit the board.
            }
            else if(guesses[0] != guesses[1])
            {
                //Not a match.
            }
            else
            {
                //Display an error message
                System.out.println("An error occurred while compairing both coordinates after coordinatesEqual ran.\nExiting program to prevent crash...");
                //Exits the program.
                System.exit(0);
            }*/
            if(guesses[1] == 0)
            {
                //Do Nothing.
            }
            else if(guesses[1] != 0) 
            {
                //Show & edit the game board.
                displayBoardValues();
            }
            else
            {
                //Display an error message
                System.out.println("An error occurred while compairing both coordinates after coordinatesEqual ran.\nExiting program to prevent crash...");
                //Exits the program.
                System.exit(0);
            }
            
        }
        //Is the board complete?
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
            guesses[0] = convertToInt;
        }
        else if(firstOrSecondCard == 2)
        {
            guesses[1] = convertToInt;
        }
        else
        {
            System.out.println("Error occurred when updating values for guesses[0] or guesses[1].\nProgram exiting to prevent crash.");
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
                //firstOrSecondCard++;
                x = guesses[2];
            }
            else if(firstOrSecondCard >= 2)
            {
                x = guesses[3];
                //firstOrSecondCard = 1;
            }
            else
            {
                System.out.println("An error occurred while verifying coordinates.\nExiting program to prevent crash...");
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
            System.out.println("\nWhere is the second card you wish to see?");
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
            int randomallyGeneratedNumber = (int)(randomNumber.nextInt(8) + 2);

            if(boardValues[0] != 0)
            {
                //Checks for duplicates.
                for(int i = 0; i <= 7; i++)
                {
                    if(boardValues[i] == randomallyGeneratedNumber)
                    {
                        //Detected a duplicate number. Let's fix that. 
                        randomallyGeneratedNumber = (int)(randomNumber.nextInt(7) + 3);
                        //Let's reset the counter to 'account' for the fix. See what I did here. Lawls =)
                        i--;
                    }
                    else
                    {
                        //Doesn't match. So do nothing.
                    }
                }
            }
            else if(boardValues[0] == 0)
            {
                //Generating the first number. Do nothing.
            }
            else
            {
                System.out.println("Error when checking for duplicates.\nExiting program to prevent crash...");
                System.exit(0);
            }
            //Set the boardValue arrary that the counter is on equal to the randon number generated.    
            boardValues[numberGeneratorCounter] = randomallyGeneratedNumber;
            //Create a copy of the numberGeneratorCounter.
            int counterCopy = numberGeneratorCounter;
            //Example: numberGeneratorCounter = 0;.
            int calculateBoardValuesToMatch = counterCopy + 8;
            //Example: boardValues[0] = boardValues[8].                 
            boardValues[calculateBoardValuesToMatch] = boardValues[counterCopy]; 
        }
        //Instalizes stars array.
        for(int j = 0; j < stars.length; j++)
        {
            stars[j] = "*";
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
        System.out.println("Board Values:");
        for(int x = 0; x < boardValues.length; x++)
        {
            System.out.println(boardValues[x]);
            if(x == 7)
            {
                System.out.println();
            }
        }

        //Displays the guesses.
        System.out.println("Guesses:");
        for(int j = 0; j < guesses.length; j++)
        {
            System.out.println(guesses[j]);
        }

    }

    public static void coordinatesEqual()
    {
        //Creates a int called "x", and set it to zero.
        int x = 0;
        //If firstOrSecondCard 
        if(firstOrSecondCard == 1)
        {
            //Temp card guess = guesses[0]
            x = guesses[0];
        }
        else if(firstOrSecondCard == 2)
        {
            //Temp card guess = guesses[1].
            x = guesses[1];
        }
        else
        {
            System.out.println("Here's the current value of x:" + x +"\n\n");
            System.out.println("An error occurred in coordinatesEqual.\nExiting program to prevent crash...");
            System.exit(0);
        }

        switch(x)
        {
            case 11:
                x = boardValues[0];
                break;
            case 12:
                x = boardValues[1];
                break;
            case 13:
                x = boardValues[2];
                break;
            case 14:
                x = boardValues[3];
                break;
            case 21:
                x = boardValues[4];
                break;
            case 22:
                x = boardValues[5];
                break;
            case 23:
                x = boardValues[6];
                break;
            case 24:
                x = boardValues[7];
                break;
            case 31:
                x = boardValues[8];
                break;
            case 32:
                x = boardValues[9];
                break;
            case 33:
                x = boardValues[10];
                break;
            case 34:
                x = boardValues[11];
                break;
            case 41:
                x = boardValues[12];
                break;
            case 42:
                x = boardValues[13];
                break;
            case 43:
                x = boardValues[14];
                break;
            case 44:
                x = boardValues[15];
                break;
            default:
                System.out.println("Here's the current value of x:" + x +"\n\n");
                System.out.println("An error occurred during the switch statment.\nExiting program to prevent crash...");
                System.exit(0);
                break;
        }
        
        if(firstOrSecondCard == 1)
        {
            guesses[2] = x;
            firstOrSecondCard++;
        }
        else if(firstOrSecondCard == 2)
        {
            guesses[3] = x;
        }
        else
        {
            System.out.println("An error occurred below the switch statment.\nExiting program to prevent crash...");
            System.exit(0);
        }
    
        //evaluateCoordinates();
    }
    
    //Do I still need this??????
    public static void evaluateCoordinates()
    {
        /*if(guesses[2] == guesses[3])
        {
            System.out.println("You guessed correctly.");
        }
        else if(guesses[2] != guesses[3])
        {
            System.out.println("They aren't equal.");
        }
        else
        {
            System.out.println("Issue in evaluateCoordinates./nExiting program to prevent crash...");
            System.exit(0);
        }*/
    }

    public static void displayBoardValues()
    {
        for(int counter = 0; counter <= 1; counter++)
        {
            //Set value for int x.
            int x = 0;
            //Instalize convertToString, then set it equal to 'no value'.
            String convertToString = "no value";
            //Decided which coordinate to test. 
            if(counter == 0)
            {
                x = guesses[0];
                firstOrSecondCard = 1;
            }
            else if(counter == 1)
            {
                x = guesses[1];
                firstOrSecondCard = 2;
            }
            else
            {
                System.out.println("Here is the current value of x: " + x);
                System.out.println("Error occurred when getting value for x in displayBoardValues.\nExiting program to prevent crash...");
                System.exit(0);
            }
            
            switch(x)
            {
                case 11:
                    convertToString = Integer.toString(boardValues[0]);
                    stars[0] = convertToString;
                    int stringToInt =  Integer.parseInt(stars[0]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 11;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 11;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 12:
                    convertToString = Integer.toString(boardValues[1]);
                    stars[1] = convertToString;
                    stringToInt =  Integer.parseInt(stars[1]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 12;
                    }
                    else if(firstOrSecondCard ==2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 12;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 13:
                    convertToString = Integer.toString(boardValues[0]);
                    stars[2] = convertToString;
                    stringToInt =  Integer.parseInt(stars[2]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 13;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 13;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 14:
                    convertToString = Integer.toString(boardValues[3]);
                    stars[3] = convertToString;
                    stringToInt =  Integer.parseInt(stars[3]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 14;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 14;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 21:
                    convertToString = Integer.toString(boardValues[4]);
                    stars[4] = convertToString;
                    stringToInt =  Integer.parseInt(stars[4]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 21;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 21;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 22:
                    convertToString = Integer.toString(boardValues[5]);
                    stars[5] = convertToString;
                    stringToInt =  Integer.parseInt(stars[5]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 22;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 22;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 23:
                    convertToString = Integer.toString(boardValues[6]);
                    stars[6] = convertToString;
                    stringToInt =  Integer.parseInt(stars[6]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 23;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 23;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 24:
                    convertToString = Integer.toString(boardValues[7]);
                    stars[7] = convertToString;
                    stringToInt =  Integer.parseInt(stars[7]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 24;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 24;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 31:
                    convertToString = Integer.toString(boardValues[8]);
                    stars[8] = convertToString;
                    stringToInt =  Integer.parseInt(stars[8]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 31;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 31;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 32:
                    convertToString = Integer.toString(boardValues[9]);
                    stars[9] = convertToString;
                    stringToInt =  Integer.parseInt(stars[9]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 32;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 32;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 33:
                    convertToString = Integer.toString(boardValues[10]);
                    stars[10] = convertToString;
                    stringToInt =  Integer.parseInt(stars[10]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 33;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 33;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 34:
                    convertToString = Integer.toString(boardValues[11]);
                    stars[11] = convertToString;
                    stringToInt =  Integer.parseInt(stars[11]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 34;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 34;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 41:
                    convertToString = Integer.toString(boardValues[12]);
                    stars[12] = convertToString;
                    stringToInt =  Integer.parseInt(stars[12]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 41;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 41;
                    }
                    else
                    {
                        System.out.println("An error occurred in displayBoardValues.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 42:
                    convertToString = Integer.toString(boardValues[13]);
                    stars[13] = convertToString;
                    stringToInt =  Integer.parseInt(stars[13]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 42;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 42;
                    }
                    else
                    {
                        System.out.println("An error occurred in evaluateCoordinates.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 43:
                    convertToString = Integer.toString(boardValues[14]);
                    stars[14] = convertToString;
                    stringToInt =  Integer.parseInt(stars[14]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 43;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 43;
                    }
                    else
                    {
                        System.out.println("An error occurred in evaluateCoordinates.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                case 44:
                    convertToString = Integer.toString(boardValues[15]);
                    stars[15] = convertToString;
                    stringToInt =  Integer.parseInt(stars[15]);
                    if(firstOrSecondCard == 1)
                    {
                        starOneTemp = stringToInt;
                        whereAmI1 = 44;
                    }
                    else if(firstOrSecondCard == 2)
                    {
                        starTwoTemp = stringToInt;
                        whereAmI2 = 44;
                    }
                    else
                    {
                        System.out.println("An error occurred in evaluateCoordinates.\nExiting program to prevent crash...");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("An error occurred during the switch statment in displayBoardValues.\nExiting program to prevent crash...");
                    System.exit(0);
                    break;
            }
        }

        //Need to display the board values when the user enters both guesses.
        System.out.println("    1  2  3  4");
        System.out.println("  ===============");
        System.out.println("1 |"+" "+stars[0]+"  "+stars[1]+"  "+stars[2]+"  "+stars[3]+" "+"|");
        System.out.println("2 |"+" "+stars[4]+"  "+stars[5]+"  "+stars[6]+"  "+stars[7]+" "+"|");
        System.out.println("3 |"+" "+stars[8]+"  "+stars[9]+"  "+stars[10]+"  "+stars[11]+" "+"|");
        System.out.println("4 |"+" "+stars[12]+"  "+stars[13]+"  "+stars[14]+"  "+stars[15]+" "+"|");
        System.out.println("  ===============\n");

        if(starOneTemp == starTwoTemp && starOneTemp != 20 && starTwoTemp != 20)
        {
            //Do nothing. Keep the board values the same.
        }
        else if(starOneTemp != starTwoTemp)
        {
            int j = whereAmI1;
            
            for(int k = 0; k <= 1; k++)
            {
                do
                {
                    switch(j)
                    {
                        case 11:
                            stars[0] = "*";
                            break;
                        case 12:
                            stars[1] = "*";
                            break;
                        case 13:
                            stars[2] = "*";
                            break;
                        case 14:  
                            stars[3] = "*";
                            break;
                        case 21:
                            stars[4] = "*";
                            break;
                        case 22:
                            stars[5] = "*";
                            break;
                        case 23:
                            stars[6] = "*";
                            break;
                        case 24:
                            stars[7] = "*";
                            break;
                        case 31:
                            stars[8] = "*";
                            break;
                        case 32:
                            stars[9] = "*";
                            break;
                        case 33:
                            stars[10] = "*";
                            break;
                        case 34:
                            stars[11] = "*";
                            break;
                        case 41:
                            stars[12] = "*";
                            break;
                        case 42:
                            stars[13] = "*";
                            break;
                        case 43:
                            stars[14] = "*";
                            break;
                        case 44:
                            stars[15] = "*";
                            break;
                        default:
                            System.out.println("whereAmI1: " + whereAmI1 + "\nwhereAmI2: " + whereAmI2 + "\n");
                            System.out.println("An error occured during the switch statment when comparing whereAmI1 and whereAmI2.\nExiting program to prevent crash...");
                            System.exit(0);
                    }
System.out.println("I made it to the end of the while loop.\nTerminating...");
System.out.println("The value of j1: " + j);


                    j = whereAmI2;

System.out.println("The value of j2: " + j);
System.exit(0);
                }
                while(k <= 1);
            }
        }
        else
        {
            System.out.println("starOneTemp: " + starOneTemp + "\nstarTwoTemp: " + starTwoTemp);
            System.out.println("An error occurred during when comparing starOneTemp and starTwoTemp in displayBoardValues.\nExiting program to prevent crash...");
            System.exit(0);
        }

        //Resets the following values. 
        if(firstOrSecondCard == 2)
        {
            guesses[0] = 0;
            guesses[1] = 0;
            firstOrSecondCard = 1;
            starOneTemp = 20;
            starTwoTemp = 20;
            haveBothGuesses = 0;
        }

    }
    
    //Erases the screen. Cheaters never prosper.
    public static void eraseScreen()
    {
        for(int x = 0; x <= 20; x++)
        {
            System.out.println();
        }
    }
}
/*
To Do:
-The random numbers somethimes generates duplicates look into this. 
-Fill in the displayBoardValues class.
-Show values of cards regardless if guess is wrong or right.
-Same board values generated evey time the program runs.
    Need to randomize.
-Fill in help docs. 
    -Inform the user how to enter cordinates.
-Save game data to a file.

Where you left off:
-------------------------
Just finished with the if else statemnt on switch statement in displayBoardValues(). Need to find a way
to reset the guesses cordinates if the board values don't match.

Also, I ran the program before I went to bed last night. A buch of errors with the if else statemnt I wrote.
It's becasue I comparing an int value with a string value with is what stars[x] is. Probally need to convert 
an int to be able to compair values.


DONE:
-----------


                        if(starOneTemp != starTwoTemp)
                        {
                            //Need to reset these cards because they don't match.
                            stars[15] = '*';
                        }

12/11/15 @ 11:43
"Press to Continue" keeps displaying after every prompt for the user to enter a guess. It even triggers when 
the program tries to print the board to the scren.


http://stackoverflow.com/questions/2258066/java-run-a-function-after-a-specific-number-of-seconds


*/