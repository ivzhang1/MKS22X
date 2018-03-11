import java.util.*;
import java.io.*;

public class USACO{

    public static void main(String[] args){
	//System.out.println(USACO.bronze("makelake/makelake.2.in"));
	System.out.println(USACO.silver("ctravel/ctravel.3.in"));
    }
    
    public static int bronze(String filename){
	int row = 0;
	int col = 0;
	int elevation;
	int instructions;
	int[][] instruction;
	int[][] board;
	int depth = 0;

	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    String firstL = s.nextLine();
	    String[] lineOne = firstL.split(" ");
	    row = Integer.parseInt(lineOne[0]);
	    col = Integer.parseInt(lineOne[1]);
	    elevation = Integer.parseInt(lineOne[2]);
	    instructions = Integer.parseInt(lineOne[3]);

	    board = new int[row][col];

	    //System.out.println(board.length + " " + board[0].length + " " + elevation + " " + instructions);
	    
	    /////////////////////PARSING/////////////////////////
	    for (int i = 0; i < row; i++){
	    	String liney = s.nextLine();
	    	String[] lineyy = liney.split(" ");

    		for (int j = 0; j < col; j++){
		    board[i][j] = Integer.parseInt(lineyy[j]);
    		}
	    }

	    // for (int i = 0; i < row; i++){
	    // 	for (int j = 0; j < col; j++){
	    // 		System.out.print(board[i][j] + " ");
	    // 	}
	    // 	System.out.println();
	    // }


	    instruction = new int[instructions][3];
	    for (int i = 0; i < instructions; i++){
	    	String tempS = s.nextLine();
	    	String[] line = tempS.split(" ");
	    	int[] temp = {Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])};
		instruction[i] = temp;
	    }

	    /////////////////////PARSING/////////////////////////
	    
	    for (int[] instr : instruction){
		int r = instr[0];
		int c = instr[1];
		int step = instr[2];
		int[][] cowPos = {{r, c}, {r, c + 1}, {r, c -1}, {r + 1,c}, {r-1,c}, {r+1,c+1}, {r-1,c-1}, {r+1,c-1}, {r-1,c+1}};

		while (step > 0){
		    int maxyMax = getMax(cowPos, board, row, col);
		    //System.out.println(maxyMax);
		    for (int[] posh: cowPos){
			if (posh[0] >= 0 && posh[0] < row && posh[1] >= 0 && posh[1] < col && board[posh[0]][posh[1]] == maxyMax){
			    board[posh[0]][posh[1]] -= 1;
			}
		    }
		    step -= 1;
		}
		//System.out.println();
	    }

	    for (int i = 0; i < row; i++){
		for (int j = 0; j < col; j++){
		    int deep = board[i][j];
		    if (deep < elevation){
			depth += elevation - deep;
		    }
		}
	    }
	    

		
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(1);
	}
	return depth * 72 * 72;
    }

    private static int getMax(int[][] pos, int[][] board, int row, int col){
	int max = 0;
	for (int[] posh: pos){
	    if (!(posh[0] < 0 || posh[0] >= row) || !(posh[1] < 0 || posh[1] >= col)){
		if (board[posh[0]][posh[1]] >= max){
		    max = board[posh[0]][posh[1]];
		}
	    }
	}
	return max;
    }
	

    public static int silver(String filename){
	int row = 0;
	int col = 0;
	int time = 0;
	int startX;
	int startY;
	int endX;
	int endY;
	char[][] board;

	try{
	    /////////////////////PARSING////////////////////////////////////////
	    ////////////////////////////////////////////////////////////////////
	    ////////////////////////////////////////////////////////////////////
	    ////////////////////////////////////////////////////////////////////
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    String firstL = s.nextLine();
	    String[] lineOne = firstL.split(" ");
	    row = Integer.parseInt(lineOne[0]);
	    col = Integer.parseInt(lineOne[1]);
	    time = Integer.parseInt(lineOne[2]);

	    board = new char[row][col];

	    //System.out.println(board.length + " " + board[0].length + " " + elevation + " " + instructions);
	    
	    for (int i = 0; i < row; i++){
	    	String liney = s.nextLine();

    		for (int j = 0; j < col; j++){
		    board[i][j] = liney.charAt(j);
    		}
	    }

	    // for (int i = 0; i < row; i++){
	    // 	for (int j = 0; j < col; j++){
	    // 		System.out.print(board[i][j] + " ");
	    // 	}
	    // 	System.out.println();
	    // }


	    String tempS = s.nextLine();
	    String[] linez = tempS.split(" ");
	    startX = Integer.parseInt(linez[0]) - 1;
	    startY = Integer.parseInt(linez[1]) - 1;
	    endX = Integer.parseInt(linez[2]) - 1;
	    endY = Integer.parseInt(linez[3]) - 1;
	    //System.out.println(startX  + " " + startY + " " + endX + " " + endY);
	    ////////////////////////////////////////////////////////////////////
	    ////////////////////////////////////////////////////////////////////
	    ////////////////////////////////////////////////////////////////////
	    
	    int[][] jekyll = new int[row][col];
	    int[][] hyde = new int[row][col];
	    
	    jekyll[startX][startY] = 1;
	    while (time > 0){
		for (int i = 0; i < row; i++){
		    for (int j = 0; j < col; j++){
			if (jekyll[i][j] != 0){
			    int[][] poss = {{i+1,j}, {i-1, j}, {i, j+1}, {i, j-1}};
			    for (int[] possible: poss){
				if (possible[0] >= 0 && possible[0] < row && possible[1] >= 0 && possible[1] < col){
				    if(board[possible[0]][possible[1]] != '*'){
					hyde[possible[0]][possible[1]] += jekyll[i][j];
				    }
				}
			    }
			    jekyll[i][j] = 0;
			}
		    
		    }
		
		}
		
		jekyll = hyde;
		hyde = new int[row][col];
		time -= 1;
	    }
	    return jekyll[endX][endY];

	}catch(FileNotFoundException e){
	    System.out.println("FILE!");
	}
	return 0;
    }




}
