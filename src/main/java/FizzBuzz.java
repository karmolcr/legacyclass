public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String answer(int input) {
        if(isAFizzBuzz(input)){
            return FIZZBUZZ;
        }
        if(isAFizz(input)){
            return FIZZ;
        }
        if(isABuzz(input)){
            return BUZZ;
        }
        return Integer.toString(input);
    }

    private boolean isAFizzBuzz(int input) {
        return isAFizz(input) && isABuzz(input);
    }

    private boolean isABuzz(int input) {
        return input%5 == 0;
    }

    private boolean isAFizz(int input) {
        return input%3 == 0;
    }
}
