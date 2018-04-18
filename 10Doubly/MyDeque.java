import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyDeque<E>{

    private LinkedList<E> ll;
    private int start, end;
    private int cap;
    
    public MyDeque(){
	cap = 10;
	ll = new LinkedList<>();
    }
    public MyDeque(int initCap){
	ll = new LinkedList<>();
	cap = initCap;
    }

    public int size(){return cap;}
    
    //Never add null
    public void addFirst(E a){
	if(a == null) throw new NullPointerException();
    }
    public void addLast(E a){
	if(a == null) throw new NullPointerException();
		
    }

    //NoSuchElementException
    public E removeFirst(){
	if(size() == 0) throw new NoSuchElementException();
	return ll.get(0);
    }
    public E removeLast(){
	if(size() == 0) throw new NoSuchElementException();

	return ll.get(0);		
    }

    public E getFirst(){
	if(size() == 0) throw new NoSuchElementException();

	return ll.get(0);
    }
    public E getLast(){
	if(size() == 0) throw new NoSuchElementException();

	return  ll.get(0);
    }
}
