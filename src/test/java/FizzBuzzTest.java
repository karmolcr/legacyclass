import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FizzBuzzTest {

    private FizzBuzz game;

    private int input;
    private String expected;

    public FizzBuzzTest(int input,String expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection parameterSet() {
        return Arrays.asList(new Object[][] {
                { 1, "1" },
                { 2, "2" },
                { 3, "Fizz" }
        });
    }

    @Before
    public void setup(){
        game = new FizzBuzz();
    }
    @Test
    public void checkAnswer(){
        assertEquals(expected, game.answer(input));
    }

}
