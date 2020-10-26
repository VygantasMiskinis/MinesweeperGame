import java.util.ArrayList;
import java.util.Random;

public class MineField {
   private static int sizex=8,sizey=10;
    Tile tilegrid[][] = new Tile[sizex][sizey];
    private int bombCount;
    private int maxBombs=10;
    private int usedflags;
    public MineField() {
        bombCount=0;
       generateTileGrid();
        usedflags=0;
   }

   public void reset(){
       bombCount=0;
       usedflags=0;
       generateTileGrid();
   }

   public int getUsedflags() {return usedflags;}

    public void setMaxBombs(int value) { maxBombs=value;}

    public int getmaxBombs() { return maxBombs; }

   public void generateTileGrid()

   {
        for(int i=0;i<sizex;i++)
        {
            for(int y=0;y<sizey;y++)
            {
              tilegrid[i][y]= new Tile();
            }

        }

        while (bombCount<maxBombs)
        {
            int ranx=generateRandomInt(sizex);
            int rany=generateRandomInt(sizey);
            if(tilegrid[ranx][rany].getBomb()!=1)
            {
                tilegrid[ranx][rany].setBomb();
                bombCount++;
               // for testing purposes
                // System.out.println("Bomb has been planted on " + ranx + " " + rany + " bomb status: " + tilegrid[ranx][rany].getBomb() );
            }

        }
   }

    public static int generateRandomInt(int a){

        int randomNumber=0;

        Random ran = new Random();
        randomNumber = ran.nextInt(a-1);

        return randomNumber;

    }

    public void update() {
        while(hasEmptyNeighbours())
        for(int i=0;i<sizex;i++)
        {
            for(int y=0;y<sizey;y++)
            {

                if(!tilegrid[i][y].getHidden())
                {
                    tilegrid[i][y].setNeighbourBombs(calcBombNeihbours(i,y));

                    if(tilegrid[i][y].getNeighbourBombs()==0) {
                        clearNeighbours(i,y);
                    }
                }


            }

        }

    }

    private boolean hasEmptyNeighbours() {
        for(int i=0;i<sizex;i++)
        {

            for(int y=0;y<sizey;y++)
            {
                if(!tilegrid[i][y].getHidden())
                    if(tilegrid[i][y].getNeighbourBombs()==0) {
                        if(i-1>=0)
                        {
                            if(tilegrid[i-1][y].getHidden()) return true;
                            if(y-1>=0) if(tilegrid[i-1][y-1].getHidden()) return true;
                            if(y+1<sizey) if(tilegrid[i-1][y+1].getHidden()) return true;
                        }

                        if(y-1>=0) {
                            if(tilegrid[i][y-1].getHidden()) return true;
                        }

                        if(y+1<sizey) {
                            if( tilegrid[i][y+1].getHidden()) return true;
                        }

                        if(i+1<sizex)
                        {
                            if(tilegrid[i+1][y].getHidden()) return true;
                            if(y-1>=0) if(tilegrid[i+1][y-1].getHidden()) return true;
                            if(y+1<sizey) if(tilegrid[i+1][y+1].getHidden()) return true;
                        }

                    }
            }
        }

        return false;
    }

    private void clearNeighbours(int i, int y) {
        if(i-1>=0)
        {
            tilegrid[i-1][y].uncover();
            if(y-1>=0) tilegrid[i-1][y-1].uncover();
            if(y+1<sizey) tilegrid[i-1][y+1].uncover();
        }

        if(y-1>=0) {
            tilegrid[i][y-1].uncover();
        }

        if(y+1<sizey) {
            tilegrid[i][y+1].uncover();
        }

        if(i+1<sizex)
        {
            tilegrid[i+1][y].uncover();
            if(y-1>=0) tilegrid[i+1][y-1].uncover();
            if(y+1<sizey) tilegrid[i+1][y+1].uncover();
        }

    }

    public int calcBombNeihbours(int a,int b){
       int bombCount=0;

       if(a-1>=0)
       {
           bombCount+=tilegrid[a-1][b].getBomb();
           if(b-1>=0) bombCount+=tilegrid[a-1][b-1].getBomb();
           if(b+1<sizey) bombCount+=tilegrid[a-1][b+1].getBomb();
       }

        if(b-1>=0) {
            bombCount+=tilegrid[a][b-1].getBomb();
        }

        if(b+1<sizey) {
            bombCount+=tilegrid[a][b+1].getBomb();
        }

        if(a+1<sizex)
        {
            bombCount+=tilegrid[a+1][b].getBomb();
            if(b-1>=0) bombCount+=tilegrid[a+1][b-1].getBomb();
            if(b+1<sizey) bombCount+=tilegrid[a+1][b+1].getBomb();
        }



       return  bombCount;

    }
    public void gameOver(){
        for(int i=0;i<sizex;i++)
        {
            for(int y=0;y<sizey;y++)
            {
               tilegrid[i][y].uncover();

            }

        }
    }

    public boolean action(int x,int y, String action) {

       switch (action)
       {
           case "flag":
               tilegrid[x][y].setFlag();
               if( tilegrid[x][y].getFlag()) usedflags++;
               else usedflags--;
               break;
           case "reveal":

               tilegrid[x][y].uncover();
               if(tilegrid[x][y].getBomb()==1) return true;
           break;
           default:

               break;
       }
       return false;
    }

    public void printField()
    {
        for(int i=0;i<=sizex;i++)
        {
            for(int y=0;y<=sizey;y++) {
                if(i==0){
                    if(y>0) {
                        if(y==10)
                        System.out.print((y) + "| ");
                        else System.out.print((y) + " | ");
                    }
                    else System.out.print("  | ");

                }
                else if (y==0) {
                    System.out.print((i) + " | ");

                }
                else {
                    System.out.print(tilegrid[i-1][y-1].draw() + " | ");

                }

                if (y == sizey) {
                    System.out.print("\n");
                    System.out.println("  -----------------------------------------");
                }

            }

        }
    }

    public boolean winCheck() {
        for(int i=0;i<sizex;i++) {

            for (int y = 0; y < sizey; y++) {

                if(tilegrid[i][y].getBomb()==1&&!tilegrid[i][y].getFlag()||
                        tilegrid[i][y].getBomb()==0&&tilegrid[i][y].getHidden())
                    return false;

            }
            }
        return true;
        }


}

