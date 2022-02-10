package com.danieltesting.testingfunctionalprogramming.stream;

import java.util.Arrays;
import java.util.List;

import static com.danieltesting.testingfunctionalprogramming.stream.LazyInvocation.wasCalled;

public class OrderOfExecution {

    public static void main(String[] args) {

//        From the performance point of view, the right order is one of the most important aspects of chaining
//        operations in the stream pipeline:

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        long size = list.stream().map(element -> { //list has 3 Strings, so this will be run 3 times
            wasCalled(); //this method here is from the LazyInvocation class, just a method with a counter
            return element.substring(0, 3);
        }).skip(2).count();

        System.out.println(size);

//        Execution of this code will increase the value of the counter by three. This means that we called the map()
//        method of the stream three times, but the value of the size is one. So the resulting stream has just one
//        element, and we executed the expensive map() operations for no reason two out of the three times.

//        If we change the order of the skip() and the map() methods, the counter will increase by only one. So we will
//        call the map() method only once:

        long size2 = list.stream().skip(2).map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).count();

//        This brings us to the following rule: intermediate operations which reduce the size of the stream should be
//        placed before operations which are applying to each element. So we need to keep methods such as skip(),
//        filter(), and distinct() at the top of our stream pipeline.

    }

}
