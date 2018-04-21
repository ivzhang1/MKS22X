import java.util.NoSuchElementException;
import java.util.ArrayList;
public class MyDeque<E>{
    
    private E[] l;
    public int start, end;
    private int cap;

    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}
	//System.out.println(a1);
	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}

	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	    System.out.println(a1.start + " " + a1.end);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }
    
    public String toString(){
	String res = "";
	if(start == end){
	    end = start+1;
	}
	for(int i = start; i != end; i%=l.length){
	    res += l[i] + ", ";
	    i+=1;
	    //System.out.println(start + " " + end);
	}
	return res;
    }

    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	cap = 0;
	end = -1;
	l = (E[])new Object[10];
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initCap){
	l = (E[])new Object[initCap];
	cap = 0;
	end = -1;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	E[] m = l;
	int len = l.length;
	l = (E[])new Object[len*2];

	for(int i = 0; i < len; i++){
	    l[i] = m[(start+i)%len];
	}
	
	start = 0;
	end = len - 1;
	//System.out.println(start + " " + end);
    }
    
    public int size(){return cap;}
    
    //Never add null
    public void addFirst(E a){
	if(a == null) throw new NullPointerException();

	if(size() == l.length){
	    resize();
	}
	
	start -= 1;
	if (start == -1){
	    start = l.length - 1;
	}
	
	l[start] = a;
	cap++;

    }
    
    public void addLast(E a){
	if(a == null) throw new NullPointerException();
	if(size() == l.length){
	    resize();
	}
	end = (end + 1) % l.length;
	l[end] = a;
	cap++;
	    
	//System.out.println(cap);
    }

    //NoSuchElementException
    public E removeFirst(){
	if(size() == 0) throw new NoSuchElementException();
	E removend = l[start];
	
	l[start] = null;
	start = (start + 1)%l.length;
	cap-=1;
	
	return removend;
    }
    public E removeLast(){
	if(size() == 0) throw new NoSuchElementException();

	E removend = l[end];

	l[end] =  null;
	end -= 1;
	if(end == -1){
	    end = l.length - 1;
	}
	cap-=1;
	
	return removend;
    }

    public E getFirst(){
	if(size() == 0) throw new NoSuchElementException();

	return l[start];
    }
    public E getLast(){
	if(size() == 0) throw new NoSuchElementException();

	return l[end];
    }
}
