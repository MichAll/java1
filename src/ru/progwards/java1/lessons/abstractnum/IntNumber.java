package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number{
    private int value;
    public IntNumber(int number) {
        value = number;
    }
    @Override
    public Number mul(Number n) {
        if (n.getClass()==IntNumber.class)
            return new IntNumber(value*((IntNumber)n).value);
        else
            return null;
    }
    public Number div(Number n) {
        return new IntNumber(value/((IntNumber)n).value);
    }
    public Number newNumber(String strNum) {
        return new IntNumber(Integer.parseInt(strNum));
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    @Override
    public boolean equals (Object obj){
        if (obj.getClass()==IntNumber.class)
            return false;
        else
            return ((IntNumber)obj).value == value;
    }
}
