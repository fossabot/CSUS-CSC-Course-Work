    public static int getCheckCoordinates()
    {
        boolean validCoordinate = false; 

        System.out.print("Coordinates: ");
        String coordinateGuess = GetInput.nextLine();

        do
        {
            if(coordinateGuess.equalsIgnoreCase("help"))
            {
                displayHelpDocs();
                System.exit(0);
            }
            else
            {
                try
                {
                    Integer.parseInt(coordinateGuess);
                    validCoordinate = true;
                }
                catch(NumberFormatException NotAIn)
                {
                    System.out.println("\nYou did not enter a valid coordinate. Please check your input and try again\nError code: 1\n");
                    break; 
                }    
            }
        }
        while(validCoordinate = false);

        int convertToInt = Integer.parseInt(coordinateGuess);

        while(validCoordinate = false)
        {      
            if(convertToInt == coordinates[0] || convertToInt == coordinates[1] || convertToInt == coordinates[2]
                ||convertToInt == coordinates[3] || convertToInt == coordinates[4] || convertToInt == coordinates[6]
                ||convertToInt == coordinates[7] || convertToInt == coordinates[8] || convertToInt == coordinates[9]
                ||convertToInt == coordinates[10] || convertToInt == coordinates[11] || convertToInt == coordinates[12]
                ||convertToInt == coordinates[13] || convertToInt == coordinates[14] || convertToInt == coordinates[15])
            {
                firstOrSecondCard++;
                validCoordinate = true; 
            } 
            else
            {
                System.out.println("Error when checking valid coordinates.\nProgram exiting to prevent a crash...");
                System.exit(0);
            }   
        }
    }