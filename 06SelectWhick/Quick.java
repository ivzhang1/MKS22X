public class Quick{
    

    public static void main(String[] args){
	int[] test = {-100,999,100,4,1,0,3,2,999,999,999};
	System.out.println(partition(test, 0, 5));
    }

    public static void quicksort(int[] ary){
    }

    public static int quickselect(int[] ary){
	return 0;
    }


    private static int partition(int[] parti, int start, int end){
	int i = (int)(Math.random() * ((end-start) + 1) + start);
	while (start <= end){
	    
	}

	
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
