public class CameraAlert{
	
	double width;
	double height;
	
	string object;
	string person;
	
	public static void main(String[] args){
		
		if (width >= height){
			console.printf("There is an %s in your parking lot.", object);
		} 
		
		else if (height >= width){
			console.printf("There is a %s in your parking lot.", person);
		}
		
		else {
			console.printf("An error occured, please contact your system administartor. Error code: 0.");
		}
		
	}
}