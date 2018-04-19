import java.util.NoSuchElementException;

public class MyDeque<E>{
    
    private E[] l;
    private int start, end;
    private int cap;

    public static void main(String[] args){
	MyDeque<String> e = new MyDeque<>();
	for (int i = 0; i < 11; i++){
	    e.addFirst("" + i);
	}
	System.out.println(e);
    }

    public String toString(){
	String res = "";
	for(int i = start; i != end; i%=l.length){
	    res += l[i] + ", ";
	    i+=1;
	    System.out.println(start + " " + end);
	}
	return res;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	cap = 0;
	l = (E[])new Object[10];
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initCap){
	l = (E[])new Object[initCap];
	cap = 0;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	E[] m = l;
	l = (E[])new Object[cap*2];
	int len = m.length;
	int z = 0;

	System.out.println(start + " " + end);
	

	System.out.println();
	for(int k = 0; k < l.length; k++){
	    System.out.println(l[k]);
	}
	
	
	start = 0;
	end = z;
	
    }
    
    public int size(){return cap;}
    
    //Never add null
    public void addFirst(E a){
	if(a == null) throw new NullPointerException();
	if(size() == l.length){
	    resize();
	}
	if(size() == 0){
	    start = 0;
	    end = 1;
	    l[start] = a;
	}
	else if(start == 0){
	    start = l.length - 1;
	    l[start] = a;
	}
	else{
	    start -= 1;
	    l[start] = a;
	}
	cap+=1;
    }
    public void addLast(E a){
	if(a == null) throw new NullPointerException();
	if(size() == l.length){
	    resize();
	}
		
    }

    //NoSuchElementException
    public E removeFirst(){
	if(size() == 0) throw new NoSuchElementException();
	return null;
    }
    public E removeLast(){
	if(size() == 0) throw new NoSuchElementException();
	return null;		
    }

    public E getFirst(){
	if(size() == 0) throw new NoSuchElementException();

	return null;
    }
    public E getLast(){
	if(size() == 0) throw new NoSuchElementException();

	return null;
    }
}
