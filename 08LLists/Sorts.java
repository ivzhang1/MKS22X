public class Sorts{
    public static void main(String[] args){
	MyLinkedListImproved<Integer> x = new MyLinkedListImproved<>();
	for(int i = 8; i > 0; i--){
	    x.add((int)(Math.random()* i *10));
	}
	System.out.println(x);
	x.add(100);
	radixsort(x);
	System.out.println(x);

    }
    
    public static void radixsort(MyLinkedListImproved<Integer> l){
	if(l != null && l.size() != 0){
	
	    int maxN = l.get(l.max());

	    if (maxN != 0){
		maxN = (int)(Math.log10(maxN) + 1);
	    }

	    @SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[] chumBuk = new MyLinkedListImproved[11];
	
	    int dig = 10;
	    //System.out.println(maxN);
	    for(int i = 0; i <= maxN; i++){
		for(Integer x: l){
		    if (x<0){
			dig = 10;
		    }
		    else if((int)(Math.log10(x)) >= i){
			dig = getPos(x, i);
		    }
		    else{
			dig = 0;
		    }
		    //System.out.println(x + " " + dig);
		    if(chumBuk[dig] == null){
			MyLinkedListImproved<Integer> k = new MyLinkedListImproved<>();
			k.add(x);
			//System.out.println(k + " " + dig);
			chumBuk[dig] = k;
			//System.out.print("Go");
			
		    }
		    else{
			chumBuk[dig].add(x);
		    }
		
		}
		l.clear();
		int counter = 0;
		for(MyLinkedListImproved<Integer> y: chumBuk){
		    //System.out.println(l + " " + y);
		    if(y != null && counter != 11){
			l.extend(y);
		    }
		    counter+=1;

		}	
	    }

	    if(chumBuk[10]!=null){
		radixsort(chumBuk[10]);
		chumBuk[10].reverse();
		chumBuk[10].extend(l);
		l = chumBuk[10];
		chumBuk[10].clear();

	    }
	    
	    
	}
    }

    public static int getNDigs(int z){
	int num = 1;
	z = Math.abs(z);
	while (z/10 != 0){
	    num+=1;
	    z/=10;
	}
	return num;
    }

    public static int getPos(int num, int j){
	for(int i = 0; i < j; i++){
	    num/=10;
	}
	return num%10;
    }
}


