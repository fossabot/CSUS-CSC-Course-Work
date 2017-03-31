//Jessica Wicksnin
//March 5, 2013


//This program takes a user-provided input file and produces an output file.  The output file
//gives the results of the Keirsey Temperament Sorter per person found in the input file.
//By providing an input file with the answers to 70 questions for a number of people, 
//the user can find each person's four-dimension personality type.

import java.util.*;
import java.io.*;

public class Personality {
	public static final int dimensions = 4; //the number of personality dimensions can be changed

	public static void main(String[] args) throws FileNotFoundException {
		intro();
		Scanner console = new Scanner(System.in);
		Scanner input = getInput(console); // prompts user for the input file name
		System.out.print("output file name? ");
		PrintStream output = new PrintStream(console.nextLine()); // prompts user for output file name
		while (input.hasNextLine()) { //goes through all the lines of the input file
			String line = findLine(console, input, output);
			int[] infp = new int[dimensions];
			char charBig = 'B';
			char charSmall = 'b';
			findBs(line, infp, charBig, charSmall);
			int[] estj = new int[dimensions];
			charBig = 'A';
			charSmall = 'a';
			findBs(line, estj, charBig, charSmall);
			int[] count = new int[dimensions];
			findTotalAandB(infp, estj, count);
			String personality = findPersonality(count);
			output.print(Arrays.toString(count) + " = " + personality); //prints results
			output.println();
		}
	}

	//This method introduces the user to the program, how it works, and the expected output
	public static void intro(){  
		System.out.println("This program processes a file of answers to the");
		System.out.println("Keirsey Temperament Sorter.  It converts the");
		System.out.println("various A and B answers for each person into");
		System.out.println("a sequence of B-percentages and then into a");
		System.out.println("four-letter personality type.");
		System.out.println();
	}
	
	//This method finds the input file name 
	public static Scanner getInput(Scanner console) throws FileNotFoundException {
		System.out.print("input file name? ");
		File f = new File(console.nextLine());
		return new Scanner(f);
	}
	
	//This method locates the line in the input file which contains the quiz answers
	public static String findLine(Scanner console, Scanner input, PrintStream output) {
		String name = input.nextLine();
		output.print(name + ": ");
		String line = input.nextLine();
		return line;
	}
	
	//This method calculates the number of "b" or "B" answers per line
	public static void findBs(String line, int[] type, char charBig, char charSmall) {
		for (int i = 0; i < 64; i = i + 7) { 
  			for (int j = 0; j < 7; j++) {
				if (line.charAt(j + i) == charBig || line.charAt(j + i)  == charSmall) {
 					if (j == 0) {
					type[0]++;
					} else if (j == 1 || j == 2) {
					type[1]++;
					} else if (j == 3 || j == 4) {
					type[2]++;
					} else if (j == 5 || j == 6) {
					type[3]++;
					}
				}
			}
		} 				
	}
 			
	//This method finds the total of non-blank (dash) answers and finds the percent of "B/b" answers
	public static void findTotalAandB(int[] infp, int[] estj, int[]count) {
		for (int i = 0; i < count.length; i++) {
		double math = (infp[i] * 100.0 / (infp[i] + estj[i]));
		int percent = (int) Math.round(math);
		count[i] = percent;
		}
	}
	
	//This method assigns a four-dimension personality type based on the percent of "b/B" answers
	public static String findPersonality(int[] count) {
		String type1 = "INFP";
		String type2 = "ESTJ";
		String type = "";
		for (int i = 0; i < type1.length(); i++) {
			if (count[i] > 50) {
				type = type + type1.charAt(i);
			} else if (count[i] < 50) {
				type = type + type2.charAt(i);
			} else type = type + 'X';
 		}
		return type;
	}
}