package com.danieltesting.testingfunctionalprogramming.basics;

import java.util.function.Function;

public class FunctionComposition {

//    refers to composing complex functions by combining simpler functions
//    any interface with a single abstract method can serve as a functional interface

    private static Function<Double, Double> log = (value) -> Math.log(value);
    private static Function<Double, Double> sqrt = (value) -> Math.sqrt(value);

    public static Double logThenSqrt(Double number) {
        Function<Double, Double> logThenSqrt = sqrt.compose(log);
        return (logThenSqrt.apply(3.14));
    }

    public static Double sqrtThenLog(Double number) {
        Function<Double, Double> sqrtThenLog = sqrt.andThen(log);
        return (sqrtThenLog.apply(3.14));
    }

}