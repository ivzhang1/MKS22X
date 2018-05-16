
public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private double distance;
    private double distSoFar = 0;
 

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
	return "" + distance; 
    }

    public int compareTo(Location lod){
	int res = 0;
	double totalD = distance()+dSoFar();
	double totald = lod.distance() + lod.dSoFar();
	if(totalD > totald){
	    res = 1;
	}
	else if(totalD < totald){
	    res = -1;
	}
	return res;
	
	
    }
}
