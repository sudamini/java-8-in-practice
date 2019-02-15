package com.practice.java8;

public class CustomApplePredicate implements CustomPredicate {

    @Override
    public String prettyPrintApple(Apple a) {
        return " "+a.getColor()+ " "+a.getWeight();
    }
}
