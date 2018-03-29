public class MyLinkedList{

    public static void main(String[] args){
	MyLinkedList ly = new MyLinkedList();
    }
    
    public Node start, end;
    public int size;

    private Node getNode(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
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
	return "";
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

    public void set(int index, Integer value){
	getNode(index).setValue(value);
    }

    public int indexOf(Integer value){
	int count = 0;
	Node curr = start;
	
	for (int i = 0; i < size; i++){
	    if (curr.getValue().equals(value)){
		return count;
	    }

	    curr = start.getNext();
	    count++;
	}
	
	return 0;
    }
    
    public boolean add(Integer newData){
	Node newy = new Node(newData);
	end.setNext(newy);
	newy.setPrev(end);
	end = newy;
	return true;
    }
    
    public void add(int index, Integer value){
	Node curr = getNode(index);
	Node newy = new Node(newData);
	end.setNext(newy);
	newy.setPrev(end);
	end = newy;
	return true;
    }

    public void remove(int index){
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
