import java.lang.Math;


public class MazeGenerator{
    private int[][] maze;
    private int numR;
    private int numC;

    public static void main(String[] args){
	if (args.length != 2){
	    System.out.println("Enter what size you want the maze: Width Length");
	    System.exit(1);
	}
	for (int i = 0; i < 2; i++){
	    try {
		if (Integer.parseInt(args[i])< 4){
		    System.out.println("You can't make a (good) maze of size 3 - 2 (walls) = 1");
		    System.exit(1);
		}
	    } catch(NumberFormatException e){
		System.out.println(args[i] + "is not a number [angry emoji]");
		System.exit(1);
	    }
	}

	
	MazeGenerator mazeGen = new MazeGenerator(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	System.out.println(mazeGen);

    }

    public MazeGenerator(int r, int c){
	maze = new int[r][c];
	numR = r;
	numC = c;
	int startingX = (int) (Math.random() * r);
	int startingY = (int) (Math.random() * c);
	System.out.println(startingX + " " + startingY);
	System.out.println(createMaze(startingX, startingY));
    }

    private String createMaze(int startX, int startY){
	if (makeHelp(startX, startY)){
	    return "Done";
	}
	return "Oh no!";
	
    }

    private boolean makeHelp(int x, int y){
	if (maze[r][c] == 1){
	    return false;
	}
	
    }

    

    



    public String toString(){
	String returned = "";
	for (int r = 0; r < numR; r++){
	    for (int c = 0; c < numC; c++){
		String current = "" + maze[r][c];
		returned += current;
	    }
	    returned += "\n";
	}
	return returned;
    }
    
}
