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
                {1, "1"},
                {2, "2"},
                {3, FizzBuzz.FIZZ},
                {4, "4"},
                {5, FizzBuzz.BUZZ},
                {6, FizzBuzz.FIZZ},
                {7, "7"},
                {8, "8"},
                {9, FizzBuzz.FIZZ},
                {10, FizzBuzz.BUZZ},
                {11, "11"},
                {12, FizzBuzz.FIZZ},
                {13, "13"},
                {14, "14"},
                {15, FizzBuzz.FIZZBUZZ}
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
