public class QuickSelect{
    

    public static void main(String[] args){
	int[] test = {20,21,20};//, 111, 27, 17, 13, 21, 20, 14, 14, 81};
	System.out.println(partition(test));
    }

    private static boolean partition(int[] parti){
	int pivot = parti.length/2;
	if (pivot > 0){
	    int pivotal = parti[pivot];
	    
	    int bigInd = parti.length-1;
	    int big = parti[bigInd];

	    int smallInd = 0;
	    int small = parti[smallInd];
	    
	    swap(parti, bigInd, pivot);

	    bigInd -= 1;
	    big = parti[bigInd];
	    
	    while (smallInd <= bigInd){
		while (small > pivotal  && bigInd > 0){// && bigInd > smallInd){
		    swap(parti, smallInd, bigInd);
		    bigInd -= 1;
		    small = parti[smallInd];
		    for (int k = 0; k < parti.length; k++){
			System.out.print(parti[k] + " ");
		    }
		    System.out.println();
		}
        
		smallInd+=1;
		small = parti[smallInd];
	    }

	    if (bigInd == 0){
		swap(parti, 0, parti.length-1);
	    }
	    else{
		swap(parti, smallInd, parti.length-1);
	    }
	}
  

	//for (int k = 0; k < parti.length; k++){
	//    System.out.print(parti[k] + " ");
	//}
	//System.out.println(parti[3] + " " + parti[5]);
	//swap(parti, 3, 5);
	//System.out.println(parti[3] + " " + parti[5]);
	return true;	
		
    }

    private static void swap(int[] base, int one, int two){
	int temp = base[one];
	base[one] = base[two];
	base[two] = temp;

    }

    
}
