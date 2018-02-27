import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Daedalus {

    private char[][] maize;
    private int numRows;
    private int numCols;
    private int startR;
    private int startC;
    private int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};


    public static void main(String args[]){
	Daedalus GMO = new Daedalus();
	System.out.println(GMO);
	System.out.println(GMO.solveMaze());
	System.out.println(GMO);
		
    }


    public Daedalus(){
	this("Maze2.txt");
    }

     public Daedalus(String fileName){
	 try{
	     kernelPlanter(fileName);
	 }
	 catch(FileNotFoundException e){
	     System.out.println("Enter a correct filename");
	 }
	     
     }

	    
    
    public void kernelPlanter(String fileName) throws FileNotFoundException {


        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File("Mazes/" + fileName);// can be a path like: "/full/path/to/file.txt" 
        

        //inf stands for the input file

        Scanner inf = new Scanner(text);
	
	File fakeText = new File("Mazes/" + fileName);
	Scanner infClone = new Scanner(fakeText);
	int rows = 0;
	while(infClone.hasNextLine()){
	    rows++;
	}
	
	maize = new char[rows][longest];
	numRows = rows;
	numCols = longest - 1;

	int currentR = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    for (int i = 0; i < line.length(); i++){
		if (line.charAt(i) == 'S'){
		    startR = currentR;
		    startC = i;
		    //System.out.println(startR + " " + startC);
		}
		maize[currentR][i] = line.charAt(i);
	    }
	    currentR += 1;
        }       
    }

    private boolean solveMaze(){
	return solveMazeH(startR, startC);
    }

    private boolean solveMazeH(int r, int c){
	if (maize[r][c] == '#' || maize[r][c] == 'X'){
	    return false;
	}
	if (maize[r][c] == 'E'){
	    return true;
	}

	maize[r][c] = '7';
	if (solveMazeH(r+1, c)||solveMazeH(r-1, c)||solveMazeH(r, c+1)||solveMazeH(r, c-1)){
	    return true;
	}
	maize[r][c] = 'X';

	return false;
	
    }

    public String toString(){
	String returned = "";
	for (int r = 0; r < numRows; r++){
	    for (int c = 0; c < numCols; c++){
		String current = "" + maize[r][c];
		returned += current;
	    }
	    returned += "\n";
	}
	return returned;
    }

    
}
