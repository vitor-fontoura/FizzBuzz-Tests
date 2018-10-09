package test;

import main.FizzBuzz;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static java.util.stream.IntStream.range;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class FizzBuzzStageTwoTest extends FizzBuzzTest {

    @DataPoints
    public static final int[] numbers = range(1, 100).toArray();

    private final FizzBuzz object = new FizzBuzz(2);

    @Theory
    public void fizzTheoryStageTwo(Integer value) {
        assumeThat(value, FizzBuzzMatchers.containsNumber(3));
        assertThat(object.evaluate(value), containsString("Fizz"));
    }

    @Theory
    public void buzzTheoryStageTwo(Integer value) {
        assumeThat(value, FizzBuzzMatchers.containsNumber(5));
        assertThat(object.evaluate(value), containsString("Buzz"));
    }
}