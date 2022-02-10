package com.danieltesting.testingfunctionalprogramming.stream;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReduction {

    public static void main(String[] args) {

        Logger log = Logger.getGlobal();

//    The API has many terminal operations which aggregate a stream to a type or to a primitive: count(), max(), min(),
//    and sum(). However, these operations work according to the predefined implementation. So what if a developer needs
//    to customize a Stream's reduction mechanism? There are two methods which allow us to do this, the reduce() and the
//    collect() methods.

//    1.1 The reduce() Method

//    There are three variations of this method, which differ by their signatures and returning types. They can have
//    the following parameters:

//    -identity – the initial value for an accumulator, or a default value if a stream is empty and there is nothing to
//    accumulate

//    -accumulator – a function which specifies the logic of the aggregation of elements. As the accumulator creates a
//    new value for every step of reducing, the quantity of new values equals the stream's size and only the last value
//    is useful. This is not very good for the performance.

//    -combiner – a function which aggregates the results of the accumulator. We only call combiner in a parallel mode
//    to reduce the results of accumulators from different threads.

//    Now let's look at these three methods in action:

        OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b); // 1,4 means from 1 to 3

//    reduced = 6 it comes from adding (1 + 2 + 3)

        int reducedTwoParams =
                IntStream.range(1, 4).reduce(10, (a, b) -> a + b);

//    reducedTwoParams = 16 it comes from adding (10 + (1 + 2 + 3))

        int reducedParams = Stream.of(1, 2, 3) //here we give the values and not the range
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called"); //the logger is not called, read next text to know why
                    return a + b;
                });

//        The result will be the same as in the previous example (16), and there will be no login, which means that
//        combiner wasn't called. To make a combiner work, a stream should be parallel:

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream() //arraylist with parallelStream
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called");
                    return a + b;
                });

//        The result here is different (36), and the combiner was called twice. Here the reduction works by the
//        following algorithm: the accumulator ran three times by adding every element of the stream to identity.
//        These actions are being done in parallel. As a result, they have (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;).
//        Now combiner can merge these three results. It needs two iterations for that (12 + 13 = 25; 25 + 11 = 36).





//        1.2 The collect() Method

//        The reduction of a stream can also be executed by another terminal operation, the collect() method. It accepts
//        an argument of the type Collector, which specifies the mechanism of reduction. There are already created,
//        predefined collectors for most common operations. They can be accessed with the help of the Collectors type.

//        In this section, we will use the following List as a source for all streams:

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

//        1.2.1 Converting a stream to the Collection (Collection, List or Set):

        List<String> collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.toList());

//        Here we create a list only with the names

//        1.2.2 Reducing to String:

        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));

//        Here we create a String of the names separated by comma and inside []

//        The joiner() method can have from one to three parameters (delimiter, prefix, suffix). The most convenient
//        thing about using joiner() is that the developer doesn't need to check if the stream reaches its end to apply
//        the suffix and not to apply a delimiter. Collector will take care of that.

//        1.2.3 Processing the average value of all numeric elements of the stream:

        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::getPrice));

//        1.2.4 Processing the sum of all numeric elements of the stream:

        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::getPrice));

//        The methods averagingXX(), summingXX() and summarizingXX() can work with primitives (int, long, double) and
//        with their wrapper classes (Integer, Long, Double). One more powerful feature of these methods is providing
//        the mapping. As a result, the developer doesn't need to use an additional map() operation before the collect()
//        method.

//        1.2.5 Collecting statistical information about stream’s elements:

        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));

//        The result of this is IntSummaryStatistics{count=5, sum=86, min=13, average=17,200000, max=23}

//        By using the resulting instance of type IntSummaryStatistics, the developer can create a statistical report
//        by applying the toString() method. The result will be a String common to this one
//        “IntSummaryStatistics{count=5, sum=86, min=13, average=17,200000, max=23}.”

//        It is also easy to extract from this object separate values for count, sum, min, and average by applying the
//        methods getCount(), getSum(), getMin(), getAverage(), and getMax(). All of these values can be extracted from
//        a single pipeline.

//        1.2.6 Grouping of stream’s elements according to the specified function:

        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));

//        In the example above, the stream was reduced to the Map, which groups all products by their price.

//        1.2.7 Dividing stream’s elements into groups according to some predicate:

        Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

//        Here only groups with price >15 are created, so there are no groups of products with price less or equal to 15

//        1.2.8 Pushing the collector to perform additional transformation:

        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));

//        In this particular case, the collector has converted a stream to a Set, and then created the unchangeable Set out of it.

//        1.2.9 Custom collector:

//        If for some reason a custom collector should be created, the easiest and least verbose way of doing so is to
//        use the method of() of the type Collector.

        Collector<Product, ?, LinkedList<Product>> toLinkedList = //toLinkedList is a name of a Collector
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPersons =
                productList.stream().collect(toLinkedList);

//        In this example, an instance of the Collector got reduced to the LinkedList<Persone>. <- not sure of this

    }

}
