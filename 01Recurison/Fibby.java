public class Fibby{
    
    public static void main (String[] args){
	// if (args.length == 1){
	//     if(args[0].equals("1")){
	// 	System.out.println(costFib(0));
	// 	System.out.println(costFib(1));
	// 	System.out.println(costFib(3));
	//     }
	// }
	// else{
	//     //Regular Fib Tests
	//     System.out.println(fibBasic(10));
	//     System.out.println(fibBasic(0));
	//     System.out.println(fibBasic(1));
	//     System.out.println(fibBasic(2));
	//     System.out.println(fibBasic(3));
	// }
	//System.out.println(sumZeroToN(10));
	//System.out.println(sumZeroToN(-10));
	//System.out.println(sumZeroToN(0));
	//System.out.println(sumAtoB(-10,10));
	//System.out.println(sumAtoB(1,100));
	System.out.println(sumZeroToNAlt(10));
	System.out.println(sumZeroToNAlt(-10));
	System.out.println(sumZeroToNAlt(0));
    }
    
    public static int fibBasic (int n){
	if (n < 2){
	    return n;
	}
	return fibBasic(n-1) + fibBasic(n-2);
    }

    public static double costFib(int n){
	if (n < 2){
	    return 0.05 * (n + 1);
	}

	return 3.10 + costFib(n-1) + costFib(n-2);
    }
    public static int sumZeroToN(int n){
	if (n < 0){
	    return -sumZeroToN(-n);
	}
	if (n == 0){
	    return 0;
	}
	return n + sumZeroToN(n-1);
    }

    public static int sumAtoB(int a,int b){
	if (a > b){
	    return sumAtoB(b,a);
	}
	if (a == b){
	    return a;
	}
	return a + sumAtoB(a + 1, b);
    }

    public static int sumZeroToNAlt(int n){
	if (n < 0){
	    return -sumHelper(-n, 0);
	}
	return sumHelper(n, 0);
    }

    public static int sumHelper(int n, int sum){
	if (n == 0){
	    return sum;
	}
	return sumHelper(n - 1, sum + n);
    }
}
