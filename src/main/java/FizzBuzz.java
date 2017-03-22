public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String answer(int input) {


        FizzBuzzRule fizzBuzzRule = new FizzBuzzRule();
        if(fizzBuzzRule.isAnswer(input)){
            return fizzBuzzRule.getAnswer();
        }
        FizzRule fizzRule = new FizzRule();
        if(fizzRule.isAnswer(input)){
            return fizzRule.getAnswer();
        }
        BuzzRule buzzRule = new BuzzRule();
        if(buzzRule.isAnswer(input)){
            return buzzRule.getAnswer();
        }
        return Integer.toString(input);
    }

}
