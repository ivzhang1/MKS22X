import java.util.LinkedList;

public class FrontierStack implements Frontier{
    public LinkedList<Location> stack;

    public FrontierStack(){
	stack = new LinkedList<>();
    }
    
    public Location next(){
	return stack.remove();
    }
    
    public void add(Location n){
	stack.addFirst(n);
    }
    
    public boolean hasNext(){
	return stack.size() != 0;
    }
}
