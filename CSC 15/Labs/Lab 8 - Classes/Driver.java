public class driver {
	public static void main(String[] args) {
		//Constructor 1.
		Stock intel = new Stock("INTC", 34.30, 35.31, 500);
		Stock google = new Stock("GOOGL", 790.89, 789.44, 10);
		Stock microsoft = new Stock("MSFT", 65.71, 61.09, 50);
		
		//No argument constructor.
		Stock twitter = new Stock();
		
		//Prints memory location.
		//System.out.println(twitter);
		//Prints the stock values.
		System.out.println(microsoft.toString() + "\n");
		
		/*
		 * Mutator Methods
		 */
		
		//Set the stock symbol.
		microsoft.setSymbol("MICR");
		//Set the purchase price.
		microsoft.setPurchasePrice(1.0);
		//Set the current stock price.
		microsoft.setCurrentPrice(10.0);
		//Set the total share value.
		microsoft.setTotalShare(1);
		
		System.out.println(microsoft.toString() + "\n");
		
		/*
		 * Accessor Methods
		 */
		
		//Get the stock symbol.
		System.out.println("Symbol: " + microsoft.gettSymbol());
		//Get the purchase price.
		System.out.println("Purchase Price: " + microsoft.getPurchasePrice());
		//Get the current stock price.
		System.out.println("Curent Stock Price: " + microsoft.getCurrentPrice());
		//Get the total share value.
		System.out.println("Total Shares: " + microsoft.getTotalShare() + "\n");
		
		/*
		 * Utility Methods
		 */
		
		//Did we lose or gain any money?
		System.out.println("Google Net: " + google.lossOrGain());
	}
}

