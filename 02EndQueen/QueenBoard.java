public class QueenBoard{
    private int[][] board;
    

    // public static void main(String[] args){
    // 	QueenBoard test = new QueenBoard(5);
    // 	System.out.println(test.addQueen(2,2)); // true
    // 	System.out.println(test.addQueen(0,1)); // true
	
    // 	System.out.println(test.addQueen(2,2)); // false
    // 	System.out.println(test.addQueen(2,1)); // false
    // 	System.out.println(test.addQueen(0,2)); // false

    // 	System.out.println(test.removeQueen(2,2)); // true
    // 	System.out.println(test.removeQueen(0,0)); // false	
	
    // 	System.out.println(test);
    // 	test = new QueenBoard(8);
    // 	//System.out.println(test);
    // 	System.out.println(test.solve());
    // 	System.out.println(test);
    // 	test = new QueenBoard(8);	
    // 	System.out.println(test.countSolutions());
    // 	System.out.println(test);
    // }
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen (int r, int c, int addAmount){
	if (board[r][c] != 0){
	    return false;
	}
	
	//Adds to same row and column
	for (int i = 0 ; i < board.length; i ++){
	    board[r][i] += addAmount;
	    board[i][c] += addAmount;
	}

	int row = r;
	int col = c;
	//Adds to diagonals
	for (int inc = -1; inc < 2; inc+=2){
	    for (int incA = -1; incA < 2; incA+=2){
		row = r;
		col = c;
		while (row > -1 && col > -1 && row < board.length && col < board.length){
		    board[row][col] += addAmount;
		    row += inc;
		    col += incA;
		   
		}
	    }
	}

	board[r][c] = -1;
	return true;
	
    }

    private boolean addQueen(int r, int c){
	return addQueen(r,c,1);
    }


    private boolean removeQueen(int r, int c){
	if (board[r][c] != -1){ //Queen at position
	    return false;
	}
	board[r][c] = 0;
	boolean worked = addQueen(r,c,-1);
	board[r][c] = 0;
	return worked;
    }

    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *        true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public boolean solve(){
	if (hasNonZero()){
	    throw new IllegalStateException();
	}
	return solveHelp(0);
    }
    
    private boolean solveHelp(int c){
    	if (c == board.length){
    	    return true;
    	}
	for(int r = 0; r < board.length; r++){
	    if (addQueen(r, c)){
		if (solveHelp(c+1)){
		    return true;
		}
		else{
		    removeQueen(r,c);
		}
	    }
	}
	return false;
	
    }

    

    private boolean hasNonZero(){
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] != 0){
		    return true;
		}
	    }
	}
	return false;
    }


    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){
	if (hasNonZero()){
	    throw new IllegalStateException();
	}
	return countSolutionsHelp(0);
	
    }
    
    private int countSolutionsHelp(int c){
	int times = 0;
  	if (c == board.length){
	    return 1;
    	}

    	for (int r = 0; r < board.length; r++){
    	    if (addQueen(r,c)){
		times += countSolutionsHelp(c+1);
		removeQueen(r,c);	
    	    }
    	}
    	return times;
	
    }
    
    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    public String toString(){
	String toPrint = "";
	String add = "";
	    
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] == -1){
		    add = "Q ";
		}
		else if (board[r][c] > 0){
		    add = "_ ";
		}
		else {
		    add = "_ ";
		}
		toPrint += add;
	    }
	    toPrint += "\n";
	}
	return toPrint;
    }

    
    
    
}
