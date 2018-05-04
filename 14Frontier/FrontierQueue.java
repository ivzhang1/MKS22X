import java.util.LinkedList;
public class FrontierQueue implements Frontier{
    public LinkedList queue;
    public Location next(){
	return null;
    }
    public void add(Location n){}
    public boolean hasNext(){
	return true;
    }
}
