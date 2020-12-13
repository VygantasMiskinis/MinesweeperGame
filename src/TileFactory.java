public class TileFactory {

    public Tile createTile(String type){
        switch(type){
            case "bomb":
                return new tileWithBomb();
            case "number":
                return new tileWithNumber();
            default:
                return new tileEmpty();
        }
    }
}
