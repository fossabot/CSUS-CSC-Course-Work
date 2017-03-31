    public static void valueEquals()
    {
        //Creates a boardValuesTEMP arrary.
        int[] boardValuesTEMP = new int[16];
        //Creates a coordinatesTEMP arrary.
        int[] coordinatesTEMP = new int [15];
        //For loop that copys the boardValues and cordinates arrary.
        for(int i = 0; i < boardValues.length; i++)
        {
            //Copys the values from boardValues array.
            boardValuesTEMP[i] = boardValues[i];
            //Sets coordinatesTEMP equal to boardValuesTEMP.
            coordinatesTEMP[i] = boardValuesTEMP[i];
        }
        
    }