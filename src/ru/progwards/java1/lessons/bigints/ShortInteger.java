package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    short a;
    ShortInteger(short a) {
        this.a = a;
    }
    @Override
    public String toString() {
        return Short.toString(a);
    }
    @Override
    public int perMen() {
        return a;
    }
}
