public class Quick{
    

    public static void main(String[] args){
	int[] test = {-100,12,100,4,1,0,3,2,90,99,899};
	System.out.println(partition(test, 0, 5));
    }

    public static void quicksort(int[] ary){
    }

    public static int quickselect(int[] ary){
	return 0;
    }


    private static int partition(int[] parti, int start, int end){
	int i = (int)(Math.random() * ((end-start) + 1) + start);
	int pivotal = parti[i];
	int starty = start;
	swap(parti, i, start);
	start++;

	while (start <= end){
	    toString(parti);
	    if (parti[start] == pivotal){
		swap(parti, start, i);
		i++;
	    }
	    else if (parti[start] > pivotal){
		swap(parti, start, end);
		end-=1;
	    }
	    else{
		swap(parti, i, start);
		i++;
		start++;
	    }
	}
	toString(parti);
	swap(parti, starty, end);
	System.out.println(i + " " + end + " " + pivotal);
	toString(parti);
	return 0;
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
