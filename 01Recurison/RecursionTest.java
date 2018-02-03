public class RecursionTest{

    public static void main (String[] args){
	Recursion x = new Recursion();
	System.out.println(x.fact(5)); //120
	//System.out.println(x.fact(-1));//ERROR
	long startTime = System.currentTimeMillis();
	System.out.println(x.fib(1000));


	
	System.out.println("Runtime: " +
			   (System.currentTimeMillis() - startTime) + "ms or " +
			   (System.currentTimeMillis() - startTime)/1000.0 + "s"
			   );

	System.out.println(x.sqrt(2.0));
	System.out.println(x.sqrt(0.5));	
	
    }




}
