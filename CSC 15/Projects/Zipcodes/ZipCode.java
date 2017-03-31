//@author Marc Woodyard
/********************************************************************************************************
*Program Name: Zipcode to Barcode Program                                                               *
*Description: Encode a zipcode to a bar code.											                *
*Author: Marc Woodyard                                                                                  *
*Class: CSC-15 TuTh 12:00pm                                                                             *
*Teacher: Gita Faroughi                                                                                 *
*********************************************************************************************************/

public class ZipCode
{
	//Instance Variables
	private static int zipcode;
	private static int[] zipcodeDigit = new int[6];
	private static String[] encoded = new String[6];
	private static String[] barcode = new String[30];
   
	//Constructor
	public ZipCode(int Zip) {
		zipcode = Zip;
	}
	
	public static int getZip (String data) {
		String zipcodeString = data.substring(0,5);
		int zipcode = Integer.parseInt(zipcodeString);
		return zipcode;
	}
	
	public static String getCity(String data, int stage) {
		String city = "NaH";
		if(stage == 1) {
			city = data.substring(6);
			
		} else if(stage == 2) {
			city = data.substring(30);
		} else {
			System.out.println("Error in getCity");
			System.exit(0);
		}
		return city;
	}

	public static String generateEncoding(int zipcode) {
		ZipCode.toArray(zipcode);

		for(int i = 0; i < zipcodeDigit.length; i++) {
			ZipCode.encode(zipcodeDigit[i], i);
		}
		
		ZipCode.checkDigit(zipcode);
		ZipCode.encode(zipcodeDigit[0], 0);
		String output = encoded[5] + encoded[4] + encoded[3] + encoded[2] + encoded[1] + encoded[0];
		return output;
	}

	public static void toArray(int zipcode) {
		for(int i = 1; i < 6; i++) {
			int Digit = zipcode % 10;
			zipcode = zipcode / 10;
			zipcodeDigit[i] = Digit;
		}
	}

	public static void encode(int Digit, int place) {
		switch(Digit) {
			case 1:
				encoded[place] = "00011";
				break;
			case 2:
				encoded[place] = "00101";
				break;
			case 3:
				encoded[place] = "00110";
				break;
			case 4:
				encoded[place] = "01001";
				break;
			case 5:
				encoded[place] = "01010";
				break;
			case 6:
				encoded[place] = "01100";
				break;
			case 7:
				encoded[place] = "10001";
				break;
			case 8:
				encoded[place] = "10010";
				break;
			case 9:
				encoded[place] = "10100";
				break;
			case 0:
				encoded[place] = "11000";
				break;
			default:
				System.out.println("Error in encode.");
				System.exit(0);
				break;
		}
	}
	
	public static void checkDigit(int zipcode) {
		int count = 0;
		for(int i = 0; i < zipcodeDigit.length; i++) {
			count += zipcodeDigit[i];
		}
		
		if(count == 10)
			count = 0;
		else if(count == 20)
			count = 0;
		else if(count == 30)
			count = 0;
		else if(count >= 10 && count <= 20)
			count = 20 - count;
		else if(count >= 20 && count <= 30)
			count = 30 - count;
		else if(count >= 30 && count <= 40)
			count = 40 - count;
		
		zipcodeDigit[0] = count;	
	}

	public static String generateBarcode(String encodedZip) {
		for(int i = 0; i < encodedZip.length(); i++) {
			String Digit = Character.toString(encodedZip.charAt(i));
			if(Digit.equals("1"))
				barcode[i] = "|";
			else if(Digit.equals("0"))
				barcode[i] = ":";	
		}
		String output = arrayToString(barcode);
		return output;
	}
	
	public static String arrayToString(String[] array) {
		String output = "NaH";
		for(int i = 0; i < array.length; i++) {
			if(i == 0)
				output = array[i];
			else
				output += array[i];
		}
		return output;
	}
	
	public static String readBarcode(String data) {
		data = data.substring(0, 29);
		int count = 0;
		for(int i = 0; i < 5; i++) {
			String temp = data.substring(count, count + 5);
			count+=5;
			switch (temp) {
				case ":::||":
					zipcodeDigit[i] = 1;
					break;
				case "::|:|":
					zipcodeDigit[i] = 2;
					break;
				case "::||:":
					zipcodeDigit[i] = 3;
					break;
				case ":|::|":
					zipcodeDigit[i] = 4;
					break;
				case ":|:|:":
					zipcodeDigit[i] = 5;
					break;
				case ":||::":
					zipcodeDigit[i] = 6;
					break;
				case "|:::|":
					zipcodeDigit[i] = 7;
					break;
				case "|::|:":
					zipcodeDigit[i] = 8;
					break;
				case "|:|::":
					zipcodeDigit[i] = 9;
					break;
				case "||:::":
					zipcodeDigit[i] = 0;
					break;
			}
		}
		
		for(int i = 0; i < encoded.length; i++) {
			String temp = Integer.toString(zipcodeDigit[i]);
			encoded[i] = temp;
		}
		
		String result = encoded[0] + encoded[1] + encoded[2] + encoded[3] +
				encoded[4];
		return result;
	} 
	
	public static String printCity (String city) {
		int length = city.length();
		String output = "NaH";
		if(length == 17)
			output = city + " ";
		else if(length == 16)
			output = city + "  ";
		else if(length == 15)
			output = city + "   ";
		else if(length == 14)
			output = city + "    ";
		else if(length == 13)
			output = city + "     ";
		else if(length == 12)
			output = city + "      ";
		else if(length == 11)
			output = city + "       ";
		else if(length == 10)
			output = city + "        ";
		else if(length == 9)
			output = city + "         ";
		else if(length == 8)
			output = city + "          ";
		else if(length == 7)
			output = city + "           ";
		else if(length == 6)
			output = city + "            ";
		return output;
	}
}      