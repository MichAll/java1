package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a, b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return (a + "+" + b + "i");
    }

    public ComplexNum add(ComplexNum num) {
        int addA = (this.a + num.a);
        int addB = (this.b + num.b);
        return new ComplexNum(addA, addB);
    }

    public ComplexNum sub(ComplexNum num) {
        int addA = (this.a - num.a);
        int addB = (this.b - num.b);
        return new ComplexNum(addA, addB);
    }

    public ComplexNum mul(ComplexNum num) {
        int addA = (this.a * num.a - this.b * num.b);
        int addB = (this.b * num.a + this.a * num.b);
        return new ComplexNum(addA, addB);
    }

    public ComplexNum div(ComplexNum num) {
        int addA = ((this.a * num.a + this.b * num.b) / (num.a * num.a + num.b * num.b));
        int addB = ((this.b * num.a - this.a * num.b) / (num.a * num.a + num.b * num.b));
        return new ComplexNum(addA, addB);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
