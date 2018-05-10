import java.util.Random;
/**
 * RoomTester.java 
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class RoomTester 
{
    public static void main(String[] args)
    {
        // for (int i = 0; i < 10; i++){
             // boolean up = TorF();
            // boolean down = TorF();
            // boolean left = TorF();
            // boolean right = TorF();

            //Room genRoom = new Room(up,down,left,right);
             Room genRoom = new Room(true,true,true,true);
            System.out.println(genRoom+"\n\n");
       // }
    }

    public static boolean TorF(){
        Random r = new Random();
        int ran =  r.nextInt(2);
        if(ran == 0)
            return true;
        return false;
    }

}
