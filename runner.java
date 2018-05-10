import javax.swing.JFrame;
/**
 * runner.java 
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class runner 
{
   public static void main(String[] args)
   {
       
        Room r = new Room(false,false,false,false);
        RoomGraphics rg = new RoomGraphics(r);
        
        
        
        JFrame frame= rg.getFrame();    
        frame.getContentPane().add(new RoomGraphics(r));
        frame.setSize(1366, 768);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);    
      
    }
   }

