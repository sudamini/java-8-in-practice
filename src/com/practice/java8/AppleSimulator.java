package com.practice.java8;

import java.util.ArrayList;
import java.util.List;


public class AppleSimulator {
    static List<Apple> inventory = new ArrayList<>();

    public static void main(String args[]) {

        Apple greenApple = new Apple();
        greenApple.setColor("Green");
        greenApple.setWeight(20);

        Apple redApple = new Apple();
        redApple.setColor("Red");
        redApple.setWeight(30);

        inventory.add(greenApple);
        inventory.add(redApple);

        System.out.println(filterGreenApples(inventory).get(0).getColor());
        /* This shows syntax of lambda expressions*/
        List<Apple> results = filter(inventory, (Apple apple)->"Red".equals(apple.getColor()));
        System.out.println ("filtered red apples " +results);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(40);
        numbers.add(50);

        //List<String> evenNumbers = flexibleFilter ( numbers, (Integer i) -> i%2 == 0 );

    }

    /*
    This method will accept any list - could be apples, oranges, numbers whatever
     */
     public static <T>  List<T> flexibleFilter ( List<T> list, FlexiblePredicate<T> p ) {
         List<T> result = new ArrayList<>();
         for (T e: list ) {
             if ( p.test(e) ){
                 result.add(e);
             }
         }
         return result;
     }

     /*
    Method without behaviour parametirization.
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> filteredApples = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals("Green")) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    /*
    Method without behaviour parametirization
     */
    public static List<Apple> filterRedApples(List<Apple> inventory) {
        return null;
    }

    /*
    Method without behaviour parametirization
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        return null;
    }
    /* Behaviours will change, conditions will change - may want to filter apples that are green and heavy and from Peru etc*/

    /*
    This method uses behaviour parameterization. If a new criteria is required to filter apples, we need to create a new implementation
    of Predicate interface and we can still continue to use this method. It is not necessary to create Predicate objects, we can send code directly to methods.
     */
    public static List<Apple> filter(List<Apple> inventory, Predicate predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /*
    This is too verbose. we can use anonymous classes or lambda
    expressions.
     */
    public static void prettyPrintApple(List<Apple> inventory, CustomApplePredicate predicate) {

        for (Apple apple : inventory) {
            String characteristic = predicate.prettyPrintApple(apple);
            {
                System.out.println("Apple is " + characteristic);
            }
        }
    }
// Use of anonymous classes.
    List<Apple> redApples = filterApples(inventory, new Predicate() {
        public boolean test(Apple apple) {
            return "multicolor".equals(apple.getColor());
        }
    });

    List<Apple> filterApples(List<Apple> in, Predicate p) {
        List<Apple> multicolorApples = new ArrayList<Apple>();
        for (Apple a : in) {
            if ( p.test(a) ) {
                multicolorApples.add(a);
            }
        }
        return multicolorApples;
    }
}
