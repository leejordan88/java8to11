package com.example.java8to11.optional;

import com.example.java8to11.domain.OnlineClass;
import com.example.java8to11.domain.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        OnlineClass onlineClass = optional.orElseGet(App::createNewClass);
        System.out.println(onlineClass.toString());

        OnlineClass onlineClass1 = optional.orElseThrow(() -> new IllegalArgumentException("해당하는 값을 찾을 수 없다."));

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "new class", true);
    }
}
