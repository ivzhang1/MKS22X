public class Merge{
    public static void main(String[] args){
	
    }

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	//toString(data);
	msort(data, temp, 0, data.length-1);
    }

    public static void msort(int[] data, int[] temp, int lo, int hi){
	if (hi - lo <= 35){
	    insertionSort(data, lo, hi);
	    return;
	}
	else{
	    for (int i = lo; i <= hi; i++){
		temp[i] = data[i];
	    }
	    int mid = hi/2 + lo/2;
		
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid+1, hi);
	    merge(data, temp, lo, mid, hi);
	}
       
    }

    public static void insertionSort(int[] ary, int lo, int hi){

	for (int i = lo+1; i <= hi; i++){
	    int key = ary[i];
	    int past = i;

	    while (past > lo && key < ary[past-1]){
		ary[past] = ary[past-1];
		past-=1;
	    }

	    ary[past] = key;
	}

    }
    
    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int medic = mid+1;
	int count = lo;
	

	while(lo <= mid && medic <= hi){

	    if (temp[lo] <= temp[medic]){
		data[count] = temp[lo];
		lo++;
	    }
	    else{
		data[count] = temp[medic];
		medic++;
	    }
	    count++;
	    //toString(temp);
	}

	while (lo <= mid){
	    data[count] = temp[lo];
	    lo++;
	    count++;
	}

	while (medic <= hi){
	    //System.out.println(count);
	    data[count] = temp[medic];
	    medic++;
	    count++;
	}	

    }

    
    public static void toString(int[] parti){
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
