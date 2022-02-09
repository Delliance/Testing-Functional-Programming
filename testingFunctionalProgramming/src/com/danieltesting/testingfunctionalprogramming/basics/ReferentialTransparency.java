package com.danieltesting.testingfunctionalprogramming.basics;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ReferentialTransparency {

//    call an expression referentially transparent if replacing it with its corresponding value has no impact on the program's behavior.
//    for referential transparency, we need our functions to be pure and immutable

    private static Logger logger = Logger.getGlobal();

    public void main() {

        String data = new SimpleData().setData("Baeldung").getData();
//        The three calls to logger are semantically equivalent but not referentially transparent:
        logger.log(Level.INFO, new SimpleData().setData("Baeldung").getData());
//        The first call is not referentially transparent as it produces a side-effect. If we replace this call with its value as in the third call, we'll miss the logs
        logger.log(Level.INFO, data);
//        The second call is also not referentially transparent as SimpleData is mutable. A call to data.setData anywhere in the program would make it difficult for it to be replaced with its value.
        logger.log(Level.INFO, "Baeldung");
    }

    public class SimpleData {

        private Logger logger = Logger.getGlobal();

        private String data;

        public String getData() {
            logger.log(Level.INFO, "Get data called for SimpleData");
            return data;
        }

        public SimpleData setData(String data) {
            logger.log(Level.INFO, "Set data called for SimpleData");
            this.data = data;
            return this;
        }

    }

}