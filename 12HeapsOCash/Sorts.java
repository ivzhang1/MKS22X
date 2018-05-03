public class Sorts{

    public static void main(String[] args){
	int[] heap = new int[15];

	for(int i = 0; i < 15; i++){
	    heap[i] = (int)(Math.random() * 10);
	}
	System.out.println(toString(heap));
	heapify(heap, heap.length-1);
	System.out.println(toString(heap));
	heapsort(heap);
	System.out.println(toString(heap));

    }
    
    public static void heapsort(int[] ary){
	heapify(ary, ary.length-1);
	heapsortH(ary, ary.length-1);
    }

    public static void heapsortH(int[] ary, int end){
	if(end > 0){
	    swap(ary, 0, end);
	    pushDown(ary, ary[0], 0, end);
	    heapsortH(ary, end-1);
	}
    }
    
    public static void heapify(int[] mess, int i){
	if(i > 0){
	    pushUp(mess, mess[i], i);
	    heapify(mess, i - 1);
	}
    }
    
    private static void pushDown(int[] heap, int c, int starting, int end){
	int id = 2 * starting;

	if(id+1 >= end || id+2 >= end){
	}
	else if(heap[id + 1] > c && heap[id + 1] > heap[id+2]){
	    swap(heap, starting, id + 1);
	    pushDown(heap, c, id+1, end);
	}
	else if(heap[id + 2] > c && heap[id + 2] > heap[id+1]){
	    swap(heap, starting, id + 2);
	    pushDown(heap, c, id + 2, end);
	}
    }

    public static void pushUp(int[] heap, int c, int starting){
	int id = (starting - 1) / 2;
	if(c > heap[id]){
	    swap(heap, starting, id);
	    pushUp(heap, c, id);
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


