import java.util.ArrayList;

public class Fibby{
    private ArrayList<Integer> memory = new ArrayList<Integer>(10);
    private int value;
    
    public static void main (String[] args){
	if (args.length == 1){
	    if(args[0].equals("1")){
		System.out.println(costFib(0));
		System.out.println(costFib(1));
		System.out.println(costFib(4));
	    }
	}
	else{
	    //Regular Fib Tests
	    System.out.println(fibBasic(10));
	    System.out.println(fibBasic(0));
	    System.out.println(fibBasic(1));
	    System.out.println(fibBasic(2));
	    System.out.println(fibBasic(3));
	}
    }
    
    public static int fibBasic (int n){
	if (n < 2){
	    return n;
	}
	return fibBasic(n-1) + fibBasic(n-2);
    }

    public static double costFib(int n){
	if (n <= 1){
	    return 0.05 * (n + 1);
	}

	return 3.10 + costFib(n-1) + costFib(n-2);
    }
    
    // public int fibCool (int n){
    // 	if (memory.get(n) != null || n < 2){
    // 	    return memory.get(n);
    // 	}
    // 	value = fibCool(n-1) + fibCool(n-2);
    // 	memory.add(value, n);
    // 	return 0;
	
    // }
}
