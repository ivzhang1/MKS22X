import java.util.ArrayList;

public class Sort{
    public static void main(String[] args){
	MyLinkedListImproved<Integer> x = new MyLinkedListImproved<>();
	for(int i = 0; i < 10; i++){
	    x.add(i);
	}
	radixsort(x);
    }
    
    
    public static void radixsort(MyLinkedListImproved<Integer> l){
	int maxN = getNDigs(l.get(l.max()));
	ArrayList<MyLinkedListImproved<Integer>> chumBuk = new ArrayList<>(10);
	for (int p = 0; p < 10; p++){
	    chumBuk.add(null);
	}
	
	int dig = 10;
	for(int i = 0; i < maxN; i++){
	    for(Integer x: l){
		if(getNDigs(x) > i){
		    dig = getPos(x, i);
		    if(chumBuk.get(dig) == null){
			MyLinkedListImproved<Integer> k = new MyLinkedListImproved<>();
			k.add(x);
			chumBuk.set(dig, k);
			System.out.print("Go");
			
		    }
		    else{
			chumBuk.get(dig).add(x);
		    }
		}
	    }
	    l.clear();
	    for(MyLinkedListImproved<Integer> y: chumBuk){					
		l.extend(y);
	    }
	    
	    chumBuk = new ArrayList<>(10);
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


