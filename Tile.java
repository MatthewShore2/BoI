import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Abstract class Tile - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class Tile
{
    // instance variables - replace the example below with your own
    String image;
    boolean walkable;
    boolean hurt;
    int type;
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Tile(String image,boolean walkable,boolean hurt, int type)
    {
        this.image = image;
        this.walkable = walkable;
        this.hurt = hurt;
        this.type = type;
    }
    
    public Image getImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(image));
        return i.getImage();
    }
    
    public boolean getWalkable()
    {
        return walkable;
    }
    
    public boolean getHurt()
    {
        return hurt;
    }
    
    public int getType()
    {
        return type;
    }
}
