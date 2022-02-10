package com.danieltesting.testingfunctionalprogramming.listslambdasmethodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindingElementsInACollection {

    public static void main(String[] args) {

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

//        The elegant methods used to traverse and transform collections will not directly help you pick elements from
//        a collection. The filter() method is designed for that purpose.

//        Imagine that from a list of names, you need to pick the ones that start with the letter N. Because there may
//        be zero matching names in the list, the result may be an empty list. First, here’s how to code it using the
//        old approach.

        final List<String> startsWithN =
                new ArrayList<String>();
        for(String name : friends) {
            if (name.startsWith("N")) {
                startsWithN.add(name);
            }
        }

//      Here is how to refactor this code to use the filter() method and see how it changes things.

        final List<String> startsWithN2 =
                friends.stream()
                        .filter(name2 -> name2.startsWith("N"))
                        .collect(Collectors.toList());

//      The filter() method expects a lambda expression that returns a boolean result. If the lambda expression
//      returns true, the element in context while executing that lambda expression is added to a result
//      collection; it’s skipped otherwise. Finally, the method returns a stream with only elements for which the
//      lambda expression yielded true. In the end, you transformed the result into a List using the collect()
//      method.

//      Here’s how to print the number of elements in the result collection.

        System.out.println(
                String.format(
                        "Found %d names", startsWithN2.size()));

//        The filter() method returns an iterator just like the map() method does, but the similarity ends there.
//        Whereas the map() method returns a collection of the same size as the input collection, the filter() method
//        might not. It might yield a result collection with a number of elements ranging from zero to the maximum
//        number of elements in the input collection. However, unlike map(), the elements in the result collection that
//        filter() returned are a subset of the elements in the input collection.
    }

}
