class Finance
{
    public static double monthlyInterestRate = 0.05;
    public static double monthlyDeposit = 100.0;
    public static int numberOfMonths = 6;

    public static void main(String[] args)
    {
        //Displays the header text.
        description();
        
        //Out put the table and info.
        for(int i = 1; i <= 4; i++)
        {
            totalSavings(numberOfMonths, monthlyInterestRate);
        }        
    }

    //Calculate the interest.
    public static double interest(double rate, double amount)
    {
        double interest = rate * amount / numberOfMonths;
        return interest;
    }

    //calcualte the toal savings.
    public static void totalSavings(int months, double monthlyRate)
    {
        System.out.println("With the monthly deposit of: " + monthlyDeposit);
        System.out.println("With he annual interest rate of: " + monthlyInterestRate + "%");
        System.out.println("Account summary is: \n");
        System.out.println("Interest\tSaving");

        double totalInterest = 0.0;
        double totalSaving = 0.0; 
        double bankBallance = monthlyDeposit;
        double calculateInterest = 0.0;

        for(int i = 1; i <= months; i++)
        {
            //Calculate the interest.
            double interest = interest(monthlyInterestRate, monthlyDeposit);
            calculateInterest = interest + calculateInterest;
            totalInterest = calculateInterest + totalInterest;

            //Calculate the savings
            //totalSaving = interest + monthlyDeposit;
            totalSaving = calculateInterest + bankBallance;
            
            //Print the values to the table.
            System.out.println(Math.round( calculateInterest * 100.0) / 100.0 + "\t\t" + Math.round( totalSaving * 100.0 ) / 100.0);

            //After every month, add $100.
            bankBallance = bankBallance + monthlyDeposit;
        }
        
        //After six months, deposit $100 more each month.
        monthlyDeposit = monthlyDeposit + 100;

        System.out.println("\nTotal amount of interest after " + months + " months is: " + totalInterest);
        System.out.println("**************************************************\n");
    }

    public static void description()
    {
        System.out.println("_________________________________________________________________________");
        System.out.println("|\t\tWelcome to Marc Woodyard Finance Company\t\t|");
        System.out.println("|\tThis software calculates the monthly and the total saving\t|");
        System.out.println("|after depositing certain amount of money each month for a given period |");
        System.out.println("|\t\t\t\t\t\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------\n");
    }
}
