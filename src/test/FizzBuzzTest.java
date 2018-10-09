package test;

import main.FizzBuzz;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static java.util.stream.IntStream.range;

import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class FizzBuzzTest {

    @DataPoints
    public static final int[] numbers = range(1, 100).toArray();

    private final FizzBuzz object = new FizzBuzz(1);

    @Theory
    public void validOutputTheory(Integer number) {
        assertThat(object.evaluate(number), FizzBuzzMatchers.isValidFizzBuzz());
    }

    @Theory
    public void fizzTheory(Integer number) {
        assumeThat(number, FizzBuzzMatchers.isDivisibleBy(3));

        assertThat(object.evaluate(number), containsString("Fizz"));
    }

    @Theory
    public void buzzTheory(Integer number) {
        assumeThat(number, FizzBuzzMatchers.isDivisibleBy(5));

        assertThat(object.evaluate(number), containsString("Buzz"));
    }

    @Theory
    public void numberTheory(Integer number) {
        String fizzbuzz = object.evaluate(number);
        assumeThat(fizzbuzz, FizzBuzzMatchers.isANumber());

        assertThat(Integer.valueOf(fizzbuzz), equalTo(number));
    }
}