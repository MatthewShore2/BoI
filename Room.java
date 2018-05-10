import java.util.Random;
/**
 * @author 181ShoreM
 *
 */
public class Room {
    Tile[][] tile = new Tile[7][13];
    boolean up;
    boolean down;
    boolean left;
    boolean right;
    //Rows 0 and 8 only have one tile and should be (mostly) invisible to the player
    //Col 0 and 14 only have one tiles and should be (mostly) invisible to the player
    public Room(boolean up, boolean down, boolean left, boolean right){
        //Tile[][] tiles = new Tile[9][15];
        // this.tile = tiles;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        //AllBlank
        for (int row = 0; row < 7; row++){
            for (int col = 0; col < 13; col++){
                tile[row][col] = new Tile("/Images/Spike.jpeg",true,false, 0);
            }
        }

        //Randomizer
        //Randomly chooses if an exit or not (Will be replaced by Baily generator)
        // boolean up = TorF();
        // boolean down = TorF();
        // boolean left = TorF();
        // boolean right = TorF();

        Random r = new Random();
        //Rock Formation
        int rF = r.nextInt(8);
        while((rF == 3) && (up)){
            rF =  r.nextInt(5);   
        }
        rockFormation(rF);
    }   

    public boolean getUp(){
        return up;
    }

    public Tile[][] getLayout()
    {
        return tile;
    }

    public boolean getDown(){
        return down;
    }

    public boolean getLeft(){
        return left;
    }

    public boolean getRight(){
        return right;
    }

    public Tile emptyTile(){
        Tile empty = new Tile(null,true,false, 0);//Empty();
        return empty;
    }

    public Tile rockTile(){
        Tile rock = new Tile("/Images/Rock.jpeg",false,false, 1);//Rock();
        return rock;
    }

    public Tile spikeTile(){
        Tile spike = new Tile("/Images/Spike.jpeg",true,true, 2);//Spike();
        return spike;
    }

    public Tile isType(int type){
        if (type == 0)
            return emptyTile();
        else if(type == 1)
            return rockTile();
        else if (type == 2)
            return spikeTile();
        return null;
    }

    public Tile isType(Tile t){
        if (t.getType() == 0)
            return emptyTile();
        else if(t.getType() == 1)
            return rockTile();
        else if (t.getType() == 2)
            return spikeTile();
        return null;
    }

    public boolean isEmpty(Tile t){
        if (t.getType() == 0)
            return true;
        return false;
    }

    public boolean isRock(Tile t){
        if (t.getType() == 1)
            return true;
        return false;
    }

    public boolean isSpikes(Tile t){
        if (t.getType() == 2)
            return true;
        return false;
    }

    public Map mapGen(){
        Map m = new Map(9,9);
        m.addRooms(8);
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                // if(m[row][col] == null){

                // }
                // else{
                // }
            }
        }
        return m;
    }

    public String toString(){
        String s = "";
        for (int row = 0; row < 7; row++){
            for (int col = 0; col < 13; col++){
                if(tile[row][col].getType() == 0)
                    s+= " ";
                else if(tile[row][col].getType() == 1)
                    s+= "0";
                else if(tile[row][col].getType() == 2)
                    s+= "M";
                else //if(tile[row][col] == null)
                    s+= "%";
            }
            s+= "\n";
        }
        return s;
    }

    /**
     * randomly generates true or false
     */
    public boolean TorF(){
        Random r = new Random();
        int ran =  r.nextInt(2);
        if(ran == 0)
            return true;
        return false;
    }

    /**
     * Places Rocks
     */
    public void rockFormation(int a){
        // Rows 0-6 (3 is center)
        // Cols 0-12 (6 is center)
        if (a == 0){
            /*
            0000000X0000000
            0             0
            0      0      0
            0     0 0     0
            X    0   0    X
            0             0
            0             0
            0             0
            0000000X0000000

             */
            tile[1][6] = rockTile();
            tile[2][5] = rockTile();
            tile[2][7] = rockTile();
            tile[3][4] = rockTile();
            tile[3][8] = rockTile();

        }
        else if (a == 1){
            /*
            0000000X0000000
            0   0       0 0
            0       0   0 0
            0   0   0   0 0
            X   0 0 0 0   X
            0 0   0   0   0
            0 0   0       0
            0 0       0   0
            0000000X0000000

             */
            tile[6][1] = rockTile();
            tile[5][1] = rockTile();
            tile[4][1] = rockTile();
            tile[0][3] = rockTile();
            tile[2][3] = rockTile();
            tile[3][3] = rockTile();
            tile[3][5] = rockTile();
            tile[4][5] = rockTile();
            tile[5][5] = rockTile();
            tile[1][7] = rockTile();
            tile[2][7] = rockTile();
            tile[3][7] = rockTile();
            tile[3][9] = rockTile();
            tile[4][9] = rockTile();
            tile[6][9] = rockTile();
            tile[0][11] = rockTile();
            tile[1][11] = rockTile();
            tile[2][11] = rockTile();

        }
        else if (a == 2){
            /*
            0000000X0000000
            0             0
            0     000     0
            0    0   0    0
            X    0   0    X
            0    0   0    0
            0     000     0
            0             0
            0000000X0000000

             */
            tile[2][4] = rockTile();
            tile[3][4] = rockTile();
            tile[4][4] = rockTile();

            tile[1][5] = rockTile();
            tile[5][5] = rockTile();
            tile[1][6] = rockTile();
            tile[5][6] = spikeTile();
            tile[1][7] = rockTile();
            tile[5][7] = rockTile();

            tile[2][8] = rockTile();
            tile[3][8] = rockTile();
            tile[4][8] = rockTile();
        }
        else if (a == 3){
            /*
            0000000X0000000
            0   0000000   0
            0   00   00   0
            0             0
            X      0      X
            0             0
            0             0
            0             0
            0000000X0000000

             */
            tile[0][3] = rockTile();
            tile[0][4] = rockTile();
            tile[0][5] = rockTile();
            tile[0][6] = rockTile();
            tile[0][7] = rockTile();
            tile[0][8] = rockTile();
            tile[0][9] = rockTile();

            tile[1][3] = rockTile();
            tile[1][9] = rockTile();

            tile[3][4] = rockTile();
            tile[3][8] = rockTile();
            tile[5][6] = rockTile();
        }
        else if (a == 4){
            /*
            0000000X0000000
            0             0
            00   00000   00
            0   0 000 0   0
            X  000   000  X
            0   0 000 0   0
            00   00000   00
            0             0
            0000000X0000000
             */
            for(int row = 1; (row == 1||row == 5); row+=4){
                tile[row][0] = rockTile();
                tile[row][4] = spikeTile();
                tile[row][5] = rockTile();
                tile[row][6] = spikeTile();
                tile[row][7] = rockTile();
                tile[row][8] = spikeTile();
                tile[row][12] = rockTile();
            }
            for(int row = 2; (row == 2||row == 4); row+=2){
                tile[row][3] = rockTile();
                tile[row][5] = rockTile();
                tile[row][6] = rockTile();
                tile[row][7] = rockTile();
                tile[row][9] = rockTile();
            }
            tile[3][2] = rockTile();
            tile[3][3] = rockTile();
            tile[3][4] = rockTile();
            tile[3][8] = rockTile();
            tile[3][9] = rockTile();
            tile[3][10] = rockTile();
        }
        else if (a == 5){
            /*
            0000000X0000000
            0             0
            0 0 0 0 0 0 0 0
            0             0
            X  0 0 0 0 0  X
            0             0
            0 0 0 0 0 0 0 0
            0             0
            0000000X0000000
             */
            for(int row = 1; (row == 1||row == 5); row+=4){
                tile[row][1] = rockTile();
                tile[row][3] = rockTile();
                tile[row][5] = rockTile();
                tile[row][7] = rockTile();
                tile[row][9] = rockTile();
                tile[row][11] = rockTile();
            }
            tile[3][2] = rockTile();
            tile[3][4] = rockTile();
            tile[3][6] = rockTile();
            tile[3][8] = rockTile();
            tile[3][10] = rockTile();
        }
        else if (a == 6){
            /*
             */
        }
        else {
            //norocks
        }
    }
}