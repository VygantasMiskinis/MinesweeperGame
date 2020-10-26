import javax.swing.*;

public class Tile extends JButton {
   private int isBomb;
   private boolean isFlagged;
   private boolean isHidden;
   private int neighbourBombs;
    public Tile () {
      isBomb=0;
      isFlagged=false;
      isHidden=true;
        neighbourBombs=0;
    }

    public int getBomb () {
        return isBomb;
    }

    public int getNeighbourBombs(){return neighbourBombs;}

    public void setNeighbourBombs(int value) {neighbourBombs=value;}

    public boolean getHidden () {
        return isHidden;
    }

    public boolean getFlag () {
        return isFlagged;
    }

    public void setBomb () {
        isBomb=1;
    }

    public void setFlag () {
       if(isFlagged) isFlagged=false;
       else isFlagged=true;
    }

    public void uncover () { isHidden=false; }


    public String draw ()  {



        if(isHidden) {
            if (isFlagged)
                return "\uD83D\uDEA9";

            else
                return "■";
        }

        else
        {
            if (isFlagged)
                return "\uD83D\uDEA9";

            else if(isBomb==1)
            {
                return "☠";
            }

            else if (neighbourBombs>0)
            return String.valueOf(neighbourBombs);

            else
                return "□";
        }



    }

}
