import java.util.Scanner;
class BirthdayShell {
    
    public static void main(String[] args ) {
        Scanner kb = new Scanner(System.in);
        description();
        //Used to determine how many times the program will repeat.
        System.out.print("How many times do you to use this software? ");
        
        int useSoftware = kb.nextInt();
        
        for(int i = 1; i <= useSoftware; i++) {
            play(kb);
        }
    }

    public static void play(Scanner kb) {
        System.out.print("\nWhat is your name? ");
        //Clear the input buffer.
        kb.nextLine();
        String name = kb.nextLine();
        System.out.println("\nHi " + name + ". Please answer the following questions so I can guess your birthday.");
        
        int birthday = 0;
        int tempBirthday = 0;
        
        for(int i = 1; i <= 5; i++) {
            if(i == 1) {
                tempBirthday = askQuestion("set1", kb, birthday);
                birthday = tempBirthday + birthday;
            } else if(i == 2) {
                tempBirthday = askQuestion("set2", kb, birthday);
                birthday = tempBirthday + birthday;
            } else if(i == 3) {
                tempBirthday = askQuestion("set3", kb, birthday);
                birthday = tempBirthday + birthday;
            } else if(i == 4) {
                tempBirthday = askQuestion("set4", kb, birthday);
                birthday = tempBirthday + birthday;
            } else if(i == 5) {
                tempBirthday = askQuestion("set5", kb, birthday);
                birthday = tempBirthday + birthday;
            }
        }
        
        System.out.println("Your birthday is on the " + birthday + ".");
        System.out.println("Did I guess it right? (Yes/No) ");
        String guessedRight = kb.nextLine();
        
        if(guessedRight.equalsIgnoreCase("yes"))
            System.out.println("Yessss I guessed it right!!!!!");
        else
            System.out.println("Awww...");
    }
    
    public static int askQuestion(String set, Scanner kb, int birthday) {
        
        int tempBirthday = 0;
        
        String set1Answer = "NaH";
        String set2Answer = "NaH";
        String set3Answer = "NaH";
        String set4Answer = "NaH";
        String set5Answer = "NaH";
        
        if(set.equalsIgnoreCase("set1")) {
            set1Answer = set1(kb);
            if(set1Answer.equalsIgnoreCase("yes"))
                tempBirthday = birthday + 1;
        }
        else if(set.equalsIgnoreCase("set2")) {
            set2Answer = set2(kb); 
            if(set2Answer.equalsIgnoreCase("yes"))
                tempBirthday = birthday + 2;
        }
        else if(set.equalsIgnoreCase("set3")) {
            set3Answer = set3(kb);
            if(set3Answer.equalsIgnoreCase("yes"))
                tempBirthday = birthday + 4;
        }
        else if(set.equalsIgnoreCase("set4")) {
            set4Answer = set4(kb);
            if(set4Answer.equalsIgnoreCase("yes"))
                tempBirthday = birthday + 8;
        }
        else if(set.equalsIgnoreCase("set5")) {         
            set5Answer = set5(kb);
            if(set5Answer.equalsIgnoreCase("yes"))
                tempBirthday = birthday + 16;
        }
        
        return tempBirthday;
    }  
    
    public static String set1(Scanner kb) { 
        String days = " 1  3  5  7 9 11 13 15 17 19 21 23 25 27 29 31";
        displayDays(days);
        String answer = kb.nextLine();
        return answer;          
    }

    public static String set2(Scanner kb) {              
        String days = " 2  3  6  710 11 14 15 18 19 22 23 26 27 30 31";
        displayDays(days);
        String answer = kb.nextLine();
        return answer;
    }
    
    public static String set3(Scanner kb) {  
        String days = " 4  5  6  712 13 14 15 20 21 22 23 28 29 30 31";
        displayDays(days);
        String answer = kb.nextLine();
        return answer;          
    }

    public static String set4(Scanner kb) {              
        String days = " 8  9 10 1112 13 14 15 24 25 26 27 28 29 30 31";
        displayDays(days);
        String answer = kb.nextLine();
        return answer;
    }
    
    public static String set5(Scanner kb) {              
        String days = "16 17 18 1920 21 22 23 24 25 26 27 28 29 30 31";
        displayDays(days);
        String answer = kb.nextLine();
        return answer; 
    }
    
    public static void displayDays(String days) {
        System.out.println("\n" + days.substring(0, 11));
        System.out.println(days.substring(11, 22));
        System.out.println(days.substring(23, 34));
        System.out.println(days.substring(35, 46));
        System.out.println("\nIs your birthday in this set? (Yes/No): ");
    }
          
    public static void description() {
        System.out.println("*****************************************");
        System.out.println("Welcome to Birthday Guessing website by your name");
        System.out.println("You will be prompted to answer five questions");
        System.out.println("Then computer will guess your birthday");
        System.out.println("*******************************************");
    }                     
}