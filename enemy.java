// import javax.swing.*;
// import java.awt.*;
// import java.awt.image.BufferedImage;
// import javax.imageio.ImageIO;
// /**
 // * Write a description of class enemy here.
 // *
 // * @author (your name)
 // * @version (a version number or a date)
 // */
// public abstract class enemy extends globalPositionEnemy
// {
    // // instance variables - replace the example below with your own
    // protected int speed;
    // protected int health;
    // protected int attack;
    // private int oriHP;
    // private String pIU;
    // private String pID;
    // private String pIR;
    // private String pIL;
    // protected int velX,velY;
    // /**
     // * Constructor for objects of class enemy
     // */
    // public enemy(int x, int y, int health, int attack,int speed,String pIU,String pIR,String pID, String pIL)
    // {
        // super(x,y);
        // this.attack = attack;
        // this.health = health;
        // oriHP = health;
        // this.speed = speed;
        // velX = speed;
        // velY = speed;
    // }

    // public abstract BufferedImage getImage();
   
    // public void update()
    // {

        // if(up) {
            // y-=velY;
            // playerImage = pIU;
        // }
        // if(down) {
            // y+=velY;
            // playerImage = pID;
        // }
        // if(left) {
            // x-=velX;
            // playerImage = pIL;
        // }
        // if(right) {
            // x+=velX;
            // playerImage = pIR;
        // }
    // }
    
    // /**
     // * An example of a method - replace this comment with your own
     // *
     // * @param  y  a sample parameter for a method
     // * @return    the sum of x and y
     // */
    // public int getAttack()
    // {
        // return attack;
    // }
    
    // public int getHealth()
    // {
        // return health;
    // }
    
    // public void ouch(int att)
    // {
        // health-=att;
    // }
    
    // public void resetHP()
    // {
        // health = oriHP;
    // }
// }
