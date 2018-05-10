
/**
 * Map.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Map
{
    Room[][] map;
    public Map(int s1, int s2)
    {
        map = new Room[s1][s2];
        for(int i = 0; i < map.length; i++)
        {
            for(int c = 0; c < map[0].length; c++)
            {
                map[i][c] = null;
            }
        }
        map[map.length / 2][map[0].length / 2] = new Room(true,true,true,true);
    }

    public Room[][] getMap(){
        return map;
        
    }
    
    public Room getRoomAt(int r, int c){
        return map[r][c];
        
    }

    public int hasNeighbors(int x, int y)
    {
        int count = 0;
        if((x < map.length - 1) && (y < map[0].length - 1) &&(map[x+1][y + 1] != null))
        {
            count++;
        }
        if((x < map.length - 1) && (y > 0) &&(map[x+1][y - 1] != null))
        {
            count++;
        }
        if((x > 0) && (y < map[0].length - 1) &&(map[x-1][y + 1] != null))
        {
            count++;
        }
        if((x > 0) && (y > 0) &&(map[x-1][y - 1] != null))
        {
            count++;
        }
        if((x < map.length - 1) && (map[x+1][y] != null))
        {
            count++;
        } 
        if((x > 0) && map[x-1][y] != null)
        {
            count++;
        }
        if((y < map[0].length - 1) && (map[x][y+1] != null))
        {
            count++;
        }
        if((y > 0) && (map[x][y-1] != null))
        {
            count++;
        }

        return count;
    }

    public void addRooms(int num)
    {
        int count = 0;
        int temp = 0;
        while(count < num)
        {
            if(temp > 500)
            {
                fix();
                break; 
            }
            for(int i = 0; i < map.length; i++)
            {
                for(int c = 0; c < map[0].length; c++)
                {
                    if((hasNeighbors(i,c) < 5) && (count < num) && (map[i][c] == null))
                    {
                        if((i < map.length - 1) && (map[i+1][c] != null))
                        {
                            if(map[i+1][c].up == true)
                            {
                                int a = (int)(Math.random() * 2 + 1);
                                int b = (int)(Math.random() * 2 + 1);
                                int d = (int)(Math.random() * 2 + 1);
                                boolean aa = (a == 2);
                                boolean bb = (b == 2);
                                boolean dd = (c == 2);
                                map[i][c] = new Room(aa, true,bb,dd);
                                count++;
                            }
                        }
                        if((i > 0) && map[i-1][c] != null)
                        {
                            if(map[i-1][c].down == true)
                            {
                                int a = (int)(Math.random() * 2 + 1);
                                int b = (int)(Math.random() * 2 + 1);
                                int d = (int)(Math.random() * 2 + 1);
                                boolean aa = (a == 2);
                                boolean bb = (b == 2);
                                boolean dd = (c == 2);
                                map[i][c] = new Room(true,aa,bb,dd);
                                count++;
                            }
                        }
                        if((c < map[0].length - 1) && (map[i][c+1] != null))
                        {
                            if(map[i][c + 1].left == true)
                            {
                                int a = (int)(Math.random() * 2 + 1);
                                int b = (int)(Math.random() * 2 + 1);
                                int d = (int)(Math.random() * 2 + 1);
                                boolean aa = (a == 2);
                                boolean bb = (b == 2);
                                boolean dd = (c == 2);
                                map[i][c] = new Room(aa,bb,dd,true);
                                count++;
                            }
                        }
                        if((c > 0) && (map[i][c-1] != null))
                        {
                            if(map[i][c - 1].right == true)
                            {
                                int a = (int)(Math.random() * 2 + 1);
                                int b = (int)(Math.random() * 2 + 1);
                                int d = (int)(Math.random() * 2 + 1);
                                boolean aa = (a == 2);
                                boolean bb = (b == 2);
                                boolean dd = (c == 2);
                                map[i][c] = new Room(aa,bb,true,dd);
                                count++;
                            }
                        }
                    }
                }
            }
            temp++;
        }
        fix();
    }

    public void fix()
    {
        for(int i = 0; i < map.length; i++)
        {
            for(int c = 0; c < map[0].length; c++)
            {
                if(hasNeighbors(i,c) > 4 && (i != map.length / 2) && (c != map[0].length / 2))
                {
                    map[i][c] = null;
                    if((i < map.length - 1) && (map[i+1][c] != null))
                        map[i+1][c].up = false;

                    if((i > 0) && map[i-1][c] != null)
                        map[i-1][c].down = false;
                    if((c > 0) && (map[i][c-1] != null))
                        map[i][c - 1].right = false;
                    if((c < map[0].length - 1) && (map[i][c+1] != null))
                        map[i][c + 1].left = false;
                }

            }
        }
        for(int i = 0; i < map.length; i++)
        {
            for(int c = 0; c < map[0].length; c++)
            {
                if((i < map.length - 1) && (i > 0) && (c > 0) && (c < map[0].length - 1) && (map[i-1][c] == null) && (map[i+1][c] == null) && (map[i][c + 1] == null) && (map[i][c - 1] == null))
                {
                    map[i][c] = null;
                } 
            }
        }
        for(int i = 0; i < map.length; i++)
        {
            for(int c = 0; c < map[0].length; c++)
            {
                if(map[i][c] != null)
                {
                    if((i < map.length - 1) && (map[i+1][c] != null))
                        map[i][c].down = true;
                    else
                        map[i][c].down = false;

                    if((i > 0) && map[i-1][c] != null)
                        map[i][c].up = true;
                    else
                        map[i][c].up = false;

                    if((c > 0) && (map[i][c-1] != null))
                        map[i][c].left = true;
                    else
                        map[i][c].left = false;

                    if((c < map[0].length - 1) && (map[i][c+1] != null))
                        map[i][c].right = true;
                    else
                        map[i][c].right = false;
                }
            }
        }
    }

    public void printMap()
    {
        for(int i = 0; i < map.length; i++)
        {
            for(int c = 0; c < map[0].length; c++)
            {
                if(map[i][c] != null)
                {
                    System.out.print("1");
                }
                else
                {
                    System.out.print("0");
                }  
            }
            System.out.println();
        }
    }
}
