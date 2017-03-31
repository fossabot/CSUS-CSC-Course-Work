public class HailStone
{

	//Acumulating sum code for the HailStone PracticeIt prolbem. 

	public static void main(String[] args)
	{
	
		public static void hailStone(int first, int count)
		{
			int sum = 0;
			int last = first;
			
			for (counter = 1; counter < count; counter++)
			{				
			
				sum = sum + first;
			
				if(last %2 == 1)
				{
					last = 3 * first  + 1
				}
				
				else
				{
					first = first / 2
				}
			}
		}
	}
}