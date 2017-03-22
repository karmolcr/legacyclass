public class FizzBuzz {

    public String answer(int input) {
        if(input == 3){
            return "Fizz";
        }else if(input == 5){
            return "Buzz";
        }
        return Integer.toString(input);
    }
}
