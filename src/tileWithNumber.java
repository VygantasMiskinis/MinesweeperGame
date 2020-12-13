public class tileWithNumber extends Tile {
    private int neighbourBombs=0;

    public tileWithNumber(int i){
        super();
        neighbourBombs=i;
    }
    public String draw() {
        if (isFlagged) {
            return "F";
        } else if (isHidden)
            return "H";
        else
            return String.valueOf(neighbourBombs);
    }
}
