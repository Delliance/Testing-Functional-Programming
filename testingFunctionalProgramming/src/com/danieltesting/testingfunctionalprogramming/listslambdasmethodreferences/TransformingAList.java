package com.danieltesting.testingfunctionalprogramming.listslambdasmethodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformingAList {

    public static void main(String[] args) {

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

//        Suppose the task is to convert a list of names to all capital letters

//        Java’s String is immutable, so instances can’t be changed. You could create new strings in all caps and
//        replace the appropriate elements in the collection. However, the original collection would be lost; also, if
//        the original list is immutable, as it is when it’s created with Arrays.asList(), the list can’t change. It
//        would also be hard to parallelize the work

//        Creating a new list that has the elements in all uppercase is better.

        final List<String> uppercaseNames =
                new ArrayList<String>();
        for(String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }

//        In this imperative style, this code created an empty list and then populated it with uppercase names, one
//        element at a time, while iterating through the original list. As a first step to move toward a functional
//        style, use the internal iterator forEach() method to replace the for loop, as follows:

        final List<String> uppercaseNames2 =
                new ArrayList<String>();
        friends.forEach(name ->
                uppercaseNames2.add(name.toUpperCase()));
        System.out.println(uppercaseNames2);

//        This code used the internal iterator, but that still required the empty list and the effort to add elements
//        to it.

//        Going the next step, the map() method of a new Stream interface can help avoid mutability and make the code
//        concise. A Stream is much like an iterator on a collection of objects and provides some nice fluent functions.
//        Using the methods of this interface, you can compose a sequence of calls, so the code reads and flows in the
//        same way you’d state the problem, making it easier to read.

//        The map() method of Stream can map or transform an input sequence to an output sequence. This will fit quite
//        well for the task at hand.

        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

//        The  stream( ) method is available on all collections since JDK 8, and it wraps the collection into an
//        instance of Stream. The map() method applies the given lambda expression or block of code within the
//        parentheses on each element in the Stream. The map() method is quite unlike the forEach() method, which
//        simply runs the block in the context of each element in the collection. In addition, the map() method
//        collects the result of running the lambda expression and returns the resulting collection. Finally, the code
//        prints the elements in this result using the forEach() method.

//        The map() method is very useful for mapping or transforming an input collection into a new output collection.
//        This method will ensure that the same number of elements exists in the input and the output sequence. However,
//        element types in the input don’t have to match the element types in the output collection.

//        In this example, both the input and the output are a collection of strings. You could have passed to the map()
//        method a block of code that returned, for example, the number of characters in a given name. In this case,
//        the input would still be a sequence of strings, but the output would be a sequence of numbers, as in the next
//        example.

        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + " "));

//        The versions using the lambda expressions have no explicit mutation; they’re concise. These versions also
//        didn’t need any initial empty collection or garbage variable; that variable quietly receded into the shadows
//        of the underlying implementation.

    }

}
