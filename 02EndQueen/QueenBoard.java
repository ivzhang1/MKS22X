public class QueenBoard{
    private int[][] board;

    public static void main(String[] args){
	QueenBoard test = new QueenBoard(5);
	System.out.println(test.addQueen(2,2,1)); // true
	System.out.println(test.addQueen(0,1,1)); // true
	System.out.println(test.addQueen(2,2,1)); // false
	System.out.println(test.addQueen(2,1,1)); // false
	System.out.println(test.addQueen(0,2,1)); // false

	System.out.println(test.removeQueen(2,2)); // true
	System.out.println(test.removeQueen(0,0)); // false	
	
	System.out.println(test);
    }
    
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

	board[r][c] = -10;
	return true;
	
    }


    private boolean removeQueen(int r, int c){
	if (board[r][c] != -10){ //Queen at position
	    return false;
	}
	board[r][c] = 0;
	boolean worked = addQueen(r,c,-1);
	board[r][c] = 0;
	return worked;
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
