public class Location{
    private int x,y;
    private Location previous;

    public Location(int _x, int _y, Location prev){
    }

    public int xL(){return x;}

    public int yL(){ return y;}

    public Location loc(){return previous;}
}
