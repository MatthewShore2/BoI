
/**
 * Write a description of class GlobalPositionPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GlobalPositionPlayer
{
    // instance variables - replace the example below with your own
    protected int x;
    protected int y;
    /**
     * Constructor for objects of class globalPosition
     */
    public GlobalPositionPlayer(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    
    public void move(int xz,int yz)
    {
        x+=xz;
        y+=yz;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getX()
    {
        return x;
    }
}
