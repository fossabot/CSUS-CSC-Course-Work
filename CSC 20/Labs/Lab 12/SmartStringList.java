package Lab12;

import java.util.ArrayList;

public class SmartStringList {

    private ArrayList<String> list;
    private boolean           sorted         = true;
    private int               previousLength = 0;

    /**
     * Create a SmartStringList object.
     * @params - int specifies the initial capacity of the list.
     * @returns - None
     */
    public SmartStringList(int capacity) {
        ArrayList<String> list = new ArrayList<String>(capacity);
        this.list = list;
    }

    public void add(String s) {
        //A newly added element is smaller than the old last element, time to sort!
        if (this.previousLength > s.length() && this.list.size() != 0) {
            this.sorted = false;
        }

        this.list.add(s);

        if (this.sorted = false)
            this.sort();

        this.previousLength = s.length();
    }

    /**
     * Returns a string at a given index.
     * @params int - locaiton of String in list.
     * @returns String - String at passed index.
     */
    public String get(int i) {
        return this.list.get(i);
    }

    /**
     * Returns the location of a string in the list.
     * @params String - Target String to search for.
     * @returns int - Location of String in list. 
     */
    public int indexOf(String s) {

        //Binary Search.
        if (this.sorted == true) {
            int low = 0;
            int mid = (this.list.size() - 1) / 2;
            int high = this.list.size() - 1;

            //Lets find our direction.

            //Search first half of list.
            if (this.get(mid - 1).length() > s.length()) {
                for (int i = this.get(mid - 1).length(); i >= 0; i--) {
                    if (this.get(i).equalsIgnoreCase(s))
                        return i;
                }
            }

            //Search second half of list.
            else if (this.get(mid - 1).length() < s.length()) {
                for (int i = this.get(mid - 1).length(); i <= this.list.size(); i++) {
                    if (this.get(i).equalsIgnoreCase(s))
                        return i;
                }
            }
        }

        //Linear Search.
        else if (this.sorted == false) {
            for (int i = 0; i < this.list.size() - 1; i++) {
                if (this.get(i).equalsIgnoreCase(s))
                    return i;
            }

            this.sort();
        }

        //Element doesn't exist.
        return -1;
    }

    /**
     * Sorts the list by String size.
     * @params - None
     * @returns - None
     */
    public void sort() {

        //Selection sort.
        int counter = this.list.size();
        int place = 0;
        String temp = "NaH";

        for (int i = 0; i < this.list.size(); i++) {
            if (this.get(i).length() > this.get(i + 1).length()) {
                temp = this.get(i);
            }

            //Lets reset.
            if (i == this.list.size() - 1) {
                this.list.add(place, temp);
                place++;
                counter--;
                i = 0;
            }
        }

        this.sorted = true;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        SmartStringList a = new SmartStringList(10);
        
        a.add("Welcome");
        a.add("to");
        a.add("CSUS");
        
        a.sort();
    }
}
