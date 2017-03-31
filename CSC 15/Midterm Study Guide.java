/*  ___    ___         _____     
   |\  \  |\  \       / __  \    
 __\_\  \_\_\  \_____|\/_|\  \   
|\____    ___    ____\|/ \ \  \  
\|___| \  \__|\  \___|    \ \  \ 
    __\_\  \_\_\  \_____   \ \__\
   |\____    ____   ____\   \|__|
   \|___| \  \__|\  \___|        
         \ \__\ \ \__\           
          \|__|  \|__|           
*/
class GCD
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(gcd(45, 200));
    }
    
    public static int gcd(int a, int b) 
    {
        if (b == 0) 
            return a;
        else if(a == 0)
            return b;
        
        return gcd(b,a%b);
    }
}
/*  ___    ___         _______     
   |\  \  |\  \       /  ___  \    
 __\_\  \_\_\  \_____/__/|_/  /|   
|\____    ___    ____\__|//  / /   
\|___| \  \__|\  \___|   /  /_/__  
    __\_\  \_\_\  \_____|\________\
   |\____    ____   ____\\|_______|
   \|___| \  \__|\  \___|          
         \ \__\ \ \__\             
          \|__|  \|__|
*/
import java.util.*;

class RandomX
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Random rand = new Random();
        randomX(rand);
    }
    
    public static void randomX(Random rand) 
    {
        int randomNumber = 0;
        do
        {
            randomNumber = rand.nextInt(19 + 5) + 1;
            for(int i = 1; i <= randomNumber; i++)
            {
                System.out.print("*");
            } 
        } while(randomNumber < 16);  
    }
}
/*
    ___    ___       ________     
   |\  \  |\  \     |\_____  \    
 __\_\  \_\_\  \____\|____|\ /_   
|\____    ___    ____\    \|\  \  
\|___| \  \__|\  \___|   __\_\  \ 
    __\_\  \_\_\  \_____|\_______\
   |\____    ____   ____\|_______|
   \|___| \  \__|\  \___|         
         \ \__\ \ \__\            
          \|__|  \|__|                                   
*/
import java.util.*;

class RandomLines
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Random rand = new Random();
        randomLines(rand);
    }
    
    public static void randomLines(Random rand) 
    {
        int numberOfCharacter = 0;
        int numberOfLines = (10 + 5) + 1; 
        int letterNumber = 1;
        for(int i = 1; i <= numberOfLines; i++)
        {
            numberOfCharacter = rand.nextInt(80 + 1) + 1;
            for(int j = 1; j <= numberOfCharacter; j++)
            {
                letterNumber = rand.nextInt(26 + 1) + 1;
                switch(letterNumber)
                {
                    case 1:
                        System.out.print("a");
                        break;
                    case 2:
                        System.out.print("b");
                        break;
                    case 3:
                        System.out.print("c");
                        break;
                    case 4:
                        System.out.print("d");
                        break;
                    case 5:
                        System.out.print("e");
                        break;
                    case 6:
                        System.out.print("f");
                        break;
                    case 7:
                        System.out.print("g");
                        break;
                    case 8:
                        System.out.print("h");
                        break;
                    case 9:
                        System.out.print("i");
                        break;
                    case 10:
                        System.out.print("j");
                        break;
                    case 11:
                        System.out.print("k");
                        break;
                    case 12:
                        System.out.print("l");
                        break;
                    case 13:
                        System.out.print("m");
                        break;
                    case 14:
                        System.out.print("n");
                        break;
                    case 15:
                        System.out.print("o");
                        break;
                    case 16:
                        System.out.print("p");
                        break;
                    case 17:
                        System.out.print("q");
                        break;
                    case 18:
                        System.out.print("r");
                        break;
                    case 19:
                        System.out.print("s");
                        break;
                    case 20:
                        System.out.print("t");
                        break;
                    case 21:
                        System.out.print("u");
                        break;
                    case 22:
                        System.out.print("v");
                        break;
                    case 23:
                        System.out.print("w");
                        break;
                    case 24:
                        System.out.print("x");
                        break;
                    case 25:
                        System.out.print("y");
                        break;
                    case 26:
                        System.out.print("x");
                        break;
                    default:
                        System.out.print("t");
                        break;
                }
            }
            System.out.println();
        }
    }
} 
/*  ___    ___       ___   ___     
   |\  \  |\  \     |\  \ |\  \    
 __\_\  \_\_\  \____\ \  \\_\  \   
|\____    ___    ____\ \______  \  
\|___| \  \__|\  \___|\|_____|\  \ 
    __\_\  \_\_\  \_____     \ \__\
   |\____    ____   ____\     \|__|
   \|___| \  \__|\  \___|          
         \ \__\ \ \__\             
          \|__|  \|__|                      
*/
          
/*    _           _          
 __  /\ \        / /\         
/_/\_\ \_\      / /  \        
\ \__/\/_/_    / / /\ \       
 \/_/\/___/\  / / /\ \ \      
   /\/___ \ \/_/ /  \ \ \     
  / /_/ /_/ /\_\/    \ \ \    
  \ \_\ \_\/          \ \ \   
   \/_/                \ \ \  
                        \ \ \ 
                         \_\/ 
*/                              

/*    _          _          
 __  /\ \       / /\         
/_/\_\ \_\     / /  \        
\ \__/\/_/_   / / /\ \       
 \/_/\/___/\ /_/ /\ \ \      
   /\/___ \ \\ \ \_\ \ \     
  / /_/ /_/ / \ \/__\ \ \    
  \ \_\ \_\/   \_____\ \ \   
   \/_/         \ \ \_\ \ \  
                 \ \___\ \ \ 
                  \_______\/ 
*/
class Eequals
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String[] array1 = {"four", "score", "and", "seven", "ago", "ago"};
        String[] array2 = {"four", "score", "ago", "seven", "years", "ago"};
        String target = "ago";
        System.out.println(countStrings(array1, array2, target));
    }
    
    public static int countStrings(String[] a, String[]b, String target)
    {
        int occurances = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i].equalsIgnoreCase(target))
                occurances++;
        }
        
        for(int j = 0; j < b.length; j++)
        {
            if(b[j].equalsIgnoreCase(target))
                occurances++;
        }
        return occurances;
    }
}                          
/*    _          _          
 __  /\ \       / /\         
/_/\_\ \_\     / /  \        
\ \__/\/_/_   / / /\ \       
 \/_/\/___/\ /_/ /\ \ \      
   /\/___ \ \\ \ \_\ \ \     
  / /_/ /_/ / \ \/__\ \ \    
  \ \_\ \_\/   \_____\ \ \   
   \/_/               \ \ \  
                       \ \ \ 
                        \_\/ 
*/ 
class Eequals
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String[] array1 = {"four", "score", "and", "seven", "years", "ago"};
        String[] array2 = {"four", "score", "and", "seven", "years", "ago"};
        System.out.println(equals(array1, array2));
    }
    
    public static boolean equals(String[] a, String[]b)
    {
        if(a.length == b.length)
        {
            for(int i = 0; i < a.length; i++) 
            {
                if(!(a[i].equalsIgnoreCase(b[i])))
                    return false;
            }
            return true;
        }
        return false;
    }  
}                            
/*    _        _               _          
 __  /\ \     / /\            / /\         
/_/\_\ \_\   / /  \          / /  \        
\ \__/\/_/_ /_/ /\ \        / / /\ \       
 \/_/\/___/\\_\/\ \ \      / / /\ \ \      
   /\/___ \ \    \ \ \    /_/ /  \ \ \     
  / /_/ /_/ /     \ \ \   \ \ \   \ \ \    
  \ \_\ \_\/       \ \ \   \ \ \   \ \ \   
   \/_/           __\ \ \___\ \ \___\ \ \  
                 /___\_\/__/\\ \/____\ \ \ 
                 \_________\/ \_________\/ 
*/ 
import java.util.*;
class SwapPairs
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String[] phrase = {"four", "score", "and", "seven", "years", "ago"};
        swapPairs(phrase);
        System.out.println(Arrays.toString(phrase));
    }
    
    public static void swapPairs(String[] array)
    {
        String temp = "NaH";
        for(int i = 0; i < array.length - 1; i++)
        {
            temp = array[i + 1];
            array[i + 1] = array[i];
            array[i] = temp;
            i++;
        }
    }  
}                                 
/*    _        _           _              
 __  /\ \     / /\        / /\            
/_/\_\ \_\   / /  \      / /  \           
\ \__/\/_/_ /_/ /\ \    /_/ /\ \          
 \/_/\/___/\\_\/\ \ \   \_\/\ \ \         
   /\/___ \ \    \ \ \       \ \ \        
  / /_/ /_/ /     \ \ \       \ \ \       
  \ \_\ \_\/       \ \ \       \ \ \      
   \/_/           __\ \ \___  __\ \ \___  
                 /___\_\/__/\/___\_\/__/\ 
                 \_________\/\_________\/ 
*/ 
class EvenArray
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int [] numbers = {6, 2, 9, 11, 3};
        System.out.println(percentEven(numbers));
    }
    
    public static double percentEven(int[] array)
    {
        double count = 0.0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] % 2 == 0)
                count++;
        }
        return count / array.length * 100;
    }  
}
/* 			   _                _
 __  /\ \     / /\             /\ \      
/_/\_\ \_\   / /  \           /  \ \     
\ \__/\/_/_ /_/ /\ \         / /\ \ \    
 \/_/\/___/\\_\/\ \ \        \/_/\ \ \   
   /\/___ \ \    \ \ \           / / /   
  / /_/ /_/ /     \ \ \         / / /    
  \ \_\ \_\/       \ \ \       / / /  _  
   \/_/           __\ \ \___  / / /_/\_\ 
                 /___\_\/__/\/ /_____/ / 
                 \_________\/\________/  
*/
class ArrayUnique
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] list1 = {3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97, 10, 4};
        int[] list2 = {4, 7, 2, 3, 9, 12, -47, -19, 308, 3, 74};
        System.out.println(isUnique(list1)); //True
        System.out.println(isUnique(list2)); //False
    }

    public static boolean isUnique(int[] array) 
    {
        for(int i = 0; i < array.length; i++) 
        {
            for(int j = i + 1; j < array.length; j++)
            {
                if(array[i] == array[j])
                    return false;
            }
        }
        return true;
    }   
}