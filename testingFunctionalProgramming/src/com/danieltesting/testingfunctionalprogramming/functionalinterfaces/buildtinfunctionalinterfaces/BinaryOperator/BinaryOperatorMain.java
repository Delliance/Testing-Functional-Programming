package com.danieltesting.testingfunctionalprogramming.functionalinterfaces.buildtinfunctionalinterfaces.BinaryOperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorMain {

    public static void main(String[] args) {
        BinaryOperator<MyValue> binaryOperator =
                (value1, value2) -> { value1.add(value2); return value1; };
    }

}
