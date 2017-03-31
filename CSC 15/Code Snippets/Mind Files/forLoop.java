public forLoop {

	string hello = system.out.println("Hello,");	
	string my = system.out.println("my");	
	string name = system.out.println("name");	
	string is = system.out.println("is");
	string enterName = 	console.printf("What is your name: " )
	
	public static void main(String[] args){
		
		for (int counter = 0; counter <= 10; counter++) {
			
			for (int One = 0; 1 < 3; 1++){
			
				console.printf("-------------%s-------------", hello);
				console.printf("-------------%s-------------", my);
				console.printf("-------------%s-------------", name);
				console.printf("-------------%s-------------", is);
				console.printf("-------------%s-------------", enterName);
				
				for (int Two = 1; Two < 10; Two++){
					System.out.println("This is so cool!", my);
				}
								
			}
			
		}
		
		System.out.println();
		
	}
}