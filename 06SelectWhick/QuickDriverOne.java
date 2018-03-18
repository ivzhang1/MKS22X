import java.util.Random;

public class QuickDriverOne{


    public static void main(String[] args){
	try{
	    int[] test = new int[Integer.parseInt(args[0])];
	    for(int i =0; i < test.length; i++){
		Random seed= new Random();
		int num=seed.nextInt((Integer.parseInt(args[1])));
		if(seed.nextBoolean()){
		    num*=-1;
		}
		test[i]=num;

	    }
	    System.out.println("Before:"+"\n");
	    toString(test);
	    System.out.println(Quick.partition(test, 0, test.length-1));
	    System.out.println("After:"+"\n");
	    toString(test);
	}
	catch(Exception IndexOutOfBounds){
	    System.out.println("After the file name insert the size of the array and the bounds for the numbers in the array"+"\n"+"EX: FileName 10 200"+"\n"+"Would give an array of size 10 with numbers ranging from -200 to 200");
	}
	    
    }


    private static void toString(int[] parti){
	for (int k = 0; k < parti.length; k++){
	    System.out.print(parti[k] + ", ");
	}
	System.out.println();
    }

}
