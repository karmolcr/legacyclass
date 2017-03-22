public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String answer(int input) {


        Rule fizzBuzzRule = new FizzBuzzRule();
        Rule fizzRule = new FizzRule();
        Rule buzzRule = new BuzzRule();

        if(fizzBuzzRule.isAnswer(input)){
            return fizzBuzzRule.getAnswer();
        }

        if(fizzRule.isAnswer(input)){
            return fizzRule.getAnswer();
        }

        if(buzzRule.isAnswer(input)){
            return buzzRule.getAnswer();
        }
        return Integer.toString(input);
    }

}
