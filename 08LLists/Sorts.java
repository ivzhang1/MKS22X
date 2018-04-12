public class Sorts{
    public static void main(String[] args){
	MyLinkedListImproved<Integer> x = new MyLinkedListImproved<>();
	for(int i = 0; i < 10; i++){
	    x.add(i);
	}
	radixsort(x);
    }
    
    
    public static void radixsort(MyLinkedListImproved<Integer> l){
	int maxN = getNDigs(l.get(l.max()));
	for(int i = 0; i < 3; i++){
	    //System.out.println(maxN);
	    System.out.println(getPos(1000, i));
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


