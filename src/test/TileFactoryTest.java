import game.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileFactoryTest {

    @Test
    public void createTile() {
        TileFactory factory = new TileFactory();
        Assert.assertTrue("Factory returns wrong object",factory.createTile("empty") instanceof tileEmpty);
        Assert.assertTrue("Factory returns wrong object",factory.createTile("bomb") instanceof tileWithBomb);
        Assert.assertTrue("Factory returns wrong object",factory.createTile("number") instanceof tileWithNumber);
        Assert.assertTrue("Factory returns wrong object",factory.createTile("test Giberrish") instanceof tileEmpty);

    }
}