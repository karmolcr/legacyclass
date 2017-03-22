public class BuzzRule implements Rule {
    public boolean isAnswer(int input) {
        return input%5 == 0;
    }

    public String getAnswer() {
        return FizzBuzz.BUZZ;
    }
}
