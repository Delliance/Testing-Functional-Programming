package com.danieltesting.testingfunctionalprogramming.basics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FirstClassFunctions {

//    functions are allowed to support all operations typically available to other entities
//    Higher-order functions are capable of receiving function as arguments and returning a function as a result
//     new features to ease the process, like lambda expressions, method references, and predefined functional interfaces.
//    Java treats a lambda expression as an Object

    public static List<Integer> sortWithoutLambda(List<Integer> numbers) {
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        });
        return numbers;
    }

    public static List<Integer> sortWithLambda(List<Integer> numbers) {
        Collections.sort(numbers, (n1, n2) -> n1.compareTo(n2));
        return numbers;
    }

}