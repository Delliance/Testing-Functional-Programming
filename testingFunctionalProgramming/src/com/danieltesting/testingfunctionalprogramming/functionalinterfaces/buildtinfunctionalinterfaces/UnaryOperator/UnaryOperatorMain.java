package com.danieltesting.testingfunctionalprogramming.functionalinterfaces.buildtinfunctionalinterfaces.UnaryOperator;

import java.util.function.UnaryOperator;

public class UnaryOperatorMain {
    public static void main(String[] args) {

        UnaryOperator<Person> unaryOperator =
                (person) -> { person.name = "New Name"; return person; };

    }

}
