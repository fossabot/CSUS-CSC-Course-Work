package Word;

public class Word implements Comparable<Word> {
    private int count;
    private String word;
    
    // Construct a Word, initialize counter to 1
    public Word(String word) {
        this.count = 1;
        this.word = word;
    }  
    
    // Return the word contained in the object
    public String getWord() {
        return this.word;
    }
    
    // Return the number of times the word has been counted
    public int getCount() {
        return this.count;
    }
    
    // Increment counter by 1
    public void increment() {
        this.count++;
    }
    
    // return negative,0,positive based on counter (return num time word has been sceen)
    public int compareTo(Word other) {
        if(this.count > other.getCount()) {
            return 1;
        }
        else if(this.count == other.getCount()) {
            return 0;
        }
        else {
            return -1;
        }
    }

    // return "word (counter)" 
    public String toString() {
        return this.word;
    }   
}