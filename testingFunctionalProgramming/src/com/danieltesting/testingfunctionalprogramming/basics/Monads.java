package com.danieltesting.testingfunctionalprogramming.basics;

import java.util.Optional;

public class Monads {

//    a monad allows us to wrap a value, apply a set of transformations, and get the value back with all transformations applied
//    we can define our own monad types in Java to achieve different objectives

    public static Optional<Integer> add(Optional<Integer> val1, Optional<Integer> val2) {
        return val1.flatMap(first -> val2.flatMap(second -> Optional.of(first + second)));
    }

}