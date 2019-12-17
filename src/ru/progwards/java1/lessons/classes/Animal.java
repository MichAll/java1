package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;

    public Animal(double weight) {
        this.weight=weight;
    }
    enum AnimalKind { ANIMAL, COW, HAMSTER, DUCK }
    enum FoodKind { UNKNOWN, HAY, CORN }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }
    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public double getWeight() {
        return weight;
    }
    public double getFoodCoeff() {
        return 0.02;
    }
    public double calculateFoodWeight() {
         return (weight * getFoodCoeff());
    }
    public String toString() {
        return ("I am "+getKind()+", eat "+getFoodKind());
    }
    public String toStringFull() {
        return ("I am "+getKind()+", eat "+getFoodKind()+" "+calculateFoodWeight());
    }
    public static void main(String[] args) {
        Animal animal = new Animal(25);
        System.out.println(animal.toString());
        System.out.println(animal.toStringFull());
    }
}
