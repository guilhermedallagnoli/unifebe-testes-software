import java.util.function.Consumer;
import java.util.function.Function;

public abstract class GivenWhenThen<TInput, TResult> {
    protected TInput input;

    public GivenWhenThen(TInput input) {
        this.input = input;
    }

    public void Given(Consumer<TInput> give) {
        give.accept(input);
    }

    public void When(Consumer<TInput> when) {
        when.accept(input);
    }

    public abstract void Then(Function<TInput, TResult> then);
}
