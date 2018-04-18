import java.util.NoSuchElementException;

public class MyDeque<String>{

    private String[] ll;
    private int start, end;
    private int cap;
    
    public MyDeque(){
	cap = 10;
	ll = new String[10];
    }
    public MyDeque(int initCap){
	ll = new String[initCap];
	cap = initCap;
    }

    public int size(){return cap;}
    
    //Never add null
    public void addFirst(String a){
	if(a == null) throw new NullPointerException();
    }
    public void addLast(String a){
	if(a == null) throw new NullPointerException();
		
    }

    //NoSuchElementException
    public String removeFirst(){
	if(size() == 0) throw new NoSuchElementException();
	return null;
    }
    public String removeLast(){
	if(size() == 0) throw new NoSuchElementException();
	return null;		
    }

    public String getFirst(){
	if(size() == 0) throw new NoSuchElementException();

	return null;
    }
    public String getLast(){
	if(size() == 0) throw new NoSuchElementException();

	return null;
    }
}
