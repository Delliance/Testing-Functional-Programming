package com.danieltesting.testingfunctionalprogramming.listslambdasmethodreferences;

import java.util.Arrays;
import java.util.List;

public class UsingMethodReferences {

    public static void main(String[] args) {

//        This is after the TransformAList examples, this shows a shorter code using method references

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

//        You can make the code be just a bit more concise by using a feature called method reference. The Java compiler
//        will take either a lambda expression or a reference to a method where an implementation of a functional
//        interface is expected. With this feature, a short String::toUpperCase can replace name ->name.toUpperCase(),
//        as follows:

        friends.stream()
                .map(String::toUpperCase) // In the example in TransformingAList this was a lambda
                .forEach(name -> System.out.println(name));

//        Java knows to invoke the String class’s given method toUpperCase() on the parameter passed in to the
//        synthesized method—the implementation of the functional interface’s abstract method. That parameter reference
//        is implicit here.

//        In simple situations such as the previous example, you can substitute method references for
//        lambda expressions

//        In the preceding example, the method reference was for an instance method. Method references can also refer
//        to static methods and methods that take parameters

//        When should you use method references?
//        They are nice replacements when the lambda expressions are short and make simple, direct calls to either an
//        instance method or a static method. In other words, if lambda expressions merely pass their parameters
//        through, you can replace them with method references.


    }

}
