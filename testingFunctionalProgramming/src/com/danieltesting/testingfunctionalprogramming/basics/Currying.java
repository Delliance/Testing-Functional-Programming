package com.danieltesting.testingfunctionalprogramming.basics;

import java.util.function.Function;

public class Currying {

//    technique of converting a function that takes multiple arguments into a sequence of functions that take a single argument

    private static Function<Double, Function<Double, Double>> weight = mass -> gravity -> mass * gravity;

    private static Function<Double, Double> weightOnEarth = weight.apply(9.81);

    private static Function<Double, Double> weightOnMars = weight.apply(3.75);

    public static Double weightOnEarth(Double mass) {
        return weightOnEarth.apply(mass);
    }

    public static Double weightOnMars(Double mass) {
        return weightOnMars.apply(mass);
    }

    public static Function<Double, Double> weightOnEarth() {
        final double gravity = 9.81;
        return mass -> mass * gravity;
    }

}