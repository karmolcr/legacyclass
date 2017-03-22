import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void oneShouldBe1(){
        FizzBuzz game = new FizzBuzz();
        assertEquals("1", game.answer(1));
    }
}
