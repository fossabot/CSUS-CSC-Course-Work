public class verifyValidImput
{
	boolean result = false;
	public static boolean analyzeImput (String x)
	{
		if(x.contiansIgnoreCase("1,2,3,4,5,6,7,8,9,0,a,b,c,d,e,f,g
								h,i,j,k,l,m,n,o.p,q,r,s,t,u,v,w,x,y,z"))
		{
			//Contians valid imput. Nothing to see here...Carry on.
			result = true;
			return result;
		}
		else
		{
			//Terminate the program with an error message.
			System.out.println("Looks like you enter invalid input.\nProgram terminating...");
			//System.exit(0);
			return result;
		}
	}
}