package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    public static double volumeBallDouble(double radius) {
        double sphereVd = (double)4/3 * 3.14 * radius * radius * radius;
        return sphereVd;
    }
    public static float volumeBallFloat(float radius) {
        float sphereVf = (float)4/3 * 3.14F * radius *radius * radius;
        return sphereVf;
    }
    public static double calculateAccuracy(double radius) {
        Double radiusAcc = volumeBallDouble(radius) - volumeBallFloat((float)radius);
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
