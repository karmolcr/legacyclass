import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class FizzBuzzUsingRulesTest {
    @Test
    public void shouldVerifyByGivenRule(){
        Rule mockRule = Mockito.mock(Rule.class);
        FizzBuzz game = new FizzBuzz(Arrays.asList(mockRule));

        game.answer(1);

        Mockito.verify(mockRule).isAnswer(1);
    }
}
