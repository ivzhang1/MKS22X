public class Sorts{

    public static void main(String[] args){
        int[] heap = new int[15];

	for(int i = 0; i < heap.length; i++){
	     heap[i] = (int)(Math.random() * 10);
        }
	// //System.out.println(toString(heap));
	heapSort(heap);
	System.out.println(toString(heap));

    }
    
    public static void heapSort(int[] ary){
	heapify(ary, ary.length-1);
	for(int i = ary.length-1; i>-1; i-=1){
	    swap(ary, 0, i);
	    pushDown(ary, 0, i);
	}
	if(ary.length > 2 && ary[0] > ary[1]){
	    swap(ary, 0, 1);
	}
	if(ary[ary.length-2] > ary[ary.length-1]){
	    swap(ary, ary.length-1, ary.length-2);
	}
    }
    
    public static void heapify(int[] mess, int len){
	for (int i=len+1; i>-1; i--){

	    pushDown(mess, i, len);	
	    //System.out.println(i);
	}
    }
    
    private static void pushDown(int[] heap, int starting, int end){
	int id = 2 * starting;
	
	if(id+1 < end && heap[id + 1] > heap[starting] && heap[id + 1] > heap[id+2]){
	    swap(heap, starting, id + 1);
	    pushDown(heap, id+1, end);
	}
	else if(id+2 < end && heap[id + 2] >= heap[starting] && heap[id + 2] >= heap[id+1]){
	    swap(heap, starting, id + 2);
	    pushDown(heap, id + 2, end);
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


