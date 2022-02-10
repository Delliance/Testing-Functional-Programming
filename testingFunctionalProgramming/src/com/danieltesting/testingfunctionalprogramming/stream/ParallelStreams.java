package com.danieltesting.testingfunctionalprogramming.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));


//        Before Java 8, parallelization was complex. The emergence of the ExecutorService and the ForkJoin simplified
//        a developer’s life a little bit, but it was still worth remembering how to create a specific executor, how to
//        run it, and so on. Java 8 introduced a way of accomplishing parallelism in a functional style.

//        The API allows us to create parallel streams, which perform operations in a parallel mode. When the source of
//        a stream is a Collection or an array, it can be achieved with the help of the parallelStream() method:

        Stream<Product> streamOfCollection = productList.parallelStream(); //product is the class used for examples
        boolean isParallel = streamOfCollection.isParallel(); //here we are performing two different operations
        boolean bigPrice = streamOfCollection //in one we are doing .isParallel() and the other .map() both at same time
                .map(product -> product.getPrice() * 12)
                .anyMatch(price -> price > 200);

//        If the source of a stream is something other than a Collection or an array, the parallel() method should be
//        used:
//        in the previous example the source was a collection

        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        boolean isParallel2 = intStreamParallel.isParallel();

//        Under the hood, Stream API automatically uses the ForkJoin framework to execute operations in parallel. By
//        default, the common thread pool will be used and there is no way (at least for now) to assign some custom
//        thread pool to it. This can be overcome by using a custom set of parallel collectors.

//        When using streams in parallel mode, avoid blocking operations. It is also best to use parallel mode when
//        tasks need a similar amount of time to execute. If one task lasts much longer than the other, it can slow
//        down the complete app’s workflow.

//        The stream in parallel mode can be converted back to the sequential mode by using the sequential() method:

        IntStream intStreamSequential = intStreamParallel.sequential();
        boolean isParallel3 = intStreamSequential.isParallel();

    }

}
