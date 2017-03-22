import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FizzBuzzRuleTest {
    private FizzBuzzRule rule;

    private int input;
    private boolean expected;

    public FizzBuzzRuleTest(int input,boolean expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection parameterSet() {
        return Arrays.asList(new Object[][] {
                {15, true},
                {30, true}
        });
    }

    @Before
    public void setup(){
        rule = new FizzBuzzRule();
    }
    @Test
    public void checkLogicAnswer() {
        assertEquals(expected, rule.isAnswer(input));
    }
}
