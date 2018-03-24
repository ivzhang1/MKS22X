//me.dt.in.th/page/Quicksort

public class Quick{

    public static void main(String[] args){
    }


    public static void toString(int[] parti){
	for (int k = 0; k < parti.length; k++){
	    System.out.print(parti[k] + ", ");
	}
	System.out.println();
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
    
    public static void quicksort(int[] ary){
	quicksorty(ary, 0, ary.length-1);
    }

    private static void quicksorty(int[] ary, int start, int end){
	if (start < end){
	    
	    int i = (int)(Math.random() * ((end-start) + 1) + start);
	    int pivotal = ary[i];
	    int small = start;
	    int big = end;
	    int x = start + 1;

	    swap(ary, i, start);

	    //System.out.println(pivotal);
	    //toString(parti);


	    if (big - small < 1000){
	    	insertionSort(ary, start, end);
	    }
	    else{
	    
		while (x <= big){
		    //toString(parti);
		    //System.out.println("LOL: "  + "small: " + small + " big: " + big + " i: " + i);
		    //toString(parti);
		    //System.out.println(pivotal);
		    if (ary[x] < pivotal){
			swap(ary, x, small);
			small++;
			x++;
		    }
		    else if (ary[x] == pivotal){
			//System.out.println(i);
			x++;
			//toString(parti);
			//System.out.println(pivotal);
		    }
		    else{
			swap(ary, big, x);
			big-=1;
		    }
		}
		quicksorty(ary, start, small-1);
		quicksorty(ary, big+1, end);

	    }
	}
    }

    public static int quickselect(int[] ary, int k){
	return quickselecty(ary, k, 0, ary.length - 1);
    }

    private static int quickselecty(int[] ary, int k, int starty, int curr){
	int party = partition(ary, starty, curr);
	if (party == k){
	    return ary[k];
	}
	if (k > party){
	    return quickselecty(ary, k, party + 1, ary.length - 1);
	}	
	return quickselecty(ary, k, 0, party - 1);
    }


    ///THIS IS INCLUSIVE, includes end
    //@returns current location
    public static int partition(int[] parti, int start, int end){
	if (parti.length < 2){
	    return start;
	}
	int i = (int)(Math.random() * ((end-start) + 1) + start);
	int pivotal = parti[i];
	int small = start;
	int big = end;
	int x = start;

	swap(parti, i, start);

	//System.out.println(pivotal);
	//toString(parti);
	
	while (x <= big){
	    //toString(parti);
	    //System.out.println("LOL: "  + "small: " + small + " big: " + big + " i: " + i);
	    //toString(parti);
	    //System.out.println(pivotal);
	    if (parti[x] < pivotal){
		swap(parti, x, small);
		small++;
		x++;
	    }
	    else if (parti[x] == pivotal){
		//System.out.println(i);
		x++;
		//toString(parti);
		//System.out.println(pivotal);
	    }
	    else{
		swap(parti, big, x);
		big-=1;
	    }
	}
	//System.out.println("LOL: "  + "small: " + small + " big: " + big);
		    


	//swap(parti, start, i);

	//toString(parti);

	return i;
    }
    
    private static void swap(int[] base, int one, int two){
	int temp = base[one];
	base[one] = base[two];
	base[two] = temp;

    }







    
    // private static boolean partition(int[] parti, int start, int end){
	
    // 	Random rand = new Random();
    // 	int pivot = rand.nextInt((end-start)) + start;
    // 	int pivotal = parti[pivot];

    // 	int initEnd = end;
    // 	swap(parti, pivot, end);
    // 	end -= 1;
	
    // 	while (start < end){
    // 	    while(parti[start] >= pivotal && end > start){
    // 		swap(parti, start, end);
    // 		end-=1;
    // 		//toString(parti);
    // 		//System.out.println("pivot: " + pivot + " pivotal:" + pivotal+ " start:" + start + " big:" + end);
    // 	    }
    // 	    start+=1;
    // 	}
    // 	//toString(parti);

    // 	if (parti[initEnd] > parti[end]){
    // 	    swap(parti, initEnd, end + 1);
    // 	}
    // 	else{
    // 	    swap(parti, initEnd, end);
    // 	}
	
    // 	//toString(parti);
    // 	//System.out.println("pivot: " + pivot + " pivotal:" + pivotal+ " start:" + start + " big:" + end);
    // 	return true;
		
    // }

    
}
