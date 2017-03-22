import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String answer(int input) {


        List<Rule> rules = Arrays.asList(new FizzBuzzRule(), new FizzRule(), new BuzzRule());

        for (Rule rule:
             rules) {
            if(rule.isAnswer(input)){
                return rule.getAnswer();
            }
        }

        return Integer.toString(input);
    }

}
