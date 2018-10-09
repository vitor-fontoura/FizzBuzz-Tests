package test;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class FizzBuzzMatchers {

    public static Matcher<String> isValidFizzBuzz() {
        return new BaseMatcher<String>() {
            @Override
            public boolean matches(final Object o) {
                final String str = (String) o;
                return str.equals("Fizz")
                        || str.equals("Buzz")
                        || str.equals("FizzBuzz")
                        || isANumber().matches(str);
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("Should be a valid main.FizzBuzz output");
            }
        };
    }

    public static Matcher<Integer> isDivisibleBy(Integer dividend) {
        return new BaseMatcher<Integer>() {
            @Override
            public boolean matches(final Object o) {
                final Integer value = (Integer) o;
                return (value % dividend) == 0;
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("Should be divisible by ").appendValue(dividend);
            }
        };
    }

    public static Matcher<String> isANumber() {
        return new BaseMatcher<String>() {
            @Override
            public boolean matches(final Object o) {
                final String str = (String) o;
                return str.chars().allMatch(Character::isDigit);
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("Should be a number");
            }
        };
    }

    public static Matcher<Integer> containsNumber(Integer number) {
        return new BaseMatcher<Integer>() {
            @Override
            public boolean matches(final Object o) {
                final String str = ((Integer) o).toString();
                return str.matches(number.toString());
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("Should contain number ").appendValue(number);
            }
        };
    }

}
