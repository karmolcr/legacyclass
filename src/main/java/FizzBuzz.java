import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String answer(int input) {


        Rule rule_01 = new FizzBuzzRule();
        Rule rule_02 = new FizzRule();
        Rule rule_03 = new BuzzRule();

        List<Rule> rules = Arrays.asList(rule_01, rule_02, rule_03);

        if(rules.get(0).isAnswer(input)){
            return rules.get(0).getAnswer();
        }

        if(rules.get(1).isAnswer(input)){
            return rules.get(1).getAnswer();
        }

        if(rules.get(2).isAnswer(input)){
            return rules.get(2).getAnswer();
        }
        return Integer.toString(input);
    }

}
