
public class FizzBuzzRule {
    FizzRule fizzRule = new FizzRule();
    BuzzRule buzzRule = new BuzzRule();
    public boolean isAnswer(int input) {
        return fizzRule.isAnswer(input) && buzzRule.isAnswer(input);
    }
    public String getAnswer() {
        return "FizzBuzz";
    }
}
