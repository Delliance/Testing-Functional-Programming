package com.danieltesting.testingfunctionalprogramming.basics;

public class Recursion {

//    allows us to break down a problem into smaller pieces

//    this style of recursion is also known as head recursion
    public static Integer headRecursion(Integer number) {

        return (number == 1) ? 1 : number * headRecursion(number - 1);

    }

//    slightly different implementation of the recursion known as tail recursion Here, we ensure that the recursive call is the last call a function makes
    public static Integer tailRecursion(Integer number, Integer result) {

        return (number == 1) ? result : tailRecursion(number - 1, result * number);

    }

}