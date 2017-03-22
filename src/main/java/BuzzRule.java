public class BuzzRule extends FizzBuzz {
    public boolean isAnswer(int input) {
        return input%5 == 0;
    }

    public String getAnswer() {
        return "Buzz";
    }
}
