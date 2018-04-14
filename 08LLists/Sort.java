public class Sort{
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
	int maxN = (int)Math.ceil(Math.log(l.get(l.max()))/Math.log(10));
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[] chumBuk = new MyLinkedListImproved[10];
	
	int dig = 10;
	System.out.println(maxN);
	for(int i = 0; i <= maxN; i++){
	    for(Integer x: l){
		if(Math.ceil((Math.log(x)/Math.log(10))) >= i){
		    dig = getPos(x, i);
		}
		else{
		    dig = 0;
		}
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
	    for(MyLinkedListImproved<Integer> y: chumBuk){
		//System.out.println(l + " " + y);
		if(y != null){
		    l.extend(y);
		}
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


