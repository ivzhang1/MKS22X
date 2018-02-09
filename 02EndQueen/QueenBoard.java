public class QueenBoard{
    private int[][] board;

    public static void main(String[] args){
	QueenBoard test = new QueenBoard(5);
	System.out.println(test.addQueen(2,2));
	System.out.println(test);
    }
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen (int r, int c){
	if (board[r][c] != 0){
	    return false;
	}
	
	//Adds to same row and column
	for (int i = 0 ; i < board.length; i ++){
	    board[r][i] += 1;
	    board[i][c] += 1;
	}

	//Adds to diagonals
	for (int inc = -1; inc < 2; inc+=2){
	    int row = r;
	    int col = c;
	    for (int incA = -1; incA < 2; incA+=2){
		row = r;
		col = c;
		while ((row+col < row*2) && (row + col > 0)){
		    board[row][col] += 1;
		    row += inc;
		    col += incA;
		}
	    }
	}

	board[r][c] = -10;
	return true;
	
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
		if (board[r][c] == -10){
		    add = "Q ";
		}
		else if (board[r][c] > 0){
		    add = "X ";
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
