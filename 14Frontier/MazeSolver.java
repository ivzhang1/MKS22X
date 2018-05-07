public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public static void main(String[] args){
	MazeSolver m = new MazeSolver(args[0]);
	System.out.println(m.solve(0));
	System.out.println(m);

	
	//MazeSolver n = new MazeSolver(args[0]);
	//System.out.println(n.solve(1));
	//System.out.println(n);

	
    }
    

    
    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    //Default to BFS
    public boolean solve(){ return solve(0); }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	if(mode == 1){
	    frontier = new FrontierQueue();
	}
	else{
	    frontier = new FrontierStack();
	}

	frontier.add(maze.getStart());
	Location end = maze.getEnd();
	while(frontier.hasNext()){


	    Location prev = frontier.next();
	    Location[] nextL = maze.getNeighbors(prev);
	    for(Location l: nextL){
		if(l != null){
		    char chary = maze.get(l.xL(), l.yL());
		    if(chary == 'E'){
			maze.set(prev.xL(), prev.yL(), '.');

			return true;
		    }
		    //return true;
		    if(chary == ' '){
			frontier.add(l);
		    }
		}
	    }
	    System.out.println(maze.toStringColor());
	    maze.set(prev.xL(), prev.yL(), '.');
	}
      
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}

