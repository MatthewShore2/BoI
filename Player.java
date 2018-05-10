import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends GlobalPositionPlayer
{
    // instance variables - replace the example below with your own
    int attack;
    int health;
    //0 = up, 1 = right, 2 = down, 3 = left
    private int fRoom ;
    private boolean up,down,left,right;
    private String playerImage = "Images/IssacForward.png/";
    private double velX = 1;
    private double velY = 1;
    private JFrame rg;
    private Room r;
    /**
     * Constructor for objects of class Player
     */
    public Player(int x, int y, JFrame rg1,Room r)
    {

        super(x,y);
        rg = rg1;
        fRoom = -1;
        this.r=r;
        attack = 1;
        health = 4;
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;

        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;

        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;

        }
    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;

        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;

        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;

        }
    }

    public void resetBooleans()
    {
        fRoom = -1;
    }

    //public boolean switchRoom()
    //{
    //figure out how I switched rooms
    //}

    public int getfRoom()
    {
        return fRoom;
    }

    public void speedUp(int z)
    {
        velX+=z;
        velY+=z;
    }

    public void attUp(int z)
    {
        attack += z;

    }

    public void healthUp(int z)
    {
        health += z;
    }

    public void draw(Graphics2D g2d)
    {
        g2d.drawImage(getPlayerImage(),x,y,null);
    }

    public Image getPlayerImage()
    {
        ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
        return i.getImage();
    }

    public void ouch()
    {
        health--;
    }
    
    public void setX(int x1)
    {
        x = x1;

    }

    public void setY(int y1)
    {
        y = y1;

    }

    public void update()
    {

        if(up) {
            y-=velY;
            // playerImage = "/images/herou1.png/";
        }
        if(down) {
            y+=velY;
            // playerImage = "/images/herod1.png/";
        }
        if(left) {
            x-=velX;
            //playerImage = "/images/herol1.png/";
        }
        if(right) {
            x+=velX;
            //playerImage = "/images/heror1.png/";
        }
        for(int i = 0; i < 14; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if((x>(i/14)*47&&x<(i+1/14)*47)&&(y>(j/9)*58&&y<(j+1/9)*58))
                {
                    if(!r.getLayout()[i][j].getWalkable()||r.getLayout()[i][j].getHurt())
                    {
                        if(r.getLayout()[i][j].getHurt())
                        {
                            ouch();
                        }
                        if(up)
                        {
                            y++;

                        }
                        if(down)
                        {
                            y--;
                        }
                        if(right)
                        {
                            x--;
                        }
                        if(left)
                        {
                            x++;
                        }

                    }
                }

            }
        }

        if(x>1321&&right)
        {
            x--;
            if(fRoom==1)
            {
                
            }
        }
        if(x<47&&left)
        {
            x++;
        }
        if(y>709)
        {
            
        }
    }
}
