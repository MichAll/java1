package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void main(String[] args) {
        Figure3D fig = new Cube(new IntNumber(3));
        System.out.println(fig.volume());

        fig = new Cube(new DoubleNumber(3.0));
        System.out.println(fig.volume());

        fig = new Pyramid(new IntNumber(3));
        System.out.println(fig.volume());

        fig = new Pyramid(new DoubleNumber(3.0));
        System.out.println(fig.volume());

    }
}
