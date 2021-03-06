package ru.progwards.java1.lessons.classes;

import java.util.Objects;

public class Animal {
    double weight;

    public Animal(double weight) {
        this.weight=weight;
    }
    enum AnimalKind { ANIMAL, COW, HAMSTER, DUCK }
    enum FoodKind { UNKNOWN, HAY, CORN }

//возвращает информацию о цене 1 кг еды
    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case HAY: return 20;
            case CORN: return 50;
            case UNKNOWN: return 0;
            default: return 0;
        }
    }
//  информация о цене еды для данного животного
    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }
//возвращает результаты сравнения цены еды для данного животного с ценой еды для другого животного, используя Double.compare
    public int compareFoodPrice(Animal aminal) {
        return Double.compare(this.calculateFoodWeight(), aminal.calculateFoodWeight());
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return Double.compare(animal.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

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
