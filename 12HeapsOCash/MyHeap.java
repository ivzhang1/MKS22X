public class MyHeap<T extends Comparable<T>>{
    public static void main(String[] args){
	MyHeap<Integer> heap = new MyHeap<>();
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

	int[] test = new int[10];
	for(int z = 0; z < 10; z++){
	    test[z] = (int)(Math.random() * 10);
	}

	heapify(test,test.length-1);
	System.out.println();
	    
	for(int k = 0; k < 10; k++){
	    System.out.println(test[k]);
	}

    }


    
    private T[] h;
    private int size = 0;
    private boolean max = true;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	h = (T[])new Comparable[10];
    }

    public MyHeap(boolean isMax){
	this();
	max = isMax;
    }
    
    @SuppressWarnings("unchecked")
    public void resize(){
	T[] temph = (T[])new Comparable[size*2];
	for(int i = 0; i < size; i++){
	    temph[i] = h[i]; 
	}
	h = temph;
    }

    private void swap(T[] base, int one, int two){
	T temp = base[one];
	base[one] = base[two];
	base[two] = temp;
    }

    public void pushU(int index){
	swap(h, index, (index-1)/2);
    }

    public void pushD(int index, int incr){
	swap(h, index, 2*index + incr);
    }
    
    public void add(T s){
	if(size == h.length){
	    resize();
	}
	h[size] = s;
	addH(s, size);
	size+=1;
    }

    public void addH(T s, int i){
	int id = (i - 1) / 2;
	if(s.compareTo(h[id]) > 0){
	    pushU(i);
	    addH(s,id);
	    //System.out.println(id + "" + i);
	}
    }

    public T remove(){
	if (size == 0){
	    return null;
	}
	
	T r = h[0];
	h[0] = h[size-1];
	//System.out.println(
	removeH(h[size-1], 0);
	h[size-1] = null;

	size -= 1;
	return r;
    }

    public void removeH(T s, int i) {
	int id = 2 * i;

	if(id+1 >= size || id+2 >= size){
	}
	else if(h[id + 1].compareTo(s) > 0){
	    pushD(i, 1);
	    removeH(s, id+1);
	}
	else if(h[id + 2].compareTo(s) > 0){
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

    public T peek(){
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

    public static void pushDown(int[] h, int i, int not){
	//System.out.println("s");
	int id =  2*i;
	int s = h[i];
	if(id+1 >= h.length || id+2 >= h.length){
	}
	else{
	    if(id + 1 != not && h[id + 1]>=s && h[id+1] >= h[id+2]){
		swap(h, i, id+1);
		pushDown(h, id+1, not);
	    }
	    else if(id + 2 != not && h[id + 2] >= s && h[id+2] >= h[id+1]){
		swap(h, i, id+2);
		pushDown(h, id+2, not);
	    }
	}
    }

    
    public static void heapsort(int[] ary){
	heapify(ary, ary.length-1);
	for(int i = ary.length-1; i > 0; i-=1){
	    swap(ary, 0, i);
	    pushDown(ary, 0, i);
	} 
    }
    
    public static void heapify(int[] mess, int i){
	int it = i;
	if (i > 0){
	    while(mess[i] > mess[(i-1)/2]){
		swap(mess, i, (i-1)/2);
		i = (i - 1)/2;
		//System.out.println("\n" + i + "\n");
	    }
	    heapify(mess, it - 1);

	}

    }

    public int compareTo(T obj){
	int res = 
    }
    
    private static void swap(int[] base, int one, int two){
	int temp = base[one];
	base[one] = base[two];
	base[two] = temp;
    }
}
