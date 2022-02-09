package com.danieltesting.testingfunctionalprogramming.functionalinterfaces.buildtinfunctionalinterfaces.Predicate;

import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {

        Predicate predicate = new CheckForNull();
        String objectToTest = null;
        Boolean isThereAnObject = predicate.test(objectToTest);
        System.out.println("Is the object NOT null? "+isThereAnObject);


//        You can also implement the Java Predicate interface using a Lambda expression.
        Predicate predicate2 = (value) -> value != null;
    }

}
