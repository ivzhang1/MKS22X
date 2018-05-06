public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
      maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
      if(mode == 0){
	  frontier = new FrontierQueue();
      }
      else{
	  frontier = new FrontierStack();
      }

      frontier.add(Maze.getStart());
      Location end = Maze.getEnd();
      while(frontier.hasNext()){
	  Location[] nextL = Maze.getNeighbors(frontier.next());
	  for(Location l: nextL){
	      if(!l.equals(null)){

		  if(l.equals(end)){
		      return true;
		  }

		  frontier.add(l);
	      }
	  }
      }
      
      return false;
  }

  public String toString(){
    return maze.toString();
  }
}

