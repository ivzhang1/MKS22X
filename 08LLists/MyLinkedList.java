public class MyLinkedList{

    public Node first;
    public Node last;
    public int length;

    
    private class Node{
	private Node next, prev;
	private int data;

	public Node(int daty){
	    data = daty;
	    next = null;
	    prev = null;
	}

	public Node getNext(){
	    return next;
	}

	public Node getPrev(){
	    return prev;
	}

	public int getValue(){
	    return data;
	}

	public void setNext(Node nexy){
	    next = nexy;
	}

	public void setPrev(Node prey){
	    prev = prey;
	}

	public void setValue(int daty){
	    data = daty;
	}
	
	public String toString(){
	    return "" + getValue();
	}
    }


}
