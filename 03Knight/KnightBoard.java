public class KnightBoard{
    private int[][] board;
    private int numRows;
    private int numCols;

    public static void main(String[] args){
	KnightBoard n = new KnightBoard(3,3);
	
	
    }
    
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	int counter = 8;
	for (int i = 0; i < startingRows; i++){
	    for (int k = 0; k < startingCols; k++){
		board[i][k] = counter++;
	    }
	}
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
		int current = board[r][c];
		if (current < 10){
		    current = "_" + current;
		}
		returned += "" + current + " ";
	    }
	    returned += "\n";
	}
	return returned;
    }

    public boolean solve(){} 
    public int countSolutions(){} 

    //see format for toString below
    //blank boards use underscores 
    //you get a blank board if you never called solve or 
    //when there is no solution
    private boolean solveH(int row ,int col, int level){ 
    }

}
