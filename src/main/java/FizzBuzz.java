import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";
    private List<Rule> rules;

    FizzBuzz(List<Rule> rules){
        this.rules = rules;
    }

    public String answer(int input) {



        for (Rule rule:
                rules) {
            if(rule.isAnswer(input)){
                return rule.getAnswer();
            }
        }

        return Integer.toString(input);
    }

}
