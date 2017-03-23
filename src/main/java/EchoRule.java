public class EchoRule implements Rule{
    private int input;

    public boolean isAnswer(int input) {
        this.input = input;
        return true;
    }

    public String getAnswer() {
        return Integer.toString(this.input);
    }
}
