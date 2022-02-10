package com.danieltesting.testingfunctionalprogramming.listslambdasmethodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IteratingThroughAList {

    public static void main(String[] args) {

//        You can easily create an immutable collection of a list of names with the following code:
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

//        Here’s the habitual, but not so desirable, way to iterate and print each of the elements.
        for(int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));

//            Java offers a construct that is a bit more civilized than the good old for loop.
            for(String name : friends) {
                System.out.println(name);
            }

//            Both these versions are external iterators, which mix how you do it with what you would like to achieve.
//            You explicitly control the iteration with them, indicating where to start and where to end; the second
//            version does that under the hood using the Iterator methods. With explicit control, the break and continue
//            statements help manage the iteration’s flow of control.

//            The second construct has less ceremony than the first and is better than the first if you don’t intend to
//            modify the collection at a particular index. Both styles, however, are imperative and you can dispense
//            with them in modern Java by using a functional approach.

//            Both styles, however, are imperative and you can dispense with them in modern Java by using a functional
//            approach.

//            There are quite a few reasons to favor the change to the functional style.
//              -for loops are inherently sequential and are quite difficult to parallelize.
//              -Such loops are nonpolymorphic: You get exactly what you ask for. You passed the collection to for
//              instead of invoking a method (a polymorphic operation) on the collection to perform the task.
//              -At the design level, the code fails the “Tell, don’t ask” principle. You ask for a specific iteration
//              to be performed instead of leaving the details of the iteration to the underlying libraries.

            friends.forEach(new Consumer<String>() { //Consumer is one of the built-int functional interfaces
                public void accept(final String name) {
                    System.out.println(name);
                }
            });

//            You have invoked forEach() on the friends collection and passed an anonymous instance of Consumer to it.
//            The forEach() method will invoke the accept() method of the given Consumer for each element in the
//            collection and perform a specified action. In this example, the action merely prints the given value,
//            which is a name.

//            As for the benefit, you went from specifying how to iterate to focusing on what you want to do for each
//            element.

//            The bad news is the code looks a lot more verbose, so much that it can drain away any excitement about
//            the new style of programming. Thankfully, you can fix that quickly. his is where lambda expressions and
//            the compiler magic come in

            friends.forEach((final String name) -> System.out.println(name));

//            The internal-iterator version is more concise than the other ones. In addition, it helps focus your
//            attention on what you want to achieve for each element rather than how to sequence through the
//            iteration—it’s declarative.

//            The better-code version has a limitation, however. Once the forEach() method starts, unlike in the other
//            two versions, you can’t break out of the iteration. (There are facilities to handle this limitation.)
//            Consequently, this style is useful where you want to process each element in a collection.

//             The Java compiler also offers some lenience and can infer the types. Leaving out the type is convenient,
//             requires less effort, and is less noisy. Here’s the previous code without the type information

            friends.forEach((name) -> System.out.println(name));

//            The Java compiler treats single-parameter lambda expressions as special. You can leave off the parentheses
//            around the parameter if the parameter’s type is inferred.

            friends.forEach(name -> System.out.println(name));

//            There’s one caveat: Inferred parameters are nonfinal

//            This example has reduced the code quite a bit. One last step will tease out another ounce of conciseness.

            friends.forEach(System.out::println);

//            Lambda expressions helped you concisely iterate over a collection

        }

    }

}
