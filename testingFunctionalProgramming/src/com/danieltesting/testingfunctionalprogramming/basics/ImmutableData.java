package com.danieltesting.testingfunctionalprogramming.basics;

public class ImmutableData {

//    refers to the property that an entity can't be modified after being instantiated
//    Java itself provides several built-in immutable types like String
//    use of the final keyword

    private final String someData;

    private final AnotherImmutableData anotherImmutableData;

    public ImmutableData(final String someData, final AnotherImmutableData anotherImmutableData) {
        this.someData = someData;
        this.anotherImmutableData = anotherImmutableData;
    }

    public String getSomeData() {
        return someData;
    }

    public AnotherImmutableData getAnotherImmutableData() {
        return anotherImmutableData;
    }

    public class AnotherImmutableData {

        private final Integer someOtherData;

        public AnotherImmutableData(final Integer someData) {
            this.someOtherData = someData;
        }

        public Integer getSomeOtherData() {
            return someOtherData;
        }

    }

}