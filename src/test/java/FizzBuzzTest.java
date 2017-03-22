import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz game;

    @Before
    public void setup(){
        game = new FizzBuzz();
    }
    @Test
    public void oneShouldBe1(){
        assertEquals("1", game.answer(1));
    }

    @Test
    public void twoShouldBe2(){
        assertEquals("2", game.answer(2));
    }
}
