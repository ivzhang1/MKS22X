import java.util.LinkedList;

public class FrontierStack implements Frontier{
    public LinkedList stack;

    public Location next(){
	return null;
    }
    
    public void add(Location n){
    }
    
    public boolean hasNext(){
	return true;
    }
}
