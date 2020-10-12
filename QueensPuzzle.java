/***********************
 *
 *   QueensPuzzle - models a row x col chessboard with queens on it   
 *
 *   Author:   Colin Ryan
 *   Date:     2016-
 *
 ***********************/   

 public class QueensPuzzle
 {
    private boolean[][] board;
    public static final String DARK_SQUARE = "\u2588\u2588"; 
    public static final String LIGHT_SQUARE = "  ";
    public static final String QUEEN = "Qu";
    public int dim;
    
    // write a constructor which takes int row and int col and creates the row x col board
    public QueensPuzzle(int row, int col)
    {
    	board = new boolean[row][col];
    	dim = (row + col) /2;
    	boolean defaultboard = false;
       	for(int i=0;i<board.length;i++)
    	{
    		for(int k=0;k<board[i].length;k++)
    		{
    			board[i][k] = defaultboard;
    		}
    	}
    }

    // write a getter for board
    public boolean[][] getBoard()
    {
    	return this.board;
    }

    public void placeQueen(int row, int col)
    {
        if(board[row][col] == false)
        	board[row][col] = true;
    }
    public void clearBoard()
    {
        for(int i = 0; i < board.length; i++)
        	for(int k=0;k<board[i].length;k++)
        		board[i][k] = false;
    }
    public boolean allQueensSafe()
    {
         return (checkDiagonal() && checkHorizontal() && checkVertical() );
    }
    private boolean checkHorizontal()
    {
    	boolean oneQueen = false;
    	boolean isSafe = true;
    	int row = 0;
    	int col = 0;
    	while(col<board.length && isSafe)
    	{
    		if(board[row][col] == true)
    		{
    			oneQueen = true;
    			col++;
    		}
    		while(oneQueen && col<board.length)
    		{
    			if(board[row][col] == true)
    				isSafe = false;
    			col++;
    		}
    		oneQueen = false;
    		col++;
    	}
    	//System.out.println("horiz check: " + isSafe);
    	return isSafe;
    }
    private boolean checkVertical()
    {
    	boolean isSafe = true;
    	boolean oneQueen = false;
    	int row = 0;
    	int col = 0;
    	while(col<board[row].length && isSafe)
    	{
    		while(row <board.length)
    		{
    			if(board[row][col] == true)
    			{
    				oneQueen = true;
    				row++;
    			}
    			while(oneQueen && row<board.length)
    			{
    				if(board[row][col] == true)
    					isSafe = false;
    				row++;
    			}
    			row++;
    		}
    		oneQueen = false;
    		row=0;
    		col++;
    	}
    	//System.out.println("vertical check: " + isSafe);
    	return isSafe;
    }
    private boolean checkDiagonal()
    {
    	boolean isSafe = true;
    	boolean oneQueen = false;
    	for( int k = 0 ; k < (board.length * 2) ; k++ ) 
    	{
	        for( int j = 0 ; j <= k ; j++ ) 
	        {
	            int i = k - j;
	            if( i < dim && j < dim )
	            {
	            	if(oneQueen && isSafe)
	        		{
	            		//System.out.println("Queen unsafe");
	        			if(board[i][j] == true)
	        				isSafe = false;
	        			
	        		}
	            	if(board[i][j] == true)
	        		{
	        			oneQueen = true;
	        		}
	            }
	        }
    		oneQueen = false;
	    }
    	return isSafe;
    }
    
    public String toString()
   	{
   		String boardStr = "\n";
          
   		for (int row = 0; row < this.board.length; ++row)
   		{
   			for (int col = 0; col < this.board[row].length; ++col)
   			{
   				String x = "";
   				if(board[row][col] == true)
   					x = QUEEN;
   				else if((row + col) % 2 == 0)
   					x = DARK_SQUARE;
   				else
   					x = LIGHT_SQUARE; 
   				boardStr += x + " ";
   			}
   			boardStr += "\n";
   		}
   		return boardStr + "\n";
   	}
 }