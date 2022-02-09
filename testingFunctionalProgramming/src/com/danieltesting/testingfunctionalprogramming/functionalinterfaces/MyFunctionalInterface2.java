package com.danieltesting.testingfunctionalprogramming.functionalinterfaces;

import java.io.IOException;
import java.io.PrintWriter;

//Normally a Java interface does not contain implementations of the methods it declares,
// but it can contain implementations in default methods, or in static methods. Below is
// another example of a Java functional interface, with implementations of some of the
// methods:


public interface MyFunctionalInterface2{
    public void execute();

    public default void print(String text) {
        System.out.println(text);
    }

    public static void print(String text, PrintWriter writer) throws IOException {
        writer.write(text);
    }
}

//The above interface still counts as a functional interface in Java, since it only contains
// a single non-implemented method.