public class Location{
    private int x,y;
    private Location previous;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int xL(){return x;}

    public int yL(){ return y;}

    public Location loc(){return previous;}

    public String toString(){
	return x + ", " + y + ", " + "(" + previous + ")"; 
    }
}
