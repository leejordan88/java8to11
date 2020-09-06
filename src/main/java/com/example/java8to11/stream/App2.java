package com.example.java8to11.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App2 {

    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("joonsung");
        nameList.add("keesun");
        nameList.add("toby");
        nameList.add("foo");

        Spliterator<String> spliterator = nameList.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        System.out.println("spliterator=================================================");
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("spliterator1=================================================");
        while (spliterator1.tryAdvance(System.out::println));

        long count = nameList.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("J"))
                .count();
        System.out.println("count: " + count);
        System.out.println("=================================================");

        List<String> startWithJList = nameList.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("J"))
                .collect(Collectors.toList());
        startWithJList.forEach(System.out::println);
        System.out.println("=================================================");

        nameList.removeIf(s-> s.startsWith("J"));
        nameList.forEach(System.out::println);
        System.out.println("=================================================");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        nameList.sort(compareToIgnoreCase.reversed());
        nameList.forEach(System.out::println);
        System.out.println("=================================================");


    }

}
