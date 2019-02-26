package ru.geekbrains.java3.generic.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CollectionUtils {

    public static <T, R> List<R> transform(List<T> collection, Function<T, R> transform) {
        List<R> result = new ArrayList<>();
        for (T value : collection) {
            result.add(transform.apply(value));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("1");
        input.add("2");

//        Function<String, Integer> transform = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s);
//            }
//        };

//        Function<String, Integer> transform = s -> Integer.parseInt(s);
//        Function<String, Integer> transform = Integer::parseInt;


        List<Integer> out = CollectionUtils.transform(input, Integer::parseInt);
        for (Integer value : out) {
            System.out.println(value);
        }

    }

}
