public class Stock {
	private String symbol;
	private double purchasePrice;
	private double currentPrice;
	private int totalShare;
	
	public Stock(String s, double pP, double cP, int tS) {
		symbol = s;
		purchasePrice = pP;
		currentPrice = cP;
		totalShare = tS;
	}
	
	//No argument constructor. Creates a default object.
	public Stock() {
		//We're going to change these later.
		this.symbol = "?";
		this.purchasePrice = 0.0;
		this.currentPrice = 0.0;
		this.totalShare = 0;
	}

	public String toString() {
		String s = "Symbol: " + symbol;
		s = s + "\nInital Price: " + purchasePrice;
		s = s + "\nInital Share: " + totalShare;
		s = s + "\nCurrent Price: " + currentPrice;
		return s;
	}
	
	/*
	 * Mutator Methods
	 */
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setPurchasePrice(double purchasePrice) {
		if(purchasePrice > 0)
			this.purchasePrice = purchasePrice;
	}
	
	public void setCurrentPrice(double currentPrice) {
		if(currentPrice > 0)
			this.currentPrice = currentPrice;
	}
	
	public void setTotalShare(int totalShare) {
		if(totalShare > 0)
		this.totalShare = totalShare;
	}
	
	/*
	 * Accessor Methods
	 */
	
	public String gettSymbol() {
		return symbol;
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public double getCurrentPrice() {
		return currentPrice;
	}
	
	public int getTotalShare() {
		return totalShare;
	}

	/*
	 * Utility Methods
	 */
	
	public boolean equals(String s1, String s2) {
		boolean result = false;
		if(s1.equals(s2))
			result = true;
		return result;
	}
	
	public double lossOrGain() {
		return purchasePrice - currentPrice * totalShare;
	}
	
	public double sell(String s, double p, int tS) {
		return 0.0;
	}
}