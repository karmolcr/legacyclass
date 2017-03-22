import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BuzzRuleTest {
    private BuzzRule rule;

    private int input;
    private boolean expected;

    public BuzzRuleTest(int input,boolean expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection parameterSet() {
        return Arrays.asList(new Object[][] {
                {5, true},
                {10, true}
        });
    }

    @Before
    public void setup(){
        rule = new BuzzRule();
    }
    @Test
    public void checkLogicAnswer() {
        assertEquals(expected, rule.isAnswer(input));
    }
}
