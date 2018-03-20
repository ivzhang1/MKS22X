public class Merge{
    public static void main(String[] args){}

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];

	msort(data, temp, 0, data.length-1);
    }

    public static void msort(int[] data, int[] temp, int lo, int hi){
	if (lo < hi){
	    mid = (hi + lo)/2;
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid + 1, hi);
	    merge(data, temp, lo, mid, hi);
	}
    }

    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	
	
    }

    
}
