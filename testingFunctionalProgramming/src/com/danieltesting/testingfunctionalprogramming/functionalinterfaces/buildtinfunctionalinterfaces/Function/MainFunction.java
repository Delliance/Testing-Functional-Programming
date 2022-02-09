package com.danieltesting.testingfunctionalprogramming.functionalinterfaces.buildtinfunctionalinterfaces.Function;

import java.util.function.Function;

public class MainFunction {

    public static void main(String[] args) {

        Function<Long, Long> adder = new AddThree();
        Long result = adder.apply((long) 4);
        System.out.println("result = " + result);

//        You can also implement the Function interface using a Java lambda expression. Here is how that looks:
        Function<Long, Long> adder2 = (value) -> value + 3;
        Long resultLambda = adder2.apply((long) 8);
        System.out.println("resultLambda = " + resultLambda);
//        As you can see, the Function interface implementation is now inlined in the declaration of the adderLambda variable, rather than in a separate class
    }

}
