public class tileWithNumber extends Tile {
    private int neighbourBombs=0;

    public tileWithNumber(){
        super();
    }


    @Override
    protected String printTile() {
        return String.valueOf(neighbourBombs);
    }

    @Override
    public void setNeighbourBombs(int bombs) {
        this.neighbourBombs = bombs;
    }
}
