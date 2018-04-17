import java.util.LinkedList;

public class Calc{
    public static double result(String exp){
	LinkedList<Double> r = new LinkedList<>();
	String[] Cs = exp.split(" ");
	for (int i = 0; i < Cs.length; i++){
	    String k = Cs[i];
	    if (k.equals("+") || k.equals("-") || k.equals("*") || k.equals("/") || k.equals("%")){
		r.push(doMath(k.charAt(0),r)); 
	    }
	    else{
		if (!k.equals(" ")){
		    r.push(Double.parseDouble(k));
		}
	    }
	    
	    //r.add(Cs[i]);
	    //System.out.println(Cs[i]);		    
	}

	
	
	return r.get(0);

    }

    public static double doMath(char k, LinkedList<Double> l){
	double res = 0;
	int size = l.size();
	for(int i = 0; i < size; i++){
	    System.out.println(l.get(i));
	    // if (k == '+'){
	    // 	res += l.pop();
	    // }
	    // else if (k == '-'){
	    // 	res -= l.pop();
	    // }
	    // else if (k == '*'){
	    // 	if (res == 0){
	    // 	    res=1;
	    // 	}
	    // 	res *= l.pop();
	    // }
	    // else if (k == '/'){
	    // 	if (res == 0){
	    // 	    res = 1;
	    // 	}
	    // 	res /= l.pop();
	    // }
	    // else if (k == '%'){
	    // 	if (res == 0){
	    // 	    res = 1;
	    // 	}
	    // 	res %= l.pop();
	    // }
	}
	System.out.println();
	return res;
    }

    public static void main(String[] args){
	System.out.println(result("8 2 + 99 9 - * 2 + 9 -"));
    }


}
