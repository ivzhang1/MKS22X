public class KnightBoard{
    private int[][] board;
    public int[][] heuristic;
    private int numRows;
    private int numCols;
    private int[][] moves = {{1, -2}, {1, 2},
			   {-1,-2}, {-1, 2},
			   {2, -1}, {-2, -1},
			   {2,1}, {-2, 1}};

    public static void main(String[] args){
	KnightBoard n = new KnightBoard(50,50);
	//System.out.println(n.solve(0,0));
	//System.out.println(n);
	//n = new KnightBoard(5,5);
	//System.out.println(n.countSolutions(0,0));
	//System.out.println(n);
	for (int r = 0; r < n.heuristic.length; r++){
	    for (int c = 0; c < n.heuristic[r].length; c++){
		System.out.print(n.heuristic[r][c]);
	    }
	    System.out.println();
	}
		
	
	
    }
    
    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalStateException();
	}
	board = new int[startingRows][startingCols];
	numRows = startingRows;
	numCols = startingCols;
	heuristic = new int[startingRows][startingCols];
	heuristic();
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

    private int countHeuristic(int r, int c, int level){
	return 0;
    }

    //Finds shortest next path and returns it [row,col]
    private int findShortestNext(int r, int c){
	return 0;
    }

    //Creates heurisitic
    private void heuristic(){
	
	int size = numRows*numCols;
	for(int i = 0; i < size; i++){
	    int countMoves = 0;
	    for(int[] set: moves){
		int nextRow = i/numRows + set[0];
		int nextCol = i%numCols + set[1];
		if (!(nextRow < 0 || nextCol < 0 || nextCol >= numCols || nextRow >= numRows)){
		    countMoves++;
		}
	    }
	    heuristic[i/numRows][i%numCols] = countMoves;
	}
    }

}
