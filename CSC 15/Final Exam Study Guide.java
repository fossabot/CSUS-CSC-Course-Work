/*
1. Write a program that accepts a number from the user and returns a string representing the factorial
of that number. For example factorial(10) should return the string "9*8*7*6*5*4*3*2*1". factorial(-5)
should return an empty string.
*/
public class Final
{
    public static void main(String[] args)
    {
        factorial(10);
    }
    
    public static void factorial(int x)
    {
        while(x != 1)
        {]
            x--;
            System.out.print(x);
            if(x != 1)
            {
                System.out.print("*");
            }
        }
    }
}
/*
2. Write program that accepts a word containing the @ character as an input. If the word does not
contain an @ character, then your program should keep prompting the user for the word. When the
user enters the right word your program should output it on the screen.
*/
import java.util.Scanner;

public class Final
{
    static Scanner GetInput = new Scanner(System.in);
    static String userWord = "Not Set Yet";
    //0 = No / 1 = Yes
    static boolean done;
    public static void main(String[] args)
    {
        System.out.print("Enter a word: ");
        do
        {
            userWord = GetInput.nextLine();
            check(userWord);
        }
        while(done = true);
        System.exit(0);
    }
    
    public static void check(String x)
    {
        if(x.contains("@"))
        {
            System.out.println(x);
            done = true;
        }
        else
        {
            System.out.print("You did not enter a valid word. Please try again.\nEnter a word: ");
            done = false;
        }
    }
}

/*
3. Write a program that reads a sentence and output a message based on the last character in the sentence.
*/
public class sentenceType
{
    public static void main(String [] args)
    {
        String sentence = "Hello World!";
        check(sentence);
    }

    public static void check(String x)
    {
        if(x.contains("."))
        {
            System.out.println("declarative");
        }
        else if(x.contains("!"))
        {
            System.out.println("exclamatory");
        }
        else if(x.contains("?"))
        {
            System.out.println("interrogative");
        }
    }
}
/*
4. Write a program that accepts a temperature and outputs a probable season.
*/
public class thermometer
{
    public static void main(String[] args)
    {
        int temp = 35;
        checkTemp(temp);
    }

    public static void checkTemp(int x)
    {
        if(x > 110 || x < 0)
        {
            System.out.println("Invalid input.");
        }
        else if(x >= 90)
        {
            System.out.println("Summer");
        }
        else if(x < 90 && x > 70)
        {
            System.out.println("Spring");
        }
        else if(x < 70 && x > 50)
        {
            System.out.println("Fall");
        }
        else if(x <=50)
        {
            System.out.println("Winter");
        }

        else
        {
            System.out.println("Invalid input.");
        }
    }
}
/*
5. Write a method that accepts an array of double values and returns the percentage of the values above 90.
*/

public class adverage90
{
    static double[] grades = new double[] {89.5,75.6,99.9,93.2,105.1,106.8};
    
    public static void main(String[] args)
    {
        checkPercent(grades);
    }

    public static void checkPercent(double[] x)
    {
        //double[] above90 = new double[];

        double howManyValues = 0;
        double above90 = 0;
        double result;

        for(int i = 0; i < grades.length; i++)
        {
            if(x[i] > 90.0)
            {
                //above90[i] = x[i];
                above90++;
            }
            else
            {
                //Not above 90. So do nothing.
            }
            howManyValues++;
        }
        result = (above90 / howManyValues) * 100;
        System.out.println(result + "% of the values are above 90.");
    }
}
/*
6. Write a program that reads 7 different values from the keyboard that represents the Dow Jones Average for 7 days. 
Your program should output the lowest value for those seven days and the number of the days on which the lowest value 
occurred.
*/
import java.util.*;
public class Final
{
    static Scanner GetInput = new Scanner(System.in);
    static double[] adverage = new double[8];
    public static void main(String[] args)
    {
        for(int i = 0; i < adverage.length; i++)
        {
            System.out.print("Enter the adverage for day " + i + ": ");
            double userData = GetInput.nextDouble();
            adverage[i] = userData;
        }

        int arraryLength = adverage.length;
        
        double[] duplicateAdverage = new double[arraryLength];
        
        for(int j = 0; j < adverage.length; j++) 
        {
            duplicateAdverage[j] = adverage[j];
        }

        Arrays.sort(duplicateAdverage);

        int whichDay = 0;
        double lowestAdverage = 0;

        for(int k = 0; k < adverage.length; k++)
        {
            if(duplicateAdverage[0] == adverage[k])
            {
                whichDay = k;
                lowestAdverage = adverage[k];
            }
            else
            {
                //Do nothing and continue searching.
            }
        }
        System.out.println("The lowest Down Jones adverage occured on day " + whichDay + ". The adverage for that day was " + lowestAdverage);
    }
}
/*
7. write a method that accepts two arrays of String and return true if the two arrays are equal and return false otherwise.
Guessing the arrary values, not the array lengths.
*/
public class arrayEquals
{
    public static void main(String[] args)
    {
        String[] first = new String[] {"Hi"};
        String[] second = new String[] {"Hi"};

        checkStrings(first, second);
    }

    public static boolean checkStrings(String[] x, String[] y)
    {
        boolean result = false;
        if(x[0] == y[0])
        {
            result = true;
        }
        return result;
    }
}
/*
8. Write a method called allLess that accepts two arrays of integers and returns true if each element in the first array 
is less than the element at the same index in the second array. Your method should return false if the arrays are not the 
same length. 

For example, if the two arrays passed are {45, 20, 300} and {50, 41, 600}, your method should return true. If 
the arrays are not the same length, you should always return false.
*/
public class sameLength
{
    public static void main(String[] args)
    {
        int[] first = new int[] {1,2,3};
        int[] second = new int[] {2,4,6};

        allLess(first, second);   
    }

    public static boolean allLess(int[] x, int[] y)
    {
        boolean result = false;
        if(x.length == y.length)
        {
            result = true;
        }
        return result;
    }
}
/*
9. Write a method named swapPairs that accepts an array of strings as a parameter and switches the order of values in a pairwise fashion. 
Your method should switch the order of the first two values, then switch the order of the next two, switch the order of the next two, and 
so on. For example, if the array initially stores these values:

String[] a = {"four", "score", "and", "seven", "years", "ago"};

swapPairs(a);

Your method should switch the first pair ("four", "score"), the second pair ("and", "seven") and the third pair ("years", "ago"), to yield 
this array:

{"score", "four", "seven", "and", "ago", "years"
*/
//import java.util.*;
public class swapPairsProgram
{
    public static void main(String[] args)
    {
        String[] first = new String[] {"One", "Two", "Three", "Four"};
                                    //  Two    One    Four     Three

        swapPairs(first);
    }

    public static void swapPairs(String[] x)
    {
        String temp = x[0];

        for (int i = 0; i < 3; i+=2) 
        {
            String temp1 = x[i];
            String temp2 = x[i+1];
            x[i] = temp2;
            x[i+1] = temp1;
        }
    }
}
/*
10. Write a method isPalindrome that accepts an array of Strings as its argument and returns true if that array is 
a palindrome (if it reads the same forwards as backwards) and /false if not. 

For example, the array {"alpha", "beta", "gamma", "delta", "gamma", "beta", "alpha"} 

is a palindrome, so passing that array to your method would return true. Arrays with zero or one element are considered to be palindromes.
*/
import java.util.*;
public class Final
{
    public static void main(String[] args)
    {
        String[] first = new String[] {"First", "Second", "Four", "Fifth"};
        isPalindrome(first);
    }

    public static boolean isPalindrome(String[] x)
    {
        String[] temp = new String[x.length];

        for(int i = 0; i < x.length; i++)
        {
            temp[i] = x[i];
        }
        
        Collections.reverse(Arrays.asList(temp));

        boolean result = false;
        
        for(int k = 0; k < temp.length; k++)
        {
            if(x[k] == temp[k])
            {
                result = true;
            }
            else
            {
                result = false;
                k = temp.length;
            }
        }
    return result;
    }
}
/*
11. Write a method called mode that returns the most frequently occurring element of an array of integers. Assume that the array has at least 
one element and that every element in the array has a value between 0 and 100 inclusive. Break ties by choosing the lower value For example, 
if the array passed contains the values {27, 15, 15, 11, 27}, your method should return 15. 

(Hint: You may wish to look at the Tally program from earlier in this chapter to get an idea of how to solve this problem.)
*/
public class mostOccuring
{
    public static void main(String[] args)
    {
        int[] values = new int[] {1,2,2,3,3,3,3};
        mode(values);
    }

    public static int mode(int[] a)
    {

      int count = 1, tempCount;

      int popular = a[0];

      int temp = 0;

      for (int i = 0; i < (a.length - 1); i++)
      {

        temp = a[i];

        tempCount = 0;
        
        for (int j = 1; j < a.length; j++)
        {
          if (temp == a[j])

            tempCount++;
        }
        
        if (tempCount > count)
        {
          popular = temp;

          count = tempCount;
        }
      }

      return popular;
    }
}
/*
12. Write a method named minGap that accepts an integer array as a parameter and returns the minimum 'gap' between adjacent values in the array. 
The gap between two adjacent values in a array is defined as the second value minus the first value. For example, suppose a variable called array 
is an array of integers that stores the following sequence of values.

int[] array = {1, 3, 6, 7, 12};

The first gap is 2 (3 - 1), the second gap is 3 (6 - 3), the third gap is 1 (7 - 6) and the fourth gap is 5 (12 - 7). Thus, the call ofminGap(array) 
should return 1 because that is the smallest gap in the array. Notice that the minimum gap could be a negative number. For example, if array stores 
the following sequence of values:

{3, 5, 11, 4, 8}

The gaps would be computed as 2 (5 - 3), 6 (11 - 5), -7 (4 - 11), and 4 (8 - 4). Of these values, -7 is the smallest, so it would be returned.
*/
public class Hello_World
{
    public static void main(String[] args)
    {
        int[] data = {1, 3, 6, 7, 12};
        minGap(data);
    }
    public static int minGap (int[] x)
    {
        int calculate = 0;
        int[] values = new int[x.length];
        for(int i = 0; i < 4; i++)
        {
            calculate = x[i+1] - x[i];
            //System.out.println(calculate);
            values[i] = calculate;
        }

        int a, b;
        int temp;
        int sortTheNumbers = x.length - 1;

        for (a = 0; a < sortTheNumbers; ++a)
        {
            for (b = 0; b < sortTheNumbers; ++b)
            {
                if (values[b] < values[b + 1])
                {
                    temp = values[b];
                    values[b] = values[b + 1];
                    values[b + 1] = temp;
                }
            }
        }

        int result = values[3];
        return result;
    }
}
/*
13. Write a method called collapse that accepts an array of integers as a parameter and returns a new array containing the result of 
'replacing each pair of integers with the sum of that pair. 

For example, if an array called list stores the values {7, 2, 8, 9, 4, 13, 7, 1, 9, 10}, then the call of collapse(list) should 
return a new array containing {9, 17, 17, 8, 19}. 

The first pair from the original list is collapsed into 9 (7 + 2), the second pair is collapsed into 17 (8 + 9), and so on. If the list stores an 
odd number of elements, the final element is not collapsed. For example, if the list had been {1, 2, 3, 4, 5}, then the call would return 
{3, 7, 5}. Your method should not change the array that is passed as a parameter.
*/
public class Hello_World
{
    public static void main(String[] args)
    {
        int[] list = new int[] {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
        collapse(list);
    }

    public static int[] collapse(int[] x)
    {
        int calculate = 0;

        int[] storedValues = new int[5];
        int tempCounter = 0;
        for(int i = 0; i < 9; i++) 
        {
            storedValues[tempCounter] = x[i] + x[i + 1];
            tempCounter++;
            i++;
        }
        return storedValues;
    }
}
/*
14. Write a method called append that accepts two integer arrays as parameters and returns a new array that contains the result of appending the 
second array's values at the end of the first array. For example, if arrays list1 and list2 store {2, 4, 6} and {1, 2, 3, 4, 5} respectively, 
the call of append(list1, list2) should return a new array containing {2, 4, 6, 1, 2, 3, 4, 5}. If the call instead had been append(list2, list1), 
the method would return an array containing {1, 2, 3, 4, 5, 2, 4, 6}.
*/
public class Hello_World
{
    public static void main(String[] args)
    {
        int[] list1 = new int[] {2, 4, 6};
        int[] list2 = new int[] {1, 2, 3, 4, 5};
        append(list1, list2);
    }

    public static int[] append(int[] x, int[] y)
    {
        int[] appendArray = new int[x.length + y.length];

        int tempCounter = 0;

        for(int i = 0; i < appendArray.length; i++)
        {
            if(i < x.length)
            {
                appendArray[i] = x[i];
            }
            else
            {
                appendArray[i] = y[tempCounter];
                tempCounter++;

            }
        }

        return appendArray;
    }
}
/*
15. Write a method named gcd that accepts two integers as parameters and returns the greatest common divisor of the two numbers. The greatest 
common divisor (GCD) of two integers a and b is the largest integer that is a factor of both a and b. The GCD of any number and 1 is 1, and 
the GCD of any number and 0 is that number.One efficient way to compute the GCD of two numbers is to use Euclid's algorithm, which states the 
following:

GCD(A, B) = GCD(B, A % B) GCD(A, 0) = Absolute value of A

In other words, if you repeatedly mod A by B and then swap the two values, eventually B will store 0 and A will store the greatest common divisor.

For example: gcd(24, 84) returns 12, gcd(105, 45) returns 15, and gcd(0, 8) returns 8
*/
public class Hello_World
{
    public static void main(String[] args)
    {
        int first = 105;
        int second = 45;
        GCD(first, second);
    }

    public static int GCD(int a, int b)
    {
        if (b==0)
        {
            return a;
        }
        return GCD(b,a%b);
    }
}
            /*
            16. Write a method named swapDigitPairs that accepts an integer n as a parameter and returns a new integer whose value 
            is similar ton's but with each pair of digits swapped in order. For example, the call of swapDigitPairs(482596) would 
            return 845269. Notice that the 9 and 6 are swapped, as are the 2 and 5, and the 4 and 8. If the number contains an odd 
            number of digits, leave the leftmost digit in its original place. For example, the call of swapDigitPairs(1234567) 
            would return 1325476. Do not use the String class to solve this problem.
            */

import java.util.Arrays;
public class Hello_World
{
    public static void main(String[] args)
    {
        System.out.print(swapDigitPairs(1234567));
    }

    public static int swapDigitPairs(int x)
    {
        String temp = Integer.toString(x);

        int[] newGuess = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }

        Arrays.toString(newGuess);
        Integer.parseInt(newGuess[0]);


        return newGuess[0];
    }
}

/*
17. What does this code do?
*/
import java.awt.*;
public class ReferenceMystery3 
{
    public static void main(String[] args) 
    {
        int a = 7;
        int b = 9;
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        addToXTwice(a, p1);
        System.out.println(a + " " + b + " " + p1.x + " " + p2.x);
        addToXTwice(b, p2);
        System.out.println(a + " " + b + " " + p1.x + " " + p2.x);
    }

    public static void addToXTwice(int a, Point p1) 
    {
        a = a + a;
        p1.x = a;
        System.out.println(a + " " + p1.x);
    }
}

Output: 
14 14
7 9 14 2
18 18
7 9 14 18

/*
18. Write a class called BankAccount with following instance variables:

private String id;
private double balance;
private int transactions;

include constructor, accessors, mutators, equals, toString, deposit, withdraw, close. For each method must make your own restrictions.
*/
















