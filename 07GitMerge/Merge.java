public class Merge{
    public static void main(String[] args){
	
    }

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];

	msort(data, temp, 0, data.length-1);
    }

    public static void msort(int[] data, int[] temp, int lo, int hi){
	if (lo < hi){
	    for (int i = lo; i <= hi; i++){
		temp[i] = data[i];
	    }
	    int mid = (hi + lo)/2;

	    msort(temp, data, lo, mid);
	    msort(temp, data, mid+1, hi);
	    merge(data, temp, lo, mid, hi);
	}
    }

    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int curr = lo;
	
	while (lo <= hi){
	    if (temp[lo] <= temp[hi]){
		data[curr] = temp[lo];
		lo++;
	    }

	    else{
		data[curr] = temp[hi];
		hi-=1;
	    }
	    curr++;
	}

	
	System.out.println(curr);
	

	
    }

    
    private static void toString(int[] parti){
	for (int k = 0; k < parti.length; k++){
	    System.out.print(parti[k] + ", ");
	}
	System.out.println();
    }

    private static void toString(int[] parti, int start, int end){
	System.out.print("[");
	for (int k = start; k < end; k++){
	    System.out.print(parti[k] + ", ");
	}
	System.out.print("]");
	System.out.println();
    }
    
}
