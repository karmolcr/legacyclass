public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String answer(int input) {
        if(input%15 == 0){
            return FIZZBUZZ;
        }
        if(input%3 == 0){
            return FIZZ;
        }
        if(input%5 == 0){
            return BUZZ;
        }
        return Integer.toString(input);
    }
}
