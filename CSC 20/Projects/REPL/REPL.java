import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("unchecked")

public class REPL {
	public static void main(String[] args) {
		System.out.println("Welcome to Circuit Master 2000");
		Scanner kb = new Scanner(System.in);
		GateOutput out = null;
		String response = "";
		HashMap<String, GateInputSingle> map = new HashMap<String, GateInputSingle>();
		do {
			System.out.print(">");
			response = kb.nextLine();
			if(!(response.equalsIgnoreCase("exit")))
				verify(response, map, out);
		} while(response.equalsIgnoreCase("exit") == false);
		System.out.println("Goodbye!");
	    kb.close();
	    System.exit(0);
	}
	
	public static void verify(String x, HashMap map, GateOutput out) {
		if(x.contains("=") && map.isEmpty() == true) 
			System.out.println("error");
			
		else if(x.contains("=") && map.isEmpty() == false) {
		    
			if(x.contains("true"))
			    map.put(x.charAt(0), true);
			
			else if(x.contains("false"))
				map.put(x.charAt(0), false);
				
			System.out.println(out.output());
		}

		else {
			out = CircuitBuilder.buildCircuit(CircuitBuilder.toPostfix(x), map);
			System.out.println(out.output());
		}
	}
}