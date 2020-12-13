public class tileEmpty extends Tile {

    public tileEmpty() {
        super();
    }

    public String draw() {
        if (isFlagged) {
            return "F";
        } else if (isHidden)
            return "H";
        else
            return "E";
    }
}

