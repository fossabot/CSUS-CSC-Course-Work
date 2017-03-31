import java.util.*;

public class storyTelling
{
    public static void main(String[] args)
    {
        //Instalize the scanner.
        Scanner getInput = new Scanner(System.in);
        //Display the program header.
        displayHeader();   
        //Lets get the story started
        story(getInput);
    }
    
    public static void story(Scanner getInput)
    {
        System.out.print("What is your name? ");
        String usersName = getInput.nextLine();
        
        System.out.print("\nHello " + usersName + ". How many people are in your family? ");
        int numberOfFamilyMembers = getInput.nextInt();
        
        //Clear the input buffer.
        getInput.nextLine();
        
        System.out.print("\nShould I refer to you as a he or she? ");
        String heOrShe = getInput.nextLine();
        
        System.out.print("\nWhat are three of your favorite Halloween characters?\nCharacter 1: ");
        String halloweenCharacter1 = getInput.nextLine();
        System.out.print("\nCharacter 2: ");
        String halloweenCharacter2 = getInput.nextLine();
        System.out.print("\nCharacter 3: ");
        String halloweenCharacter3 = getInput.nextLine();
        
        System.out.print("\nWhat is the spookiest place you can think of? ");
        String spookeyPlace = getInput.nextLine();
        
        System.out.print("\nWhat is the address of the " + spookeyPlace + "? ");
        String spookeyPlaceAddress = getInput.nextLine();
        
        System.out.print("\nHow much does a hamburger at Mc Donalds cost? ");
        float mcDonaldsCost = getInput.nextFloat();
        
        //Clear the input buffer.
        getInput.nextLine();
        
        System.out.print("\nWhat is your favorite kind of candy? ");
        String favoriteCandy = getInput.nextLine();
        
        System.out.print("\nHow would you describe something that is very scary? ");
        String scaryDescription = getInput.nextLine();
        
        System.out.println("\n\nHere is your story:\n");
        
        System.out.print("Once upon a " + scaryDescription + "night, " + usersName + " went for a jog to the " + spookeyPlace + " at " 
        + spookeyPlaceAddress + ".\nWhen " + heOrShe + " got there " + heOrShe + " screamed when " + heOrShe + " saw a " + scaryDescription + " " + 
        halloweenCharacter1 + ".The " + halloweenCharacter1 + "was very friendly\nafter " + usersName + " gave it a " + favoriteCandy + "Then " + 
        halloweenCharacter1 + "the introduced " + usersName + " to his friends the " + halloweenCharacter2 + " \nand " + halloweenCharacter3 + ".The " +
        halloweenCharacter1 + " said that it had " + numberOfFamilyMembers + " more more friends if " + usersName + " wanted to meet them.\n" +
        usersName + " gave the " + halloweenCharacter1 + " $" + mcDonaldsCost + " and told the " + halloweenCharacter1 + "not to bring out his other friends. Then "
        + usersName + " ran away.");
        
    }
    
    public static void displayHeader()
    {
        System.out.println("================================================================");
        System.out.println("Welcome to storytelling by Marc Woodyard");
        System.out.println("You will be prompted to answer some questions");
        System.out.println("once you provide all the answers, a story will appear on the");
        System.out.println("screen.\n================================================================");

    }
}