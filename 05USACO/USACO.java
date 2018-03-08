import java.util.*;
import java.io.*;

public class USACO{

    public static void main(String[] args){
	//System.out.println(USACO.bronze(""));
	System.out.println(USACO.silver("makelake/makelake.1.in"));
    }
    
    public static int bronze(String filename){
	int row = 0;
	int col = 0;
	int elevation;
	int instructions;
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(1);
	}
	return 0;
    }

    public static int silver(String filename){
	char[][] board;

	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    String firstL = s.nextLine();
	    String[] lineOne = firstL.split(" ");
	    board = new char[Integer.parseInt(lineOne[0])][Integer.parseInt(lineOne[1])];
	    //System.out.println(board.length + " " + board[0].length);
 	    
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(1);
	}

	return 0;
    }



}
