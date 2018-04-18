import java.util.LinkedList;

public class DEQ<E>{

    private LinkedList<E> ll;
    private int start, end;
    
    //Never add null
    public void addFirst(){
    }
    public void addLast(){
    }

    //NoSuchElementException
    public void removeFirst(){
    }
    public void removeLast(){
    }

    public E getFirst(){

	return ll.get(0);
    }
    public E getLast(){
	return  ll.get(0);
    }
}
