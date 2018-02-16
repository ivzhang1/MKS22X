public class KnightBoard{
    private int[][] board;
    private int numRows;
    private int numCols;

    public static void main(String[] args){
	KnightBoard n = new KnightBoard(7,7);
	System.out.println(n.solve(0,0));
	System.out.println(n);
	
	
    }
    
    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalStateException();
	}
	board = new int[startingRows][startingCols];
	numRows = startingRows;
	numCols = startingCols;
    }
	
    //see format for toString below
    //blank boards use underscores 
    //you get a blank board if you never called solve or 
    //when there is no solution
    public String toString(){
	String returned = "";
	for (int r = 0; r < numRows; r++){
	    for (int c = 0; c < numCols; c++){
		String current = "" + board[r][c];
		if (board[r][c] < 10){
		     current = "_" + current;
		}
		returned += "" + current + " ";
	    }
	    returned += "\n";
	}
	return returned;
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
    private boolean checkConditions(int startingRow, int startingCol){
	if (hasNonZero()){
	    throw new IllegalStateException();
	}
	if (startingRow < 0 || startingCol < 0 || startingRow >= numRows || startingCol >= numCols){
	    throw new IllegalArgumentException();
	}
	return true;
    }
    
    public boolean solve(int startingRow, int startingCol){
	checkConditions(startingRow, startingCol);
	return solveH(startingRow, startingCol, 1);
    }

    //see format for toString below
    //blank boards use underscores 
    //you get a blank board if you never called solve or 
    //when there is no solution
    private boolean solveH(int r ,int c, int level){
	
	if (board[r][c] != 0){
	    return false;
	}
	if (numRows * numCols == level){
	    board[r][c] = level;
	    return true;
	}

	//Move Combos
	int[] moves = {r+1, c-2, r+1, c+2,
		       r-1,c-2, r-1, c+2,
		       r+2, c - 1, r-2, c-1,
		       r+2,c+1, r-2, c+1};
	for (int i = 0; i < 16; i+=2){
	    int nextRow = moves[i];
	    int nextCol = moves[i+1];
	    //System.out.println(level);
	    if (!(nextRow < 0 || nextCol < 0 || nextCol >= numCols || nextRow >= numRows)){
		board[r][c] = level;
		if (solveH(nextRow, nextCol, level + 1)){
		    //board[r][c] = level;
		    return true;
		}
		board[r][c] = 0;
		//return false;
	    }
	}
	return false;	    
    }

        
    public int countSolutions(){
	return 0;
    } 

}
