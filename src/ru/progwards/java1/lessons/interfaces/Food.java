package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        if (this.getWeight() == getWeight()) return CompareResult.EQUAL;
        else if (this.weight < weight) return CompareResult.LESS;
        else return CompareResult.GREATER;
    }
}
