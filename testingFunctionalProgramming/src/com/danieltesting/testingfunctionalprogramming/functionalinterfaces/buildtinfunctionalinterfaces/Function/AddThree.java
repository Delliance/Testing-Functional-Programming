package com.danieltesting.testingfunctionalprogramming.functionalinterfaces.buildtinfunctionalinterfaces.Function;

import java.util.function.Function;

public class AddThree implements Function<Long, Long> {

    @Override
    public Long apply(Long aLong) {
        return aLong + 3;
    }
}
