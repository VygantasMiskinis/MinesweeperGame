import game.MineField;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MineFieldTest {
        @Test
    public void testBombGeneration() throws Exception{
            MineField field = new MineField();
            field.reset();
            Assert.assertTrue("Wrong number of bombs generated",field.getBombCount()==field.getmaxBombs());
        }
}