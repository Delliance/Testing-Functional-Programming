package com.danieltesting.testingfunctionalprogramming.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPipeline {

    public static void main(String[] args) {

//        To perform a sequence of operations over the elements of the data source and aggregate their results, we need
//        three parts:
//        the source,
//        intermediate operation(s) and a
//        terminal operation.

//        Intermediate operations return a new modified stream. For example, to create a new stream of the existing one
//        without few elements, the skip() method should be used:

        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1);

//        If we need more than one modification, we can chain intermediate operations. Let's assume that we also need to
//        substitute every element of the current Stream<String> with a sub-string of the first few chars. We can do
//        this by chaining the skip() and map() methods:

        Stream<String> twiceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1).map(element -> element.substring(0, 3));

//        A stream by itself is worthless; the user is interested in the result of the terminal operation, which can be
//        a value of some type or an action applied to every element of the stream. We can only use one terminal
//        operation per stream.

//        The correct and most convenient way to use streams is by a stream pipeline, which is a chain of the stream
//        source, intermediate operations, and a terminal operation:

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().count();

    }

}
