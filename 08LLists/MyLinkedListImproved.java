import java.util.Iterator;
public class MyLinkedListImproved<TypO extends Comparable<TypO>> implements Iterable<TypO>{

    public void extend(MyLinkedListImproved<TypO> z){
	if (z.start != null){
	    if (start == null){
		start = z.start;
	    }
	    else{
		z.start.setPrev(end);
		end.setNext(z.start);
	    }
	    end = z.end;	    
	    size += z.size;
	    z.clear();
	}
    }

    public void reverse(){
	if (start != null){
	    Node star = start;
	    Node tempy;
	    for(int i = 0; i < size; i++){
		tempy = star.getPrev();
		star.setPrev(star.getNext());
		star.setNext(tempy);
		star = star.getPrev();
	    }
	    //System.out.println(start + " " + end);

	    Node temp = end;
	    end = start;
	    start = temp;
	}
	//System.out.println(start + " " + end);
	
    }
    
    public static void main(String[] args){
	MyLinkedListImproved<String> s = new MyLinkedListImproved<>();
	s.add("asdasda");
	s.add("asdasda");

	MyLinkedListImproved<String> st = new MyLinkedListImproved<>();
	st.add("asda132131223sda");
	st.add("as123213123a");

	MyLinkedListImproved<String> sty = new MyLinkedListImproved<>();
	sty.add("sads");
	sty.add("sasd");
	
	s.extend(st);
	s.extend(sty);
	System.out.println(s);
	s.reverse();
	System.out.println(s);

	MyLinkedListImproved<Integer> t = new MyLinkedListImproved<>();
	for (int i = 0; i < 3; i++){
	    t.add(2);
	}
	t.add(3);
	t.add(0);
	System.out.println(t);
	for (Integer x: t){
	    System.out.print(x + " ");
	}
	System.out.println(t.max() + " " + t.min());
    }
    
    public Node start, end;
    public int size;

    private Node getNode(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	if (index == size-1){
	    return end;
	}
	
	Node curr = start;

	while (index > 0){
	    curr = curr.getNext();
	    index-=1;
	}

	return curr;
    }
    
    
    public MyLinkedListImproved(){
	start = null;
	end = null;
	size = 0;
    }
    
    public String toString(){
	Node curr = start;
	String result = "[";
	for (TypO z: this){
	    result += "" + z + ",";
	}
	result += "]";
	return result;
    }

    public void clear(){
	start = null;
	end = null;
	size = 0;
    }
    
    public int size(){
	return size;
    }

    public TypO get(int index){
	return getNode(index).getValue();
    }

    public int max(){
	int big = -1;
	int counter = 0;
	TypO bigy = null;
	try{
	    bigy = start.getValue();
	    big = 0;
	}
	catch(NullPointerException n){
	    return big;
	}
	
	for(TypO x: this){
	    if (x.compareTo(bigy) > 0){
		big = counter;
		bigy = x;
	    }
	    counter+=1;
	}
	return big;
    }

    public int min(){
	int small = -1;
	int counter = 0;
	TypO smally = null;
	try{
	    smally = start.getValue();
	    small = 0;
	}
	catch(NullPointerException n){
	    return small;
	}
	
	for(TypO x: this){
	    if (x.compareTo(smally) < 0){
		small = counter;
		smally = x;
	    }
	    counter+=1;
	}
	return small;
    }

    public TypO set(int index, TypO value){
	getNode(index).setValue(value);
	return value;
    }

    public int indexOf(TypO value){
	int count = 0;
	Node curr = start;
	
	for (int i = 0; i < size; i++){
	    if (curr.getValue().equals(value)){
		return count;
	    }

	    curr = curr.getNext();
	    count++;
	}
	
	return -1;
    }
    
    public boolean add(TypO newData){
	add(size, newData);
	return true;
    }
    
    public void add(int index, TypO value){
	Node newy = new Node(value);
	Node curr;
	if (size == 0){
	    //newy.setPrev(newy);
	    //newy.setNext(newy);
	    start = newy;
	    end = newy;
	}
	else{
	    if (index == 0){
		curr = start;
		newy.setPrev(newy);
		newy.setNext(curr);
		curr.setPrev(newy);
		start = newy;
	    }
	    else if (index == size){
		curr = end;
		newy.setPrev(curr);
		newy.setNext(null);
		curr.setNext(newy);
		end = newy;
	    }
	    else{
		curr = getNode(index);
		//System.out.println("Here");
		curr.getPrev().setNext(newy);
		newy.setPrev(curr.getPrev());
		newy.setNext(curr);
		curr.setPrev(newy);
		//System.out.println(this);
	    }
	}

	
	size+=1;
    }

    public boolean remove(TypO value){
	int index = 0;
	Node curr = getNode(index);
	//System.out.println(start);
	while (!curr.getValue().equals(value) && !curr.equals(end)){
	    //System.out.println("NO");
	    curr = curr.getNext();
	    index+=1;
	}
	if (curr.getValue().equals(value)){
	    //System.out.println("NO");
	    remove(index);
	    return true;
	}
	return false;
	
	
    }
    
    public TypO remove(int index){
	Node removy = getNode(index);	    
	Node prevy = removy.getPrev();
	Node nexty = removy.getNext();

	if (size == 0){
	    start = end = null;
	}
	else if (index == 0){
	    start = nexty;
	    nexty.setPrev(nexty);
	}
	else if (index == size-1){
	    end = prevy;
	    prevy.setNext(prevy);
	}
	else{	    	
	    nexty.setPrev(prevy);
	    prevy.setNext(nexty);
	}
       
	size-=1;
	return removy.getValue();
	
    }

    private class Node{
	private Node next, prev;
	private TypO data;

	public Node(TypO daty){
	    data = daty;
	    next = null;
	    prev = null;
	}

	public Node getNext(){return next;}
	public Node getPrev(){return prev;}
	public TypO getValue(){return data;}

	public void setNext(Node nexy){next = nexy;}
	public void setPrev(Node prey){prev = prey;}
	public void setValue(TypO daty){data = daty;}
	
	public String toString(){return "" + getValue();}
    }

    public Iterator<TypO> iterator(){
	return new NodeIterator(start);
    }

    private class NodeIterator implements Iterator<TypO>{
	Node curr;
	public NodeIterator(Node start){
	    curr = start;
	}

	public TypO next(){
	    if(hasNext()){
		TypO ans = curr.getValue();
		curr = curr.getNext();
		return ans;
	    }
	    else{
		System.exit(1);
	    }
	    return null;
	}
	
	public boolean hasNext(){
	    return !(curr == null);
	}
	
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }


}
