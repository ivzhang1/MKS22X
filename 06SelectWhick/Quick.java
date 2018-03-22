public class Quick{

    public static void main(String[] args){

	
	//MOST IMPORTANT TEST........PARTITION!!!
	//(This could be more extensive ..... and better .... and A LOT MORE!)
	//(My partition returns the index num of PIVOT, and is inclusive of the last num)
	System.out.println("TESTING PARTITION");

	int[] tests = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
	
	int ans = partition(tests, 0, tests.length - 1);
	System.out.println("Pivot: " + tests[ans] + " Index: " + ans);
	System.out.println("Pivot correct? " + checkPivot(tests, ans));
	toString(tests);

	
	int[] testt = {};
	ans = partition(testt, 0, 0);
	toString(testt);

	int[] testu = {1};
	ans = partition(testu, 0, 1);
	System.out.println("Pivot: " + testu[ans] + " Index: " + ans);
	toString(testu);


	int[] testv = {1,1};
	ans = partition(testv, 0, 1);
	System.out.println("Pivot: " + testv[ans] + " Index: " + ans);
	toString(testv);

	int[] testw = {2,1};
	ans = partition(testw, 0, 1);
	System.out.println("Pivot: " + testw[ans] + " Index: " + ans);
	toString(testw);

	int[] testx = {1,2};
	ans = partition(testx, 0, 1);
	System.out.println("Pivot: " + testx[ans] + " Index: " + ans);
	toString(testx);
	System.out.println("DONE!\n");



	//Borrowed most from K
	int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
	toString(test);	
	////SHOULD PRINT THE ARRAY IN ORDER FROM LEAST TO GREATEST
	System.out.println("\nPRINTING LEAST TO GREATEST");
	for (int i = 0; i < test.length; i++){
	    System.out.println(quickselect(test, i));;
	}
	System.out.println("DONE!\n");


	//Testing QuickSort
	System.out.println("TESTING QUICKSORT!");
	//General Case

	long start,end;
	start = System.currentTimeMillis();

	System.out.print("Before: ");
	int[] testy = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
	toString(testy);
	quicksort(testy);
	end = System.currentTimeMillis();

	System.out.print("aAfter: ");
	toString(testy);
	System.out.println("Time: " + (end-start) + "ms");

	//Edge Cases
	System.out.print("\nTESTING EDGY CASES!\n");

	int[] testz = {};
	System.out.print("Before: ");
	toString(testz);
	System.out.print("aAfter: ");
	quicksort(testz);
	toString(testz);
	System.out.println();

	int[] testa = {1};
	System.out.print("Before: ");
	toString(testa);
	System.out.print("aAfter: ");
	quicksort(testa);
	toString(testa);
	System.out.println();

	int[] testb = {1,1};
	System.out.print("Before: ");
	toString(testb);
	System.out.print("aAfter: ");
	quicksort(testb);
	toString(testb);
	System.out.println();

	int[] testc = {2,1};
	System.out.print("Before: ");
	toString(testc);
	System.out.print("aAfter: ");
	quicksort(testc);
	toString(testc);
	System.out.println();

	int[] testd = {1,2};
	System.out.print("Before: ");
	toString(testd);
	System.out.print("aAfter: ");
	quicksort(testd);
	toString(testd);
	System.out.println();
	
    }

    //Checks to see if pivot is correct
    //Given: ary, pivot
    private static boolean checkPivot(int[] ary, int pivot){
	for (int i = 0; i < pivot; i++){
	    if (ary[i] > ary[pivot]){
		return false;
	    }
	}
	for (int j = pivot + 1; j < ary.length; j++){
	    if (ary[j] < ary[pivot]){
		return false;
	    }
	}
	return true;
    }


    public static void toString(int[] parti){
	for (int k = 0; k < parti.length; k++){
	    System.out.print(parti[k] + ", ");
	}
	System.out.println();
    }

    public static void quicksort(int[] ary){
	quicksorty(ary, 0, ary.length-1);
    }

    private static void quicksorty(int[] ary, int start, int end){
	if (start < end){
	    int party = partition(ary, start, end);
	    //System.out.println(start + " " + end + " " + party);
	    quicksorty(ary, start, party-1);
	    quicksorty(ary, party+1, end);
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
	int small = start + 1;
	int big = end;

	swap(parti, i, start);

	//System.out.println(pivotal);
	//toString(parti);
	
	while (small <= big){
	    //toString(parti);
	    //System.out.println("LOL: "  + "small: " + small + " big: " + big + " i: " + i);
	    //toString(parti);
	    //System.out.println(pivotal);
	    if (parti[small] < pivotal){
		small++;
	    }
	    else if (parti[small] == pivotal && i <= big){
		//System.out.println(i);
		swap(parti, small, i);
		i++;
		//toString(parti);
		//System.out.println(pivotal);
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
