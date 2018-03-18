public class Quick{
    private int current = 0;

    public static void main(String[] args){
	int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000};
	//System.out.println(partition(test, 0, 10));
	toString(test);
	////SHOULD PRINT THE ARRAY IN ORDER FROM LEAST TO GREATEST
	for (int i = 0; i < test.length; i++){
	    System.out.println(quickselect(test, i));;
	}
    }

    public static void quicksort(int[] ary){
    }

    public static int quickselect(int[] ary, int k){
	return quickHelpy(ary, k, 0, ary.length - 1);
    }

    private static int quickHelpy(int[] ary, int k, int starty, int curr){
	int party = partition(ary, starty, curr);
	if (party == k){
	    return ary[k];
	}
	if (k > party){
	    return quickHelpy(ary, k, party + 1, ary.length - 1);
	}	
	return quickHelpy(ary, k, 0, party - 1);
    }


    ///THIS IS INCLUSIVE, includes end
    //@returns current location
    private static int partition(int[] parti, int start, int end){
	if (parti.length < 2){
	    return start;
	}
	int i = (int)(Math.random() * ((end-start) + 1) + start);
	int pivotal = parti[i];
	int small = start + 1;
	int big = end;

	swap(parti, i, start);

	//System.out.println(pivotal);
	//toString(parti);
	
	while (small <= big){
	    //toString(parti);
	    //System.out.println("LOL: "  + "small: " + small + " big: " + big + " i: " + i);
	    if (parti[small] < pivotal){
		small++;
	    }
	    else if(parti[small] == pivotal && i <= end){
		swap(parti, small, i);
		i++;
	    }
	    else{
		swap(parti, big, small);
		big-=1;
	    }
	}
	//System.out.println("LOL: "  + "small: " + small + " big: " + big);
		    


	swap(parti, start, big);

	//toString(parti);

	return big;
    }
    
    private static void swap(int[] base, int one, int two){
	int temp = base[one];
	base[one] = base[two];
	base[two] = temp;

    }

    private static void toString(int[] parti){
	for (int k = 0; k < parti.length; k++){
	    System.out.print(parti[k] + " ");
	}
	System.out.println();
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
