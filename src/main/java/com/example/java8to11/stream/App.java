package com.example.java8to11.stream;

import com.example.java8to11.domain.Greeting;

import java.util.Arrays;
import java.util.function.*;

public class App {

    public static void main(String[] args) {

        //Function<param, return>
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        //Function.compose -> 앞에 function 실행 전 인자 function 실행
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
//        System.out.println(multiply2AndPlus10.apply(2));

        //Function.andThen 앞에 function 실행 후 뒤 function 실행
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
//        System.out.println(plus10AndMultiply2.apply(10));

        //Consumer void method
        Consumer<Integer> printT = (i) -> System.out.println(i);
//        printT.accept(10);

        //Supplier<T> return T
        Supplier<Integer> get10 = () -> 10;
//        System.out.println(get10.get());

        //Predicate<T> test return true or false
        Predicate<String> startsWithJoonsung = (s) -> s.startsWith("joonsung");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

//        System.out.println(startsWithJoonsung.test("joonsungLee"));
//        System.out.println(isEven.test(3));

        //if param type and return type is same
        UnaryOperator<Integer> plus20 = (i) -> i + 20;
//        System.out.println(plus20.apply(10  ));

        UnaryOperator<String> hi = Greeting::hi;
//        System.out.println(hi.apply("joonsung"));

        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greeting = greetingSupplier.get();

        UnaryOperator<String> hello = greeting::hello;
//        System.out.println(hello.apply("joonsungLee"));

        String[] names = {"joonsung", "jordan", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }

}
