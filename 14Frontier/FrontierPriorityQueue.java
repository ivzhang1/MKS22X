public class FrontierPriorityQueue implements Frontier{
    public MyHeap<Location> pQueue;
    public Location end;
    
    public FrontierPriorityQueue(){
	pQueue = new MyHeap<>(false);
    }
    public FrontierPriorityQueue(Location endy){
	pQueue = new MyHeap<>(false);
	end = endy;
    }
    
    public Location next(){
	return pQueue.remove();
    }
    public void add(Location n){
	double dist = Math.sqrt(
				Math.pow((end.xL()-n.xL()),2) +
				Math.pow((end.yL()-n.yL()),2)
				);
	n.distance = dist;
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
