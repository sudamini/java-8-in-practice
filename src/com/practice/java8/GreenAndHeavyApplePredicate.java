package com.practice.java8;

public class GreenAndHeavyApplePredicate implements Predicate {
    @Override
    public boolean test(Apple a) {
        return ( a.getColor().equals("Green") && a.getWeight() > 20 );
    }
}
