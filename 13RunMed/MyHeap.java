public class MyHeap{
    public static void main(String[] args){
	MyHeap heap = new MyHeap();
	for(int i = 0; i < 10; i++){
	    heap.add(i);
	}
	System.out.println(heap);
	heap.remove();
	System.out.println(heap);

	heap.remove();
	System.out.println(heap);

	heap.remove();

	System.out.println(heap);

    }


    
    private Integer[] h;
    private int size = 0;
    private boolean max = true;
    
    public MyHeap(){
	h = new Integer[10];
    }

    public MyHeap(boolean isMax){
	this();
	max = isMax;
    }

    public void resize(){
	Integer[] temph = new Integer[size*2];
	for(int i = 0; i < size; i++){
	    temph[i] = h[i]; 
	}
	h = temph;
    }

    private static void swap(Integer[] base, int one, int two){
	Integer temp = base[one];
	base[one] = base[two];
	base[two] = temp;
    }

    public void pushU(int index){
	swap(h, index, (index-1)/2);
    }

    public void pushD(int index, int incr){
	swap(h, index, 2*index + incr);
    }
    
    public void add(Integer s){
	if(size == h.length){
	    resize();
	}
	h[size] = s;
	addH(s, size);
	size+=1;
    }

    public void addH(Integer s, int i){
	int id = (i - 1) / 2;
	if(s > h[id]){
	    pushU(i);
	    addH(s,id);
	    //System.out.println(id + "" + i);
	}
    }

    public Integer remove(){
	if (size == 0){
	    return null;
	}
	
	Integer r = h[0];
	h[0] = h[size-1];
	//System.out.println(
	removeH(h[size-1], 0);
	h[size-1] = null;

	size -= 1;
	return r;
    }

    public void removeH(Integer s, int i) {
	int id = 2 * i;

	if(id+1 >= size || id+2 >= size){
	}
	else if(h[id + 1] > s){
	    pushD(i, 1);
	    removeH(s, id+1);
	}
	else if(h[id + 2] > s){
	    pushD(i, 2);
	    removeH(s, id + 2);
	}
    }

    // public String remove(int index){
    // 	if (index == size){
    // 	    return remove();
    // 	}
    // 	h[index] = h[size];
    // 	String temp = h[index];
    // 	h[size] = null;
    // 	removeH(h[index], index);	
    // 	size-=1;
    // 	return temp;
    // }

    // public void removeH(String s, int i){
    // 	int id = i * 2;
    // 	if(id > size){

    // 	}
    // 	else if(s.compareTo(h[id + 1]) > 0){
    // 	    pushD(i, 1);
    // 	    removeH(s, id);
    // 	}
    // 	else if(s.compareTo(h[id + 2]) > 0){
    // 	    pushD(i, 2);
    // 	    removeH(s, id);
    // 	}
	    
    // }

    public Integer peek(){
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
