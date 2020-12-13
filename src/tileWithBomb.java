public class tileWithBomb extends Tile {

    public tileWithBomb(){
        super();
    }
    public String draw() {
        if (isFlagged) {
            return "F";
        } else if (isHidden)
            return "H";
        else
            return "B";
    }
}
