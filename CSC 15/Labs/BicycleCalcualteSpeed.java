/*
 * Plugin Name: Bicycle Speed Calculator
 * Description: Calcualtes the speed of a bicycle based on the gear size and cadence.
 * Author: Marc Woodyard
 * Version: 0.0.1
 * Author URI: https://marcwoodyard.com
 * License: GPL2+
 */
import java.math.BigDecimal;

public class BicycleCalcualteSpeed
{
	public static final int GEAR_SIZE = 100;
	public static final int CADENCE = 90;
	public static final double MPH = (1.0 / 12.0) * (1.0 / 5280.0);
	public static final int MINUTES_PER_HOUR = 60;

	public static void main(String[] args)
	{
		//Let's print the header statement. 
		describe();
		//Dispay the calculated speed.
		milesPerHour();	
	}

	//Calcualte the speed at
	public static void milesPerHour()
	{
		double speed = GEAR_SIZE * Math.PI * MPH * CADENCE * MINUTES_PER_HOUR;
		//Lets tell the user their speed.
		System.out.println("You will bike: " + speed + " miles per hour.");
	}

	//Display the header.
	public static void describe()
	{
		System.out.println("*****************************************************************");
		System.out.println("*\tThis software has been developed by \"Marc Woodyard\"\t*");
		System.out.println("*\twelcome to the bicycle \"miles-per-hour\" calculator\t*");
		System.out.println("*****************************************************************\n");
		//Tell the user what gear size and cadence we are using to calculate speed.
		System.out.println("With a gear size of: " + GEAR_SIZE);
		System.out.println("A cadence of: " + CADENCE);
	}

}