package dz.tester;

import dz.Tests;
import dz.tester.annotations.AfterSuite;
import dz.tester.annotations.BeforeSuite;
import dz.tester.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Evgenii Chentsov
 */
public class Tester {

    public static void main(String[] args) throws Exception {
        for (String arg : args) {
            System.out.println(arg);
        }
        start(Tests.class);
    }

    private static <T> void start(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Constructor constructor = clazz.getConstructor();
        T instance = (T) constructor.newInstance();

        startSingleMethod(clazz, BeforeSuite.class, instance);


        List<Method> tests = getMethodByAnnotation(clazz, Test.class);
        tests.sort(Comparator.comparingInt((Method method) -> {
            return method.getAnnotation(Test.class).priority().getPriority();
        }).reversed());

        for (Method test : tests) {
            test.invoke(instance);
        }

        startSingleMethod(clazz, AfterSuite.class, instance);
    }

    private static List<Method> getMethodByAnnotation(Class clazz, Class<? extends Annotation> annotation) {
        List<Method> annotatedMethods = Arrays
                .stream(clazz.getMethods())
                .filter(method -> method.isAnnotationPresent(annotation))
                .collect(Collectors.toList());

//        List<Method> methods = new ArrayList<>();
//        for (Method method : clazz.getMethods()) {
//            if (method.isAnnotationPresent(annotation)) {
//                methods.add(method);
//            }
//        }

        boolean isSingle = annotatedMethods.size() < 2;
        boolean mustBeSingle = annotation.equals(BeforeSuite.class) || annotation.equals(AfterSuite.class);
        if (mustBeSingle && !isSingle)
            throw new RuntimeException(annotation.getSimpleName() + " is not unique");

        return annotatedMethods;
    }

    private static void startSingleMethod(Class<?> clazz, Class<? extends  Annotation> annotation, Object instance)
            throws IllegalAccessException, InvocationTargetException {

        List<Method> singleMethodAsList = getMethodByAnnotation(clazz, annotation);
        for (Method method : singleMethodAsList) {
            method.invoke(instance);
        }
    }

}
