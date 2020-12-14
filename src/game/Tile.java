package game;

import javax.swing.*;

public abstract class Tile {
    protected boolean isFlagged;
    protected boolean isHidden;

    public Tile() {
        isFlagged = false;
        isHidden = true;
    }
    public boolean getHidden() {
        return isHidden;
    }

    public boolean getFlag() {
        return isFlagged;
    }


    public void setFlag() {
        if (isFlagged) isFlagged = false;
        else isFlagged = true;
    }

    public void uncover() {
        isHidden = false;
    }


    public  String draw(){
        if (isFlagged) {
            return "F";
        } else if (isHidden)
            return "H";
        else
            return printTile();
    }

    protected abstract String printTile();

    public abstract void setNeighbourBombs(int bombs);
}