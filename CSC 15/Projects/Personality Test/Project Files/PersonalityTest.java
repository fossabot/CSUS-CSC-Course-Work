/********************************************************************************************************
*Program Name: Personality Type Program                                                                 *
*Description: Tells the user what personality type they are based on an imported data file.             *
*Author: Marc Woodyard                                                                                  *
*Class: CSC-15 TuTh 12:00pm                                                                             *
*Teacher: Gita Faroughi                                                                                 *
*********************************************************************************************************/
import java.io.*;
import java.util.*;

public class PersonalityTest {
	public static final int[] INTROVERTEXTROVERT = {0, 7, 14, 21, 28, 35, 42, 49, 56, 63};
    public static final int[] SENSINGINTUITION = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30, 36, 37, 43, 44, 50, 51, 57, 58, 64, 65};
    public static final int[] THINKINGFEELING =  {3, 4, 10, 11, 17, 18, 24, 25, 31, 32, 38, 39, 45, 46, 52, 53, 59, 60, 66, 67};
    public static final int[] JUDGINGPERCEIVING = {5, 6, 12, 13, 19, 20, 26, 27, 33, 34, 40, 41, 47, 48, 54, 55, 61, 62, 68, 69};
    public static char[] fileData = new char[70];
    public static int[] percentValues = new int[5];
    public static char[] personalityType = new char[4];
    public static double numberA = 0.0;
    public static double numberB = 0.0; 

    public static void main(String[] args) throws FileNotFoundException {
    	//Display the program description.
    	programDescription();
        //Instalize the scanner.
        Scanner console = new Scanner(System.in);
        //Grab the program data from the file.
        Scanner dataFile = getDataFile(console);
        //Get the output file name from the user.
        PrintStream outputFileName = outputFile(console);
        //Crunch the numbers to get the personality type.
        inputOutputData(dataFile, outputFileName);
    }
    
    //Display the program description.
    public static void programDescription() {
		System.out.println("This program processes a data file on your desktop that contains answers\nto the Keirsey Temperament "
				+ "Sorter personality test and outputs the user's\nfour-letter personality type to a file.\n");
    }
    
    //Get the data file location from the user and make sure it's valid.
    public static Scanner getDataFile(Scanner console) throws FileNotFoundException {
    	File dataFile;
    	boolean fileExists = false;

    	do {
    		System.out.println("Data File Upload:\n------------------");
	    	System.out.print("Enter data file name: ");
	    	dataFile = new File(System.getProperty("user.home") + "/Desktop/" + console.nextLine());
	    	if(dataFile.exists())
	    		fileExists = true;
	    	else
	    		System.out.println("[Program] UPLOAD FAILED! File not found. Make sure the data file is\non your desktop"
	    				+ "and you included the file type (file.txt).\n");
    	} while(fileExists == false);
    	
    	System.out.println("[Program] Data imported successfully!\n");
    	
    	return new Scanner(dataFile);  
    }

    //Ask the user what the output file name should be called, then create the file.
    public static PrintStream outputFile(Scanner console) throws FileNotFoundException {
    	String outputFileName;
    	boolean validFile = false;
    	
    	do {
    		System.out.println("Save Personalty Type Data:\n-------------------------------");
    		System.out.print("Enter the output file name: ");
            outputFileName = console.nextLine();
            if(outputFileName.contains(".txt"))
            	validFile = true;
            else
            	System.out.println("[Program] SAVE FAILED! Not a valid file type. Make sure you include \nthe file type (file.txt).\n");
    	} while(validFile == false);
    	
    	System.out.println("[Program] File saved successfully!\n");

        return new PrintStream(System.getProperty("user.home") + "/Desktop/" + outputFileName);
    }

    //Process data and write it to the output file.
    public static void inputOutputData(Scanner dataFromFile, PrintStream writer) {
        	while(dataFromFile.hasNext()) {
    		//Get the user's name.
    		String name = dataFromFile.nextLine();
    		//Get the user's answers.
    		String dataValues = dataFromFile.nextLine();
    		//Sanitize the data and put it into an array.
    		sanitizeDataToArray(dataValues);
            //Print the user's name to the file.
    		writer.println(name + ":");
    		//Analyze the data to determine personality type.
    		for(int i = 4; i >= 1; i--) {
                //Sort throught the data.
    			analyzeData(i);
                //Convert numberA and numberB to an int to loose the decimal.
    			int aNumber = (int) numberA;
    			int bNumber = (int) numberB;
                //Write the results to the file.
    			writer.print(aNumber + "A-" + bNumber + "B ");
                //Calculate the the "b" percentage of answers.
                calculatePercents(i);
                //Get the personality type.
                getType(i);
                //Reset the values and analyze the next set of answers.
                numberA = 0.0;
                numberB = 0.0;
    		}

    		writer.println("");
    		//Write percentages.
            writer.print("[" + percentValues[4] + "%, " + percentValues[3] + "%, "
            		+ percentValues[2] + "%, " + percentValues[1] + "%]");

    		//Write personality type.
    		writer.print(" = " + personalityType[3] + personalityType[2] + personalityType[1] +
    				personalityType[0]);
    		writer.println("");
    		writer.println("");
    	}
        //Close the file.
        writer.close();	
    }
    
    //Check the data for a, b, -. Then put it in a char array.
    public static void sanitizeDataToArray(String dataToProcess) {
    	for(int i = 0; i < fileData.length; i++) {
    		char letterAtIndex = dataToProcess.charAt(i);   		
    		switch (letterAtIndex) {
    		case 'A':
    		case 'B':
    		case 'a':
    		case 'b':
    			letterAtIndex = Character.toLowerCase(letterAtIndex);
    			fileData[i] = letterAtIndex;
    			break;
    		//Answer left blank.
    		case '-':
    			fileData[i] = letterAtIndex;
    			break;
    		default:
    			System.out.println("\n[Program] ERROR! An error occured while reading the data file."
						+ " Make sure the line of data only contains \"a\", \"b\", or \"-\" characters.");
				System.exit(0);
    		}
    	}
    }

    //Sort through the data.
    public static void analyzeData(int currentPersonalityType) {
    	int numberOfQuestions = 0;
    	//What personality type are we testing for?
    	switch(currentPersonalityType) {
	    	case 4:
	    		numberOfQuestions = INTROVERTEXTROVERT.length;
	    		break;
	    	case 3:
	    		numberOfQuestions = SENSINGINTUITION.length;
	    		break;
	    	case 2:
	    		numberOfQuestions = THINKINGFEELING.length;
	    		break;
	    	case 1:
	    		numberOfQuestions = JUDGINGPERCEIVING.length;
	    		break;
	    	default:
	    		System.out.println("\n[Program] Error at analyzeData switch.");
				System.exit(0);	
                break;
    	}
    	
        //Get the question number.
    	for(int i = 0; i < numberOfQuestions; i++) {
    		int currentQuestion = 0;
    		if(currentPersonalityType == 4)
    			currentQuestion = INTROVERTEXTROVERT[i];
    		else if(currentPersonalityType == 3)
    			currentQuestion = SENSINGINTUITION[i];
    		else if(currentPersonalityType == 2)
    			currentQuestion = THINKINGFEELING[i];
    		else if(currentPersonalityType == 1)
    			currentQuestion = JUDGINGPERCEIVING[i];
    		else {
    			System.out.println("\n[Program] Error at analyzeData for loop.");
				System.exit(0);	
    		}
    		
            //Get the user's response.
			char dataResult = fileData[currentQuestion];

    		if(dataResult == 'a')
    			numberA++;
    		else if(dataResult == 'b')
    			numberB++;
    	}
    }  

    //Calculate the personality type percentage.
    public static void calculatePercents(int currentPersonalityType) {
    		double calculate = (numberB / (numberA + numberB) * 100.0);
    		percentValues[currentPersonalityType] = (int) calculate;
    }

    //Determine the personality type.
    public static void getType(int currentPersonalityType) {
    	switch(currentPersonalityType) {
    		case 4:
    			if(numberA > numberB)
    				personalityType[3] = 'E';
    			else
    				personalityType[3] = 'I';
    			if(numberA == numberB)
    				personalityType[3] = 'X';
    			break;
    		case 3:
    			if(numberA > numberB)
    				personalityType[2] = 'S';
    			else
    				personalityType[2] = 'N';
    			if(numberA == numberB)
    				personalityType[2] = 'X';
    			break;
    		case 2:
    			if(numberA > numberB)
    				personalityType[1] = 'T';
    			else
    				personalityType[1] = 'F';
    			if(numberA == numberB)
    				personalityType[1] = 'X';
    			break;
    		case 1:
    			if(numberA > numberB)
    				personalityType[0] = 'J';
    			else
    				personalityType[0] = 'P';
    			if(numberA == numberB)
    				personalityType[0] = 'X';
    			break;
    	}
    }
}