import java.util.Stack;

public class FrontierStack implements Frontier{
    public Stack<Location> stack;

    public FrontierStack(){
	stack = new Stack<>();
    }
    
    public Location next(){
	return stack.pop();
    }
    
    public void add(Location n){
	stack.push(n);
    }
    
    public boolean hasNext(){
	return stack.size() != 0;
    }
}
