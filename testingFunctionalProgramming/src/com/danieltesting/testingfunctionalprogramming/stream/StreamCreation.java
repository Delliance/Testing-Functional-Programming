package com.danieltesting.testingfunctionalprogramming.stream;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {

//        1 Stream Creation

//        Once created, the instance will not modify its source, therefore allowing the creation of multiple instances
//        from a single source

//        1.1 Empty Stream

        Stream<String> streamEmpty = Stream.empty();

//        We often use the empty() method upon creation to avoid returning null for streams with no element:

//        public Stream<String> streamOf(List<String> list) {
//            return list == null || list.isEmpty() ? Stream.empty() : list.stream();
//        }

//        1.2 Stream of Collection

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

//        1.3 Stream of Array

        Stream<String> streamOfArray = Stream.of("a", "b", "c");

//        We can also create a stream out of an existing array or of part of an array:

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

//        1.4 Stream.builder()

//        When builder is used, the desired type should be additionally specified in the right part of the statement,
//        otherwise the build() method will create an instance of the Stream<Object>:

        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build(); //without the <String> here it is an Object

//        1.5 Stream.generate()

//        The generate() method accepts a Supplier<T> for element generation. As the resulting stream is infinite, the
//        developer should specify the desired size, or the generate() method will work until it reaches the memory
//        limit:

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);

//        The code above creates a sequence of ten strings with the value “element.”

//        1.6 Stream.iterate()

//        Another way of creating an infinite stream is by using the iterate() method:

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

//        The first element of the resulting stream is the first parameter of the iterate() method. When creating every
//        following element, the specified function is applied to the previous element. In the example above the second
//        element will be 42.

//        1.7 Stream of Primitives

//        Java 8 offers the possibility to create streams out of three primitive types: int, long and double. As
//        Stream<T> is a generic interface, and there is no way to use primitives as a type parameter with generics,
//        three new special interfaces were created: IntStream, LongStream, DoubleStream.

//        Using the new interfaces alleviates unnecessary auto-boxing, which allows for increased productivity:

        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

//        The .range(int startInclusive, int endExclusive) method creates an ordered stream from the first parameter to
//        the second parameter. It increments the value of subsequent elements with the step equal to 1. The result
//        doesn't include the last parameter, it is just an upper bound of the sequence.

//        The .rangeClosed(int startInclusive, int endInclusive) method does the same thing with only one difference,
//        the second element is included. We can use these two methods to generate any of the three types of streams
//        of primitives.

//        Since Java 8, the Random class provides a wide range of methods for generating streams of primitives. For
//        example, the following code creates a DoubleStream, which has three elements:

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);
        doubleStream.forEach(System.out::println);

//        1.8 Stream of String

//        We can also use String as a source for creating a stream with the help of the chars() method of the String
//        class. Since there is no interface for CharStream in JDK, we use the IntStream to represent a stream of chars
//        instead.

        IntStream streamOfChars = "abc".chars();

//        The following example breaks a String into sub-strings according to specified RegEx:

        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("Hello, there, world");
        streamOfString.forEach(System.out::println);

//        1.9 Stream of File

//        Java NIO class Files allows us to generate a Stream<String> of a text file through the lines() method. Every
//        line of the text becomes an element of the stream:

        Path path = Paths.get("C:\\file.txt");
//        Stream<String> streamOfStrings = Files.lines(path); //error at .lines for some reason, solve with try-catch
//        Stream<String> streamWithCharset =
//                Files.lines(path, Charset.forName("UTF-8"));

//        The Charset can be specified as an argument of the lines() method.

    }

}
