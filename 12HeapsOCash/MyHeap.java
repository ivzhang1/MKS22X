public class MyHeap{
    public static void main(String[] args){
	MyHeap heap = new MyHeap();
	for(int i = 0; i < 20; i += 1){
	    heap.add("" + i);
	}
	System.out.println(heap);
	for(int i = 0; i < 20; i += 1){
	    heap.remove();
	}
    }


    
    private String[] h;
    private int size = 0;
    private boolean max = true;
    
    public MyHeap(){
	h = new String[10];
    }

    public MyHeap(boolean isMax){
	this();
	max = isMax;
    }

    public void resize(){
	String[] temph = new String[size*2];
	for(int i = 0; i < size; i++){
	    temph[i] = h[i]; 
	}
	h = temph;
    }

    private static void swap(String[] base, int one, int two){
	String temp = base[one];
	base[one] = base[two];
	base[two] = temp;
    }

    public void pushU(int index){
	swap(h, index, (index-1)/2);
    }

    public void pushD(int index, int incr){
	swap(h, index, 2*index + incr);
    }
    
    public void add(String s){
	if(size == h.length){
	    resize();
	}
	h[size] = s;
	addH(s, size);
	size+=1;
    }

    public void addH(String s, int i){
	int id = (i - 1) / 2;
	if(s.compareTo(h[id]) > 0){
	    pushU(i);
	    addH(s,id);
	    //System.out.println(id + "" + i);
	}
    }

    public String remove(){
	if (size == 0){
	    return null;
	}
	String r = h[size];
	h[size] = null;
	size -= 1;
	return r;
    }

    public String remove(int index){
	if (index == size){
	    return remove();
	}
	h[index] = h[size];
	String temp = h[index];
	h[size] = null;
	removeH(h[index], index);	
	size-=1;
	return temp;
    }

    public void removeH(String s, int i){
	int id = i * 2;
	if(id > size){

	}
	else if(s.compareTo(h[id + 1]) > 0){
	    pushD(i, 1);
	    removeH(s, id);
	}
	else if(s.compareTo(h[id + 2]) > 0){
	    pushD(i, 2);
	    removeH(s, id);
	}
	    
    }

    public String peek(){
	if (h.length > 0) return h[0];
	return null;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String res = "[";
	for (int i = 0; i < size; i++){
	    res += h[i] + ", ";
	}
	return res + "]";
	
    }
    
}
