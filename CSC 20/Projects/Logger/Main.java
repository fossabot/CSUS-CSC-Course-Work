package Project1;

import java.util.Date;
public class Main {
	public static void main(String[] args) {

        Logger log = new Logger();
        
        log.add(new Date("4 Jan 2017, 13:00:00 PST"), "4");
        
        log.add(new Date("1 Jan 2017, 13:00:00 PST"), "1");
        
        log.add(new Date("3 Jan 2017, 13:00:00 PST"), "3");
        
        log.add(new Date("2 Jan 2017, 13:00:00 PST"), "2");

        System.out.println(log.toString());
	    
		//LoggerKrovetz log1 = new LoggerKrovetz();
		Logger log1 = new Logger();
        Logger log2 = new Logger();
        Logger log3 = new Logger();
         
        // Add a bunch of dates to test sorting and array expansion
        long ms = 10000000;
        for (int i = 0; i < 100; i++, ms-=1000) {
            log1.add(new Date(ms), "Test " + i);
            log2.add(new Date(ms), "Test " + i);
        }
        
        // Add length 50 string, should be okay
        log1.add("12345678901234567890123456789012345678901234567890"); 
        log2.add("12345678901234567890123456789012345678901234567890"); 
 
        // Add too long string, should throw exception and ignore
        try {
            log2.add("123456789012345678901234567890123456789012345678901");
            System.out.println("false");
            return;
        }
        catch (IllegalArgumentException e) {
            // Correct implementation should go here. We do nothing
        }
        catch (Exception e) {
            System.out.println("false");
            return;
        }
 
        // Add embedded newline string, should throw exception and ignore
        try {
            log2.add("Hello\nHello");
            System.out.println("false");
            return;
        }
        catch (IllegalArgumentException e) {
            // Correct implementation should go here. We do nothing
        }
        catch (Exception e) {
            System.out.println("false");
            return;
        }

        if ( ! log1.toString().equals(log2.toString()) ) {
            System.out.println("false");
            return;
       }
       
        // Add current date log
        log3.add("All tests passed!");
        System.out.println(log3);
	}
}