import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private int numRows;
    private int numCols;
    private int startR;
    private int startC;
    private int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean animate;//false by default
    
    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: throw Exception then Main prints out error.
      InvalidStateException

    */

    public Maze(String filename){
	try {
	    kernelPlanter(filename);
	} catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(1);
	}

	int countS = 0;
	int countE = 0;
	for (int r = 0; r < numRows; r++){
	    for (int c = 0; c < numCols; c++){
		if (maze[r][c] == 'S'){
		    countS += 1;
		}
		if (maze[r][c] == 'E'){
		    countE += 1;
		}
		
	    }
	}
	if (countS != 1 || countE != 1){
	    throw new IllegalStateException();
	}
    }
    
    public void kernelPlanter(String fileName) throws FileNotFoundException {


        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File(fileName);// can be a path like: "/full/path/to/file.txt" 
        

        //inf stands for the input file

        Scanner inf = new Scanner(text);
	
	File fakeText = new File(fileName);
	Scanner infClone = new Scanner(fakeText);
	int rows = 0;
	int length = 0;
	while(infClone.hasNextLine()){
	    rows++;
	    length = infClone.nextLine().length();
	}
	
	maze = new char[rows][length];
	numRows = rows;
	numCols = length;

	int currentR = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    for (int i = 0; i < line.length(); i++){
		if (line.charAt(i) == 'S'){
		    startR = currentR;
		    startC = i;
		    //System.out.println(startR + " " + startC);
		}
		maze[currentR][i] = line.charAt(i);
	    }
	    currentR += 1;
        }       
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

	//find the location of the S. 


	//erase the S


	//and start solving at the location of the s.

	return solve(startR,startC);

    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'

      Note: This is not required based on the algorithm, it is just nice visually to see.
      All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private

	int total = 0;
        //automatic animation! You are welcome.
        //if(animate){
            //clearTerminal();
            //System.out.println(this);

	    //wait(20);
	    //}

	if(maze[row][col] == 'E'){
	    return 1;
	}
	
	if(maze[row][col] == '.' || maze[row][col] == '#' || maze[row][col] == '@'){
	    return 0;
	}
	
	maze[row][col] = '@';
	//System.out.println(total);
	//System.out.println(this);
        int sum = solve(row+1, col) + solve(row-1,col) + solve(row,col+1) + solve(row, col-1);
	if (sum < 0){
	    maze[row][col] = '.';
	    return -1;
	}
	return total + sum + 1;
	

        //COMPLETE SOLVE

        //return total; //so it compiles
    }

    public String toString(){
	String returned = "";
	for (int r = 0; r < numRows; r++){
	    for (int c = 0; c < numCols; c++){
		String current = "" + maze[r][c];
		returned += current;
	    }
	    returned += "\n";
	}
	return returned;
    }
}


