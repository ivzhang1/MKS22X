import java.util.LinkedList;
public class FrontierQueue implements Frontier{
    public LinkedList<Location> queue;

    public FrontierQueue(){
	queue = new LinkedList<>();
    }
    
    public Location next(){
	return queue.remove();
    }
    public void add(Location n){
	queue.add(n);
    }
    public boolean hasNext(){
	return queue.peek() != null;
    }

    public String toString(){
	String res = "[";
	for(Location x: queue){
	    res += "" + x + " , ";
	}
	return res + "]";
    }
}
