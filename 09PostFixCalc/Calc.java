import java.util.LinkedList;

public class Calc{
    public static double eval(String exp){
	LinkedList<Double> r = new LinkedList<>();
	String[] Cs = exp.split(" ");
	for (int i = 0; i < Cs.length; i++){
	    String k = Cs[i];
	    //System.out.println(k);
	    if (k.equals("+") || k.equals("-") || k.equals("*") || k.equals("/") || k.equals("%")){
		//System.out.println(k.charAt(0));
		double ans = doMath(k.charAt(0),r);
		//System.out.println(ans);
		//System.out.println();
		r.push(ans); 
	    }
	    else{
		r.push(Double.parseDouble(k));
	    }
	    
	    //r.add(Cs[i]);
	    //System.out.println(Cs[i]);		    
	}

	
	
	return r.get(0);

    }

    public static double doMath(char k, LinkedList<Double> l){
	int size = l.size();
	double res = l.pop();
	for(int i = size-1; i < size; i++){
	    if (k == '+'){
	    	res += l.pop();
	    }
	    else if (k == '-'){
	    	res = l.pop() - res;
	    }
	    else if (k == '*'){
	    	if (res == 0){
	    	    res=1;
	    	}
	    	res *= l.pop();
	    }
	    else if (k == '/'){
	    	if (res == 0){
	    	    res = 1;
	    	}
	    	res /= l.pop();
	    }
	    else if (k == '%'){
	    	if (res == 0){
	    	    res = 1;
	    	}
	    	res %= l.pop();
	    }
	}
	//System.out.println();
	return res;
    }

    public static void main(String[] args){
	System.out.println(eval("99 100 - 10 12 - -"));
    }


}
