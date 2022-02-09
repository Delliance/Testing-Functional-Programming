package com.danieltesting.testingfunctionalprogramming.basics;

import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FunctionalProgrammingTechniques {

    public static void main(String[] args) {

//        here are all my notes all the other classes in this package come from the github https://github.com/eugenp/tutorials


        Logger logger = Logger.getGlobal();


//        FUNCTION COMPOSITION
        Function<Double, Double> log = (value) -> Math.log(value);
        Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
        Function<Double, Double> logThenSqrt = sqrt.compose(log); //Here a method compose is created
        logger.log(Level.INFO, String.valueOf(logThenSqrt.apply(3.14)));
        // Output: 1.06
        Function<Double, Double> sqrtThenLog = sqrt.andThen(log); //Here a method andThen is created
        logger.log(Level.INFO, String.valueOf(sqrtThenLog.apply(3.14)));
        // Output: 0.57


//        MONADS
        System.out.println(Optional.of(2).flatMap(f -> Optional.of(3).flatMap(s -> Optional.of(f + s))));
        logger.log(Level.INFO, String.valueOf(Optional.of(2)));


//        CURRYING
        Function<Double, Function<Double, Double>> weight = mass -> gravity -> mass * gravity;

        Function<Double, Double> weightOnEarth = weight.apply(9.81);
        logger.log(Level.INFO, "My weight on Earth: " + weightOnEarth.apply(60.0));

        Function<Double, Double> weightOnMars = weight.apply(3.75);
        logger.log(Level.INFO, "My weight on Mars: " + weightOnMars.apply(60.0));


//        RECURSION
        //look at the methods outside the Main class




    }

//    CURRYING yes this is part of currying a function as a method
    private static Function<Double, Double> weightOnEarth2() {
        final double gravity = 9.81; //this is called closure
        return mass -> mass * gravity;
    }

//    RECURSION this is outside because the examples are methods
    Integer factorial(Integer number) {
        return (number == 1) ? 1 : number * factorial(number - 1);
    }

    Integer factorial(Integer number, Integer result) { // this one here is called tail recursion, Here, we ensure that the recursive call is the last call a function makes
        return (number == 1) ? result : factorial(number - 1, result * number);
    }

}
