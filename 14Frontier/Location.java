public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private double distance;
    private double distSoFar;
 

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Location(int _x, int _y, Location prev, double dist){
	x = _x;
	y = _y;
	previous = prev;
	distance = dist;
    }

    public Location(int _x, int _y, Location prev, double dist, double d){
	x = _x;
	y = _y;
	previous = prev;
	distance = dist;
	distSoFar = d;
    }
    
    public int xL(){return x;}

    public int yL(){ return y;}

    public double distance(){ return distance;}

    public double dSoFar(){return distSoFar;}
    
    public Location loc(){return previous;}

    public String toString(){
	return x + ", " + y + ", " + "(" + previous + ")"; 
    }

    public int compareTo(Location lod){
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
