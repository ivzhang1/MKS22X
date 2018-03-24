public class Merge{
    public static void main(String[] args){
	
    }

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	//toString(data);
	msort(data, temp, 0, data.length-1);
    }

    public static void msort(int[] data, int[] temp, int lo, int hi){
	if (lo < hi){
	    for (int i = lo; i <= hi; i++){
		temp[i] = data[i];
	    }
	    int mid = (hi + lo)/2;

	    if (hi - lo < 1000){
		insertionSort(data, lo, hi);
	    }
	    else{
		msort(temp, data, lo, mid);
		msort(temp, data, mid+1, hi);
		merge(data, temp, lo, mid, hi);
	    }
	}
    }

    public static void insertionSort(int[] data, int start, int end){
	int place = 0;
	int temp = 0;
	int temp2 = 0;

	for (int i = start; i <= end; i++){
	    int n = 0;
	    place = data[i];

	    while(data[n] < place && n < i){
		n++;
	    }
	    temp = data[n];
	    for (int k = n; k < i; k++){
		temp2 = data[k+1];
		data[k+1] = temp;
		temp = temp2;
	    }
	    data[n] = place;

	}

    }
    
    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int medic = mid+1;

	for (int i = lo; i <= hi; i++){
	    if (lo <= mid && (medic > hi || temp[lo] < temp[medic])){
		data[i] = temp[lo];
		lo++;
	    }
	    else{
		data[i] = temp[medic];
		medic++;
	    }

	    
	}

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
