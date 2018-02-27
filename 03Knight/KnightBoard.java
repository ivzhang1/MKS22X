import java.util.ArrayList;

public class KnightBoard{
    private int[][] board;
    private int numRows;
    private int numCols;
    private int[][] moves = {{2, 1}, {1, 2},
			   {-1,-2}, {-1, 2},
			   {2, -1}, {-2, -1},
			   {1,-2}, {-2, 1}};


    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3,3);

	System.out.println(a);
	/* Prints
	   _ _ _
	   _ _ _
	   _ _ _
	*/

	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (a.solve(i,j)){
		    System.out.println("There is an error with your solve method");
		}
	    }
	} //prints nothing

	System.out.println(a.countSolutions(0,0)); //prints 0



	KnightBoard b = new KnightBoard(5,5);
	System.out.println(b.solve(0,0)); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    KnightBoard b1 = new KnightBoard(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(0,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"



	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		KnightBoard abc = new KnightBoard(5,5);
		System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	    }
	}
	KnightBoard c = new KnightBoard(5,5);

	int totalSol = 0;
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	    }
	}

	System.out.println(totalSol); //prints 1728

	KnightBoard d = new KnightBoard(5,5);
	System.out.println(d.countSolutions(0,0)); //prints 304

    }	
      
    
    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
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
		    if (board[r][c] == 0){
			current = "_";
		    }
		    else{
			current = "_" + current;
		    }
		}
		returned += "" + current + " ";
	    }
	    returned += "\n";
	}
	return returned;
    }

    private boolean hasNonZero(){
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
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

	
	for (int i = 0; i < 8; i++){
	    int nextRow = r + moves[i][0];
	    int nextCol = c + moves[i][1];
	    //System.out.println(level);
	    if (nextRow < 0 || nextCol < 0 || nextCol >= numCols || nextRow >= numRows){
	    }
	    else{
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
    
    public int countSolutions(int startingRow, int startingCol){
	checkConditions(startingRow, startingCol);
	return countH(startingRow, startingCol, 1);
    }

    private int countH(int r, int c, int level){
	int total = 0;
	if (board[r][c] != 0){
	    return 0;
	}
	if (numRows * numCols == level){
	    return 1;
	}
	for (int i = 0; i < 8; i++){
	    int nextRow = r + moves[i][0];
	    int nextCol = c + moves[i][1];
	    if (nextRow < 0 || nextCol < 0 || nextCol >= numCols || nextRow >= numRows){
	    }
	    else{
		board[r][c] = level;
		total += countH(nextRow, nextCol, level+1);
		board[r][c] = 0;
	    }
	}

	return total;
    }

}
