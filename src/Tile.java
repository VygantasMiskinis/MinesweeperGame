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


    public abstract String draw();
}