import java.io.*;
public class Driver{

    public static void main(String[]args){
	Maze f;

	try {
	    // System.out.println("TestMazes/"+ i + ".dat");
	    f = new Maze("TestMazes/"+ 6 + ".dat");//true animates the maze.
	    f.setAnimate(true);
	    System.out.println(f.solve());

	    System.out.println(f);

	}catch(FileNotFoundException e){
	    System.out.println("Bad file");
	    System.exit(1);
	}
        
    }
    
}
