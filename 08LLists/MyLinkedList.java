public class MyLinkedList{

    public Node start, end;
    public int size;

    private Node getNode(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	if (index == size){
	    return end;
	}
	
	Node curr = start;

	while (index > 0){
	    curr = curr.getNext();
	    index-=1;
	}

	return curr;
    }
    
    
    public MyLinkedList(){
	start = null;
	end = null;
	size = 0;
    }
    
    public String toString(){
	Node curr = start;
	String result = "[";
	//System.out.println(size);
        for (int i = 0; i < size; i++){
	    result += curr.getValue() + ",";
	    //System.out.println(curr);
	    curr = curr.getNext();
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

    public int get(int index){
	return getNode(index).getValue();
    }

    public Integer set(int index, Integer value){
	getNode(index).setValue(value);
	return value;
    }

    public int indexOf(Integer value){
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
    
    public boolean add(Integer newData){
	add(size, newData);
	return true;
    }
    
    public void add(int index, Integer value){
	Node newy = new Node(value);

	if (size == 0){
	    newy.setPrev(newy);
	    newy.setNext(newy);
	    start = newy;
	    end = newy;
	}
	else{
	    Node curr = getNode(index);
	    if (index == 0){
		newy.setPrev(newy);
		newy.setNext(curr);
		curr.setPrev(newy);
		start = newy;
	    }
	    else if (index == size){
		//System.out.println("There");
		newy.setPrev(curr);
		newy.setNext(newy);
		curr.setNext(newy);
		end = newy;
	    }
	    else{
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

    public boolean remove(Integer value){
	Node curr = start;
	int index = 0;
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
    
    public void remove(int index){
	Node removy = getNode(index);
	Node prevy = removy.getPrev();
	Node nexty = removy.getNext();
	
	if (index == 0){
	    start = nexty;
	    nexty.setPrev(nexty);
	}
	else if (index == size){
	    end = prevy;
	    prevy.setNext(prevy);
	}
	else{	    	
	    nexty.setPrev(prevy);
	    prevy.setNext(nexty);
	}
       
	size-=1;
	
    }
    
    private class Node{
	private Node next, prev;
	private Integer data;

	public Node(Integer daty){
	    data = daty;
	    next = null;
	    prev = null;
	}

	public Node getNext(){return next;}
	public Node getPrev(){return prev;}
	public Integer getValue(){return data;}

	public void setNext(Node nexy){next = nexy;}
	public void setPrev(Node prey){prev = prey;}
	public void setValue(Integer daty){data = daty;}
	
	public String toString(){return "" + getValue();}
    }


}
