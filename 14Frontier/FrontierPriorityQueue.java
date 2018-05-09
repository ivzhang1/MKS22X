public class FrontierPriorityQueue implements Frontier{
    public MyHeap<Location> pQueue;
    
    public FrontierPriorityQueue(){
	pQueue = new MyHeap<>(false);
    }

    public Location next(){
	return pQueue.remove();
    }
    public void add(Location n){
	pQueue.add(n);
    }
	    
    public boolean hasNext(){
	return pQueue.peek() != null;
    }

    public String toString(){
	String res = "[";
	return res + "]";
    }
}
