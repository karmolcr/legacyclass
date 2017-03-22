public class FizzRule implements Rule{
    public boolean isAnswer(int input) {
        return input%3 == 0;
    }

    public String getAnswer() {
        return "Fizz";
    }
}
