// This program processes data for the Keirsey Temperament Sorter (questions
// stored in survey.txt).Fall 2016, October

import java.io.*;
import java.util.*;

public class PersonalityTests {
    public static final int DIMENSIONS = 4;
    public static final String set1 ="1 8 15 22  29 36 43 50 57 64";
    public static final String set2 = "2 3 9 10 16 17 23 24 30 31 37 38 44 45 51 52 58 59 65 66";
    public static final String set3 = "4 5 11 12 18 19 25 26 32 33 39 40 46 47 53 54 60 61 67 68";
    public static final String set4= "6 7 13 14 20 21 27 28 34 35 41 42 48 49 55 56 62 63 69 70";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner input = userInput(console);
        PrintStream out = userOutput(console);
        process(input, out);
    }

    /*This method prompts the user for a file name that holds the information for this program 
    your program must keep asking for a file name that exists in the current directory
    console Scanner until the user gives a legal file name. this method returns the file object*/
    public static Scanner userInput(Scanner console) throws FileNotFoundException {
        
        try {
            System.out.print("Input file name with extention: ");
            File file = new File(console.nextLine());

            console = new Scanner(file);
			
            while (console.hasNextLine()) {
                String line = console.nextLine();
                System.out.println(line);
            }
            console.close();
        //What does this do?
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }       
        return  null;
    }

    /* This method prompts the user for an output file name so
    the result of this program can be written to it. 
    This method will keep prompting the user until we get a valid file name and returns the file object  */
    public static PrintStream userOutput(Scanner console) throws FileNotFoundException {
        System.out.print("Output file name: ");
        String name = console.nextLine();
        return new PrintStream(new File(name));
    }

    /* This method process the file that conatins  the information.
    the parameters to this method are the input file object and the output file object.
    this method reads the inforamtion for each person. the first line holds he name of
    the person and the next line holds the user's answers to the personality questions. 
    after reding the answers to the questions for the person, methods count and percent and personalityType
    must be called in this method*/ 
    public static void process(Scanner input, PrintStream out)
    {
    
    }

    /* Fills the aCount and bCount arrays with counts of how many
     As and Bs this person answered in each dimension. 
    the methods isInTheSet and output neeeds to be called in this method*/
    public static void count(PrintStream out, String answers, int[] aCount, int[] bCount)
    {
    }
    
    /*This method outputs the content of the array aCount
    and bCount to the output file. refer to the provided output file*/                         
    public static void output(PrintStream out ,int[] aCount, int[] bCount)
    { 
    }
    
    /*This method finds if the question number being processed is in the given set or not*/
    public static boolean inTheSet(String set, int num)
    {
        return false;
    }

    // uses the given A and B count arrays to compute and return
    // a new array of the percentage of B answers out of the (A+B) total
    // for each dimension
    public static int[] percents(PrintStream out, int[] aCount, int[] bCount) {
         
        return null;
    }

    // returns the personality type that corresponds to the given
    // percentages, such as "IXTJ"
    public static void personalityType(PrintStream out, int[] percents)
    {
    }
}