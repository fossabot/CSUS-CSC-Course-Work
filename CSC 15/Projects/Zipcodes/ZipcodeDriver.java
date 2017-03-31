//@author Marc Woodyard
/********************************************************************************************************
*Program Name: Zipcode to Barcode Program                                                               *
*Description: Encode a zipcode to a bar code.											                *
*Author: Marc Woodyard                                                                                  *
*Class: CSC-15 TuTh 12:00pm                                                                             *
*Teacher: Gita Faroughi                                                                                 *
*********************************************************************************************************/

import java.io.*;
import java.util.*;
public class ZipcodeDriver {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb = new Scanner(System.in);
		PrintStream out = OutputFile( kb, "Enter the file name that you want to store the barcodes: ");
		Scanner input = Inputfile(kb, "Enter the file name that contains the zip codes: ");
		processZipCodes(input, out);
		System.out.println("Now converting the bar codes back to the original zipcode.");
		input = Inputfile(kb, "Enter the file name that contains the barcodes: ");
		out =  OutputFile( kb, "Enter the file name that that you want to store the zip codes to: ");
		processBarCodes(input, out);
	}
	
	/*this method gets the output file name so that we output the result in this file*/
	public static PrintStream OutputFile(Scanner console, String instructions) throws FileNotFoundException {
		String outputFileName;
    	boolean validFile = false;
    	do {
    		System.out.print(instructions);
            outputFileName = console.nextLine();
            if(outputFileName.contains(".txt"))
            	validFile = true;
            else
            	System.out.println("[Program] SAVE FAILED! Not a valid file type. Make sure you include \nthe file type (file.txt).\n");
    	} while(validFile == false);
    	System.out.println("[Program] File saved successfully!\n");
    	return new PrintStream(System.getProperty("user.home") + "/Desktop/" + outputFileName);
	} 

	/*This method gets the name of the input file. It should keep asking the user until you get a valid file name */  
	public static Scanner Inputfile(Scanner console, String instructions) throws FileNotFoundException {
		File dataFile;
    	boolean fileExists = false;
    	do {
	    	System.out.print(instructions);
	    	dataFile = new File(System.getProperty("user.home") + "/Desktop/" + console.nextLine());
	    	if(dataFile.exists())
	    		fileExists = true;
	    	else
	    		System.out.println("[Program] UPLOAD FAILED! File not found. Make sure the data file is\non your desktop"
	    				+ "and you included the file type (file.txt).\n");
    	} while(fileExists == false);
    	System.out.println("[Program] Zipcode data imported successfully!\n");
    	return new Scanner(dataFile);  
	} 
	
	//Encodes the zipcodes and assigns them to the matching city.
	public static void processZipCodes(Scanner dataFile,  PrintStream writer) {
		while(dataFile.hasNext()) {
			//Get the zipcode and city name.
			String data = dataFile.nextLine();
			//Seperate the zipcode and city name.
			int zipcode = ZipCode.getZip(data);
			String city = ZipCode.getCity(data, 1);
			//Encode the information.
			String encoding = ZipCode.generateEncoding(zipcode);
			//Generate a barcode.
			String barcode = ZipCode.generateBarcode(encoding);
			//Write the bar code and city to the file.
			writer.println(barcode + " " + city);
		}
	}
	
	//Decode the barcoes and print the zipcodes to a file.
	public static void processBarCodes(Scanner dataFile, PrintStream writer) { 
		while(dataFile.hasNext()) {
			//Get the zipcode and city name.
			String data = dataFile.nextLine();
			//Get the city name.
			String city = ZipCode.getCity(data, 2);
			//Get the zipcode.
			String zipcode = ZipCode.readBarcode(data);
			//Write the bar code and city to the file.
			writer.print(ZipCode.printCity(city));
			writer.println(zipcode);
		}
	}
}   
      