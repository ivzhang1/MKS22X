public class Locations implements Comparable<Locations>{
    private int x,y;
    private Locations previous;
    public double distance;

    public Locations(int _x, int _y, Locations prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Locations(int _x, int _y, Locations prev, double dist){
	x = _x;
	y = _y;
	previous = prev;
	distance = dist;
    }

    
    public int xL(){return x;}

    public int yL(){ return y;}

    public double distance(){ return distance;}


    public Locations loc(){return previous;}

    public String toString(){
	return x + ", " + y + ", " + "(" + previous + ")"; 
    }

    public int compareTo(Locations lod){
	int res = 0;
	if(distance() >= lod.distance()){
	    res+=1;
	}
	if(distance() <= lod.distance()){
	    res-=1;
	}
	return res;
	
	
    }

    
}
