package ru.progwards.java1.lessons.interfaces;

public class Cow extends Animal {

    public Cow(double weight) {
        super(weight);
    }
    @Override
    public AnimalKind getKind() {
        return AnimalKind.COW;
    }
    @Override
    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }
    @Override
    public double getFoodCoeff() {
          return 0.05;
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.calculateFoodWeight(), animal.calculateFoodWeight());
    }

    public static void main(String[] args) {
        System.out.println(new Cow(100).toString());
        System.out.println(new Cow(100).toStringFull());
    }
}
