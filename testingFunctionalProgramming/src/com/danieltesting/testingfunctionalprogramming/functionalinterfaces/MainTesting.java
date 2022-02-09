package com.danieltesting.testingfunctionalprogramming.functionalinterfaces;

public class MainTesting {

    public static void main(String[] args) {


//        A Java functional interface can be implemented by a Java Lambda Expression
//        A Java lambda expression implements a single method from a Java interface
//        In order to know what method the lambda expression implements, the interface
//        can only contain a single unimplemented method. In other words, the interface
//        must be a Java functional interface.
        MyFunctionalInterface lambda = () -> { //this right here is the lambda expression
            System.out.println("Executing...");
        };

    }

}
