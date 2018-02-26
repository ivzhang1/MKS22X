public class Recursion{
    
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }

    //SHOULD BE O(n)
    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return fibHelper(n, 0, 1);
    }

    //Where aSum = fib(n-2) and bSum = fib(n-1)
    public static int fibHelper(int n, int aSum, int bSum){
	if (n == 0){
	    return aSum;
	}
	return fibHelper(n-1, bSum, aSum + bSum);
    }


    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n * 1.0, n/(2.0), 0.000001);
    }

    public static double sqrtHelper(double n, double guess, double tolerance){
	if ((guess * guess - n) < tolerance && !(guess * guess < n)  ){
	    return guess;
	}

	double newGuess = (n/guess + guess) / 2;
	    
	return sqrtHelper(n, newGuess, tolerance);
    }

    public static Boolean isPossibleSum(int n, int target){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return isPossibleSumHelper(n, target, n, 0);
    }

    public static Boolean isPossibleSumHelper(int n, int target, int current, int partialSum){
	//System.out.println(partialSum + " " + target);
	if (partialSum == target){
	    return true;
	}
	if (current < 0){
	    return (partialSum == target);
	}
	return isPossibleSumHelper(n, target, current-1, partialSum+current) ||  isPossibleSumHelper(n, target, current-1, partialSum);
    }
    
}
