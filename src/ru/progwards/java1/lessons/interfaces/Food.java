package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {

        System.out.println(smthHasWeigt);
        if (this.weight == weight) return CompareResult.EQUAL;
        else if (this.weight < weight) return CompareResult.LESS;
        else return CompareResult.GREATER;
    }

    public static void main(String[] args) {
        System.out.println(new Food(300).compareWeight(new Food(400)));
    }
}
