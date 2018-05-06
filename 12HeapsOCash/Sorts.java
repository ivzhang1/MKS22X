public class Sorts{

    public static void main(String[] args){
	int[] heap = new int[15];

	for(int i = 0; i < 15; i++){
	    heap[i] = (int)(Math.random() * 10);
	}
	//System.out.println(toString(heap));
	heapify(heap);
	System.out.println(toString(heap));

    }
    
    public static void heapsort(int[] ary){
	heapify(ary);
	System.out.println(toString(ary));
	heapsortH(ary, ary.length-1);
    }

    public static void heapsortH(int[] ary, int end){
	if(end > 0){
	    swap(ary, 0, end);
	    pushDown(ary, 0);
	    heapsortH(ary, end-1);
	}
    }
    
    
    public static void heapify(int[] mess){
	for (int i=mess.length; i>-1; i--){
	    pushDown(mess, i);
	    //System.out.println(i);
	}
	pushDown(mess, 0);
    }
    
    private static void pushDown(int[] heap, int starting){
	int id = 2 * starting;

	if(id+1 < heap.length && heap[id + 1] > heap[starting] && heap[id + 1] > heap[id+2]){
	    swap(heap, starting, id + 1);
	    pushDown(heap, id+1);
	}
	else if(id+2 < heap.length && heap[id + 2] >= heap[starting] && heap[id + 2] >= heap[id+1]){
	    swap(heap, starting, id + 2);
	    pushDown(heap, id + 2);
	}

    }

    public static void pushUp(int[] heap, int starting){
	int id = (starting - 1) / 2;
	if(heap[starting] > heap[id]){
	    swap(heap, starting, id);
	    pushUp(heap, id);
	}
    }

    private static void swap(int[] base, int one, int two){
	int temp = base[one];
	base[one] = base[two];
	base[two] = temp;
    }

    public static String toString(int[] heap){
	String res = "[";
	for (int i = 0; i < heap.length; i++){
	    res += heap[i] + ", ";
	}

	return res + "]";
    }
    
}


