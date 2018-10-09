package main;

public class Main {

    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(2);

        for(Integer i=0; i<100; i++){
            System.out.println(fizzBuzz.evaluate(i));
        }

    }
}
