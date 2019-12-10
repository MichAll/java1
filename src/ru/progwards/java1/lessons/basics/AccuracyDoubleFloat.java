package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    public static double volumeBallDouble(double radius) {
        double sphereVd = (double)4/3 * 3.14 * Math.pow(radius, 3);
        return sphereVd;
    }
    public static float volumeBallFloat(float radius) {
        float sphereVf = (float)4/3 * 3.14F * (float)Math.pow(radius, 3);
        return sphereVf;
    }
    public static double calculateAccuracy(double radius) {
        double radiusAcc = radius - (float)radius;
        return radiusAcc;
    }
    public static void main(String[] args) {
        Double radiusEar = 6371.2;
        System.out.println(volumeBallDouble(radiusEar));
        Float radiusF = radiusEar.floatValue();
        System.out.println(volumeBallFloat(radiusF));
        System.out.println(calculateAccuracy(radiusEar));
     }
}
