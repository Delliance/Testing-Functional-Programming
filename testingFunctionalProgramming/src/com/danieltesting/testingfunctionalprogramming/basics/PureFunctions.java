package com.danieltesting.testingfunctionalprogramming.basics;

import java.util.List;
import java.util.stream.Collectors;

public class PureFunctions {

//    a pure function should return a value based only on the arguments and should have no side effects

    public static Integer sum(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.summingInt(Integer::intValue));
    }

}