package ru.progwards.java1.lessons.interfaces;

public class Duck extends Animal {

    public Duck(double weight) {
        super(weight);
    }
    @Override
    public AnimalKind getKind() {
        return AnimalKind.DUCK;
    }
    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff() {
        return 0.04;
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    public static void main(String[] args){
        System.out.println(new Duck(10).toString());
        System.out.println(new Duck(10).toStringFull());
    }
}
