package com.example.java8to11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App3 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("joonsung");
        names.add("keesun");
        names.add("toby");
        names.add("foo");

        List<String> collect = names.parallelStream().map((s) -> {
            System.out.println(s + "::" + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

    }

}
