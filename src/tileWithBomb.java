public class tileWithBomb extends Tile {

    public tileWithBomb(){
        super();
    }

    @Override
    protected String printTile() {
        return "B";
    }

    @Override
    public void setNeighbourBombs(int bombs) {

    }
}
