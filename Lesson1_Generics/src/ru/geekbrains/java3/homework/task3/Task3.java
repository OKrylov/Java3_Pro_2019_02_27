package ru.geekbrains.java3.homework.task3;

public class Task3 {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());//3
//        orangeBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());//2
//        appleBox.add(new Orange());
        System.out.println("appleBox weight is " + appleBox.getWeight());

        appleBox2.add(new Apple());//1
        System.out.println("appleBox2 weight is " + appleBox2.getWeight());

//        appleBox.moveAllTo(orangeBox);
        appleBox.moveAllTo(appleBox2);

        System.out.println("appleBox weight is " + appleBox.getWeight());//0
        System.out.println("appleBox2 weight is " + appleBox2.getWeight());//2+1=3

        System.out.println("Compare oranges and apples: " + appleBox.compareTo(orangeBox));
        System.out.println("Compare oranges and apples2: " + appleBox2.compareTo(orangeBox));
    }
}