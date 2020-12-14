package game;

public class tileEmpty extends Tile {

    public tileEmpty() {
        super();
    }

    @Override
    protected String printTile() {
        return "E";
    }

    @Override
    public void setNeighbourBombs(int bombs) {

    }
}

