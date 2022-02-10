package com.danieltesting.testingfunctionalprogramming.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class LazyInvocation {

    private static long counter;

    static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {

//        Intermediate operations are lazy. This means that they will be invoked only if it is necessary for the
//        terminal operation execution.

//        For example, let's call the method wasCalled(), which increments an inner counter every time it's called:

//        method is outside the main

//        Now let's call the method wasCalled() from operation filter():

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });

//        As we have a source of three elements, we can assume that the filter() method will be called three times, and
//        the value of the counter variable will be 3. However, running this code doesn't change counter at all, it is
//        still zero, so the filter() method wasn't even called once. The reason why is missing of the terminal
//        operation.

//        Let's rewrite this code a little bit by adding a map() operation and a terminal operation, findFirst(). We
//        will also add the ability to track the order of method calls with the help of logging:

        Logger log = Logger.getGlobal();

        Optional<String> stream2 = list.stream().filter(element -> { //the list here was created above
            log.info("filter() was called");
            return element.contains("2");
        }).map(element -> {
            log.info("map() was called");
            return element.toUpperCase();
        }).findFirst();

        System.out.println(stream2);

//        What this code does is for each value of the list it'll apply a filter, first it'll check the first value
//        here we DON'T use the counter we specifically search for a String that contains a "2". Only the first value
//        that contains that 2 will pass the filter, if there is a value with "2" in this case "abc2" it'll go to the
//        map() and make the element .toUpperCase(), and finally assign it to stream2

//        The resulting log shows that we called the filter() method twice and the map() method once. This is because
//        the pipeline executes vertically. In our example, the first element of the stream didn't satisfy the filter's
//        predicate. Then we invoked the filter() method for the second element, which passed the filter. Without
//        calling the filter() for the third element, we went down through the pipeline to the map() method.

//        The findFirst() operation satisfies by just one element. So in this particular example, the lazy invocation
//        allowed us to avoid two method calls, one for the filter() and one for the map().


    }



}
