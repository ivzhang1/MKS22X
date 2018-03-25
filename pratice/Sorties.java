public class Sorties{

    public static void insertionsort(int[] data, int start, int end){
	for (int i = start+1; i <= end; i++){
	    int currentPos = i;
	    int currentVal = data[i];
	    while (currentPos >= start+1 && currentVal <= data[currentPos-1]){
		data[currentPos] = data[currentPos-1];
		currentPos-=1;
	    }
	    data[currentPos] = currentVal;
	}
    }
    
    public static void quicksort(int[] data){
	quicksorty(data, 0, data.length-1);
    }

    public static void quicksorty(int[] data, int start, int end){
	if (end - start <= 35){
	    insertionsort(data, start, end);
	}
	else if (end > start){
	    int mid = (int)(Math.random()*(end-start+1) + start);
	    int pivot = mid;
	    int pivotal = data[pivot];
	    int k = start+1;
	    int smol = start;
	    int endy = end;
	    
	    swap(data, pivot, start);

	    while(k <= end){
		if (data[k] == pivotal){
		    k++;
		}
		else if (pivotal < data[k]){
		    swap(data, k, end);
		    end -= 1;
		}
		else{
		    swap(data, smol, k);
		    k++;
		    smol++;
		}
		    
	    }
	    
	    
	    quicksorty(data, start, smol);
	    quicksorty(data, end, endy);
	}
    }


    public static void swap(int[] data, int one, int two){
	int temp = data[one];
	data[one] = data[two];
	data[two] = temp;
    }

    
    public static void mergesort(int[] data){
	int[] tempy = new int[data.length];
	mergeysort(data, tempy, 0, data.length-1);
    }

    public static void mergeysort(int[] data, int[] temp, int start, int end){
	if (start > end){
	    int midy = (start + end)/2;
	    for (int i = start; i <= end; i++){
		temp[i] = data[i];
	    }
	    
	    mergeysort(temp, data, start, midy);
	    mergeysort(temp, data, midy+1, end);
	    merge(data, temp, start, midy, end);
	}
    }

    public static void merge(int[] data, int[] temp, int start, int mid, int end){
	int midesque = mid+1;
	int amp = start;

	while (start<=mid && midesque <= end){
	    if (temp[start] <= temp[midesque]){
		data[amp] = temp[start];
		start+=1;
	    }
	    else{
		data[amp] = temp[midesque];
		midesque+=1;
	    }
	    amp+=1;
	}

	while (start <= mid){
	    data[amp] = temp[start];
	    start+=1;
	    amp+=1;
	}

	while (midesque <= end){
	    data[amp] = temp[midesque];
	    midesque+=1;
	    amp+=1;
	}
	
    }

    

}
