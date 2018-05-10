import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * KeyInput.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class KeyInput extends KeyAdapter
{
    Player p;
    /**
     * Constructs the KeyInput class
     * @param Player The player 
     */
    public KeyInput(Player p)
    {
        this.p = p;
    }
    
    /**
     * Reads which key was pressed
     * @param KeyEvent The keyevent taken in
     */
    public void keyPressed(KeyEvent e)
    {
        p.keyPressed(e);
    }
    
    /**
     * Reads which key was released 
     * @param KeyEvent Which key was released
     */
    public void keyReleased(KeyEvent e)
    {
        p.keyReleased(e);
    }
}
