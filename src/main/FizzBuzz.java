package main;

public class FizzBuzz {

    private static final Integer fizz = 3;
    private static final Integer buzz = 5;

    private final Boolean isStageTwo;

    public FizzBuzz(Integer stage) {
        isStageTwo = (stage == 2);
    }

    public String evaluate(Integer number) {
        String response = "";

        if(isFizz(number))
            response = "Fizz";

        if(isBuzz(number))
            response += "Buzz";

        if(response.equals(""))
            response = number.toString();

        return response;
    }

    private Boolean testNumbers(Integer number, Integer fizzBuzz) {
        Boolean response = isMultiple(number, fizzBuzz);

        if(isStageTwo)
            response = (response || hasDigit(number, fizzBuzz));

        return response;
    }

    private Boolean isFizz(Integer number) {
        return testNumbers(number, fizz);
    }

    private Boolean isBuzz(Integer number){
        return testNumbers(number, buzz);
    }

    private static Boolean isMultiple(Integer dividend, Integer divisor) {
        return (dividend % divisor == 0);
    }

    private static Boolean hasDigit(Integer hayStack, Integer needle) {
        return (hayStack.toString().indexOf(needle.toString()) != -1);
    }

}