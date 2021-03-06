package ru.progwards.java1.lessons.interfaces;

public class Hamster extends Animal{

    public Hamster(double weight) {
        super(weight);
    }
    @Override
    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }
    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff() {
        return 0.03;
    }

    public static void main(String[] args) {
        System.out.println(new Hamster(5).toString());
        System.out.println(new Hamster(5).toStringFull());
    }
}
