public class FizzBuzz {

    public String answer(int input) {
        if(input%3 == 0){
            return "Fizz";
        }
        if(input%5 == 0){
            return "Buzz";
        }
        return Integer.toString(input);
    }
}
