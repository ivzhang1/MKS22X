import java.util.LinkedList;

public class Calc{
    public static int result(String exp){
	LinkedList<Character> parts = new LinkedList<>();
	char[] Cs = exp.toCharArray();
	for (char k: Cs){
	    if (k < 48 && k > 36){
		parts.push(doMath(parts));
	    }
		
	    if (k > 47 && k < 58){
	        parts.push(k-48);
		//System.out.println(k-48);
	    }
	    //System.out.println(c);
	}
	
	return 0;

    }

    public static int doMath(LinkedList<Character> l){
	int res = 0;
	int size = l.size();
	if (k == '+'){
	    for(int i = size; i > 0; i-=1){
		res += l.getLast();
		l.pop();
	    }
	} else if (k == '-'){
	    for(int i = size; i > 0; i-=1){
		res -= l.getLast();
		l.pop();
	    }
	}
	else if (k == '*'){
	    for(int i = size; i > 0; i-=1){
		res *= l.getLast();
		l.pop();
	    }
	}
	else if (k == '/'){
	    for(int i = size; i > 0; i-=1){
		res /= l.getLast();
		l.pop();
	    }
	}
	return res;
    }

    public static void main(String[] args){
	result("123+");
    }


}
