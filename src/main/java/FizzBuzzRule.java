
public class FizzBuzzRule implements Rule {
    FizzRule fizzRule = new FizzRule();
    BuzzRule buzzRule = new BuzzRule();
    @Override
    public boolean isAnswer(int input) {
        return fizzRule.isAnswer(input) && buzzRule.isAnswer(input);
    }
    @Override
    public String getAnswer() {
        return FizzBuzz.FIZZBUZZ;
    }
}
