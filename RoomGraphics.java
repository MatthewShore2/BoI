import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.net.URL;
import javafx.scene.*;
import javax.sound.sampled.*;
import javafx.stage.Stage;
import java.net.*;
import javafx.application.Application;
public class RoomGraphics extends JPanel implements ActionListener{
    private JFrame jp = new JFrame();
    public Player p;
    Room rA;
    Timer gameloop;
    //there is an array of the string. We just run through it and
    //paint all the things based on the string
    public RoomGraphics(Room rA)
    {
        int x = 642;
        int y = 347;
        //         if(p.getfRoom()==0)
        //            {
        //                x = 624;
        //                y = 100;
        //            }
        //            else if(p.getfRoom()==1)
        //            {
        //                x = 92;
        //                y = 362;
        //            }
        //            else if(p.getfRoom()==2)
        //            {
        //                x =624;
        //                y = 628;
        //            }
        //            else if(p.getfRoom()==3)
        //            {
        //                x = 1242;
        //                y = 362;
        //            }
        p = new Player(x,y,jp,rA);
        setFocusable(true);
        gameloop = new Timer(10,this);
        gameloop.start();
        this.rA = rA;
        addKeyListener(new KeyInput(p));
    }

    public JFrame getFrame()
    {
        return jp;
    }

    public Image getBackgroundIm()
    {
        ImageIcon i = new ImageIcon(getClass().getResource("/Images/room.png"));
        return i.getImage();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getBackgroundIm(), 0,0,this);
        p.draw(g2d);
        for(int i = 0; i < 14; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                g2d.drawImage(rA.getLayout()[i][j].getImage(),(i/14)*47,(j/9)*58,this);
            }
        }

    }
    /**
     * updates and repaints the frame as actions happen
     * @param ActionEvent ae, can be any event that triggers the updates.
     */
    public void actionPerformed(ActionEvent ae)
    {
        p.update();
        repaint();
    }

    public Player getPlayer()
    {
        return p;
    }
    //public static void play(Player p)
    //{

    //Room ti = new Room();

    //}
}
