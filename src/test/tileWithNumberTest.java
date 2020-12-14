import game.tileWithNumber;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
public class tileWithNumberTest {

    @Test
    public void printTile() {
        tileWithNumber tile = new tileWithNumber();
        tile.setNeighbourBombs(5);
        tile.uncover();
        Assert.assertEquals("Draw function returns wrong number","5",tile.draw());

    }
}