package ru.progwards.java1.lessons.basics;

public class Astronomy {
    static final double PI_2 = 3.14;

    public static Double sphereSquare(Double r) { //2.1
        Double S = 4 * PI_2 * r * r;
        return S;
    }
    public static Double earthSquare() { //2.2
        Double square = sphereSquare(6371.2);
        return square;
    }
    public static Double mercurySquare() { //2.3
        Double square = sphereSquare(2439.7);
        return square;
    }
    public static Double jupiterSquare() { //2.4
        Double square = sphereSquare(71492.0);
        return square;
    }
    public static Double earthVsMercury() { //2.5
        Double squareSquare = earthSquare() / mercurySquare();
        return squareSquare;
    }
    public static Double earthVsJupiter() { //2.6
        Double squareSquare = earthSquare() / jupiterSquare();
        return squareSquare;
    }
    public static void main(String[] args) {
        System.out.print("Площадь поверхности Земли ");
        System.out.println(earthSquare());
        System.out.print("Площадь поверхности Меркурия ");
        System.out.println(mercurySquare());
        System.out.print("Площадь поверхности Юпитера ");
        System.out.println(jupiterSquare());
        System.out.print("Земля VS Меркурий ");
        System.out.println(earthVsMercury());
        System.out.print("Земля VS Юпитер ");
        System.out.println(earthVsJupiter());
    }
}
