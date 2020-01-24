package com.ap;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

public class Main {


    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("111", "222", "333", "444");
        Stream<String> s2 = Stream.of("555", "666", "777", "888");
        Stream<String> s3 = Stream.of("999", "1010", "1111", "1212");
        Stream<String> all = Stream.of(s1, s2, s3)
                .flatMap(identity())
                .peek(x -> System.out.println("Flat mapped " + x))
                .filter(startsWithPrefix())
                .peek(x -> System.out.println("Filtered " + x))
                .map(x -> x + " " + x.length());
//                .limit(2);

        System.out.println("Invoking terminal...");

        System.out.println(all.anyMatch(startsWithPrefix()));

    }

    private static Predicate<String> startsWithPrefix() {
        return x -> x.matches("[123].+");
    }
}
