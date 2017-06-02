package Word;

import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args){
        ArrayList<Word> wordList = new ArrayList();
        System.out.println("Running...");
        Scanner in = null;
        try {
            in = new Scanner(new File("src/main/java/Word/hamlet.txt"));
            
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        while (in.hasNext()) {
            String word = in.next();
            word = word.replaceAll("[^a-zA-Z0-9]+", "");
            word = word.toUpperCase();
            Word a = new Word(word);
            wordList.add(a);
            
            for(int i = 0; i < wordList.size(); i ++){
                if(a.getWord().equals(wordList.get(i).getWord()))
                a.increment();
                Collections.sort(wordList);
                System.out.println("Sorted one word!");
            }          
        }
        System.out.println(wordList);
        //ArrayList wordList2 = new ArrayList();
        Collections.sort(wordList);
        System.out.println(wordList);
/*        for(int i = 0; i < 10; i++) {
            word = wordList.get(i);
            System.out.print(word.getWord() + " ");
            System.out.println("(" + word.getCount() + ")");
        }
        */

    }
}

/*   res = ""
   for each character c in s
      if (Character.isLetter(c))
         res = res + Character.toUpperCase(c)
   return res
   
   
 * public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner input = getInput(console);
        PrintStream out = getOutput(console);
        process(input, out);
    }
    
    
 * public static Scanner getInput(Scanner console) throws FileNotFoundException {
      String fileName = "";
      boolean flag = false;
      while(flag==false)
      {
        System.out.println("enter file name: ");
        fileName = console.nextLine();
        try{
          console = new Scanner(new File(fileName));
          if(console!=null)
          {
            flag = true;
          }
        }
        catch(FileNotFoundException e){
          System.out.println("Illegal file name error");
          flag=false;
          System.out.println("try again...");
        }
      }
      return console;
    }
 * 
 */



            //word = word.replaceAll("[.;!?-]", "");
            
            /*
            if(word.contains("'")) 
                word = word.replace("'", ""); 
            else if(word.contains("."))
                word = word.replace(".", ""); 
            else if(word.contains(","))
                word = word.replace(",", ""); 
            else if(word.contains(";"))
                word = word.replace(";", ""); 
            else if(word.contains("-"))
                word = word.replace("-", ""); 
            else if(word.contains("-"))
                word = word.replace("-", ""); 
                
                */








