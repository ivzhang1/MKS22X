public class RunningMedian{
    public MyHeap<Double> min;
    public MyHeap<Double> max;


    public static void main(String[] args){
	RunningMedian lol = new RunningMedian();
	for(double i = 0; i < 10.0; i++){
	    lol.add(i);
	    System.out.println(lol.getMedian());
	}
	lol.add(10.0);
	lol.add(10.0);
	lol.add(10.0);
	lol.add(10.0);
	lol.add(10.0);
	lol.add(10.0);
	lol.add(10.0);
	lol.add(10.0);
	System.out.println(lol);
    }


    
    public RunningMedian(){
	min = new MyHeap<>(false);
	max = new MyHeap<>();
    }

    public void add(Double doubly){
	if(max.peek() == null || doubly < max.peek()){
	    max.add(doubly);
	}
	else{
	    min.add(doubly);
	}
	
	while(max.size()-min.size() > 1){
	    min.add(max.remove());
	}
	
	while(min.size()-max.size() > 1){
	    max.add(min.remove());
	}
    }
    
    public Double getMedian(){
	Double value = 0.0;
	switch(max.size() - min.size())
	    {
	    case -1:
		value = min.peek();
		break;
	    case 0:
		value = (min.peek() + max.peek())/2;
		break;
	    case 1:
		value = max.peek();
		break;
	    default: value = null;
	}
	
	return value;
    }

    public int size(){
	return min.size() + max.size();
    }

    public String toString(){
	String res = "";
	res += max.toString() + "\n" + min.toString();
	return res;
    }

    
}
