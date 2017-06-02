package Project1;
/**The Logger class keeps track of an array of dates and log
*  enteries that are passed to the class through parameters.
*
* @author Marc Woodyard
* @version Feb 27 2017
*/ 
import java.util.Date;
import java.util.Arrays;

public class Logger {
	//Instance Variables
	private String[] info; 
	private Date[] time;
	private int elements;
	private int position;

	//Initialize logger.
	public Logger() {
		this.info = new String[32];
		this.time = new Date[32];
		this.elements = 0;
		this.position = 0;
	}
	
	/**
	 *Adds a string element to the array with a custom timestamp 
	 *that the user specifies.
	 *@param A string representing the information that the user 
	 *		 would like to store. 
	 *@return None
	 */
	public void add(Date date, String info) {
		//Check if Array is Full
		if(this.info[this.info.length - 1] == null && 
		   this.time[this.time.length - 1] == null) {
			//Not full, continue...
		} else {
			//Full, copy array and pass a new memory location back.
			this.info = Arrays.copyOf(this.info, this.info.length * 2);
			this.time = Arrays.copyOf(this.time, this.time.length * 2);
		}	
		
		//Check if info contains \n, is longer than 50 characters.
		if(info.contains("\n") || info.length() > 50)
			throw new IllegalArgumentException();
		
		//Check if string is blank.
		if(info.length() == 0)
			info = "\"\"";
			
		//Sort array elements by date.
		//Search backwards through array to avoid nullPointers.
        for(this.position = this.elements; this.position > 0 && 
        this.time[this.position - 1].compareTo(date) > 0; this.position--) {
            //Move log enteries to make space for current one.
            this.info[this.position] = this.info[this.position - 1];
            this.time[this.position] = this.time[this.position - 1];

        }
        
        //Keep track of how many log elements we have.
        this.elements++;

        //Add the data to the array.
        this.info[this.position] = info;
        this.time[this.position] = date;
	}

	/**
	 *Adds a string element to the array with the current timestamp when the method was called.
	 *@param A string representing the information that the user would like to store. 
	 *@return None
	 */
	public void add(String info) {
        this.add(new Date(), info);
    }
	
	/**
	 *Outputs the log elements in order as a String.
	 * @param None
	 * @return A string representing all of the log elements and timestamps sorted by date (oldest first).
	 */
	public String toString() {
		String result = "";
		for(int i = 0; i < time.length; i++) {
			if(info[i + 1] == null || time[i + 1] == null) {
				result = result.concat(time[i] + ": " + info[i]);
				break;
			}
			result = result.concat(time[i] + ": " + info[i] + "\n");
		}
		return result;
	}	
}