import java.util.LinkedList;

public class Calc{
    public static int result(String exp){
	LinkedList<Character> parts = new LinkedList<>();
	char[] Cs = exp.toCharArray();
	for (char k: Cs){
	    if (k < 48 && k > 36){
		//System.out.println(doMath(k, parts));
		parts.push((char)(doMath(k, parts)));
	    }
		
	    if (k > 47 && k < 58){
		//System.out.println("?");

	        parts.push((char) (k-48));
		//System.out.println(k-48);
	    }
	    //System.out.println(c);
	}
	
	return parts.get(0);

    }

    public static int doMath(char k, LinkedList<Character> l){
	int res = l.pop();
	int size = l.size();
	for(int i = size; i > 0; i-=1){
	    if (k == '+'){
		res += l.pop();
	    }
	    else if (k == '-'){
		res -= l.pop();
	    }
	    else if (k == '*'){
		res *= l.pop();
	    }
	    else if (k == '/'){
		res /= l.pop();
	    }
	}
	return res;
    }

    public static void main(String[] args){
	System.out.println(result("132+32*"));
    }


}
